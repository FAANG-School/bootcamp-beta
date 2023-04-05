package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    private static Map<Book, String> mapOfBooksinLibrauary=new HashMap<>();

    public static void main(String[] args)
    {
        addBook(new Book("Bible", "-", 1), "1");
        addBook(new Book("Harry Potter", "J.K.Rouling", 1997), "1");
        findBook("Bible", "-", 1);
        printAllBooks();
    }
    public static void addBook(Book newBook, String shelf){
        mapOfBooksinLibrauary.put(newBook, shelf);
    }
    public static void removeBook(Book book){
        mapOfBooksinLibrauary.remove(book);
    }
    public static void findBook(String title, String author, int year){
        System.out.println(mapOfBooksinLibrauary.get(new Book(title, author, year)));
    }
    public static void printAllBooks(){
        for(Book book:mapOfBooksinLibrauary.keySet())
        {
            System.out.println("Book:"+book.getTitle()+"; Author:"+book.getAuthor()+"; Year of publishing:"+book.getYear()+"; Shelf:"+mapOfBooksinLibrauary.get(book));
        }
    }

}
