package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student student : students.keySet()) {
            if (student.account().equals(account)) {
                rsl = Optional.of(student);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            for (Subject subject : students.get(a.get())) {
                if (subject.name().equals(name)) {
                    rsl = Optional.of(subject);
                    break;
                }
            }
        }
        return rsl;
    }

}