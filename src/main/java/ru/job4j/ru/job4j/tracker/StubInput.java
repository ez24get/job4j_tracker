package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Input;

public class StubInput implements Input {

    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}
