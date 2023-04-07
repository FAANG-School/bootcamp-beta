package ru.faang.school.hashmap.task_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main underTest;

    @BeforeEach
    void setUp() {
        underTest = new Main();
        underTest.forecast.put("Kiev", new WeatherData("Kiev", "10", "75"));
        underTest.forecast.put("Minsk", new WeatherData("Minsk", "8", "65"));
        underTest.forecast.put("Warsaw", new WeatherData("Warsaw", "12", "72"));
        underTest.forecast.put("Vilnius", new WeatherData("Vilnius", "5", "64"));
        underTest.forecast.put("Stockholm", new WeatherData("Stockholm", "7", "85"));
    }

    @Test
    void getWeatherByCityThatIsInHash() {
        assertEquals(underTest.getWeatherByCity("Minsk"), new WeatherData("Minsk", "8", "65"));
    }

    @Test
    void getWeatherByCityThatIsNotInHash() {
        String city = "Amsterdam";
        underTest.getWeatherByCity(city);
        assertTrue(underTest.forecast.containsKey(city));

    }

    @Test
    void updateWeatherByCity() {
        String city = "Stockholm";
        int oldHash = underTest.forecast.get(city).hashCode();
        underTest.updateWeatherForCity(city);
        int newHash = underTest.forecast.get(city).hashCode();
        assertNotEquals(oldHash, newHash);
    }

    @Test
    void deleteCity() {
        underTest.deleteWeatherForCity("Stockholm");
        assertNull(underTest.forecast.get("Stockholm"));
    }
}