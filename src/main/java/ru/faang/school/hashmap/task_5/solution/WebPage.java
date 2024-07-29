package ru.faang.school.hashmap.task_5.solution;

import java.util.*;

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

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Set<String> getKeyWords(){
        String keyWords = getTitle()+" "+getContent();
        keyWords = keyWords.replace(".", "");
        keyWords = keyWords.replace(",", "");
        keyWords = keyWords.replace("!", "");
        keyWords = keyWords.replace("—", "");

        Set<String> keyWordsSet = new HashSet<>(Arrays.asList(keyWords.toLowerCase(Locale.ROOT).trim().split(" ")));
        keyWordsSet.remove("");

        return keyWordsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebPage webPage)) return false;
        return Objects.equals(getUrl(), webPage.getUrl()) && Objects.equals(getTitle(), webPage.getTitle()) && Objects.equals(getContent(), webPage.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getTitle(), getContent());
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
