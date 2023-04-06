package Task_2;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> _library;

    public static void main(String[] args){

        _library = new HashMap<>();

        _library.put(new Book("Капитан Немо", "Жюль Верн", 1976), "A");
        _library.put(new Book("Спектр", "Сергей Лукьяненко", 2002), "B");
        _library.put(new Book("Артас: Восхождение Короля Лича", "Кристи Голден", 2009), "C");

        addBook(new Book("Повелитель кланов", "Кристи Голден", 2001), "D");

        removeBook("Спектр", "Сергей Лукьяненко", 2002);

        searchBook("Капитан Немо", "Жюль Верн", 1976);

        for (Map.Entry<Book, String> entry: _library.entrySet()){
            System.out.println("Номер полки: " + entry.getValue() + ". Название книги: " + entry.getKey().getTitle() + ". Автор книги: " + entry.getKey().getAuthor() +
                    ". Год выхода: " + entry.getKey().getYear());
        }
    }

    public static void addBook(Book book, String location){
        _library.put(book, location);
        var newBook = _library.get(book);
        System.out.println("Номер полки: " + newBook + ". Название книги: " + book.getTitle() + ". Автор книги: " + book.getAuthor() +
                ". Год выхода: " + book.getYear());
    }

    public static void removeBook(String title, String author, int year){
        var book = new Book(title, author, year);
        _library.remove(book);
        System.out.println("Произошло удаление книги: " + book.getTitle());
    }

    public static void searchBook(String title, String author, int year){
        var book = new Book(title, author, year);
        var location = _library.get(book);
        System.out.println("Эта книга находится на полке: " + location);
    }
}
