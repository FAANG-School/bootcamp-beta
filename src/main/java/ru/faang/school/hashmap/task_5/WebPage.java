package ru.faang.school.hashmap.task_5;

import java.net.URL;
import java.util.Objects;

public class WebPage {
    private URL url;
    private String title;
    private String content;


    public WebPage(URL url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
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
        if (!(o instanceof WebPage)) return false;
        WebPage webPage = (WebPage) o;
        return getUrl().equals(webPage.getUrl()) && Objects.equals(getTitle(), webPage.getTitle()) && Objects.equals(getContent(), webPage.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getTitle(), getContent());
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url + "\n" +
                title + "\n" + "\n";
    }
}
