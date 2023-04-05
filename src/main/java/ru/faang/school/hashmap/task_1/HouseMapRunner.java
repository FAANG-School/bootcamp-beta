package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class HouseMapRunner {
    public static void main(String[] args) {
        House stark = new House("Stark", "Stark sigil");
        House barateon = new House("Barateon", "Barateon sigil");
        House stonton = new House("Stonton", "Stonton sigil");
        House rikker = new House("Rikker", "Rikker sigil");

        Map<String, House> houseMap = new HashMap<>();

        HouseService.putNewHouses(houseMap, stark, barateon, stonton, rikker);

        HouseService.printHousesInfo(houseMap);

        HouseService.removeHouse(houseMap, stark.getName());

        HouseService.printHousesInfo(houseMap);

        HouseService.getHouseInfo(houseMap, rikker.getName());
    }
}
