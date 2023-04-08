package ru.faang.school.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataTest {
    Map<String, WeatherData> data;

    @BeforeEach
    void setUp() {
        data = new HashMap<>();
        data.put("N", new WeatherData("N", 10, 40));
        data.put("N2", new WeatherData("N2", 17, 80));
        data.put("N3", new WeatherData("N3", 37, 90));
    }

    @Test
    void getWeather() {
        WeatherData result = WeatherData.getWeather(data, "N2");

        assertNotNull(result);
        assertEquals(17, result.getTemperature());
    }

    @Test
    void getServiceWeather() {
        WeatherData result = WeatherData.getWeather(data, "N5");

        assertNotNull(result);
        assertEquals("N5", result.getCity());
        assertEquals(12, result.getTemperature());
    }

    @Test
    void updateWeather() {
        WeatherData newWeather = new WeatherData("N2", -5, 90);

        WeatherData.updateWeather(data, newWeather);

        assertEquals(-5, WeatherData.getWeather(data, "N2").getTemperature());
        assertEquals(90, WeatherData.getWeather(data, "N2").getHumidity());
    }

    @Test
    void deleteWeather() {
        WeatherData.deleteWeather(data, "N");

        assertEquals(2, data.size());
    }

    @Test
    void printAllWeatherData() {
        WeatherData.printAllWeatherData(data);
    }
}