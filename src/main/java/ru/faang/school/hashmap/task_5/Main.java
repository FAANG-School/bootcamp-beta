package ru.faang.school.hashmap.task_5;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Main {

    private static Map<String, List<WebPage>> webPageMap = new HashMap<>();

    public static void main(String[] args) throws MalformedURLException {
        WebPage webPage1 = new WebPage("test1.com", "test1", "word1, word2, word3");
        WebPage webPage2 = new WebPage("test2.com", "test2", "word3, word4, word5");
        WebPage webPage3 = new WebPage("test3.com", "test3", "word6, word7, word8");
        WebPage webPage4 = new WebPage("test4.com", "test4", "word1, word3, word6");

        indexURL(webPage1);
        indexURL(webPage2);
        indexURL(webPage3);
        indexURL(webPage4);

        List<WebPage> webPageList = findWebPage("word3");

        for (WebPage wp : webPageList){
            System.out.println(wp.getUrl());
        }

        deleteWebPage("test4.com");

        System.out.println();
        for (WebPage wp : webPageList){
            System.out.println(wp.getUrl());
        }
    }

    public static void indexURL(WebPage webPage) {
        if (webPage.getContent() == null) return;
        String content = webPage.getContent();
        String[] contentWords = content.trim().split("[\\.?! ,;:]+");
        for (String word : contentWords){
            if (webPageMap.containsKey(word)){
                webPageMap.get(word).add(webPage);
            } else {
                List<WebPage> webPages = new ArrayList<>();
                webPages.add(webPage);
                webPageMap.put(word, webPages);
            }
        }
    }

    public static List<WebPage> findWebPage(String keyWord){
        if (webPageMap.containsKey(keyWord)){
            return webPageMap.get(keyWord);
        }
        return null;
    }

    public static void deleteWebPage(String url){
        for (Map.Entry<String, List<WebPage>> entry : webPageMap.entrySet()){
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
