package hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();

        House stark = new House("Stark", new Sigil());
        House lannister = new House("Lannister", new Sigil());
        House baratheon = new House("Baratheon", new Sigil());

        map.put(stark.getName(), stark);
        map.put(lannister.getName(), lannister);
        map.put(baratheon.getName(), baratheon);

        // Tests
        new House("Ruslan", new Sigil()).addHouse(map);
        System.out.println(map);

        House.removeHouse(map, "Stark");
        System.out.println(map);

        Sigil ruslanHouseSigil = House.getHouseSigil(map, "Ruslan");
    }
}
