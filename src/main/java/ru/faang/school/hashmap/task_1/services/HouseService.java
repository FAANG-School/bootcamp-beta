package ru.faang.school.hashmap.task_1.services;

import ru.faang.school.hashmap.task_1.domain.House;

public interface HouseService {

    void addNewHouse(House house);

    void deleteHouseByName(String name);

    void findHouseByName(String name);

    void conclusionAllHouse();
}