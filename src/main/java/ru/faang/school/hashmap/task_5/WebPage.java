package ru.faang.school.hashmap.task_5;

import java.net.URL;

public class WebPage {
    private URL url;
    private String title;
    private String content;

    public WebPage(URL url, String title) {
        this.url = url;
        this.title = title;
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
    public String toString() {
        return "WebPage{" +
                "url=" + url +
                ", title='" + title + '\'' +
                '}';
    }
}
