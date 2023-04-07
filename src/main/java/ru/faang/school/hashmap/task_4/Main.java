package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static Map<String, WeatherData> weatherMap = new HashMap<>();
    private final static MockService mockService = new MockService();

    public static void main(String[] args) {
        System.out.println(getWeather("Odessa"));
        System.out.println(getWeather("Kong"));
        remove("Kong");
        printAll();
    }

    private static String getWeather(String city) {

        WeatherData weatherData = weatherMap.get(city);

        if (weatherData == null) {

            WeatherData wd = mockService.doSomeLongOperation(city);
            weatherMap.put(city, wd);

            return wd.toString();
        }

        return weatherData.toString();
    }

    private static void remove(String city) {
        weatherMap.remove(city);
    }

    private static void printAll() {
        weatherMap.forEach((s, weatherData) -> System.out.println(s + " : " + weatherData.toString()));
    }
}
