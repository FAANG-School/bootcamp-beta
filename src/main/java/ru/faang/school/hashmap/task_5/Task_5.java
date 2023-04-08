package ru.faang.school.hashmap.task_5;

import ru.faang.school.hashmap.task_5.models.WebPage;

import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        var searchEngine = new HashMap<String, Map<String, WebPage>>();
        IndexPage(searchEngine, new WebPage("http://lazy.com/sleep", "Sleep", "Letters and mails."));
        IndexPage(searchEngine, new WebPage("http://news.com/crime", "Crime", "It is a crime. This crime was submitted by mail."));

        System.out.println(Search(searchEngine, "letters"));
        RemovePage(searchEngine, "http://lazy.com/sleep");
        System.out.println(Search(searchEngine, "letters"));
    }

    private static void IndexPage(Map<String, Map<String, WebPage>> indexedPages, WebPage page) {
        var words = page.getContent().toLowerCase(Locale.ROOT).split("[ .,?!-]");
        for (var word : words) {
            if (indexedPages.containsKey(word)) {
                indexedPages.get(word).put(page.getUrl(), page);
                continue;
            }

            indexedPages.put(word, new HashMap<String, WebPage>());
            indexedPages.get(word).put(page.getUrl(), page);
        }
    }
    private static Map<String, WebPage> Search(Map<String, Map<String, WebPage>> pages, String keyWord) {
        keyWord = keyWord.toLowerCase();
        if (pages.containsKey(keyWord)) {
            return pages.get(keyWord);
        }

        return null;
    }
    private static void RemovePage(Map<String, Map<String, WebPage>> pages, String url) {
        String[] keyWords = null;
        for (var pagesList : pages.entrySet()) {
            if (!pagesList.getValue().containsKey(url)) {
                continue;
            }

            keyWords = pagesList.getValue().get(url).getContent().toLowerCase(Locale.ROOT).split("[ .,?!-]");
            break;
        }

        if (keyWords == null) {
            return;
        }

        for (var key : keyWords) {
            pages.get(key).remove(url);
        }
    }
}
