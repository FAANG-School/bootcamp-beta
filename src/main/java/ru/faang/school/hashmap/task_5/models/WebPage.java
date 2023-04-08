package ru.faang.school.hashmap.task_5.models;

public class WebPage {
    private final String _url;
    private final String _title;;
    private final String _content;

    public WebPage(String url, String title, String content) {
        _url = url;
        _title = title;
        _content = content;
    }

    public String getUrl() {
        return _url;
    }
    public String getTitle() {
        return _title;
    }
    public String getContent() {
        return _content;
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + _url + '\'' +
                ", title='" + _title + '\'' +
                ", content='" + _content + '\'' +
                '}';
    }
}
