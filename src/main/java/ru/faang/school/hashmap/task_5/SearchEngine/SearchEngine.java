package ru.faang.school.hashmap.task_5.SearchEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    public static void main(String[] args) {
        webPages.add(new WebPage("https://www.nytimes.com",
                "The New York Times", "Breaking news, latest news, news"));
        webPages.add(new WebPage("https://www.wikipedia.org",
                "Wikipedia", "Encyclopedia, Wiki"));
        webPages.add(new WebPage("https://www.youtube.com",
                "YouTube", "videos, music"));
        webPages.add(new WebPage("https://www.amazon.com",
                "Amazon", "Online Shopping, Shopping, Electronics, Apparel, Computers, Books"));
        webPages.add(new WebPage("https://www.reddit.com",
                "reddit", "forum"));
        webPages.add(new WebPage("https://www.instagram.com",
                "Instagram", "photos, videos, messages"));
        webPages.add(new WebPage("https://www.github.com",
                "GitHub", "software, development, Git"));
        webPages.add(new WebPage("https://www.nike.com",
                "Nike", "Just Do It, Sport, sneakers, clothe, garment"));
        webPages.add(new WebPage("https://www.apple.com",
                "Apple", "iPod, iTunes, Mac, laptop, desktop, iPhone, iPad"));
        webPages.add(new WebPage("https://www.spotify.com",
                "Spotify", "music"));
        for (WebPage webPage : webPages) {
            indexWebPage(webPage);
        }
        System.out.println(search("music"));
        System.out.println(search("videos"));
        System.out.println(search("iphone"));
        removeWebPage("https://www.apple.com");
        System.out.println(search("iphone"));
    }


    static Map<String, List<WebPage>> searchEngine = new HashMap<>();
    static List<WebPage> webPages = new ArrayList<>();

    static void indexWebPage(WebPage webPage) {
        List<WebPage> result = new ArrayList<>();
        result.add(webPage);
        searchEngine.put(webPage.getTitle().toLowerCase(), result);
        for (String keyWord : webPage.getKeyWords()) {
            if (searchEngine.containsKey(keyWord)) {
                searchEngine.get(keyWord).add(webPage);
            } else {
                searchEngine.put(keyWord, new ArrayList<>(result));
            }
        }

    }

    static List<WebPage> search(String word) {
        List<WebPage> result = new ArrayList<>();
        for (Map.Entry<String, List<WebPage>> map : searchEngine.entrySet()) {
            if (map.getKey().equals(word.toLowerCase())) {
                result.addAll(map.getValue());
            }
        }
        return result;
    }

    static void removeWebPage(String url) {
        WebPage deletePage = new WebPage();
        for (WebPage wp : webPages) {
            if (url.equals(wp.getUrl())) {
                deletePage = wp;
            }
        }
        for (String key : deletePage.getKeyWords()) {
            if (searchEngine.containsKey(key)) {
                searchEngine.get(key).remove(deletePage);
            } else {
                System.out.println("Web Page does not exist!");
            }
        }
    }
}
