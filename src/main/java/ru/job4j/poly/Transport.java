package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int num);

    default double fuel(double liters, double price) {
        return liters * price;
    }
}
