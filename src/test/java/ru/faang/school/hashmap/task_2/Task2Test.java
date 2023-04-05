package ru.faang.school.hashmap.task_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ru.faang.school.hashmap.task_1.Book;
import ru.faang.school.hashmap.task_1.Main;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Task2Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final List<Book> books= new ArrayList<>();
	
	
	@BeforeEach
	void init() {
		System.setOut(new PrintStream(outContent));
		books.add(new Book("Test Title", "Test Author", 1900));
		books.add(new Book("Test2 Title", "Test2 Author", 2023));
		books.add(new Book("Test Title", "Test Author", 1900));
		books.add(new Book(null, "Test Author", 1900));
		books.add(new Book("Test Title", null, 1900));
		books.add(new Book("Nullable Year", "Test Author", null));
	}
	
	@AfterEach
	void shutDown() {
		System.setOut(originalOut);
		Main.map.remove(books.get(0));
		books.clear();
	}
	
	@Test
	void addNewBook() {
		Book book = books.get(0);
		
		assertEquals(null, Main.map.get(book));
		assertEquals(false, Main.map.containsValue("XX-000"));
		Assert.assertEquals(5, Main.map.size());
		
		Main.addBook(book, "XX-000");
		Assert.assertEquals(6, Main.map.size());
		assertEquals("XX-000", Main.map.get(book));
		
	}
	
	@Test
	void addNewBookNullArgs() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.addBook(null, "TT-112"));

		assertEquals("Null args", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
						() -> Main.addBook(books.get(1), null));
		
		assertEquals("Null args", exception.getMessage());
		
	}
	
	@Test
	void addNewBookExisted() {
		assertEquals(books.get(0), books.get(2));
		
		Main.addBook(books.get(0), "YY-111");
		Main.addBook(books.get(2), "XX-333");
		
		assertEquals("This book already exists"+"\r\n", outContent.toString());
	}
	
	@Test
	void removeBook() {
		Book book = books.get(0);
		Assert.assertEquals(5, Main.map.size());
		
		Main.addBook(book, "XX-999");
		Assert.assertEquals(6, Main.map.size());
		assertEquals("XX-999", Main.map.get(book));
		
		Main.removeBook(book.getTitle(), book.getAuthor(), book.getYear());
		Assert.assertEquals(5, Main.map.size());
		assertEquals(null, Main.map.get(book));
		
	}
	
	@Test
	void removeBookBadArgs() {
		Book book = books.get(0);
		
		assertEquals(false, Main.map.containsKey(book));
		Main.removeBook(book.getTitle(), book.getAuthor(), book.getYear());
		assertEquals("There are no books with such parameters"+"\r\n", outContent.toString());
		
		System.setOut(originalOut);
		
		Main.removeBook(book.getTitle(), book.getAuthor(), 9999);
		assertEquals("There are no books with such parameters"+"\r\n", outContent.toString());
	}
	
	@Test
	void removeBookNullArgs() {
		Book nullTitle = books.get(3);
		Book nullAuthor = books.get(4);
		Book nullYear = books.get(5);
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
			() -> Main.removeBook(nullTitle.getTitle(), nullTitle.getAuthor(), nullTitle.getYear()));

		assertEquals("Null args", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
			() -> Main.removeBook(nullAuthor.getTitle(), nullAuthor.getAuthor(), nullAuthor.getYear()));
		
		assertEquals("Null args", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
			() -> Main.removeBook(nullYear.getTitle(), nullYear.getAuthor(), nullYear.getYear()));
			
			assertEquals("Null args", exception.getMessage());
	}
	
	@Test
	void findBook() {
		
		assertEquals("XV-98", Main.findBook("Das Schloss", "Franz Kafka", 1926));
		assertEquals("LD-108", Main.findBook("Arc de Triomphe", "Erich Maria Remarque", 1946));
		
	}
	
	@Test
	void findBookNotExisted() {
		
		Book book1 = books.get(0);
		Book book2 = books.get(1);
		
		assertEquals("There are no books with such parameters", 
					Main.findBook(book1.getTitle(), book1.getAuthor(), book1.getYear()));
		assertEquals("There are no books with such parameters", 
					Main.findBook(book2.getTitle(), book2.getAuthor(), book2.getYear()));
		
	}
	
	@Test
	void findBooknullArgs() {
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.findBook("Das Schloss", "Franz Kafka", null));

			assertEquals("Null args", exception.getMessage());
			
			exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.findBook("Das Schloss", null, 1926));
			
			assertEquals("Null args", exception.getMessage());
			
			exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.findBook(null, "Franz Kafka", 1926));
				
				assertEquals("Null args", exception.getMessage());
		
	}
	
	@RepeatedTest(5)
	void printBooksWithPlaces() {
		Main.printBooksWithPlaces();
		
		assertEquals("King Lear, William Shakespeare, 1608; Placed: AD-119"+"\r\n" +
					 "Hamlet, William Shakespeare, 1603; Placed: AD-112" + "\r\n" +
		"Le Barbier de Seville, Pierre-Augustin Caron de Beaumarchais, 1775; Placed: GM-315" + "\r\n" +
				"Das Schloss, Franz Kafka, 1926; Placed: XV-98" + "\r\n" +
				"Arc de Triomphe, Erich Maria Remarque, 1946; Placed: LD-108" +
					 "\r\n", outContent.toString());
	}
	
	@Test
	void z_printBooksWithPlacesEmpty() {
		
		Main.map.clear();
		Main.printBooksWithPlaces();
		assertEquals("There are no books in the libruary"+"\r\n", outContent.toString());
	}


}
