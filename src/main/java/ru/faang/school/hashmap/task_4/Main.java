package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> map = new HashMap<>();

    class MockService {
        public static String mockMethod(String key){
            map.put(key, new WeatherData(key, 18.5, 91));
            return getWeather(key);
        }
    }

    public static String getWeather(String city){
        if (map.containsKey(city)) {
            return "Погода в городе " + map.get(city).toString();
        } else {
            return MockService.mockMethod(city);
        }
    }

    public static void editInfoWeather(String city, double temperature, double humidity){
        map.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeInfoOfCity(String city){
        map.remove(city);
    }

    public static void allCities(){
        for (Map.Entry<String, WeatherData> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println(getWeather("Москва"));
    }
}
