package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final WeatherService weatherService = new WeatherService();

    private static final HashMap<String, WeatherData> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(printWeatherByCityName("Moscow"));
        System.out.println(printWeatherByCityName("Moscow"));
        updateWeatherDataByCityName("Moscow", new WeatherData("Moscow", -20, 1.3));
        printCacheValues();
        System.out.println(printWeatherByCityName("Volgograd"));
        printCacheValues();
        removeWeatherDataByCityName("Volgograd");
        printCacheValues();
    }

    private static WeatherData printWeatherByCityName(String cityName) {
        if(cache.containsKey(cityName)) {
            System.out.println("Loaded from cache");
            return cache.get(cityName);
        } else {
            try {
                System.out.println("Loaded from service");
                WeatherData weatherData = weatherService.getWeatherDataByCityName(cityName);
                cache.put(cityName, weatherData);
                return weatherData;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void updateWeatherDataByCityName(String cityName, WeatherData weatherData) {
        if(cache.containsKey(cityName)) {
            cache.put(cityName, weatherData);
        }
    }

    private static void removeWeatherDataByCityName(String cityName) {
        cache.remove(cityName);
    }

    private static void printCacheValues() {
        for (WeatherData weatherData : cache.values()) {
            System.out.println(weatherData);
        }
    }
}

