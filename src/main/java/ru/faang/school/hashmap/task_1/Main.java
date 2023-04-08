package ru.faang.school.hashmap.task_1;

import ru.faang.school.hashmap.task_1.domain.House;
import ru.faang.school.hashmap.task_1.services.HouseService;
import ru.faang.school.hashmap.task_1.services.HouseServiceImpl;

public class Main {
    public static void main(String[] args) {
        HouseService houseService = new HouseServiceImpl();

        houseService.addNewHouse(new House("Старк", "Волк"));
        houseService.addNewHouse(new House("Ланнистер", "Лев"));
        houseService.addNewHouse(new House("Баратеон", "Роза"));

        houseService.conclusionAllHouse();

        houseService.deleteHouseByName("Старк");

        houseService.findHouseByName("Ланнистер");
    }
}