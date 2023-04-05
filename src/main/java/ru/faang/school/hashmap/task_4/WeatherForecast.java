package ru.faang.school.hashmap.task_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {

    private final WeatherRepository weatherRepository;

    Map<String, WeatherData> weatherForecastData = new HashMap<>();

    public WeatherForecast(Map<String, WeatherData> initialData, WeatherRepository weatherRepository) {
        weatherForecastData.putAll(initialData);
        this.weatherRepository = weatherRepository;
    }

    public WeatherData getWeather(String city) {
        WeatherData data = weatherForecastData.get(city);

        if (data == null) {
            data = weatherRepository.getWeatherForCity(city);
            weatherForecastData.put(city, data);
        }

        return data;
    }

    public void updateWeather(WeatherData data) {
        weatherForecastData.put(data.city(), data);
    }

    public void removeWeather(String city) {
        weatherForecastData.remove(city);
    }

    public void printWeather() {
        System.out.println(Arrays.toString(weatherForecastData.keySet().toArray()));
    }
}
