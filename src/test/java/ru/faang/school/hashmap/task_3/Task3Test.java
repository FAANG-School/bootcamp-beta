package ru.faang.school.hashmap.task_3;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Task3Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final Student student = new Student("John Michael Osbourne", "Music", 2021);
	private final List<Student> testList1 = List.of(
								new Student("Donald Ervin Knuth", "Computer Science", 2020),
								new Student("James Gosling", "Computer Science", 2020));
	private final List<Student> testList2 = List.of(
								new Student("Joshua J. Bloch", "Computer Science", 2023));
	
	@BeforeEach
	void init() {
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	void reset() {
		System.setOut(originalOut);
		Main.removeTest(student);
	}
	
	@Test
	void add() {
		assertEquals(false, Main.containsTest(student));
		Main.add(student);
		assertEquals(true, Main.containsTest(student));
	}
	
	@Test
	void addNullArgs() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.add(null));

		assertEquals("Null args", exception.getMessage());
	}
	
	@Test
	void addExisted() {
		assertEquals(false, Main.containsTest(student));
		Main.add(student);
		assertEquals(true, Main.containsTest(student));
		assertEquals(7, Main.sizeTest());
		Main.add(student);
		assertEquals("This student already exists"+"\r\n", outContent.toString());
		assertEquals(7, Main.sizeTest());
	}
	
	@Test
	void remove() {
		assertEquals(false, Main.containsTest(student));
		Main.addTest(student);
		assertEquals(true, Main.containsTest(student));
		Main.remove("John Michael Osbourne", "Music", 2021);
		assertEquals(false, Main.containsTest(student));
	}
	
	@Test
	void removeNotExisted() {
		Main.addTest(student);
		assertEquals(true, Main.containsTest(student));
		
		Main.remove("John Michael Osbourne Junior", "Music", 2021);
		assertEquals("No such student in list"+"\r\n", outContent.toString());
		assertEquals(true, Main.containsTest(student));
		
		System.setOut(originalOut);
		
		Main.remove("John Michael Osbourne", "Design", 2021);
		assertEquals("No such student in list"+"\r\n", outContent.toString());
		assertEquals(true, Main.containsTest(student));
		
		System.setOut(originalOut);
		
		Main.remove("John Michael Osbourne", "Music", 2020);
		assertEquals("No such student in list"+"\r\n", outContent.toString());
		assertEquals(true, Main.containsTest(student));
	}
	
	@Test
	void removeNullArgs() {
		assertEquals(false, Main.containsTest(student));
		Main.addTest(student);
		assertEquals(true, Main.containsTest(student));
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.remove("John Michael Osbourne", "Music", null));

		assertEquals("Null args", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.remove("John Michael Osbourne", null, 2021));
		
		assertEquals("Null args", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.remove(null, "Music", 2021));
		
		assertEquals("Null args", exception.getMessage());
		
	}
	
	@Test
	void searchByFacultyAndYear() {
		
		assertEquals(testList1, Main.searchByFacultyAndYear("Computer Science", 2020));
		assertEquals(testList2, Main.searchByFacultyAndYear("Computer Science", 2023));
		Main.addTest(student);
		
		assertEquals(List.of(new Student("Bob Marley", "Music", 2021), student), 
								Main.searchByFacultyAndYear("Music", 2021));
	}
	
	@Test
	void searchByFacultyAndYeardNullArgs() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.searchByFacultyAndYear(null, 2021));

		assertEquals("Null args", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.searchByFacultyAndYear("Music", null));

		assertEquals("Null args", exception.getMessage());
	}
	
	@Test
	void printByByFacultyAndYear() {
		Main.printByByFacultyAndYear();
		
		assertEquals("faculty: Computer Science, year: 2020\n  Students list:\r\n" +
					 "Donald Ervin Knuth\r\n" +
					 "James Gosling\r\n" + "\r\n" +
					"faculty: Literature, year: 2020\n  Students list:\r\n" +
					"Jack London\r\n" + "\r\n" +
					"faculty: Music, year: 2021\n  Students list:\r\n" +
					"Bob Marley\r\n" + "\r\n" +
					"faculty: Design, year: 2022\n  Students list:\r\n" +
					"Andy Warhol\r\n" + "\r\n" +
					"faculty: Computer Science, year: 2023\n  Students list:\r\n" +
					"Joshua J. Bloch\r\n" + "\r\n", 
						outContent.toString());
	}
	
	@Test
	void z_printByByFacultyAndYearEmpty() {
		Main.clearTest();
		Main.printByByFacultyAndYear();
		assertEquals("Students list is empty"+"\r\n", outContent.toString());
		
	}

}
