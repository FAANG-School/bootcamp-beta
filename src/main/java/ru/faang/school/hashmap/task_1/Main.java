package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<String, House> HOMES = new HashMap<>();

    public Main() {
        this.putHouseToMap("House Martell", "A red sun pierced by a gold spear on an orange field. A gold spear on an orange field (historical)");
        this.putHouseToMap("House House Lannister", "A golden lion rampant on a crimson field");
        this.putHouseToMap("House Baratheon", "A crowned black stag salient on a gold field");
        this.putHouseToMap("House Arryn", "A white falcon volant and crescent moon on a blue field");
        this.putHouseToMap("House Greyjoy", "A gold kraken on a black field");
        this.putHouseToMap("House Stark", "A grey direwolf's head facing sinister on a white field and a green base");
    }


    public void putHouseToMap(String name, String sigil) {
        HOMES.put(name, new House(name, sigil));
    }

    public void removeHouseFromMap(String name) {
        HOMES.remove(name);
    }

    public void showHomeInfo(String name) {
        final House house = HOMES.get(name);
        if (house != null) {
            System.out.println("House: " + name + ". Sigil: " + house.getSigil());
        } else {
            System.out.println("House is not found");
        }
    }

    public void showAllHomeInfo() {
        for (Map.Entry<String, House> home : HOMES.entrySet()) {
            System.out.println("House: " + home.getKey() + ". Sigil: " + home.getValue().getSigil() + "\n");
        }
    }
}
