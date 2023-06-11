package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class inMemWeatherDataCache {
    private static final Map<String, WeatherData> WEATHER_DATA_CACHE = new HashMap<>();

    public static void addToCache(WeatherData weatherData) {
        WeatherData weatherData1 = WEATHER_DATA_CACHE.putIfAbsent(weatherData.getCity(), weatherData);
        if (weatherData1 != null) {
            System.out.println("Город " + weatherData.getCity() + " уже есть в кэше");
        }
    }

    public static void upsertWeatherCache(String city, int temperature, int humidity) {
        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        if (WEATHER_DATA_CACHE.containsKey(city)) {
            WEATHER_DATA_CACHE.put(city, weatherData);
            System.out.println("Город " + city + " есть в списке - обновили инфу");
        } else {
            WEATHER_DATA_CACHE.put(city, weatherData);
            System.out.println("Города " + city + " нет в списке - добавили в кэш");
        }
    }

    public static void removeWeatherCache(String city) {
        if (WEATHER_DATA_CACHE.containsKey(city)) {
            WEATHER_DATA_CACHE.remove(city);
            System.out.println("Город " + city + " удален из кэша");
        } else {
            System.out.println("Город " + city + " отсутствует в кэше - удалять нечего");
        }

    }

    public static void printCityCache() {
        System.out.println("\nГорода, которые есть в кэше:");
        for (String city : WEATHER_DATA_CACHE.keySet()) {
            System.out.print(city + " ");
        }
        System.out.println();
    }

    public static void printWeatherCache() {
        System.out.println("\nИнфа в кэше: ");
        for (WeatherData weatherData : WEATHER_DATA_CACHE.values()) {
            System.out.println(weatherData);
        }
        System.out.println();
    }

    public static WeatherData getWeather(String city) {
        if (WEATHER_DATA_CACHE.containsKey(city)) {
            System.out.println("Инфа найдена в кэше!\n");
            return WEATHER_DATA_CACHE.get(city);
        }
        else {
            System.out.println("В кэше город не найден...");
            System.out.println("Идем в инет для получения инфы...");
            WeatherData weatherData = Gismeteo.getInfoWeather(city);
            System.out.println("Получили инфу из инета!");
            addToCache(weatherData);
            System.out.println("Сложили полученную инфу в кэш");
            return weatherData;
        }
    }
}
