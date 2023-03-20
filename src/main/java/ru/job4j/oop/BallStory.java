package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        System.out.println("От ежа");
        hare.tryEat(ball);
        System.out.println("От волка");
        wolf.tryEat(ball);
        System.out.println("А от лисы");
        fox.tryEat(ball);
    }
}
