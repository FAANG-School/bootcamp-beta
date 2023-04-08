package ru.faang.school.hashmap.task_1.dao;

import ru.faang.school.hashmap.task_1.domain.House;

public interface HouseDAO {

    void addNewHouse(House house);

    void deleteHouseByName(String name);

    void findHouseByName(String name);

    void conclusionAllHouse();
}