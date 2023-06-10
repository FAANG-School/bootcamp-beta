package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HouseBookTest {

    private HouseBook houseBook;

    @BeforeEach
    void setUp(){

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
        String result = houseBook.addNewHouse(
                "Targaryen", "Fire And Blood", "a three-headed dragon breathing flames");
        assertEquals(4, houseBook.getHouseBookSize());
        assertEquals("A house Targaryen added to the book. Houses in the book: 4.", result);
    }

    @Test
    void addNewHouseExistingInBookTest(){
        HouseBookException exception = assertThrows(HouseBookException.class,
                () -> houseBook.addNewHouse("Stark", "Winter is coming",
                "a grey direwolf on a white background"));

        assertEquals("The house Stark already exists in the book.", exception.getMessage());
    }

    @Test
    void getHouseSigilTest(){
        String result = houseBook.getHouseSigil("Stark");
        assertEquals("a grey direwolf on a white background", result);
    }

    @Test
    void getNotExistingHouseSigilTest(){
        HouseBookException exception = assertThrows(HouseBookException.class,
                () -> houseBook.getHouseSigil("Martell"));
        assertEquals("The house Martell doesn't exist in the book.", exception.getMessage());
    }

    @Test
    void deleteHouseTest(){
        String result = houseBook.deleteHouse("Stark");
        assertEquals(2, houseBook.getHouseBookSize());
        assertEquals("A house Stark deleted from the book. Houses in the book: 2.", result);
    }

    @Test
    void deleteNotExistingHouse(){
        assertThrows(HouseBookException.class, () -> houseBook.deleteHouse("Martell"));
        HouseBookException exception = assertThrows(
                HouseBookException.class, () -> houseBook.deleteHouse("Martell"));
        assertEquals("The house Martell doesn't exist in the book.", exception.getMessage());
    }
}
