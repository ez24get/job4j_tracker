package ru.job4j.tracker;

public interface UserAction {
    String name();

    void execute(Input input, Store tracker);

    boolean exit();
}