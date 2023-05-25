package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель персональных данных клиента банка,
 * включающую в себя имя пользователя и паспорт, геттеры и сеттеры, а так же
 * переопределённые методы equals и hashCode.
 * @author Mikhail Berezovskiy
 * @version 1.0
 */
public class User {
    /**
     * поле номера паспорта
     */
    private String passport;
    /**
     * поле имя пользователя
     */
    private String username;

    /**
     * конструктор объекта пользователя
     * @param passport поле паспорт
     * @param username поле имя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * геттер номер паспорта
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * сеттер номера паспорта
     * @param passport вносит изменение в поле паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * геттер имени
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * сеттер имени
     * @param username вносит изменения в поле имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * переопределенный метод equals
     * @param o принимает объект "о"
     * @return возвразает булеан значение равности объктов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * переопределенный метод hashCode
     * @return генерирует и возвращает hashCode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}