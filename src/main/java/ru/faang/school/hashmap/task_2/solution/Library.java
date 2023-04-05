package ru.faang.school.hashmap.task_2.solution;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Library {
    private final Map<Book, String> lib = new HashMap<>();

    /**
     *
     * @param title of the book
     * @param author of the book
     * @param year release date
     * @param place where this book is stored
     * @return false if given year is incorrect and
     * new Book was not added to the map
     */

    public boolean add(String title, String author, int year, String place){
        try {
            lib.put(new Book(title, author, year), place);
        } catch(IOException e){
            return false;
        }
        return true;
    }

    /**
     *
     * @param book key to add
     * @param place value to add
     */
    public void add(Book book, String place){
        add(book.getTitle(), book.getAuthor(), book.getYear(), place);
    }

    /**
     *
     * @param book class Book to search
     * @return the shelf name or null if book was not found
     */

    public String get(Book book){
        return lib.get(book);
    }

    /**
     *
     * @param title of the book
     * @param author of the book
     * @param year of the release
     * @return null if year is incorrect or book was not found
     */

    public String get(String title, String author, int year) {
        try {
            return get(new Book(title, author, year));
        } catch (IOException e){
            return null;
        }
    }


    /**
     *
     * @param book object to search
     * @return false if book was not found
     */
    public boolean remove(Book book){
        return lib.remove(book) != null;
    }

    /**
     *
     * @param title of the book
     * @param author of the book
     * @param year of the release
     * @return false if book was not found or year is incorrect
     */
    public boolean remove(String title, String author, int year){
        try {
            return remove(new Book(title, author, year));
        } catch(IOException e){
            return false;
        }
    }

    public String getAllBooks(){
        StringBuilder all = new StringBuilder();
        for(Map.Entry<Book, String> entry : lib.entrySet()){
            all.append(entry.getKey())
                    .append(" located at ")
                    .append(entry.getValue());
        }
        return all.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(lib, library.lib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lib);
    }
}
