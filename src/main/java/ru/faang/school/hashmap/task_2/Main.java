package ru.faang.school.hashmap.task_2;

public class Main {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        bookDAO.add(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 1997), "#12");
        bookDAO.add(new Book("Effective Java", "Joshua Bloch", 2001), "#43");
        bookDAO.add(new Book("They Both Die at the end", "Adam Silvera", 2017), "#341");

        bookDAO.printAll();
        System.out.println("-----------Find book-------------------");
        bookDAO.find("They Both Die at the end", "Adam Silvera", 2017);
        System.out.println("----------Remove book-----------------------");
        bookDAO.remove("Effective Java", "Joshua Bloch", 2001);
        System.out.println("-------------Print all books--------------------------");
        bookDAO.printAll();

//        System.out.println("-------------Check invalid arguments--------------------------");
//        bookDAO.find("Unknown book", "Unknown author", 1312);
//        bookDAO.remove("Unknown book", "Unknown author", 1233);
//        System.out.println("-------------Print all books--------------------------");
//        bookDAO.printAll();
    }
}
