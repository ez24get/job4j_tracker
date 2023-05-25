package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных банковского счета,
 * включающую в себя реквизиты и баланс, геттеры и сеттеры, а так же
 * переопределённые методы equals и hashCode.
 * @author Mikhail Berezovskiy
 * @version 1.0
 */
public class Account {
    /**
     * поле хранящее номер реквизита
     */
    private String requisite;
    /**
     * поле хранящее баланс на счету
     */
    private double balance;

    /**
     * Конструктор для создания объекта Аккаунт
     * @param requisite номер реквизита
     * @param balance баланс денег
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * геттер реквизита
     * @return возвращает номер реквизит
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * сеттер реквизита
     * @param requisite вносит принимаемый параметр в качестве
     * изменения в поле реквизит
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * геттер баланса
     * @return возвращает значение баланса
     */
    public double getBalance() {
        return balance;
    }

    /**
     * сеттер баланса, задаёт значение полю баланс
     * @param balance возвращает измененный баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределенный метод hashCode
     * @return генерирует и возвращает hashCode объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}