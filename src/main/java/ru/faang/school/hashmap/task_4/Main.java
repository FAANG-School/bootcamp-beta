package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, WeatherData> cache = new HashMap<>();
        cache.put("Москва", new WeatherData("Москва", 30.0, 35));
        cache.put("Новосибирск", new WeatherData("Новосибирск", -30.0, 40));
        cache.put("Новокузнецк", new WeatherData("Новокузнецк", 10.5, 39));
        cache.put("Рязань", new WeatherData("Рязнь", 5.6, 25));
//        deleteWeather("Рязань", cache);

        getWeather("Донецк", cache);

        updateWeather("Москва", cache);
        deleteWeather("Донецк", cache);
        showAllAvailableCities(cache);



    }
    public static void getWeather(String city, Map<String, WeatherData> map){
        WeatherData weather = map.get(city);
        if (weather == null) {

            weather = WeatherService.getWeather(city);

            map.put(city,weather);


        }
        System.out.println("В городе " + city + " температура: " + String.format("%.1f", weather.getTemperature()) + ", влажность: " + weather.getHumidity());
    }

    public static void updateWeather(String city, Map<String, WeatherData> map){
        WeatherData weather = WeatherService.getWeather(city);
        map.put(city,weather);
        System.out.println("В городе " + city + " температура: " + String.format("%.1f", weather.getTemperature()) + ", влажность: " + weather.getHumidity());
    }

    public static void deleteWeather(String city, Map<String, WeatherData> map){
        map.remove(city);
        System.out.println("Информация о погоде из города " + city + " была успешно удалена");


    }
    public static void showAllAvailableCities(Map<String, WeatherData> map){
        for(String city:map.keySet()){
            System.out.println(city);
        }
    }
}
