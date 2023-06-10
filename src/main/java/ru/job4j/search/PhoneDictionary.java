package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameSort = (s) -> s.getName().contains(key);
        Predicate<Person> surnameSort = (s) -> s.getName().contains(key);
        Predicate<Person> phoneSort = (s) -> s.getName().contains(key);
        Predicate<Person> addressSort = (s) -> s.getName().contains(key);
        var combine = nameSort.or(surnameSort).or(phoneSort).or(addressSort);
        var result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}