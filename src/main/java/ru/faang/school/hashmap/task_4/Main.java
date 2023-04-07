package ru.faang.school.hashmap.task_4;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static ru.faang.school.hashmap.task_4.DataLoader.loadWeatherData;

public class Main {
    static HashMap<String, WeatherData> weather = new HashMap<>();

    public static void main (String[] args) {
        System.out.println(getWeatherData("Kyiv"));
        System.out.println(getWeatherData("Breda"));
        System.out.println(getWeatherData("Amsterdam"));
        System.out.println(getWeatherData("Utrecht"));
        System.out.println(getWeatherData("Nijmegen"));
        System.out.println();

        showAll();

        removeWeatherData("Nijmegen");
        removeWeatherData("Kharkiv");

        updateWeatherData("Breda", 15, 30);
        System.out.println(getWeatherData("Breda"));

        updateWeatherData("asd", 1, 1);

    }
    public static WeatherData getWeatherData(String city) {
        if(weather.containsKey(city)){
            return weather.get(city);
        } else {
            WeatherData loadedWeatherData = loadWeatherData(city);
            weather.put(city ,loadedWeatherData);
            return loadedWeatherData;
        }
    }

    public static void updateWeatherData(String city, double newTemperature, double newHumidity) {
        if(weather.containsKey(city)) {
            weather.replace(city, new WeatherData(city, newTemperature, newHumidity));
            System.out.println("Data for city " + city + " was updated.");
        } else {
            System.out.println("City \"" + city + "\" was not recorded yet");
        }
    }

    public static void removeWeatherData(String city) {
        if(weather.containsKey(city)){
            weather.remove(city);
            System.out.println("City \"" + city + "\" was removed.");
        } else {
            System.out.println("City \"" + city + "\" was not recorded yet");
        }
    }

    public static void showAll() {
        if(weather.size() == 0) {
            System.out.println("Records are empty.");
        }
        for(Map.Entry<String, WeatherData> entry : weather.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
