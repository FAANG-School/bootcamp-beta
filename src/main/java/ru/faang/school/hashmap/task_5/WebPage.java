package ru.faang.school.hashmap.task_5;

import java.net.URL;
import java.util.Objects;

public class WebPage {
    private URL url ;
    private String title ;
    private String content;

    public WebPage(URL url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "WebPage {" +
                "url='" + url.toString() + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
