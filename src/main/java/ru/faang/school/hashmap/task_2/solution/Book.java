package ru.faang.school.hashmap.task_2.solution;

import java.util.Objects;

public class Book {

  private String title;

  private String author;

  private Integer year;

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public Integer getYear() {
    return year;
  }

  public Book(String title, String author, Integer year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Book book = (Book) o;

    if (!Objects.equals(title, book.title)) {
      return false;
    }
    if (!Objects.equals(author, book.author)) {
      return false;
    }
    return Objects.equals(year, book.year);
  }

  @Override
  public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + (author != null ? author.hashCode() : 0);
    result = 31 * result + (year != null ? year.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Book{ title: " + title + ", author: " + author +", year: " + year + " }";
  }
}
