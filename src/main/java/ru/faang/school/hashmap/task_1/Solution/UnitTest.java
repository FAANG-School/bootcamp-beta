package ru.faang.school.hashmap.task_1.Solution;

import org.junit.Before;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class UnitTest {

    House h;
    House h1;
    House h2;
    House h3;
    Container map;


    @Before
    public void prepare(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        map = new Container();

    }

    @org.junit.Test
    public void addTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        map = new Container();
        map.add(h);
        map.add(h1);
        map.add(h2);
        map.add(h3);
    }

    @org.junit.Test
    public void equalsTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        map = new Container();
        Container map2 = new Container();
        map.add(h);
        map.add(h1);
        map.add(h2);
        map.add(h3);

        map2.add(h1);
        map2.add(h);
        map2.add(h3);
        map2.add(h2);

        assertEquals(map, map2);
    }

    @org.junit.Test
    public void removeTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        Container map = new Container();
        Container map2 = new Container();
        map.add(h);
        map.add(h1);
        map.add(h2);
        map.add(h3);

        map.remove(h2);

        map2.add(h1);
        map2.add(h);
        map2.add(h3);

        assertEquals(map, map2);
    }

    @org.junit.Test
    public void removeNonExistingValueTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");

        Container map = new Container();

        map.add(h);
        map.add(h1);

        assertFalse(map.remove("SuperRandomString"));
    }

    @org.junit.Test
    public void removeValueFromEmptyMapTest(){
        map = new Container();
        assertFalse(map.remove("RandomValue"));
    }

    @org.junit.Test
    public void findExistingValueTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        map = new Container();
        map.add(h);
        map.add(h1);
        map.add(h2);
        map.add(h3);

        assertEquals("FFlag", map.find("First"));
        assertEquals("SFlag", map.find("Second"));
        assertEquals("TFlag", map.find("Third"));
        assertEquals("FourFlag", map.find("Fourth"));
    }

    @org.junit.Test
    public void findNonExistingValueTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        map = new Container();
        map.add(h);
        map.add(h1);
        map.add(h2);
        map.add(h3);

        assertNull(map.find("thisStringDoesn'tExists"));
        assertNull(map.find("thisToo"));
    }

    @org.junit.Test
    public void showAllTest(){
        h = new House("First", "FFlag");
        h1 = new House("Second", "SFlag");
        h2 = new House("Third", "TFlag");
        h3 = new House("Fourth", "FourFlag");
        map = new Container();
        map.add(h);
        map.add(h1);
        map.add(h2);
        map.add(h3);
        try {
            File file = new File(
                    "src/main/resources/hashmap-task1/testLog.log"
            );

            map.showAll(new FileOutputStream(file));
        } catch (IOException e){
            fail("File Not Found Exception");
        }
    }

}
