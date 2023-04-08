package ru.faang.school.hashmap.task_1;

public class Main {
    public static void main(String[] args) {
        HashMap houseMap = new HashMap(); //object connects with HashMap (in class HashMap)
        houseMap.putHouse("Stark", new House("houses of the North", "DireWolf"));
        houseMap.putHouse("Lannister", new House("houses of the Westerlands", "Lion"));
        houseMap.putHouse("Baratheon", new House("houses of the Crownlands", "BlackDeer"));
        houseMap.putHouse("Greyjoy", new House("houses of the Iron Islands","GoldenKraken"));
        houseMap.printHouseMap();
        houseMap.searchKey("Baratheon");
        houseMap.searchKey("Stark");
        houseMap.removeHouse("Baratheon");
        houseMap.searchKey("Baratheon");
        houseMap.printHouseMap();
    }
}
