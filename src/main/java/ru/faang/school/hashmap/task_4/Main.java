package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherMap = new HashMap();
        weatherMap.put("Gomel", new WeatherData("Gomel", 13.0,67.0));
        getWeather("Gomel", weatherMap);
        System.out.println();
        showAll(weatherMap);
        System.out.println();
        getWeather("Minsk", weatherMap);
        System.out.println();
        showAll(weatherMap);
        System.out.println();
        update(weatherMap,"Minsk", 15.0, 68.0);
        showAll(weatherMap);
        System.out.println();
        delete(weatherMap,"Gomel");
        showAll(weatherMap);
    }

    public static void getWeather(String city, Map<String, WeatherData> weatherMap) {
        if (weatherMap.containsKey(city)) {
            System.out.println(weatherMap.get(city));
        } else {
            weatherMap.put(city,new WeatherData(city, MokWeather.getDEFAULT_TEMPERATURE(), MokWeather.getDEFAULT_HUMIDITY()));
            System.out.println(weatherMap.get(city));
        }
    }

    public static void update(Map<String, WeatherData> weatherMap, String city, Double temperature, Double humidity){
        weatherMap.get(city).setTemperature(temperature);
        weatherMap.get(city).setHumidity(humidity);
    }

    public static void delete(Map<String, WeatherData> weatherMap, String city){
        weatherMap.remove(city);
    }

    public static void showAll(Map<String, WeatherData> weatherMap){
        for(Map.Entry<String, WeatherData> weatherDataEntry: weatherMap.entrySet()){
            System.out.println(weatherDataEntry.getValue());
        }
    }
}

