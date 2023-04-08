package ru.faang.school.hashmap.task_2.Westeros_Library;

public class Book {
    private final String name;
    private final String author;
    private final int year;

    public Book(String name, String author, int year) {
        if(name == null || author == null || year < 0){
            throw new RuntimeException("Invalid value!");
        }
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }



    @Override
    public String toString() {
        return String.format("%s - %s (%s)", name, author, year);
    }
}
