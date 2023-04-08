package ru.faang.school.task5;

import java.util.*;

public class WebPage {
    private String url;
    private String title;
    private String contenet;

    public WebPage(String url, String title, String contenet) {
        this.url = url;
        this.title = title;
        this.contenet = contenet;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContenet() {
        return contenet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebPage webPage = (WebPage) o;
        return Objects.equals(url, webPage.url) && Objects.equals(title, webPage.title) && Objects.equals(contenet, webPage.contenet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, title, contenet);
    }

    public static void main(String[] args) {
        Map<String, List<WebPage>> data  = new HashMap<>();


    }

    public static void addIndexWebPage(Map<String, List<WebPage>> data, WebPage webPage) {
        String[] index = webPage.getContenet().split(" ");
        for (String i : index) {
            if (data.containsKey(i)) {
                data.get(i).add(webPage);
            } else {
                data.put(i, new ArrayList<>());
                data.get(i).add(webPage);
            }
        }
    }

    public static List<WebPage> findWebPages(Map<String, List<WebPage>> data, String key) {
        List<WebPage> res = data.get(key);
        return res == null ? new ArrayList<>() : res;
    }

    public static void deleteIndex(Map<String, List<WebPage>> data, Map<String, WebPage> webPages, String url) {
        if (webPages.containsKey(url)) {
            WebPage webPage = webPages.get(url);
            String[] index = webPage.getContenet().split(" ");
            for (String i : index) {
                data.get(i).remove(webPage);
            }
        }
    }
}
