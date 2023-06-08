package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.hashmap.task_1.подсказки.HouseBookException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HouseBookTest {

    private HouseBook houseBook;

    @BeforeEach
    void setUp(){
        houseBook = new HouseBook();
    }

    @Test
    void addNewHouseTest() throws HouseBookException {

        houseBook.addNewHouse(
                "Targaryen", "a three-headed dragon breathing flames");

        assertEquals(4, houseBook.getHOUSES().size());
    }

    @Test
    void addNewHouseExistingInBookTest() throws HouseBookException {

        assertThrows(HouseBookException.class,
                () ->  houseBook.addNewHouse("Stark", "a grey direwolf on a white background"));
    }

    @Test
    void getHouseSigilTest() throws HouseBookException {
        String result = houseBook.getHouseSigil("Stark");
        assertEquals("a grey direwolf on a white background", result);
    }

    @Test
    void getNotExistingHouseSigilTest() throws HouseBookException {
        assertThrows(HouseBookException.class, () -> houseBook.getHouseSigil("Martell"));
    }

    @Test
    void deleteHouseTest() throws HouseBookException {
        houseBook.deleteHouse("Stark");
        assertEquals(2, houseBook.getHOUSES().size());
    }

    @Test
    void deleteNotExistingHouse() throws HouseBookException {
        assertThrows(HouseBookException.class, () -> houseBook.deleteHouse("Martell"));
    }
}
