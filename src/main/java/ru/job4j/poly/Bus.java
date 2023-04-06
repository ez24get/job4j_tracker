package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Passenger carrier");
    }

    @Override
    public void passengers(int num) {
        System.out.println(num);
    }

    @Override
    public double fuel(double liter) {
        return liter * 50;
    }
}
