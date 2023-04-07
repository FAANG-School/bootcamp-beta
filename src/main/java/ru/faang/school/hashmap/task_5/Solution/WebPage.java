package ru.faang.school.hashmap.task_5.Solution;

import java.util.List;
import java.util.Objects;

public record WebPage(String URL, List<String> content, String title) {


    public String getURL() {
        return URL;
    }

    public List<String> getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(URL, webPage.URL) && Objects.equals(content, webPage.content) && Objects.equals(title, webPage.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(URL, content, title);
    }
}
