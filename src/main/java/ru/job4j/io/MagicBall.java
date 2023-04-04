package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        String reply = switch (answer) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Возможно";
        };
        System.out.println(reply);
    }
}
