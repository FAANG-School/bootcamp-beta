package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseMap = new HashMap<>();

        houseMap.put("Старк", new House("Старк", "Голова серого лютоволка на бело-зелёном фоне"));
        houseMap.put("Таргариен", new House("Таргариен", "Трёхглавый дракон красного цвета на чёрном фоне"));
        houseMap.put("Ланнистер", new House("Ланнистер",
                "Золотой лев, стоящий на задних лапах, на малиновом поле"));
        houseMap.put("Болтон", new House("Болтон",
                "Красный ободранный человек, распятый вниз головой на белом косом кресте на чёрном фоне"));
        houseMap.put("Баратеон", new House("Баратеон",
                "Черный коронованный олень, стоящий на задних ногах, на золотом поле"));
        houseMap.put("Фреи", new House("Фреи",
                "Две башни Близнецов и мост между ними на сером фоне, под замком находится синяя вода"));
        houseMap.put("Талли", new House("Талли",
                "Прыгающая серебряная форель среди красно-синих волн"));


        houseMap.remove("Старк");
        System.out.println(houseMap.get("Таргариен").getSigil());
        houseMap.forEach((s, house) -> System.out.println(house.toString()));
    }
}
