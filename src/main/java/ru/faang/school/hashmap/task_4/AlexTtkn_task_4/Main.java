package ru.faang.school.hashmap.task_4.AlexTtkn_task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Rostov", new WeatherData("Rostov", 18, 2));
        map.put("Moscow", new WeatherData("Moscow", 20, 1));
        map.put("Saint Petersburg", new WeatherData("Saint Petersburg", 18, 4));
        map.put("Togliatti", new WeatherData("Togliatti", 18, 2));
    }

    public static void getInfo(String city) {
        if (map.containsKey(city)) {
            System.out.println(String.format("Temperature: %s, humidity: %s", +
                    map.get(city).getTemperature(), map.get(city).getHumidity()));
        } else {
            findInfoFromExternalResource();
        }
    }
    public static void findInfoFromExternalResource() {

    }

    public static void updateCityInfo(String city) {
        if (map.containsKey(city)) {
            Random random = new Random();
            int randTemperature = random.nextInt((30) + 1);
            int randHumidity = random.nextInt((3) + 1);

            map.put(city, new WeatherData(city, randTemperature ,randHumidity));
        }
    }

    public static void deleteCityInfo(String city) {
        if (map.containsKey(city)) {
            map.remove(city);
        } else {
            System.out.println("Did not found.");
        }
    }

    public static void printCityInfo() {
        for (Map.Entry<String, WeatherData> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getTemperature() + ", " + entry.getValue().getHumidity());
        }
    }
}
