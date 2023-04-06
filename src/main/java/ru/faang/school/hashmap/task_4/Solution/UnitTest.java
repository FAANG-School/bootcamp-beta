package ru.faang.school.hashmap.task_4.Solution;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UnitTest {
    public WeatherApp wa;
    @Before
    public void prepare(){
        wa = new WeatherApp();
    }
    @Test
    public void getTest(){
        assertEquals(new WeatherData("minsk", 1, 5),
                wa.getWeather("minsk"));
        assertEquals(new WeatherData("minsk", 1, 5),
                wa.getWeather("minsk"));

        assertNotEquals(new WeatherData("minsk", 2, 5),
                wa.getWeather("minsk"));
        assertNotEquals(new WeatherData("minsk", 3, 8),
                wa.getWeather("minsk"));
    }

    @Test
    public void removeTest(){
        wa.getWeather("Moscow");
        wa.getWeather("Kiev");
        wa.getWeather("LA");

        assertTrue(wa.remove("Moscow"));
        assertTrue(wa.remove("Kiev"));
        assertFalse(wa.remove("Kiev"));
        assertFalse(wa.remove("AnotherCity"));
    }

    @Test
    public void getAvailableTest(){
        wa.getWeather("Moscow");
        wa.getWeather("Kiev");
        wa.getWeather("LA");

        assertEquals(List.of("Kiev", "LA", "Moscow"), wa.getCities());
    }
}
