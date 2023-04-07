package ru.faang.school.hashmap.task_5;

import java.util.Objects;

public class WebPage {
    private String url;
    private String title;
    private String content;

    public WebPage(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebPage)) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(getUrl(), webPage.getUrl()) && Objects.equals(getTitle(), webPage.getTitle()) && Objects.equals(getContent(), webPage.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getTitle(), getContent());
    }
}
