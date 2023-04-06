package Task_2;
import java.util.Objects;
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear(){
        return year;
    }

    public boolean equals(Object object){
        if (object == this){
            return true;
        }

        if (object == null || object.getClass() != this.getClass()){
            return false;
        }

        Book book = (Book) object;
        return  this.year == book.year &&
                this.title.equals(book.title) &&
                this.author.equals(book.author);

    }

    public int hashCode() {
        return Objects.hash(title, author, year);
    }

}
