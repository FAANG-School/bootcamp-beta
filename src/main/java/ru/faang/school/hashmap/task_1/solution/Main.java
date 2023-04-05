package ru.faang.school.hashmap.task_1.solution;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houses = new HashMap<>();
    private final static String STARK_SIGIL = "https://en.wikipedia.org/wiki/List_of_A_Song_of_Ice_and_Fire_characters#/media/File:A_Song_of_Ice_and_Fire_arms_of_House_Stark_running_direwolf_white_scroll.png";
    private final static String TARGARYEN_SIGIL = "https://en.wikipedia.org/wiki/List_of_A_Song_of_Ice_and_Fire_characters#/media/File:Coat_of_arms_of_House_Targaryen_of_Dragonstone.svg";
    private final static String LANNISTER_SIGIL = "https://en.wikipedia.org/wiki/List_of_A_Song_of_Ice_and_Fire_characters#/media/File:A_Song_of_Ice_and_Fire_arms_of_House_Lannister_red_scroll.png";

    private final static House STARK_HOUSE = new House("Stark", Paths.get(STARK_SIGIL));
    private final static House TARGARYEN_HOUSE = new House("Targaryen", Paths.get(TARGARYEN_SIGIL));
    private final static House LANNISTER_HOUSE = new House("Lannister", Paths.get(LANNISTER_SIGIL));

    static {
        houses.put(STARK_HOUSE.getName(), STARK_HOUSE);
        houses.put(TARGARYEN_HOUSE.getName(), TARGARYEN_HOUSE);
        houses.put(LANNISTER_HOUSE.getName(), LANNISTER_HOUSE);
    }

    public static void main(String[] args) {
        showAllHouses();

        String baratheonSigil = "https://en.wikipedia.org/wiki/List_of_A_Song_of_Ice_and_Fire_characters#/media/File:A_Song_of_Ice_and_Fire_arms_of_House_Baratheon_yellow_scroll_English.png";
        House baratheon = new House("Baratheon", Paths.get(baratheonSigil));
        addHouse(baratheon);

        removeHouse("sdsafsa");
        showAllHouses();

        removeHouse("Stark");
        removeHouse("Baratheon");
        showAllHouses();

        addHouse(new House("Stark", Paths.get("dsafasfaf")));
        showAllHouses();

        findHouse("dsfa");

        System.out.println(findHouse("fsafsa"));
        System.out.println("Stark");

        removeAllHouses();
        showAllHouses();
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(String houseName) {
        houses.remove(houseName);
    }


    public static House findHouse(String houseName) {
        return houses.get(houseName);
    }


    public static void showAllHouses() {
        System.out.println("Дома: ");
        for (House house : houses.values()) {
            System.out.println(house.getName() + " | " + house.getSigil());
        }
        System.out.println();
    }

    public static void removeAllHouses() {
        houses.clear();
    }
}
