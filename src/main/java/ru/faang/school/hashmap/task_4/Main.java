package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static void main(String[] args) {
        weatherDataMap.put("Moscow", new WeatherData("Moscow", 18, 50));
        weatherDataMap.put("Dubai", new WeatherData("Dubai", 55, 10));
        weatherDataMap.put("London", new WeatherData("London", 12, 99));

        System.out.println(getWeatherByCity("Dubai"));

        refreshWeather("Moscow", new WeatherData("Moscow", 25, 45));

        deleteWeather("London");

        System.out.println();
        System.out.println("Print all cities in cache:");

        printAllCitiesWeather();


    }

    public static WeatherData getWeatherByCity(String city){
        if (weatherDataMap.containsKey(city)){
            return weatherDataMap.get(city);
        }
        WeatherData weatherData = getWeatherFromRemovedSource(city);
        weatherDataMap.put(city, weatherData);
        return weatherData;

    }

    public static boolean refreshWeather(String city, WeatherData weatherData){
        if (weatherDataMap.containsKey(city)){
            weatherDataMap.put(city, weatherData);
            return true;
        } else {
            return false;
        }
    }


    public static boolean deleteWeather(String city){
        if (weatherDataMap.containsKey(city)){
            weatherDataMap.remove(city);
            return true;
        } else {
            return false;
        }
    }

    public static void printAllCitiesWeather(){
        for (Map.Entry<String, WeatherData> entry : weatherDataMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static WeatherData getWeatherFromRemovedSource(String city){
        int randomTemperature = (int)(Math.random() * 100 + 1);
        int randomHumidity = (int)(Math.random() * 161) - 80;
        return new WeatherData(city, randomTemperature , randomHumidity );
    }

}
