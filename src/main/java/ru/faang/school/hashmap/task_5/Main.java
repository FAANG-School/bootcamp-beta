package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {

    Map<String, List<WebPage>> map = new HashMap<>();

    public static void main(String[] args) {

        Main main = new Main();

        main.addWebPage(new WebPage("https://www.youtube.com/", "YouTube", "YouTube — видеохостинг, предоставляющий пользователям услуги хранения, доставки и показа видео."));
        main.addWebPage(new WebPage("https://www.google.ru/", "Google", "Google — американская транснациональная корпорация в составе холдинга Alphabet, инвестирующая в интернет-поиск, облачные вычисления и рекламные технологии."));
        main.addWebPage(new WebPage("https://vk.com/feed", "ВКонтакте", "ВКонтакте – универсальное средство для общения и поиска друзей и одноклассников, которым ежедневно пользуются десятки миллионов человек. "));
        main.searchPageByWord("интернет");
        main.deleteWebPage("https://yandex.by/");
        main.deleteWebPage("https://yandex.ru/");
        main.searchPageByWord("друзей");
        main.searchPageByWord("интернет-поиск");

    }

    public void addWebPage(WebPage webPage) {

        List<String> contentWords = Arrays.stream(webPage.getContent().split("[ ,\\-]")).toList();
        System.out.println(contentWords.size());

        for (String word : contentWords) {
            if (map.get(word) != null) {
                map.get(word).add(webPage);
            } else {
                List<WebPage> webPages = new ArrayList<>();
                webPages.add(webPage);
                map.put(word, webPages);
            }
        }
    }

    public void searchPageByWord(String word) {
        if (map.get(word) != null) {
            map.get(word).forEach(System.out::println);
        }
    }

    public void deleteWebPage(String url) {
        for (var webPages : map.values()) {
            webPages.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }

}
