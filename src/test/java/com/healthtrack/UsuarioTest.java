package com.healthtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

  @Test
  void testActualizarPesoCorrectamente() {
    // Arrange (Organizar): Crear un usuario con un peso inicial.
    Usuario usuario = new Usuario("Ana Gómez", 70.0);
    double nuevoPeso = 68.5;
    // Act (Actuar): Llamar al método que se va a probar.
    usuario.actualizarPeso(nuevoPeso);
    // Assert (Afirmar): Verificar que el estado del objeto es el esperado.
    // Se usa un delta para comparar doubles por posibles imprecisiones de punto flotante.
    assertEquals(
      nuevoPeso, 
      usuario.getPeso(), 
      0.001, 
      "El peso del usuario no se actualizó correctamente."
    );
  }
  
  @Test
  void testCreacionDeUsuario() {
      // Arrange
      String nombre = "Carlos Ruiz";
      double pesoInicial = 85.5;
      // Act
      Usuario usuario = new Usuario(nombre, pesoInicial);
      // Assert
      assertEquals(nombre, usuario.getNombre(), "El nombre del usuario no es correcto.");
      assertEquals(pesoInicial, usuario.getPeso(), 0.001, "El peso inicial no es correcto.");
  }

}
