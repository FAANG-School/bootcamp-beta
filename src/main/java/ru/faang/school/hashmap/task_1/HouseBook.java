package ru.faang.school.hashmap.task_1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Getter
@RequiredArgsConstructor
public class HouseBook {

    private final Map<String, House> houses = new HashMap<>();

    public String addNewHouse(String houseName, String houseMotto,  String houseSigil){
        if (houses.containsKey(houseName)){
            throw new HouseBookException("The house " + houseName + " already exists in the book.");
        }
        houses.put(houseName, new House(houseMotto, houseSigil));
        return "A house " + houseName + " added. There are " + houses.size() + " in the list so far.";
    }

    public String deleteHouse(String houseName){
        if (houses.containsKey(houseName)){
            houses.remove(houseName);
            return "A house " + houseName + " deleted. There are " + houses.size() + " in the list so far.";
        }
        throw new HouseBookException("The house " + houseName + " doesn't exist in the book.");
    }

    public String getHouseSigil(String houseName){
        if (houses.containsKey(houseName)){
            return houses.get(houseName).sigil;
        }
        throw new HouseBookException("The house " + houseName + " doesn't exist in the book.");
    }

    public void getAllHouses(){
        if (houses.isEmpty()){
            throw new HouseBookException("The housebook is empty for now :(");
        }
        for (Map.Entry<String, House> entry : houses.entrySet()){
            System.out.println("House name is " + entry.getKey() + ", " + entry.getValue());
        }
    }
}
