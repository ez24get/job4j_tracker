package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс описывает работу простейшей реализыции банковского сервиса
 * @author Mikhail Berezovskiy
 * @version 1.0
 */
public class BankService {
    /**
     * поле, содержащее всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляющий нового пользователя
     * @param user принимает в качестве параметра объект user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод удаляет пользователя
     * @param passport принимает номер паспорта
     * @return возвразает true если удаление прошло успешно
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * метод добавляет аккаунт
     * @param passport принимает номер паспорта
     * @param account принимает номер аккаунта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * метод поиска пользователя по паспорту
     * @param passport принимает номер паспорта
     * @return возвращает пользователя user
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод поиска по реквизитам
     * @param passport приниммает паспорт
     * @param requisite принимает номер реквизита
     * @return возвразает объект account
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(p -> p.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод перевода денег
     * @param srcPassport исходый паспорт
     * @param srcRequisite исходный реквизит
     * @param destPassport конечный паспорт
     * @param destRequisite конечный реквизит
     * @param amount количество денег для перевода
     * @return возвращает true, если перевод выполнен успешно
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcUser = findByRequisite(srcPassport, srcRequisite);
        Account destUser = findByRequisite(destPassport, destRequisite);
        if (srcUser != null && destUser != null
                && srcUser.getBalance() >= amount) {
            srcUser.setBalance(srcUser.getBalance() - amount);
            destUser.setBalance(destUser.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * метод для тестов
     * @param user принимает объект user
     * @return возвразает список аккаунтов user
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}