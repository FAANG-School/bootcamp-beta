package ru.faang.school.hashmap.task_5.SearchEngine;

public class WebPage {
    private String url;
    private String title;
    private String content;

    private String[] keyWords;

    public WebPage(String url, String title, String content) {
        if (url == null || title == null) {
            throw new RuntimeException("Invalid value!");
        }
        this.url = url;
        this.title = title;
        this.content = content;
        keyWords = content.toLowerCase().split(", ");
    }

    public WebPage() {
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", title, url);
    }
}
