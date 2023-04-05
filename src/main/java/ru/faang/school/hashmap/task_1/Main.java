package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();

        // 0. Добавление информации о домах в HashMap
        houses.put("Старк", new House("Старк", "Серый лютоволк на бело-зеленом поле"));
        houses.put("Ланнистер", new House("Ланнистер", "Золотой лев на красном поле"));
        houses.put("Баратеон", new House("Баратеон", "Черный олень на золотом поле"));
        houses.put("Таргариен", new House("Таргариен", "Красный трехглавый дракон на черном поле"));

        // 1. Добавление нового дома
        houses.put("Тирелл", new House("Тирелл", "Золотая роза на зеленом поле"));

        // 2. Удаление дома по названию
        houses.remove("Баратеон");

        // 3. Поиск дома и вывод информации о гербе дома по его названию
        String houseName = "Старк";
        if (houses.containsKey(houseName)) {
            System.out.println(houses.get(houseName).getSigil());
        } else {
            System.out.println("Дом " + houseName + " не найден");
        }

        // 4. Вывод списка всех домов и их гербов
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
