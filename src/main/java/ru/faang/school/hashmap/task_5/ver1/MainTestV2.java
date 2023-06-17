package ru.faang.school.hashmap.task_5.ver1;

class MainTestV2 {
    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("https://vk.com", "vk", "vk vkontakte");
        WebPage webPage2 = new WebPage("https://music.yandex.ru", "яндекс.музыка", "музыка яндекс");
        WebPage webPage3 = new WebPage("https://ru.stackoverflow.com", "stackoverflow", "что-то сломал не работает упал прод");
        WebPage webPage4 = new WebPage("https://shazoo.ru", "shazoo", "новости игры пк железо");
        WebPage webPage5 = new WebPage("https://dzen.ru/", "dzen", "новости политика экономика спорт");
        WebPage webPage6 = new WebPage("https://yandex.ru", "yandex", "яндекс я");

        Main main = new Main();

        main.splittingIntoKeywords(webPage1);
        main.splittingIntoKeywords(webPage2);
        main.splittingIntoKeywords(webPage3);
        main.splittingIntoKeywords(webPage4);
        main.splittingIntoKeywords(webPage5);
        main.splittingIntoKeywords(webPage6);

        for (WebPage webPage : main.searchWepPages("новости")) {
            System.out.println(webPage.getUrl());
        }

        main.removePage("https://shazoo.ru");
        System.out.println("The end");
    }
}