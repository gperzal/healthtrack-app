package com.healthtrack;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);

        // Un usuario en memoria
        User user = new User("TestUser", 70.0);

        // Health check para saber que está arriba
        get("/health", (req, res) -> "OK");

        // Endpoint para actualizar peso: POST /updateWeight?weight=75
        post("/updateWeight", (req, res) -> {
            String w = req.queryParams("weight");
            if (w == null) {
                res.status(400);
                return "Missing weight";
            }
            double newWeight = Double.parseDouble(w);
            user.updateWeight(newWeight);
            return "OK";
        });
    }
}
