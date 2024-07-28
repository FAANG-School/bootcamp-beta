package ru.faang.school.hashmap.task_2.vesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        new Main().start();
    }

    public void start(){

        add(new Book("Lannister", "First", 2002), "Place 2");
        add(new Book("Baratheon", "Two", 2002), "Place 1");
        add(new Book("Stark", "Three", 2002), "Place 3");
        add(new Book("Eigon", "First", 2002), "Place 4");
        add(new Book("Gardener", "Two", 2002), "Place 6");

        printLibrary();

        remove(new Book("Gardener", "Two", 2002));

        printLibrary();

        System.out.println(getPlace(new Book("Eigon", "First", 2002)));
    }

    private void add(Book book, String polka){
        library.put(book, polka);
    }

    private void remove(Book book){
        library.remove(book);
    }

    private String getPlace(Book book){
        return library.get(book);
    }

    private void printLibrary(){
        for(Map.Entry<Book, String> set : library.entrySet()){
            System.out.println(set.getKey()+" "+set.getValue());
        }
        System.out.println();
    }
}