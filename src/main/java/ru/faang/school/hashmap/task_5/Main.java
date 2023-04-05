package ru.faang.school.hashmap.task_5;

import java.net.URL;
import java.util.*;

public class Main {
    public static Map<String, List<WebPage>> webPageMap = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void indexing(WebPage webPage) {
        String[] contentArray = webPage.getContent().split(" ");
        for (int i = 0; i < contentArray.length; i++) {
            String word = contentArray[i];
            if (webPageMap.containsKey(word)) {
                webPageMap.get(word).add(webPage);
            } else {
                List<WebPage> list = new ArrayList<>();
                list.add(webPage);
                webPageMap.put(word, list);
            }
        }
    }

    public static List<WebPage> searchingWebPage(String word) {
        if (webPageMap.containsKey(word)) {
            return webPageMap.get(word);
        } else {
            return null;
        }
    }

    public static void deleteWebPage(URL url) {
        for (var entry : webPageMap.entrySet()) {
            List<WebPage> list = entry.getValue();
            Iterator<WebPage> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getUrl().equals(url)) {
                    iterator.remove();
                }

            }
        }
    }
}
