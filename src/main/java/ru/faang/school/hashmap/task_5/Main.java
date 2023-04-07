package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<String, ArrayList<WebPage>> indexedPages = new HashMap<>();
    static HashMap<WebPage, ArrayList<String>> usesOfIndex = new HashMap<>();
    public static void main(String[] args) {
        index(new WebPage("mirpiva", "www.mirpiva.ru", "www buy pivo pivo pivo vodka pivo"));
        index(new WebPage("google", "www.google.com", "www search signin pivo vodka water sap thee koffie"));
        index(new WebPage("yandex", "www.yandex.ru", "www voiti poisk"));

        deleteByURL("www.yandex.ru");

        for(Map.Entry<String, ArrayList<WebPage>> entry : indexedPages.entrySet()) {
             System.out.print(entry.getKey() + ": ");
             for(WebPage page : entry.getValue()) {
                 System.out.print(page.title + " ");
             }
             System.out.println();
        }

        find("pivo");
        find("mercury");
    }

    public static void index(WebPage page) {
        for(String word : page.content.split(" ")) {
            if(indexedPages.containsKey(word)) {
                if(!indexedPages.get(word).contains(page)){
                    indexedPages.get(word).add(page);
                }
            } else {
                ArrayList<WebPage> temp = new ArrayList<>();
                temp.add(page);
                indexedPages.put(word, temp);
            }
            if(usesOfIndex.containsKey(page)) {
                usesOfIndex.get(page).add(word);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(word);
                usesOfIndex.put(page,temp);
            }
        }
    }

    public static void find(String keyword) {
        if(indexedPages.containsKey(keyword)){
            System.out.print("Keyword \"" + keyword + "\" contain these pages: ");
            for(WebPage page : indexedPages.get(keyword)){
                System.out.print(page.title + " ");
            }
            System.out.println();
        } else {
            System.out.println("Indexed webpages does not contain this keyword: \"" + keyword + "\"");
        }
    }

    public static void deleteByURL(String url) {
        for(Map.Entry<WebPage, ArrayList<String>> entry : usesOfIndex.entrySet()) {
            if(entry.getKey().url.equals(url)) {
                for(String keyword : entry.getValue()){
                    indexedPages.get(keyword).remove(entry.getKey());
                    if(indexedPages.get(keyword).size() == 0) {
                        indexedPages.remove(keyword);
                    }
                }
            }

        }
    }
}
