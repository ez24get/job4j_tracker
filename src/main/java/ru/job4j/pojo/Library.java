package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("One", 123);
        Book two = new Book("Two", 93);
        Book cleanCode = new Book("Clean code", 423);
        Book three = new Book("Three", 223);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = cleanCode;
        books[3] = three;
        for (Book bk : books) {
            System.out.println("Book name: " + bk.getName() + "; # of pages - " + bk.getPages());
        }
        System.out.println("index 1 and 3 swap");
        books[0] = three;
        books[3] = one;
        for (Book bk : books) {
            System.out.println("Book name: " + bk.getName() + "; # of pages - " + bk.getPages());
        }
        System.out.println("Only clean code: ");
        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println("Book name: " + bk.getName() + "; # of pages - " + bk.getPages());
            }
        }
    }
}
