package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Passenger carrier");
    }

    @Override
    public void passengers(int num) {
        num = 48;
    }

    @Override
    public double fuel(double liters, double price) {
        return Transport.super.fuel(liters, price);
    }
}
