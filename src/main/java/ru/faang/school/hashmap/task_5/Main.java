package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {
    private static Map<String, List<WebPage>> webPageMap = new HashMap<>();
    private static Map<String, WebPage> urlMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://example.com/page1", "Example Page 1", "This is an example web page.");
        WebPage webPage2 = new WebPage("https://example.com/page2", "Example Page 2", "This is another example web page.");

        index(webPage1);
        index(webPage2);

        show("this");

        delete("https://example.com/page2");

        show("is");
    }

    public static void index(WebPage webPage) {
        urlMap.put(webPage.getUrl(), webPage);
        String[] words = webPage.getContent().toLowerCase().split(" ");
        for (String word : words) {
            if (word.length() != 1) {
                List<WebPage> webPages = webPageMap.getOrDefault(word, new ArrayList<>());
                webPages.add(webPage);
                webPageMap.put(word, webPages);
            }
        }
    }

    public static void show(String keyWord) {
        System.out.println(webPageMap.get(keyWord.toLowerCase()));
    }

    public static void delete(String url) {
        WebPage webPage = urlMap.get(url);
        if (webPage == null) {
            return;
        }

        urlMap.remove(url);

        for (String keyword : webPage.getContent().split(" ")) {
            List<WebPage> webPages = webPageMap.get(keyword);
            if (webPages != null) {
                webPages.remove(webPage);
                if (webPages.isEmpty()) {
                    webPageMap.remove(keyword);
                }
            }
        }
    }
}

