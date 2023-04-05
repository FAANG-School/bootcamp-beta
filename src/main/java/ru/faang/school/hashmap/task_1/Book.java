package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class Book {
	
	private String title;
	private String author;
	private Integer year;
	
	
	public Book(String title, String author, Integer year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	@Override
	public int hashCode() {
		return Objects.hash(author, title, year);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title)
				&& Objects.equals(year, other.year);
	}


	@Override
	public String toString() {
		return title + ", " + author + ", " + year;
	}
	
	
	
	

}
