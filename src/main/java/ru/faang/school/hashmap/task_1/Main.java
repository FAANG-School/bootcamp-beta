package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        String req_house;

        FillHousesTestValues(houses);
        PrintAllInfo(houses);
        System.out.println();

        System.out.println("Добавим еще один дом.");
        AddHouse(houses, "Да́беллы ", "Бронзовый звонящий колокол на красном поле с золотой каймой");
        PrintAllInfo(houses);
        System.out.println();

        req_house = "Старк";
        System.out.println("Поиск заданного дома.");
        GetInfoHouse(houses, req_house);
        System.out.println();

        req_house = "Старкк";
        System.out.println("Поиск заданного дома.");
        GetInfoHouse(houses, req_house);
        System.out.println();

        System.out.println("Удаление дома.");
        req_house = "Баратеон";
        DeleteHouse(houses, req_house);
        PrintAllInfo(houses);


    }

    public static void FillHousesTestValues(Map<String, House> houses) {
        String[][] test_values = {
                {"Старк", "Серый лютоволк, бегущий по снежно-белому полю"},
                {"Ланнистер", "Золотой лев на алом поле"},
                {"Баратеон", "Чёрный коронованный олень на золотом поле"}
        };

        System.out.println("Заполнение мапы тестовыми значениями.");
        for (var pair : test_values) {
            AddHouse(houses, pair[0], pair[1]);
        }
    }

    public static void AddHouse(Map<String, House> houses,  String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }


    public static void DeleteHouse(Map<String, House> houses, String name) {
        houses.remove(name);
    }

    public static void GetInfoHouse(Map<String, House> houses, String name) {
        House cur_house = houses.get(name);
        if (cur_house != null) {
//            String res = cur_house.getName() + " " + cur_house.getSigil();
//            System.out.println("Дома найден: " + res);
            System.out.println("Дом найден: " + cur_house);
            return;
        }
        System.out.println("Дом: " + name + " не существует.");
    }

    public static void PrintAllInfo(Map<String, House> houses) {
        if (houses.size() != 0) {
            System.out.println("Содержание мапы: ");
            for (Map.Entry<String, House> entry : houses.entrySet()) {
                House cur_house = entry.getValue();
//                System.out.println("Дом: " + cur_house.getName() + ", герб: " + cur_house.getSigil());
                System.out.println(cur_house);
            }
        }
        else System.out.println("Мапа пустая.");
    }
}
