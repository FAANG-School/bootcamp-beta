package ru.faang.school.hashmap.task_1;

import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class HouseBook {

    private final Map<String, HouseAttributes> houses = new HashMap<>();

    public String addNewHouse(String houseName, String houseMotto,  String houseSigil){
        if (houses.containsKey(houseName)){
            throw new HouseBookException(String.format(Message.HOUSE_ALREADY_EXISTS, houseName));
        }
        houses.put(houseName, new HouseAttributes(houseMotto, houseSigil));
        return String.format(Message.HOUSE_ADDED, houseName, houses.size());
    }

    public String deleteHouse(String houseName){
        if (houses.containsKey(houseName)){
            houses.remove(houseName);
            return String.format(Message.HOUSE_DELETED, houseName, houses.size());
        }
        throw new HouseBookException(String.format(Message.HOUSE_DOESNT_EXIST, houseName));
    }

    public String getHouseSigil(String houseName){
        if (houses.containsKey(houseName)){
            return houses.get(houseName).getSigil();
        }
        throw new HouseBookException(String.format(Message.HOUSE_DOESNT_EXIST, houseName));
    }

    public void getAllHouses(){
        if (houses.isEmpty()){
            throw new HouseBookException(Message.HOUSEBOOK_IS_EMPTY);
        }
        for (Map.Entry<String, HouseAttributes> entry : houses.entrySet()){
            System.out.printf((Message.HOUSE_INFO) + "%n", entry.getKey(), entry.getValue());
        }
    }

    public int getHouseBookSize(){
        return houses.size();
    }
}
