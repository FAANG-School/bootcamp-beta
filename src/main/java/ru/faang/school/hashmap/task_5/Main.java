package ru.faang.school.hashmap.task_5;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static HashMap<String, List<WebPage>> cacheSearchMap = new HashMap<>();
    public static void main(String[] args) throws MalformedURLException {
        indexWebPage(new WebPage(new URL("https://firstPage.ru"),  "FirstPage", "Интересная страниц про животных, птиц и рыб"));
        indexWebPage(new WebPage(new URL("https://firstPage.ru"),  "SecondPage", "Интересная страниц про птиц"));
        indexWebPage(new WebPage(new URL("https://anyPage.ru"),  "AnyPage", "Интересная страниц про рыб"));
        List<WebPage> list1 = getPages("Интересная");
        list1.forEach(System.out::println);
        System.out.println("_____________");

        list1 = getPages("рыб");
        list1.forEach(System.out::println);
        System.out.println("_____________");

        deleteWebPage(new URL("https://anyPage.ru"));
        list1 = getPages("рыб");
        list1.forEach(System.out::println);
    }

    static void deleteWebPage(URL url) {
        for (String string : cacheSearchMap.keySet()) {
            cacheSearchMap.get(string).remove(new WebPage(url, "", ""));
        }
    }

    static List<WebPage> getPages (String keyWord) {
        return cacheSearchMap.get(keyWord);
    }

    static void indexWebPage(WebPage webPage) {
        for (String keyWord : webPage.getContent().split(" ")) {
            if(!cacheSearchMap.containsKey(keyWord)) {
                cacheSearchMap.put(keyWord, new ArrayList<>());
            }
            cacheSearchMap.get(keyWord).add(webPage);
        }
    }
}
