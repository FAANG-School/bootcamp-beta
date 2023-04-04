package ru.faang.school;

import ru.faang.school.hashmap.task_5.Main;
import ru.faang.school.hashmap.task_5.WebPage;

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        main.indexWebPage(new WebPage("www.yandex.com","Yandex","Search everything"));
        main.indexWebPage(new WebPage("www.google.com","Google","Search everything quickly"));
        main.indexWebPage(new WebPage("www.youtube.com","Youtube","Watch everything"));
        main.indexWebPage(new WebPage("www.twitter.com","Twitter","Post everything"));
        main.indexWebPage(new WebPage("www.instagram.com","Instagram","Post fotos quickly"));
        main.indexWebPage(new WebPage("www.yahoo.com","Yahoo ","Search"));

        System.out.println(main.findPagesByKeyWord("search"));

        System.out.println(main.findPagesByKeyWord("everything"));

        System.out.println(main.findPagesByKeyWord("fotos"));

        System.out.println(main.findPagesByKeyWord("fotoss"));

        main.removePage("www.google.com");

        System.out.println(main.findPagesByKeyWord("search"));
        System.out.println(main.findPagesByKeyWord("everything"));


    }
}
