package ru.faang.school.hashmap.task_1;

import sun.util.resources.cldr.lo.CalendarData_lo_LA;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static Map<String, House> westerosHouse = new HashMap<>();

    public static void allHouses() {
        for (Map.Entry<String, House> house : westerosHouse.entrySet()) {
            System.out.println("Название дома: " + house.getKey() + " - герб " + house.getValue().getName());
        }
    }

    public static void addHouse(House house) {
        if (westerosHouse.containsKey(house.getName())) {
            System.out.println(String.format("Дом под названием %s уже есть в списке", house.getName()));
        } else {
            westerosHouse.put(house.getName(), house);
            System.out.println(house.getName() + " был добавлен в список!");
        }
    }

    public static void removeHouse(String houseName) {
        if (westerosHouse.containsKey(houseName)) {
            westerosHouse.remove(houseName);
            System.out.println(houseName + " был удален из списка!");
        } else {
            System.out.println(String.format("Дома под названием %s нет в списке - удалять нечего", houseName));
        }
    }

    public static void getHouse(String houseName) {
        if (!(westerosHouse.containsKey(houseName))) {
            System.out.println("Дом не был найден");
        } else {
            System.out.println(String.format("Дом %s был найден - герб %s", houseName, westerosHouse.get(houseName).getName()));
        }
    }

    public static void main(String[] args) {
        House baratheon = new House("Баратеон", "черный олень");
        House stark = new House("Старк", "серый лютоволк");
        House greyjoy = new House("Грейджои", "золотой кракен");
        House arren = new House("Аррен", "белая луна");
        House lannister = new House("Ланнистер", "золотой лев");

        addHouse(baratheon);
        addHouse(stark);
        addHouse(baratheon);
        addHouse(lannister);
        removeHouse("Старк");
        removeHouse("Аррен");
        getHouse("жопа");
        getHouse("Баратеон");

        System.out.println("\nВывод всех домиков");
        allHouses();
    }
}