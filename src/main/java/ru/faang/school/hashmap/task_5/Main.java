package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<WebPage>> pageMap = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage = new WebPage("darova", "lol", "privet darova aloha");
        WebPage wp = new WebPage("privet", "em", "privet tebe");
        add(webPage);
        add(wp);

        System.out.println(getInfo("aloha"));

        remove(webPage.getUrl());
        printAll();
    }

    private static void add(WebPage webPage) {
        String[] strings = webPage.getContent().split(" ");

        for (String s : strings) {
            List <WebPage> pages = pageMap.get(s);

            addLogic(s, pages, webPage);
        }

    }
    private static void addLogic(String s, List<WebPage> pages, WebPage webPage) {
        if (pages == null) {
            pages = new ArrayList<>();
            pages.add(webPage);

            pageMap.put(s, pages);
            return;
        }

        if (pages.contains(webPage)) {
            return;
        }

        pages.add(webPage);
    }

    private static List<WebPage> getInfo(String word) {
        List<WebPage> pages = pageMap.get(word);
        return pages == null ? new ArrayList<>() : pages;
    }
    private static void remove(String url) {
        for (Map.Entry<String, List<WebPage>> map : pageMap.entrySet()) {

            List<WebPage> pages = map.getValue();

            pages.removeIf(webPage -> webPage.getUrl().equalsIgnoreCase(url));
        }
    }
    private static void printAll() {
        for (Map.Entry<String, List<WebPage>> map : pageMap.entrySet()) {
            System.out.println(map.toString());
        }
    }

}
