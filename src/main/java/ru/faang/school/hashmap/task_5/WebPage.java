package ru.faang.school.hashmap.task_5;

public record WebPage(
        String url,
        String title,
        String content
) {

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
