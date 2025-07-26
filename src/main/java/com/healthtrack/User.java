package com.healthtrack;

/**
 * Represents a user in the HealthTrack platform.
 * Allows updating and retrieving user weight.
 */
public class User {
    private String name;
    private double weight;

    public User(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Updates the user weight with the new value provided.
     * @param newWeight The new weight to be assigned.
     */
    public void updateWeight(double newWeight) {
        this.weight = newWeight;
    }

    /**
     * Displays the user information.
     */
    public void showInfo() {
        System.out.println("User: " + name + ", Current Weight: " + weight + " kg");
    }
}
