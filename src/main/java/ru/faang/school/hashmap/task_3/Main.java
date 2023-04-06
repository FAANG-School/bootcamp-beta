package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
	
	private static final List<Student> students = new ArrayList<>();
	
	static {
		students.add(new Student("Jack London", "Literature", 2020));
		students.add(new Student("Bob Marley", "Music", 2021));
		students.add(new Student("Donald Ervin Knuth", "Computer Science", 2020));
		students.add(new Student("Joshua J. Bloch", "Computer Science", 2023));
		students.add(new Student("James Gosling", "Computer Science", 2020));
		students.add(new Student("Andy Warhol", "Design", 2022));
		
	}
	
	private static class Tuple {
		
		private final String faculty;
		private final Integer year;
		
		Tuple(String faculty, Integer year) {
			this.faculty = faculty;
			this.year = year;
		}
		
		Integer getYear() {
			return year;
		}

		@Override
		public int hashCode() {
			return Objects.hash(faculty, year);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			return Objects.equals(faculty, other.faculty) && Objects.equals(year, other.year);
		}

		@Override
		public String toString() {
			return "faculty: " + faculty + ", year: " + year;
		}
	}
	
	public static Map<Tuple, List<Student>> mapByFacultyAndYear() {
		
		return students.stream()
					   .collect(Collectors.groupingBy(s -> new Tuple(s.getFaculty(), s.getYear()), 
							    Collectors.toList()));
	}
	
	public static void add(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Null args");
		
		if (students.contains(student))
			System.out.println("This student already exists");
		else
			students.add(student);
	}
	
	public static void remove(String name, String faculty, Integer year) {
		if (name == null || faculty == null || year == null)
			throw new IllegalArgumentException("Null args");
		
		Student student = new Student(name, faculty, year);
		
		if (!students.remove(student))
			System.out.println("No such student in list");
	}
	
	public static List<Student> searchByFacultyAndYear(String faculty, Integer year) {
		if (faculty == null || year == null)
			throw new IllegalArgumentException("Null args");
		
		
		return mapByFacultyAndYear().get(new Tuple(faculty, year));
	}
	
	public static void printByByFacultyAndYear() {
		
		if(students.isEmpty())
			System.out.println("Students list is empty");
		else
			mapByFacultyAndYear().entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Tuple::getYear)))
				.forEach(e -> {
					System.out.println(e.getKey() + "\n  Students list:");
					e.getValue()
					  .forEach(System.out::println);
					System.out.println();
				});
		}
	
	/* just for testing. 
	 * pending delete */
	public static void clearTest() {
		students.clear();
	}
	
	/* just for testing. 
	 * pending delete */
	public static int sizeTest() {
		return students.size();
	}
	
	/* just for testing. 
	 * pending delete */
	public static boolean containsTest(Student student) {
		return students.contains(student);
	}
	
	/* just for testing. 
	 * pending delete */
	public static void removeTest(Student student) {
		students.remove(student);
	}
	
	/* just for testing. 
	 * pending delete */
	public static void addTest(Student student) {
		students.add(student);
	}

	public static void main(String[] args) {
		
		
		/* unsorted print map just for testing. 
		 * pending delete */
		mapByFacultyAndYear().forEach((k, v) -> {
			System.out.println(k + "\n  Students list: ");
			v.forEach(System.out::println);
			System.out.println();
		});
		
	}

}
