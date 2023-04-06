package ru.faang.school.hashmap.task_5.solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> webPages = new HashMap<>();
    private static final Map<WebPage, List<String>> keyWordsForWebPage = new HashMap<>();

    public static void main(String[] args) throws MalformedURLException {
    }

    public static void indexWebPage(WebPage webPage) {
        Arrays.stream(webPage.getContent().split(" ")).forEach(keyWord -> {
            List<WebPage> webPagesList = webPages.get(keyWord);
            if (webPagesList == null) webPagesList = new ArrayList<>();
            webPagesList.add(webPage);
            webPages.put(keyWord, webPagesList);

            List<String> keyWords = keyWordsForWebPage.get(webPage);
            if (keyWords == null) keyWords = new ArrayList<>();
            keyWords.add(keyWord);
            keyWordsForWebPage.put(webPage, keyWords);
        });
    }

    public static List<WebPage> searchByKeyWord(String keyWord) {
        return webPages.get(keyWord);
    }

    public static void removeWebPageFromIndex(WebPage webPage) {
        List<String> keyWords = keyWordsForWebPage.get(webPage);
        keyWords.forEach(keyWord -> webPages.get(keyWord).remove(webPage));
    }
}
