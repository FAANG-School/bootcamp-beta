package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final HashMap<String, List<WebPage>> webPages = new HashMap<>();
    private static final HashMap<String, List<String>> urlWordMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage = new WebPage("https://yandex.ru/", "Yandex", "Search email, news, weather");
        WebPage webPage2 = new WebPage("https://www.google.com/", "Google",
                "Search gmail, news, weather, maps");

        indexingWebPage(webPage);
        indexingWebPage(webPage2);

        System.out.println(getWebPagesByWord("Search"));
        System.out.println("*****************************************************************************************");

        printWebPages();

        deleteByUrl("https://yandex.ru/");

        System.out.println("*****************************************************************************************");
        printWebPages();
    }

    private static void indexingWebPage(WebPage webPage) {
        String[] words = webPage.getContent().split("\\ |\\,|\\.|\\'");
        urlWordMap.put(webPage.getUrl(), Stream.of(words).filter(word -> !word.isEmpty()).collect(Collectors.toList()));
        for (String word : words) {
            if(!word.isEmpty()) {
                if(webPages.containsKey(word)) {
                    webPages.get(word).add(webPage);
                } else {
                    List<WebPage> webPageList = new ArrayList<>();
                    webPageList.add(webPage);
                    webPages.put(word, webPageList);
                }
            }
        }
        System.out.println();
    }

    private static List<WebPage> getWebPagesByWord(String word) {
        return webPages.get(word);
    }

    private static void deleteByUrl(String url) {
        if(urlWordMap.containsKey(url)) {
            for (String word : urlWordMap.get(url)) {
                for (WebPage webPage : webPages.get(word)) {
                    if(url.equals(webPage.getUrl())) {
                        webPages.get(word).remove(webPage);
                        if(webPages.get(word).size() == 0) {
                            webPages.remove(word);
                        }
                        break;
                    }
                }
            }
        }
    }

    private static void printWebPages() {
        for (Map.Entry entry : webPages.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", webpages: " + entry.getValue());
        }
    }
}