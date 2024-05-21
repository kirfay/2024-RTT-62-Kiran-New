package org.example;
//This is car test class to instantiate and call Car objects.
public class CarTestWhich {
    public static void main(String[] args) {
        Car maruti = new Car("Red", 160);
        Car ferrari = new Car("Yellow", 400);
        System.out.println(maruti.carInfo());
        System.out.println(ferrari.carInfo());
    }

}
