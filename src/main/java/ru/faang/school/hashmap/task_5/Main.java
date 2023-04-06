package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<String, List<WebPage>> map = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        WebPage googleWebPage = new WebPage("google.com", "Google Search", "We will find everything");
        WebPage youtubeWebPage = new WebPage("youtube.com", "Youtube videos and shorts", "We will show all and 2 ads");

        main.addWebPage(googleWebPage);
        main.addWebPage(youtubeWebPage);

        main.showWebPagesByKeyword("we");

        main.removeWebPageByUrl("google.com");

        main.showWebPagesByKeyword("we");
    }

    private void addWebPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase().split("\\s");

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(webPage);
        }
    }

    private void showWebPagesByKeyword(String keyword) {
        List<WebPage> webPages = map.get(keyword.toLowerCase());
        webPages.forEach(webPage -> System.out.println(webPage.getUrl()));
    }

    private void removeWebPageByUrl(String url) {
        map.forEach((key, webPages) -> {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        });
    }
}