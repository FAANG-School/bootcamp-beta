package ru.faang.school.hashmap.task_5;


import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //возьмем для обучения, что контент идет с маленькой буквы через пробел.

        WebPage web1 = new WebPage("google.com", "google", "search info");
        WebPage web2 = new WebPage("vk.com", "VK", "info messenger");

        GoogleSearch googleSearch = new GoogleSearch();
        googleSearch.addWebPage(web1);
        System.out.println(googleSearch.addWebPage(web2));
        System.out.println("ниже без search");

        //Проверяем, что при изменении контента на сайте мапа меняется корректно
        WebPage web3 = new WebPage("google.com", "google", "info");
        System.out.println(googleSearch.addWebPage(web3));

        System.out.println("Сайты с пометкой info");
        System.out.println(googleSearch.findByKeyWord("info"));

        System.out.println("ниже без google.com");
        System.out.println(googleSearch.remove(web3));




    }

}
