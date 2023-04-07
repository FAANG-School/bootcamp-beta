package ru.faang.school.hashmap.task_5;

import java.net.URL;

public class WebPage {
    private final URL url;
    private final String title;
    private final String context;

    public WebPage(URL url, String title, String context) {
        this.url = url;
        this.title = title;
        this.context = context;
    }

    public URL getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url=" + url +
                ", title='" + title + '\'' +
                '}';
    }
}
