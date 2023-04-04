package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {
    private final Map<String, List<WebPage>> mapPages;

    public Main() {
        mapPages = new HashMap<>();
    }

    public void indexWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split(" ");
        for (String word : words) {
            final String lowerCaseWord = word.toLowerCase();
            mapPages.putIfAbsent(lowerCaseWord, new ArrayList<>());
            mapPages.get(lowerCaseWord).add(webPage);
        }
    }

    public List<WebPage> findPagesByKeyWord(String keyWord) {
        final List<WebPage> result = mapPages.get(keyWord.toLowerCase());
        if (result == null) {
            return new ArrayList<>();
        }
        return result;
    }

    public void removePage(String url) {
        final WebPage removedWebPage = new WebPage(url, "", "");
        for (Map.Entry<String, List<WebPage>> entry : mapPages.entrySet()) {
            final List<WebPage> pages = entry.getValue();
            pages.remove(removedWebPage);
        }
    }
}
