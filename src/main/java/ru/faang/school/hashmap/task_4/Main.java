package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, WeatherData> cash = new HashMap<>();

    static WeatherData whatsWeatherInCity(String city) {
        if(cash.containsKey(city.toLowerCase())) {
            return cash.get(city.toLowerCase());
        } else {
            cash.put(city.toLowerCase(),WhatsWeatherService.getWeather(city));
            return WhatsWeatherService.getWeather(city);
        }

    }

    static void updateWeather(String city, int temp, int hum) {
        if(cash.containsKey(city.toLowerCase())) {
            WeatherData weather = cash.get(city.toLowerCase());
            weather.setTemperature(temp);
            weather.setHumidity(hum);
            cash.put(city.toLowerCase(), weather);
        }
    }

    static void deleteWeather(String city) {
        if(cash.containsKey(city.toLowerCase())) {
            cash.remove(city.toLowerCase());
        }
    }

    static void printAll() {
        for(var entry : cash.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        cash.put("moscow", new WeatherData("Moscow", 20, 40));
        cash.put("amsterdam", new WeatherData("Amsterdam", 25, 60));
        cash.put("tokyo", new WeatherData("Tokyo", 27,70));
        cash.put("washington", new WeatherData("Washington", 25, 50));

        System.out.println(whatsWeatherInCity("London"));
        System.out.println(whatsWeatherInCity("Tokyo"));
        System.out.println();
        updateWeather("Moscow", 22,50);
        deleteWeather("LONDON");
        printAll();
    }
}
