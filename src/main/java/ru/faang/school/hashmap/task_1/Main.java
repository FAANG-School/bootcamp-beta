package ru.faang.school.hashmap.task_1;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {

    static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Stark", new House("Stark", "Wolf"));
        map.put("Lannister", new House("Lannister", "lion"));
        map.put("Barateon", new House("Barateon", "Deer"));

        Main main = new Main();
        main.printAllHouseAndSigil();
        main.getHouse("Stark");
        main.removeFromMap("Lannister");

        main.putToTheMap("Greyjoy", new House("Greyjoy", "Octopus"));
        main.printAllHouseAndSigil();
    }

    public void putToTheMap(String key, House value) {
        System.out.println("Добавление в мапу ключа: " + key + " и значения: " + value);
        map.put(key, value);
    }

    public void removeFromMap(String  key) {
        System.out.println("Удаление из мапы по ключу:" + key);
        map.remove(key);
    }

    public void getHouse(String name) {
        System.out.println("Поиска дома и вывода информации о гербе дома по его названию: " + name);
        System.out.println(map.get(name) + " " +  map.get(name).getSigil());
    }

    public void printAllHouseAndSigil() {
        System.out.println("Получаем список всех домов и их гербов:");
        for(Map.Entry<String, House> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

}
