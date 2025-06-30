package com.healthtrack;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un usuario de ejemplo para simular la base de datos
        Usuario usuario = new Usuario("Test User", 70.0);

        // Endpoint para obtener el peso actual (GET)
        get("/usuario/peso", (req, res) -> {
            res.type("application/json");
            return "{\"nombre\":\"" + usuario.getNombre() + "\", \"peso\":" + usuario.getPeso() + "}";
        });

        // Endpoint para actualizar el peso (POST)
        post("/usuario/peso", (req, res) -> {
            // En una app real, aquí se leería el JSON del body
            // Para simplificar, actualizaremos con un valor fijo
            double nuevoPeso = 75.5; 
            // usuario.actualizarPeso(nuevoPeso);
            res.type("application/json");
            return "{\"status\":\"success\", \"nuevoPeso\":" + usuario.getPeso() + "}";
        });
    }
}