package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    static HashMap<String, List<WebPage>> miniGoogle = new HashMap<>();
    public static void main(String[] args) {

        WebPage wb1 = new WebPage("snakes.ru", "Snakes", "Змея всегда кусаться очень сильно и больно");
        WebPage wb2 = new WebPage("bear.org", "Bears", "Медведь всегда время есть мед лето а зима спать есть ягода лазить дерево");
        WebPage wb3 = new WebPage("hare.off", "Hares", "Заяц любить есть морковь и убегать от волк и медведь");
        WebPage wb4 = new WebPage("volves.com", "Volves", "Волк медведь любить охотиться за заяц и любить змея и зима голодать");
        WebPage wb5 = new WebPage("fox.kids", "Fox", "Лиса любить волк и хотеть есть заяц в свободное время");
        WebPage wb6 = new WebPage("bird.me", "Birds", "Птица жить и спать на дерево петь песня и смотреть как змея есть заяц");

        indexWebPage(wb1);
        indexWebPage(wb2);
        indexWebPage(wb3);
        indexWebPage(wb4);
        indexWebPage(wb5);
        indexWebPage(wb6);

        miniGoogle.entrySet().stream().forEach(System.out::println);

        System.out.println("На каких сайтах дерево:");
        System.out.println(getWebPagesByKeyWord("дерево"));
        System.out.println("На каких сайтах и:");
        System.out.println(getWebPagesByKeyWord("и"));
        System.out.println("На каких сайтах зима:");
        System.out.println(getWebPagesByKeyWord("зима"));
        System.out.println("На каких сайтах медведь:");
        System.out.println(getWebPagesByKeyWord("медведь"));


        System.out.println("Удаляю bear.org__________________________");

        delWebPage("bear.org");

        miniGoogle.entrySet().stream().forEach(System.out::println);



    }


    public static void indexWebPage(WebPage webPage){
        List<String> words = Arrays.stream(webPage.getContent().toLowerCase().split(" ")).toList();

        for (var word:words) {
            if (miniGoogle.containsKey(word)) {
                miniGoogle.get(word).add(webPage);
            } else {
                miniGoogle.put(word, new ArrayList<>());
                miniGoogle.get(word).add(webPage);
            }
        }
    }
    public static List<WebPage> getWebPagesByKeyWord(String word){
        return miniGoogle.get(word);
    }

    public static void delWebPage(String url){
        for (var words: miniGoogle.values()) {
            words.removeIf(word -> word.getUrl() == url);
        }
    }
}
