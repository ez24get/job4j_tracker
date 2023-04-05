package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int num);

    default double fuel(double liters) {
        return liters * 50;
    }
}
