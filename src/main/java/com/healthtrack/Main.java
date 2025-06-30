package com.healthtrack;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
  // Hacemos el usuario una variable estática para que pueda ser manipulada
  private static Usuario usuario;

  public static void main(String[] args) {
    // Inicializa el usuario al arrancar
    usuario = new Usuario("Test User", 70.0);
    
    port(4567); // Aseguramos el puerto
    
    // Endpoint de la aplicación (GET)
    get("/usuario/peso", (req, res) -> {
      res.type("application/json");
      return "{\"nombre\":\"" + usuario.getNombre() + "\", \"peso\":" + usuario.getPeso() + "}";
    });
    
    // Endpoint de la aplicación (POST)
    post("/usuario/peso", (req, res) -> {
      double nuevoPeso = 75.5; 
      usuario.actualizarPeso(nuevoPeso);
      res.type("application/json");
      return "{\"status\":\"success\", \"nuevoPeso\":" + usuario.getPeso() + "}";
    });
    
    // Este endpoint solo lo usarán nuestras pruebas para resetear el estado
    post("/testing/reset", (req, res) -> {
      usuario = new Usuario("Test User", 70.0);
      return "State reset";
    });
  }

  // Método para detener el servidor, útil para las pruebas
  public static void stopServer() {
    spark.Spark.stop();
    spark.Spark.awaitStop();
  }
}