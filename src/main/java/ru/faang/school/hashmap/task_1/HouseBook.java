package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class HouseBook {

    static Map<String, House> houses = new HashMap<>();

       static {
           houses.putAll(Map.of(
                   "Lannister", new House("Lanniser", "a golden lion on a field of crimson"),
                   "Stark", new House("Stark", "a grey direwolf on a white background"),
                   "Baratheon", new House("Baratheon", "a black stag on a gold background")));
       }

    public static String addNewHouse(String houseName, String houseSigil){
          houses.put(houseName, new House(houseName, houseSigil));
          return "A house " + houseName + " added. There are " + houses.size() + " in the list so far.";
    }

    public static String deleteHouse(String houseName){
          houses.remove(houseName);
          return "A house " + houseName + " deleted. There are " + houses.size() + " in the list so far.";
    }

    public static String getHouseSigil(String houseName){
           return houses.get(houseName).sigil;
    }

    public static void getAllHouses(){
           for (Map.Entry<String, House> entry : houses.entrySet()){
               System.out.println("House name is " + entry.getKey() + " and the sigil is " + entry.getValue());
           }
       }
}
