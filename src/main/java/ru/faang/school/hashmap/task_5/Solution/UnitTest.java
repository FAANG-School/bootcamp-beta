package ru.faang.school.hashmap.task_5.Solution;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UnitTest {

    static SearchSystem google;
    @BeforeClass
    public static void prepare(){
        google = new SearchSystem();
        google.add(new WebPage("www.faang-school.org",
                Arrays.stream("Hello there".split(" ")).toList(),
                "FAANG School"));
        google.add(new WebPage("www.meta.com",
                Arrays.stream("It is not a facebook".split(" ")).toList(),
                "Not a Facebook"));
        google.add(new WebPage("www.hello-world.org",
                Arrays.stream("Hello world".split(" ")).toList(),
                "Hello world"));
        google.add(new WebPage("www.youtube.com",
                Arrays.stream("Big video hosting platform".split(" ")).toList(),
                "YouTube"));
    }

    @Test
    public void testAddCopy(){
        String firstTry = google.find("hosting");
        google.add(new WebPage("www.youtube.com",
                Arrays.stream("Big video hosting platform".split(" ")).toList(),
                "YouTube"));
        assertEquals(firstTry, google.find("hosting"));
    }

    @Test
    public void testRemove(){

        assertTrue(google.remove("www.youtube.com"));

        assertNull(google.findPages("video"));

        assertFalse(google.remove("nonexisting page"));
    }

    @Test
    public void findTest(){
        //simple check of string output
        System.out.println(google.find("Hello"));

        assertNull(google.findPages("no such string"));
        assertNull(google.findByURL("no such URL"));
    }

}
