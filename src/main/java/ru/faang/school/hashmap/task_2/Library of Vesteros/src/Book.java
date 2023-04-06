import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String year;

    private Book() {}

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public String getYear() { return year; }

    public static void add(Book book, String index) {
        Main.library.put(book, index);
    }

    public static void remove(String field, int fieldPos) throws NoSuchMethodException {
        Map.Entry<Book, String> ableToRemove = findBook(field, fieldPos);
        System.out.println("Book " + '\'' + ableToRemove.getKey().getTitle() + '\'' + " was deleted");
        Main.library.remove(ableToRemove.getKey());
    }

    public static void getLocationInfo(String field, int fieldPos) throws NoSuchMethodException {
        Map.Entry<Book, String> ableToPrint = findBook(field, fieldPos);
        System.out.println("Location of " + ableToPrint.getKey().getTitle() + " is " + ableToPrint.getValue());
    }

    public static void printAll() {
        Main.library.forEach((k, v) -> System.out.println(k + " --> location index " + v));
    }

    private static Map.Entry<Book, String> findBook(String field, int fieldPos) throws NoSuchMethodException {
        Book book = new Book();
        Method method = fieldPos == 1 ? book.getClass().getDeclaredMethod("getTitle")
                : fieldPos == 2 ? book.getClass().getDeclaredMethod("getAuthor")
                : book.getClass().getDeclaredMethod("getYear");
        return Main.library.entrySet().stream()
                .filter(c -> {
                    try {
                        return method.invoke(c.getKey()).equals(field);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(this.title, book.getTitle())
                && Objects.equals(this.author, book.getAuthor())
                && Objects.equals(this.year, book.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title: '" + title + '\'' +
                ", author: " + author  +
                ", year: " + year +
                '}';
    }
}
