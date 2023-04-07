package ru.faang.school.hashmap.task_5;

import java.util.Objects;

public class WebPage {
    String url;
    String title;
    String content;

    WebPage(String title, String url, String content) {
        this.title = title;
        this.url = url;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebPage webPage = (WebPage) o;

        if (!Objects.equals(url, webPage.url)) return false;
        if (!Objects.equals(title, webPage.title)) return false;
        return Objects.equals(content, webPage.content);
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
