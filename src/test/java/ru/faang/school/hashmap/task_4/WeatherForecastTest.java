package ru.faang.school.hashmap.task_4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WeatherForecastTest {

    @Test
    void testGetWeatherFromCache() {
        WeatherRepository repository = Mockito.mock(WeatherRepository.class);

        WeatherData data = new WeatherData("London", "20", "80");
        Map<String, WeatherData> initialData = new HashMap<>();
        initialData.put(data.city(), data);

        WeatherForecast weatherForecast = new WeatherForecast(initialData, repository);
        assertEquals(data, weatherForecast.getWeather("London"));
    }

    @Test
    void testGetWeatherFromRemoteCache() {
        WeatherData data = new WeatherData("Berlin", "10", "70");
        WeatherRepository repository = Mockito.mock(WeatherRepository.class);

        Map<String, WeatherData> initialData = new HashMap<>();

        WeatherForecast weatherForecast = new WeatherForecast(initialData, repository);
        assertNull(weatherForecast.getWeather("Berlin"));

        Mockito.when(repository.getWeatherForCity(data.city())).thenReturn(data);

        assertEquals(data, weatherForecast.getWeather("Berlin"));
    }

    @Test
    void updateWeather() {
        WeatherRepository repository = Mockito.mock(WeatherRepository.class);

        WeatherData londonWeather = new WeatherData("London", "20", "80");
        Map<String, WeatherData> initialData = new HashMap<>();
        initialData.put(londonWeather.city(), londonWeather);

        WeatherForecast weatherForecast = new WeatherForecast(initialData, repository);

        assertEquals(londonWeather, weatherForecast.getWeather("London"));

        londonWeather = new WeatherData("London", "30", "95");

        weatherForecast.updateWeather(londonWeather);

        assertEquals(londonWeather, weatherForecast.getWeather("London"));
    }

    @Test
    void removeWeather() {
        WeatherRepository repository = Mockito.mock(WeatherRepository.class);

        WeatherData londonWeather = new WeatherData("London", "20", "80");
        Map<String, WeatherData> initialData = new HashMap<>();
        initialData.put(londonWeather.city(), londonWeather);

        WeatherForecast weatherForecast = new WeatherForecast(initialData, repository);

        assertNotNull(weatherForecast.getWeather("London"));

        weatherForecast.removeWeather("London");

        assertNull(weatherForecast.getWeather("London"));
    }
}