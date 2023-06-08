package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HouseBookTest {

    private HouseBook houseBook;

    @BeforeEach
    void setUp(){
        Map<String, House> houses = new HashMap<>();
        houseBook = new HouseBook();
        houseBook.addNewHouse("Lannister", "A Lannister always pays his debts",
                "a golden lion on a field of crimson");
        houseBook.addNewHouse("Stark", "Winter Is Coming",
                "a grey direwolf on a white background");
        houseBook.addNewHouse("Baratheon", "Ours Is The Fury",
                "a black stag on a gold background");
    }

    @Test
    void addNewHouseTest(){

        houseBook.addNewHouse(
                "Fire And Blood", "Targaryen", "a three-headed dragon breathing flames");

        assertEquals(4, houseBook.getHouses().size());
    }

    @Test
    void addNewHouseExistingInBookTest(){

        assertThrows(HouseBookException.class,
                () ->  houseBook.addNewHouse("Stark", "Winter is coming",
                        "a grey direwolf on a white background"));
    }

    @Test
    void getHouseSigilTest(){
        String result = houseBook.getHouseSigil("Stark");
        assertEquals("a grey direwolf on a white background", result);
    }

    @Test
    void getNotExistingHouseSigilTest(){
        assertThrows(HouseBookException.class, () -> houseBook.getHouseSigil("Martell"));
    }

    @Test
    void deleteHouseTest(){
        houseBook.deleteHouse("Stark");
        assertEquals(2, houseBook.getHouses().size());
    }

    @Test
    void deleteNotExistingHouse(){
        assertThrows(HouseBookException.class, () -> houseBook.deleteHouse("Martell"));
    }
}
