package ru.faang.school.hashmap.task_4.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> weatherDAtaCache = new HashMap<>();
    private static final Random random = new Random();

    static {
        WeatherData moscowWeatherData = new WeatherData("Moscow", 17, 70);
        WeatherData saintPetersburgWeatherData = new WeatherData("Saint-Petersburg", 12, 35);

        weatherDAtaCache.put(moscowWeatherData.getCity(), moscowWeatherData);
        weatherDAtaCache.put(saintPetersburgWeatherData.getCity(), saintPetersburgWeatherData);

    }

    public static void main(String[] args) {
        showAllWeatherDataInCache();
        removeWeatherDataInCache("Moscow");
        showAllWeatherDataInCache();
        updateCache("Moscow", new WeatherData("Moscow", 15, 65));
        updateCache("Moscow", new WeatherData("Moscow", 10, 75));
        showAllWeatherDataInCache();
        System.out.println(getWeatherDataFromCache("Moscow"));
    }

    public static WeatherData getWeatherDataFromCache(String city) {
        if (weatherDAtaCache.get(city) != null) return weatherDAtaCache.get(city);
        return getWeatherDataFromYandex(city);
    }

    private static WeatherData getWeatherDataFromYandex(String city) {
        WeatherData someWeatherData = new WeatherData(city, random.nextDouble() * 50, random.nextDouble() * 80);
        weatherDAtaCache.put(city, someWeatherData);
        return someWeatherData;
    }

    public static void updateCache(String city, WeatherData weatherData) {
        weatherDAtaCache.put(city, weatherData);
    }

    public static void removeWeatherDataInCache(String city) {
        weatherDAtaCache.remove(city);
    }

    public static void showAllWeatherDataInCache() {
        System.out.println();
        weatherDAtaCache.values().forEach(System.out::println);
    }


}
