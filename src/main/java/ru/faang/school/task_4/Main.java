package ru.faang.school.task_4;

import java.util.HashMap;
import java.util.Map;


public class Main {
    static Map<Book,String> library = new HashMap<>();
    public static void main(String[] args) {
        library.put(new Book("White elephant", "Oleg Ivanov", 1997), "2");
        library.put(new Book("Black giraffe", "Ivan Olegov", 2001), "1");
        library.put(new Book("Yellow fish", "Gleb Kirillov", 2004), "2");
        library.put(new Book("Pink tiger", "Kirill Glebov", 2001), "3");
        Main main = new Main();
        main.addNewBook(new Book("Harry Potter", "Gordon Ramsay", 1995), "3");
        main.addNewBook("Parry Hotter", "Harry Potter", 1995, "4");
        main.removeNewBook(new Book("Lala", "Nana", 1337));
        main.removeNewBook("Parry Hotter", "Harry Potter", 1995);
        main.foundBook("White elephant", "Oleg Ivanov", 1997);
        main.foundBook("Nana", "Lala", 1337);
        main.printAllBooks();
    }
    public void addNewBook(Book book, String place){
        library.put(book, place);
    }
    public void addNewBook(String title, String author, int year, String place){
        library.put(new Book(title, author, year), place);
    }
    public void removeNewBook(String title, String author, int year){
        if (library.containsKey(new Book(title, author, year))) {
            library.remove(new Book(title, author, year));
        } else System.out.println("Такой книги не существует");
    }
    public void removeNewBook(Book book){
        if(library.containsKey(book)){
            library.remove(book);
        } else System.out.println("Такой книги не существует.");
    }
    public void foundBook(String title, String author, int year){
        if (library.containsKey(new Book(title, author, year))) {
            System.out.println("Эта книга найдена. Она находится на полке " + library.get(new Book(title, author, year)));
        } else System.out.println("Эта книга не найдена.");
    }
    public void printAllBooks(){
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + ", лежит на полке " + entry.getValue());
        }
    }
}