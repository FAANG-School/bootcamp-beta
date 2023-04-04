package ru.faang.school.hashmap.task_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {

        House house1 = new House("Старк", "Старк-sigil");
        House house2 = new House("Ланнистер", "Ланнистер-sigil");
        House house3 = new House("Баратеон ", "Баратеон -sigil");

        for (House house : Arrays.asList(house1, house2, house3)) {
            map.put(house.getName(), house);
        }
        all_houses();
        new_house("TestName", "TestSigil");
        delete_house("Ланнистер");
        System.out.println(find_house("TestName"));
        System.out.println(find_house("ErrorName"));
        all_houses();
    }

    private static void new_house(String name, String sigil) {
        map.put(name, new House(name, sigil));
    }

    private static void delete_house(String name) {
        map.remove(name);
    }

    private static String find_house(String name) {
        for (String key : map.keySet()) {
            if (Objects.equals(name, key))
                return map.get(name).getInformation();
        }
        return String.format("Дома c названием %s нет", name);
    }

    private static void all_houses() {
        if (map.size() == 0) {
            System.out.println("Пока домов нет :(");
            return;
        }
        for (String key : map.keySet()) {
            System.out.println(map.get(key).getInformation());
        }
    }
}
