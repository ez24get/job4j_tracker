package ru.job4j.ex;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String notFoundUser) {
        super(notFoundUser);
    }
}
