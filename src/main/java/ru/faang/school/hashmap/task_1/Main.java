package ru.faang.school.hashmap.task_1;

import java.util.HashMap;

public class Main
{
    private static HashMap<String , House> mapOfHouses=new HashMap<>();
    public static void main(String[] args) {
        addHouse("Starks", new House("Starks", "Wolf"));
        addHouse("Targarians", new House("Targarians", "Dragon"));
        addHouse("Lanisters", new House("Lanisters", "Lion"));
        addHouse("Barateons", new House("Barateons", "Deer"));
        addHouse("Freis", new House("Freis", "Castle"));
        printAllMap();
    }
    public static void addHouse(String name, House house) {
        mapOfHouses.put(name, house);
    }

    public static void removeHouses(String name) {
        mapOfHouses.remove(name);
    }
    public static void printHouseFromMap(String name){
        System.out.println(mapOfHouses.get(name).getSigil());
    }
    public static void printAllMap(){
        for(String name:mapOfHouses.keySet()){
            System.out.println("Name of house:"+mapOfHouses.get(name).getName()+" ;"+"Sigil:"+mapOfHouses.get(name).getSigil());
        }
    }

}
