package ru.faang.school.hashmap.task_1;

import java.util.Map;

public class HashMap {
    Map<String, House> map = new java.util.HashMap<>();
    public void putHouse(String key, House house) {map.put(key, house);} // realization of the put() method
    public void removeHouse(String key){map.remove(key);} // realization of the remove() method
    public void searchKey (String key){
        boolean keyName = map.containsKey(key);
        if (keyName){
            System.out.println("Sigil: " + map.get(key).getSigil());
        } else {
            System.out.println("FALSE");
        } // search of the house using key/true,false/ && realization of the get() method about sigil
    }
    public void printHouseMap() {
        for (Map.Entry<String,House> entry: map.entrySet()){
            System.out.println("KEY: " + entry.getKey() +" " + "VALUE: " + entry.getValue());
        }
    } // print all HashMap
}
