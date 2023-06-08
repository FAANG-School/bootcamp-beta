package ru.faang.school.hashmap.task_1;

import lombok.Getter;
import ru.faang.school.hashmap.task_1.подсказки.HouseBookException;

import java.util.HashMap;
import java.util.Map;
@Getter
public class HouseBook {

    private final Map<String, House> HOUSES = new HashMap<>(Map.of(
            "Lannister", new House("Lanniser", "a golden lion on a field of crimson"),
            "Stark", new House("Stark", "a grey direwolf on a white background"),
            "Baratheon", new House("Baratheon", "a black stag on a gold background")));


    public String addNewHouse(String houseName, String houseSigil) throws HouseBookException {
        if (HOUSES.containsKey(houseName)){
            throw new HouseBookException("The house " + houseName + " already exists in the book.");
        } else {
            HOUSES.put(houseName, new House(houseName, houseSigil));
            return "A house " + houseName + " added. There are " + HOUSES.size() + " in the list so far.";
        }
    }

    public String deleteHouse(String houseName) throws HouseBookException {
        if (HOUSES.containsKey(houseName)){
            HOUSES.remove(houseName);
            return "A house " + houseName + " deleted. There are " + HOUSES.size() + " in the list so far.";
        } else {
            throw new HouseBookException("The house " + houseName + " doesn't exist in the book.");
        }

    }

    public String getHouseSigil(String houseName) throws HouseBookException {
        if (HOUSES.containsKey(houseName)){
            return HOUSES.get(houseName).sigil;
        } else {
            throw new HouseBookException("The house " + houseName + " doesn't exist in the book.");
        }

    }

    public void getAllHouses() throws HouseBookException {
        if (HOUSES.isEmpty()){
            throw new HouseBookException("The housebook is empty for now :(");
        } else {
            for (Map.Entry<String, House> entry : HOUSES.entrySet()){
                System.out.println("House name is " + entry.getKey() + " and the sigil is " + entry.getValue());
            }
        }
    }
}
