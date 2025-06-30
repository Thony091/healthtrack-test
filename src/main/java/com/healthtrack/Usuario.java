package com.healthtrack;

public class Usuario {

  final private String nombre;
  private double peso;

  public Usuario(String nombre, double peso) {
    this.nombre = nombre;
    this.peso = peso;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPeso() {
    return peso;
  }

  public void actualizarPeso(double nuevoPeso) {
    // LÓGICA CORREGIDA: Asignar el nuevo peso ingresado.
    this.peso = nuevoPeso;
  }

  public void mostrarInformacion() {
    System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
  }
}
