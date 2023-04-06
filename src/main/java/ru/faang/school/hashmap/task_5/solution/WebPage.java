package ru.faang.school.hashmap.task_5.solution;

import java.net.URL;
import java.util.Objects;

public class WebPage {
    private final URL url;
    private final String title;
    private final String content;

    public WebPage(URL url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url=" + url +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public URL getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(url, webPage.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }


}
