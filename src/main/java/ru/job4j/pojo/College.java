package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Josh Bush Jr.");
        student.setGroup("9/11");
        student.setCreated(new Date(2001, 9, 11));
        System.out.println("Student: " + student.getFullName() + " enrolled in: "
                           + student.getGroup() + " on " + student.getCreated());
    }
}
