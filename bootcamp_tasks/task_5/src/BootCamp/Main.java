package BootCamp;

import java.util.*;

public class Main {

    static Map<String, List<WebPage>> pageMap = new HashMap<>();

    static void addNewWebPage(WebPage webPage){

        List<String> contentWords = Arrays.stream(webPage.getContent().split("[ ,\\-]")).toList();
        System.out.println(contentWords.size());

        for (String word : contentWords) {
            if (pageMap.get(word) != null) {
                pageMap.get(word).add(webPage);
            } else {
                List<WebPage> webPages = new ArrayList<>();
                webPages.add(webPage);
                pageMap.put(word, webPages);
            }
        }


    }

    static void searchWord(String word){
        if (pageMap.get(word) != null) {
            pageMap.get(word).forEach(System.out::println);
        }
    }

    static void deleteWebPage(String url){
            for (var webPages : pageMap.values()) {
                webPages.removeIf(webPage -> webPage.getUrl().equals(url));
            }
    }

    public static void main(String[] args) {

        addNewWebPage(new WebPage("https://www.youtube.com/", "YouTube", "YouTube — видеохостинг, предоставляющий пользователям услуги хранения, доставки и показа видео."));
        addNewWebPage(new WebPage("https://www.google.ru/", "Google", "Google — американская транснациональная корпорация в составе холдинга Alphabet, инвестирующая в интернет-поиск, облачные вычисления и рекламные технологии."));
        addNewWebPage(new WebPage("https://yandex.by/", "Яндекс", "«Я́ндекс» — транснациональная компания в отрасли информационных технологий, чьё головное юридическое лицо зарегистрировано в Нидерландах, владеющая одноимённой системой поиска в интернете, интернет-порталом и веб-службами в нескольких странах. Наиболее заметное положение занимает на рынках России, Белоруссии и Казахстана."));
        searchWord("интернет");
        deleteWebPage("https://yandex.by/");
        deleteWebPage("https://yandex.ru/");
        searchWord("транснациональная");
        searchWord("булка");

    }
}
