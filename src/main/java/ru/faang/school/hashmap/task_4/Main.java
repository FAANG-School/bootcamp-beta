package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class Main {

    private static final Map<String, WeatherData> WEATHER_MAP = new HashMap<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        updateWeatherData("Mariupol", 10, 46.3);
        updateWeatherData("Kyiv", 12, 43.2);
        updateWeatherData("Lviv", 13, 40.3);
        updateWeatherData("Kharkiv", 8, 48.1);

        System.out.println("*************");
        System.out.println(getWeatherData("Mariupol"));
        System.out.println(getWeatherData("Dummy"));
        printAllWeatherData();

        System.out.println("*************");
        deleteWeatherDate("Lviv");
        printAllWeatherData();

        System.out.println("*************");
        updateWeatherData("Mariupol", 5, 50.0);
        updateWeatherData("Dnepropetrovsk", 1, 10.0);
        printAllWeatherData();
    }

    public static void addWeatherData(String city, Integer temperature, Double humidity) {
        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        WEATHER_MAP.put(weatherData.getCity(), weatherData);
    }

    public static void updateWeatherData(String city, Integer temperature, Double humidity) {
        Optional.ofNullable(WEATHER_MAP.get(city))
                .ifPresentOrElse(w -> {
                    w.setTemperature(temperature);
                    w.setHumidity(humidity);
                }, () -> addWeatherData(city, temperature, humidity));
    }

    public static void deleteWeatherDate(String city) {
        if (WEATHER_MAP.remove(city) != null) {
            System.out.println("WeatherData successfully removed from cache!");
        } else {
            System.out.println("WeatherData for " + city + " wasn't found!");
        }
    }

    public static void printAllWeatherData() {
        WEATHER_MAP.forEach((s, weatherData) -> System.out.printf("Weather for %s is: %s\n", s, weatherData));
    }

    public static WeatherData getWeatherData(String city) {
        return Optional.ofNullable(WEATHER_MAP.get(city))
                .orElseGet(() -> {
                    WeatherData weatherData = generateWeatherDate(city);
                    WEATHER_MAP.put(city, weatherData);
                    return weatherData;
                });
    }

    private static WeatherData generateWeatherDate(String city) {
        return new WeatherData(city, random.nextInt(-10, 10), random.nextDouble(0, 100));
    }
}
