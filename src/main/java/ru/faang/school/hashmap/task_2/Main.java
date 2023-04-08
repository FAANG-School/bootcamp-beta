package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static  Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {


        addBook(new Book("Евгений Онегин", "Александр Сергеевич Пушкин", 1833), "23");
        addBook(new Book("Капитанская дочка", "Александр Сергеевич Пушкин", 1836), "2");
        addBook(new Book("Сказка о рыбаке и рыбке", "Александр Сергеевич Пушкин", 1833), "1");

        printBook("Капитанская дочка", "Александр Сергеевич Пушкин", 1836);


        removeBook("Капитанская дочка", "Александр Сергеевич Пушкин", 1836);
        printAllBooksInLibrary();



        //removeBook("Капитанская дочка", "Александр Сергеевич Пушкин", 1836), "2-я полка");





    }

    public static void printBook(String title, String author, int year){
        Book bookToBeFound = new Book(title, author, year);
        if (library.containsKey(bookToBeFound)){
            String location = library.get(bookToBeFound);
            System.out.println("Вот книга, которую вы искали: " + bookToBeFound.toString() + " , она находится на полке " + location);


        }
    }

    public static void printAllBooksInLibrary(){
        for(Map.Entry<Book, String> entry : library.entrySet()){
            System.out.println(entry.getValue() + entry.getKey());
        }
    }

    public static void addBook(Book book, String shelf){
        library.put(book, shelf);
        System.out.println("Книга " + book + "была успешно добавлена на полку: " + shelf);
    }

    public static void removeBook(String title, String author, int year){
        Book bookToBeDeleted = new Book(title, author, year);
        if(library.containsKey(bookToBeDeleted)){
            library.remove(bookToBeDeleted);
            System.out.println(bookToBeDeleted + "была успешно удалена");
        }
    }


}
