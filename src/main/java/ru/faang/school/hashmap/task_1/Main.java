package ru.faang.school.hashmap.task_1;

import java.util.HashMap;

public class Main {

    public static void addHouseToMap(HashMap<String, House> hashMap, House house) {
        hashMap.put(house.getName(), house);
    }

    public static void deleteHouseFromMap(HashMap<String, House> hashMap, String name) {
        for (String key :
                hashMap.keySet()) {
            if (key.equals(name)) {
                hashMap.remove(key);
            }
        }
    }

    public static void getInfoAboutSigilHome(HashMap<String, House> hashMap, String name) {
        for (String key :
                hashMap.keySet()) {
            if (key.equals(name)) {
                System.out.println(hashMap.get(key).getSigil());
            }

        }
    }

    public static void outInfoFromHome(HashMap<String,House> hashMap){
        for (String key:
                hashMap.keySet()) {
            System.out.println(key + " - " + hashMap.get(key).getSigil());
        }
    }

    public static void main(String[] args) {
        HashMap<String, House> hashMap = new HashMap<>();
        House house = new House("Лучники", "Герб лучников");
        House house1 = new House("Герой", "Герб героя");
        House house2 = new House("Дейнерис", "Драконы");
        House house3 = new House("Эльфы", "Эльфовый герб");
        addHouseToMap(hashMap, house);
        addHouseToMap(hashMap, house1);
        addHouseToMap(hashMap, house2);
        addHouseToMap(hashMap, house3);
        outInfoFromHome(hashMap);

    }
}
