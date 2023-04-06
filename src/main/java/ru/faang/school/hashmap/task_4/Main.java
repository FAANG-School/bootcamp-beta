package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    static {
        weatherDataMap.put("Moscow", new WeatherData("Moscow", -10, 50));
        weatherDataMap.put("Voronezh", new WeatherData("Voronezh", -20, 60));
        weatherDataMap.put("Repievka", new WeatherData("Repievka", 25, 40));
    }

    public static void main(String[] args) {
        printCashedCities();
        System.out.println(getWeatherData("Repievka"));
        updateWeatherData("Repievka");
        System.out.println(getWeatherData("Repievka"));
        removeWeatherData("Repievka");
        printCashedCities();
    }

    public static WeatherData getWeatherData(String city) {
        WeatherData weatherData;
        if (weatherDataMap.containsKey(city)) {
            weatherData = weatherDataMap.get(city);
        } else {
            weatherData = getNotCashedWeatherData(city);
            weatherDataMap.put(city, weatherData);
        }
        return weatherData;
    }

    public static void updateWeatherData(String city) {
        weatherDataMap.put(city, getNotCashedWeatherData(city));
    }

    public static void removeWeatherData(String city) {
        weatherDataMap.remove(city);
    }

    public static void printCashedCities() {
        for (String city : weatherDataMap.keySet()) {
            System.out.println(city);
        }
    }

    private static WeatherData getNotCashedWeatherData(String city) {
        return new WeatherData(city, -274, -1); // mock
    }
}
