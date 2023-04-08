package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {
    private Map<String, List<WebPage>> searchEngine = new HashMap<>();
    private Map<String, List<String>> urlKeywords = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        WebPage google = new WebPage("google.com","Google","Search engine find google how what");
        WebPage yandex = new WebPage("yandex.ru","Yandex-найдется все","Яндекс Дзен СМИ найдется все поиск как что новости");
        WebPage meduza = new WebPage("meduza.io","Медуза СМИ","Медуза СМИ новости иноагент");
        main.indexWebPage(google);
        main.indexWebPage(yandex);
        main.indexWebPage(meduza);
        main.removePageByUrl(meduza.getUrl());
        System.out.println(main.searchEngine);
        main.printPagesGroupedByKeywords();
    }

    public void indexWebPage(WebPage page) {
        for(String keyword : page.getContent().trim().strip().split(" ")) {
            if (!searchEngine.containsKey(keyword)) {
                searchEngine.put(keyword,new ArrayList<>());
            }
            searchEngine.get(keyword).add(page);
            if (!urlKeywords.containsKey(page.getUrl())) {
                urlKeywords.put(page.getUrl(),new ArrayList<>());
            }
            urlKeywords.get(page.getUrl()).add(keyword);
        }
    }

    public List<WebPage> searchByKeyword(String keyword) {
        return searchEngine.get(keyword);
    }

    public void removePageByUrl(String url) {
        List<String> keywords = urlKeywords.get(url);
        if (keywords==null) {
            throw new IllegalArgumentException("Страница с url "+url+" не существует");
        }
        for (String keyword : keywords) {
            Iterator<WebPage> iterator = searchEngine.get(keyword).iterator();
            while (iterator.hasNext()) {
                WebPage page = iterator.next();
                if (page.getUrl().equals(url)) {
                    iterator.remove();
                }
            }
            if (searchEngine.get(keyword).size()==0) {
                searchEngine.remove((keyword));
            }
        }
    }

    public void printPagesGroupedByKeywords() {
        System.out.println("Список найденных страниц по ключевым словам:");
        for(Map.Entry<String,List<WebPage>> entry : searchEngine.entrySet()) {
            System.out.println("'"+entry.getKey()+"':");
            for (WebPage page : entry.getValue()) {
                System.out.println("\t"+page.getTitle()+" - "+page.getUrl());
            }
        }
    }
    public Map<String,List<WebPage>> getSearchEngine() {
        return searchEngine;
    }

}
