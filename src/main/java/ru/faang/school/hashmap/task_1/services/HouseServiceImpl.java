package ru.faang.school.hashmap.task_1.services;

import ru.faang.school.hashmap.task_1.domain.House;

import java.util.HashMap;
import java.util.Map;

public class HouseServiceImpl implements HouseService {

    private static final Map<String, House> houses = new HashMap<>();

    @Override
    public void addNewHouse(House house) {
        houses.put(house.getName(), house);
        System.out.println("Добавлен новый дом: " + house);
    }

    @Override
    public void deleteHouseByName(String name) {
        houses.remove(name);
        System.out.println("Удален дом c именем: " + name);
    }

    @Override
    public void findHouseByName(String name) {
        System.out.println("Дом " + name + " имеет название герба: " + houses.get(name).getSigil());
    }

    @Override
    public void conclusionAllHouse() {
        houses.entrySet().forEach(k -> System.out.println(k.toString()));
    }
}