package ru.faang.school.hashmap.task_5;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void testIndex() {
        WebPage yandex = new WebPage("yandex.ru","Yandex-найдется все","Яндекс Дзен СМИ новости");
        Main main = new Main();
        main.indexWebPage(yandex);
        HashMap<String, List<WebPage>> expected = new HashMap<>();
        expected.put("Яндекс",new ArrayList<>(List.of(yandex)));
        expected.put("Дзен",new ArrayList<>(List.of(yandex)));
        expected.put("СМИ",new ArrayList<>(List.of(yandex)));
        expected.put("новости",new ArrayList<>(List.of(yandex)));
        assertEquals(expected,main.getSearchEngine());
    }

    @Test
    public void testRemoveByUrl() {
        WebPage yandex = new WebPage("yandex.ru","Yandex-найдется все","Яндекс Дзен СМИ новости");
        Main main = new Main();
        main.indexWebPage(yandex);
        HashMap<String, List<WebPage>> expected = new HashMap<>();
        expected.put("Яндекс",new ArrayList<>(List.of(yandex)));
        expected.put("Дзен",new ArrayList<>(List.of(yandex)));
        expected.put("СМИ",new ArrayList<>(List.of(yandex)));
        expected.put("новости",new ArrayList<>(List.of(yandex)));
        expected.clear();
        main.removePageByUrl("yandex.ru");
        assertEquals(expected,main.getSearchEngine());
    }

    @Test
    public void testSearch() {
        WebPage google = new WebPage("google.com","Google","Search engine find google how what");
        WebPage yandex = new WebPage("yandex.ru","Yandex-найдется все","Яндекс Дзен СМИ новости find");
        Main main = new Main();
        main.indexWebPage(google);
        main.indexWebPage(yandex);
        List<WebPage> expected1 = new ArrayList<>(List.of(google));
        List<WebPage> expected2 = new ArrayList<>(List.of(yandex));
        List<WebPage> expected3 = new ArrayList<>(List.of(google,yandex));
        assertEquals(expected1,main.searchByKeyword("google"));
        assertEquals(expected2,main.searchByKeyword("новости"));
        assertEquals(expected3,main.searchByKeyword("find"));
    }

}
