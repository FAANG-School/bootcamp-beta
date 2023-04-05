package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static final Map<Book, String> map = new HashMap<>();
	
	static {
		map.put(new Book("King Lear", "William Shakespeare", 1608), "AD-119");
		map.put(new Book("Hamlet", "William Shakespeare", 1603), "AD-112");
		map.put(new Book("Das Schloss", "Franz Kafka", 1926), "XV-98");
		map.put(new Book("Le Barbier de Seville", "Pierre-Augustin Caron de Beaumarchais", 1775), "GM-315");
		map.put(new Book("Arc de Triomphe", "Erich Maria Remarque", 1946), "LD-108");
	}

	public static void main(String[] args) {
		printBooksWithPlaces();

	}
	
	public static void addBook(Book book, String place) {
		
		if (book != null && place != null) {
			if (map.containsKey(book)) {
				System.out.println("This book already exists");
			}
			else
				map.put(book, place);
		}
		else
			throw new IllegalArgumentException("Null args");
	}
	
	public static void removeBook(String title, String author, Integer year) {
		if (title != null && author != null && year != null) {
			Book book = new Book(title, author, year);
			if (map.containsKey(book))
				map.remove(book);
			else
				System.out.println("There are no books with such parameters");
		}
		else
			throw new IllegalArgumentException("Null args");
	}
	
	public static String findBook(String title, String author, Integer year) {
		if (title != null && author != null && year != null) {
			Book book = new Book(title, author, year);
			if (map.containsKey(book))
				return map.get(book);
			else
				return "There are no books with such parameters";
		}
		else
			throw new IllegalArgumentException("Null args");
	}
	
	public static void printBooksWithPlaces() {
		
		if (map.isEmpty())
			System.out.println("There are no books in the libruary");
		
		map.forEach((k, v) -> System.out.println(k + "; Placed: " + v));
	}

}
