package ru.faang.school.hashmap.task_1.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, House> houseMap = new HashMap<>(Map.of(
            "Stark", new House("House Stark of Winterfell ", "A running grey direwolf, on an ice-white field"),
            "Lannister", new House("House Lannister of Casterly Rock ", "A gold lion, on a crimson field" ),
            "Baratheon", new House("House Baratheon of Storm's End ", "A black crowned stag, on a gold field")
    ));

    public void addHouse(String name, House house) {
        houseMap.put(name, house);
        System.out.println("House " + name + " was added");
    }

    public void deleteHouse(String name) {
        House house = houseMap.remove(name);
        if (house == null) {
            System.out.println("House " + name + " was not found");
        } else {
            System.out.println("House " + name + " was deleted");
        }
    }

    public void showSigil(String name) {
        House house = houseMap.get(name);
        if (house == null) {
            System.out.println("House " + name + " was not found");
        } else {
            System.out.println("The sigil of house " + name + " is " + house.getSigil());
        }
    }

    public void showAllHouses() {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println(entry.getValue().getName() + " - " + entry.getValue().getSigil());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.showAllHouses();

        main.addHouse(
                "Targaryen",
                new House(
                        "House Targaryen of Dragonstone",
                        "A three-headed dragon breathing flames, red on black"
                ));

        main.showAllHouses();

        main.deleteHouse("Stark");
        main.deleteHouse("Lannister");
        main.deleteHouse("Arryn");

        main.showSigil("Arryn");

        main.addHouse(
                "Arryn",
                new House(
                        "House Arryn of the Eyrie",
                        "A sky-blue falcon soaring against a white moon, on a sky-blue field"
                ));

        main.showSigil("Arryn");
    }
}
