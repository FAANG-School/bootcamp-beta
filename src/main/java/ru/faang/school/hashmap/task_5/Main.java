package ru.faang.school.hashmap.task_5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Map<String, List<WebPage>> searcher = new HashMap<>();

    public static void main(String[] args) {
        String url1 = "news.com";
        String url2 = "forum.com";
        String url3 = "important.com";
        String title1 = "Latest news";
        String title2 = "Discussion of everything";
        String title3 = "the most important thing";
        String content1 = "All the most important and latest news in the world, from children to finance.";
        String content2 = "The most interesting discussions, holy wars, important tips and a lot of different stuff.";
        String content3 = "Nothing can be more important than the information on this site. Everyone is an Illuminati here.";

        WebPage web1 = new WebPage(url1, title1, content1);
        WebPage web2 = new WebPage(url2, title2, content2);
        WebPage web3 = new WebPage(url3, title3, content3);

        indexWebPage(web1);
        indexWebPage(web2);
        indexWebPage(web3);
        System.out.println(findWebPage("the"));
        System.out.println(findWebPage("trinidad"));
        System.out.println(findWebPage("important"));
        printSearcherIndex();
        deleteUrlFromIndex("forum.com");
        printSearcherIndex();
        deleteUrlFromIndex("important.com");
        printSearcherIndex();
    }

    public static void indexWebPage(WebPage webPage) {
        Arrays.stream((webPage.getTitle() + " " + webPage.getContent()).split("\\s"))
                .map(word -> word.replaceAll("\\W", ""))
                .distinct()
                .forEach(word -> {
                    searcher.computeIfAbsent(word,
                            k -> new ArrayList<>()).add(webPage);
                });
    }

    public static List<WebPage> findWebPage(String keyword) {
        System.out.printf("Search by word: %s.\nResult: ", keyword);
        if (searcher.containsKey(keyword)) {
            return searcher.get(keyword);
        }else {
            System.out.println("Nothing found.");
            return new ArrayList<>();
        }
    }

    public static void deleteUrlFromIndex(String url) {
        /*
        a lot of time and two cups of coffee has been spent here
         */
        searcher.values().stream()
                .flatMap(list -> list.stream())
                .filter(webPage -> url.equalsIgnoreCase(webPage.getUrl()))
                .toList()
                .forEach(webPage -> {
                    for (List<WebPage> webPages : searcher.values()) {
                        webPages.remove(webPage);
                    }
                });
    }

    public static void printSearcherIndex(){
        System.out.println(" * * * * * * * * * * ");
        searcher.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        System.out.println(" * * * * * * * * * * ");
    }
}
