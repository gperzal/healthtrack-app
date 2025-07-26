package com.healthtrack;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);
        // Simple in-memory user
        User user = new User("Test", 70.0);

        // Endpoint to update weight via POST /updateWeight?weight=75
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

        // Health check for JMeter/Selenium
        get("/health", (req, res) -> "UP");
    }
}
