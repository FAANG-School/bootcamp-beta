package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {
    static Map<String, List<WebPage>> webMap = new HashMap<>();
    static Map<String, String> urlRemoveMap = new HashMap<>();

    public static void pageIndexing(WebPage webPage){
        String[] keyWord = webPage.getContent().split(" ");
        for (String key: keyWord){
            if (webMap.containsKey(key)) {
                List<WebPage> subList = webMap.get(key);
                subList.add(webPage);
                webMap.put(key, subList);
                urlRemoveMap.put(key, webPage.getUrl());
            } else {
                List<WebPage> newList = new ArrayList<>();
                newList.add(webPage);
                webMap.put(key, newList);
                urlRemoveMap.put(key, webPage.getUrl());
            }
        }
    }

    public static List<WebPage> findPage(String keyWord){
        return webMap.get(keyWord);
    }

    public static void removePage(String url){
        for (Map.Entry<String, String> entry: urlRemoveMap.entrySet()){
            if (entry.getValue().contains(url)) {
                webMap.remove(entry.getKey());
            }
        }
    }

    public static Map<String, List<WebPage>> getWebMap() {
        return webMap;
    }

    public static void main(String[] args) {
        String url1 = "http://www.google.com";
        String url2 = "http://www.yandex.com";
        pageIndexing(new WebPage(url1, "Google", "some content type"));
        pageIndexing(new WebPage(url2, "Yandex", "hello world!"));
        System.out.println(findPage("some"));
        System.out.println(findPage("hello"));
        removePage(url1);
        System.out.println(getWebMap());
    }
}
