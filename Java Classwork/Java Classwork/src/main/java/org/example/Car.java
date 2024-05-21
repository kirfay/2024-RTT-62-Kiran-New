package org.example;

public class Car {
    private String color;
    private int maxSpeed;

    public String carInfo() {
        return color + "Max Speed:-" + maxSpeed;
    }

    //This is constructor of Car Class
    Car(String color, int speedLimit) {
        String carColor = "";
        this.color = carColor;
        this.maxSpeed = speedLimit;
    }
}
