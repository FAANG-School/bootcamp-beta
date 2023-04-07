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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + year;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return year == book.year
                && (name == book.name || (name != null && name.equals(book.getName())))
                && (author == book.author || (author != null && author.equals(book.getAuthor())));
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", name, author, year);
    }
}
