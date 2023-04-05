package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String NOT_FOUND = "city %s not found in cache.\n";
    public static Map<String, WeatherData> cash = new HashMap<>();

    public static void main(String[] args) {
        printCashInformation();
        System.out.println(getWeatherData("London"));
        System.out.println(getWeatherData("Moscow"));
        updateWeatherData("London");
        updateWeatherData("Saint-Petersburg");


    }

    public static WeatherData getWeatherData(String city) {
        if (!cash.containsKey(city)) {
            cash.put(city, new WeatherDataServiceMock().getWeatherData(city));
        }
        return cash.get(city);
    }

    public static void updateWeatherData(String city) {
        if (cash.containsKey(city)) {
            cash.put(city, new WeatherDataServiceMock().getWeatherData(city));
            System.out.printf("Weather information for %s updated successfully\n", city);
        } else {
            System.out.printf(NOT_FOUND, city);
        }
    }

    public static void deleteCityFromCash(String city) {
        if (cash.containsKey(city)) {
            cash.remove(city);
            System.out.printf("Weather information for %s deleted successfully\n", city);
        } else {
            System.out.printf(NOT_FOUND, city);
        }
    }

    public static void printCashInformation() {
        if (cash.size() > 0) {
            System.out.println("The cache contains information for the following cities: ");
            cash.entrySet().stream()
                    .forEach(entry -> System.out.print(entry.getKey() + ", "));
        } else {
            System.out.println("The cash is empty");
        }
    }
}
