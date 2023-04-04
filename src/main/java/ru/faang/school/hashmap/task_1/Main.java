package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Старк","Голова серого лютоволка на бело-зелёном фоне");
        House lannister = new House("Ланнистер","Золотой лев, стоящий на задних лапах, на малиновом поле");
        House barateon = new House("Баратеон","Черный коронованный олень, стоящий на задних ногах, на золотом поле");
        House tully = new House("Талли","Прыгающая серебряная форель среди красно-синих волн");
        Main test = new Main();
        test.getHouses().put(stark.getName(),stark);
        test.getHouses().put(lannister.getName(),lannister);
        test.getHouses().put(barateon.getName(),barateon);
        test.getHouses().put(tully.getName(),tully);

        try {
            test.removeHouse("123");
            test.printSigilInfo("123");
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public Map<String, House> getHouses() {
        return houses;
    }

    public void setHouses(Map<String, House> houses) {
        this.houses = houses;
    }

    public void addHouse(House house) {
        houses.put(house.getName(),house);
    }
    public void removeHouse(String houseName) {
        if (getHouseByName(houseName)==null)  {
            throw new IllegalStateException("Дом с названием "+houseName+" не найден");
        }
        houses.remove(houseName);
    }

    public House getHouseByName(String houseName) {
        return houses.get(houseName);
    }

    public void printSigilInfo(String houseName) {
        if (getHouseByName(houseName)==null)  {
            throw new IllegalStateException("Дом с названием "+houseName+" не найден");
        }
        System.out.println("Дом "+houseName+" имеет герб '"+getHouseByName(houseName).getSigil()+"'");
    }

    public void printAllHouses() {
        for(Map.Entry<String,House> entry : houses.entrySet()) {
            System.out.println("Дом "+entry.getKey()+" имеет герб '"+entry.getValue().getSigil()+"'");
        }
    }

}
