package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HouseBookTest {

    @Test
    void addNewHouseTest(){

        HouseBook.addNewHouse(
                "Targaryen", "a three-headed dragon breathing flames");

        assertEquals(4, HouseBook.houses.size());
    }

    @Test
    void getHouseSigil(){
        String result = HouseBook.getHouseSigil("Targaryen");
        assertEquals("a three-headed dragon breathing flames", result);
    }

    @Test
    void deleteHouse(){
        HouseBook.deleteHouse("Targaryen");
        assertEquals(3, HouseBook.houses.size());
    }

}
