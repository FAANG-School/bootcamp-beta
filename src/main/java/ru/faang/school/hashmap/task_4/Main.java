package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map<String, WeatherData> CACHE_WEATHER = new HashMap<>();

    public static void addToCache(WeatherData weatherData) {
        CACHE_WEATHER.put(weatherData.getCity(), weatherData);
    }

    public static void printWeatherCache() {
        System.out.println("\nИнфа в кэше: ");
        for (Map.Entry<String, WeatherData> weatherDataEntry: CACHE_WEATHER.entrySet()) {
            System.out.println(weatherDataEntry.getValue());
        }
        System.out.println();
    }

    public static void printCityCache() {
        System.out.println("\n\nГорода, которые есть в кэше:");
        for (Map.Entry<String, WeatherData> weatherDataEntry: CACHE_WEATHER.entrySet()) {
            System.out.print(weatherDataEntry.getKey() + " ");
        }
        System.out.println();
    }

    public static WeatherData getWeather(String city) {
        if (CACHE_WEATHER.containsKey(city)) {
            System.out.println("Инфа найдена в кэше!\n");
            return CACHE_WEATHER.get(city);
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

    public static void removeWeatherCache(String city) {
        CACHE_WEATHER.remove(city);
    }

    public static void updateWeatherCache(String city, int temperature, int humidity) {
        if (CACHE_WEATHER.containsKey(city)) {
            WeatherData weatherData = new WeatherData(city, temperature, humidity);
            CACHE_WEATHER.put(city, weatherData);
            System.out.println("Информация обновлена!");
        } else {
            System.out.println("Нечего апдейтить - нет инфы о таком городе!");
        }
    }

    public static void main(String[] args) {
        WeatherData weatherData1 = new WeatherData("Москва", 16, 35);
        WeatherData weatherData2 = new WeatherData("Ульяновск", 18, 60);
        WeatherData weatherData3 = new WeatherData("Брянск", 19, 54);
        WeatherData weatherData4 = new WeatherData("Казань", 17, 44);
        WeatherData weatherData5 = new WeatherData("Ярославль", 13, 42);

        addToCache(weatherData1);
        addToCache(weatherData2);
        addToCache(weatherData3);
        addToCache(weatherData4);
        addToCache(weatherData5);

        printWeatherCache();

        getWeather("Москва");
        getWeather("Пермь");

        printWeatherCache();

        printCityCache();

        removeWeatherCache("Ярославль");
        printCityCache();

        updateWeatherCache("Чебы", 15, 21);
        updateWeatherCache("Москва", 11, 88);

        printWeatherCache();
    }
}


