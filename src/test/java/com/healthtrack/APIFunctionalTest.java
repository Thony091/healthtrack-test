package com.healthtrack;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post; // Importamos el método post estático
import static org.hamcrest.Matchers.equalTo;

public class APIFunctionalTest {

  @BeforeAll
  public static void setupServer() {
    // Inicia el servidor de Spark que está en nuestra clase Main
    Main.main(null); 
    spark.Spark.awaitInitialization(); 
    
    // Configura REST Assured
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 4567;
  }

  @AfterAll
  public static void tearDownServer() {
      // método que creamos para detener el servidor
      Main.stopServer();
  }

  // Antes de cada test, llamamos a nuestro endpoint de control para resetear
  @BeforeEach
  public void resetState() {
    // Usamos REST Assured para enviar una petición a nuestro endpoint de reseteo
    post("/testing/reset").then().statusCode(200);
  }

  @Test
  void testObtenerPesoInicialViaAPI() {
    // El estado se ha reseteado, así que el peso DEBE ser 70.0
    given()
    .when()
      .get("/usuario/peso")
    .then()
      .statusCode(200)
      .body("nombre", equalTo("Test User"))
      .body("peso", equalTo(70.0f));
  }
    
  @Test
  void testActualizarPesoViaAPI() {
    // El estado también se ha reseteado para este test.
    // Primero, verificamos el estado inicial (opcional pero buena práctica)
    given().when().get("/usuario/peso").then().body("peso", equalTo(70.0f));
  
    // Ahora, ejecutamos la acción
    given()
    .when()
      .post("/usuario/peso")
    .then()
      .statusCode(200)
      .body("status", equalTo("success"))
      .body("nuevoPeso", equalTo(75.5f));
      
    // Finalmente, verificamos que el estado ha cambiado permanentemente.
    given().when().get("/usuario/peso").then().body("peso", equalTo(75.5f));
  }
}