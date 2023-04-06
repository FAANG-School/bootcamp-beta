import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) throws NoSuchMethodException {
        Book.add(new Book("To Kill a Mockingbird", "Harper Lee", "1960-06-11"), "21432");
        Book.add(new Book("1984", "George Orwell", "1949-06-08"), "42958");
        Book.add(new Book("Harry Potter", "J.K. Rowling", "1997-06-26"), "05476");
        Book.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "1954-07-29"), "72634");
        Book.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925-04-10"), "69692");

        Book.printAll();

        /*
           удаление и поиск елементов из мапы по отдельным полям класса Book,
           2 параметром указывается позиция удаляемого поля, порядковый номер которого идентичен тому
           что был при создании экземпляра класса Book
        */

        System.out.println();

        Book.remove("To Kill a Mockingbird", 1); // title
        Book.remove("George Orwell", 2); // author
        Book.remove("1997-06-26", 3); // year

        System.out.println();

        Book.getLocationInfo("The Lord of the Rings", 1); // title
        Book.getLocationInfo("1925-04-10", 3); // year
//        Book.getLocationInfo("J.K. Rowling", 2); // author

        System.out.println();

        Book.printAll();
    }
}
