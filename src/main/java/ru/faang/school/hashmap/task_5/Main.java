package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    static Map<String, List<WebPage>> indexedPages = new HashMap<>();
    static Map<WebPage, List<String>> cashed = new HashMap<>();
    ;


    static void index(WebPage page) {
        String content = page.getContent();

        String[] words = content.split(" ");
        cashed.put(page, new ArrayList<>());
        for (var word : words) {
            cashed.get(page).add(word);
            if (!indexedPages.containsKey(word)) {
                indexedPages.put(word, new ArrayList<>());
                indexedPages.get(word).add(page);
            } else {
                indexedPages.get(word).add(page);
            }
        }
    }

    static List<WebPage> findPages(String keyWord) {

        return indexedPages.get(keyWord);
    }

    static void deletePage(String url) {
        List<WebPage> pagesToDelete = new ArrayList<>();
        for (var entry : cashed.entrySet()) {
            WebPage page = entry.getKey();
            if (page.getUrl().equals(url)) {
                List<String> keyWords = entry.getValue();
                pagesToDelete.add(page);
                for (var word : keyWords) {
                    indexedPages.get(word).remove(page);
                }
            }

        }
        for (var page : pagesToDelete) {
            cashed.remove(page);
        }
    }

    static void printAll() {
        for (var entry : indexedPages.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (var page : findPages(entry.getKey())) {
                System.out.print(page.getTitle() + "; ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        index(new WebPage("google.com", "google", "i my search www delete home world"));
        index(new WebPage("yandex.ru", "yandex", "search www delete home world vodka job"));
        index(new WebPage("bing.com", "bing", "search www home world microsoft gates"));

        deletePage("bing.com");
        printAll();
    }
}
