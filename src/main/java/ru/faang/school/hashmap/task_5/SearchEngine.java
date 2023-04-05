package ru.faang.school.hashmap.task_5;

import java.util.*;

public class SearchEngine {

    private final Map<String, List<WebPage>> cacheByContent = new HashMap<>();

    public void addToCache(WebPage webPage) {
        String[] keys = webPage.content().split(" ");

        for (String key : keys) {
            cacheByContent.computeIfAbsent(key, k -> new ArrayList<>()).add(webPage);
        }
    }

    public List<WebPage> findPages(String key) {
        return cacheByContent.get(key);
    }

    public void removePage(String url) {
        for (List<WebPage> pages : cacheByContent.values()) {
            for (Iterator<WebPage> iterator = pages.iterator(); iterator.hasNext();) {
                if (iterator.next().url().equals(url)) {
                    iterator.remove();
                }
            }
        }
    }
}
