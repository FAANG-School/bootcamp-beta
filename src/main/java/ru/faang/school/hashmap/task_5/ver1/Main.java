package ru.faang.school.hashmap.task_5.ver1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<String, List<WebPage>> index = new HashMap<>();
    private Map<String, WebPage> indexUrl = new HashMap<>();

    public void splittingIntoKeywords(WebPage webPage) {
        String[] s = webPage.getContent().split(" ");
        String keyWords = null;
        for (int i = 0; i < s.length; i++) {

            keyWords = s[i];
            if (index.containsKey(keyWords)) {
                index.get(keyWords).add(webPage);
            } else {
                List<WebPage> webPages = new LinkedList<>();
                webPages.add(webPage);
                index.put(keyWords, webPages);
            }
        }

        List<WebPage> lastListWebPage = index.get(keyWords);
        WebPage lastElement = lastListWebPage.get(lastListWebPage.size() - 1);
        if (!indexUrl.containsKey(webPage.getUrl())) {
            indexUrl.put(webPage.getUrl(), lastElement);
        }
    }

    public List<WebPage> searchWepPages(String keyWords) {
        if (index.get(keyWords) != null) {
            List<WebPage> webPages = index.get(keyWords);
            return webPages;
        } else {
            throw new IllegalArgumentException("По ключевому слову " + keyWords + " страниц не найдено");
        }
    }

    public void removePage(String url) {
        WebPage removeWebPage = indexUrl.get(url);
        String[] keyWords = removeWebPage.getContent().split(" ");
        for (int i = 0; i < keyWords.length; i++) {
            index.get(keyWords[i]).remove(removeWebPage);
            if (index.get(keyWords[i]).size() == 0) {
                index.remove(keyWords[i]);
            }
        }
        indexUrl.remove(url);
    }

}
