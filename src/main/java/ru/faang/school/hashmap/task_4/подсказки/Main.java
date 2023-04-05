package ru.faang.school.hashmap.task_4.подсказки;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> map;

    public static void main(String[] args) {
        map = new HashMap<>();
        map.put("ST", new WeatherData("ST", "14", "1"));
        lookAtWeather();
    }

    static WeatherData viewTheWeather(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }


        map.put(MocServies.apiWeather().getCity(), MocServies.apiWeather());
        return MocServies.apiWeather();
    }


    static void updateInfoOfWeather(String key, String temperature, String humidity) {
        map.put(key, new WeatherData(key, temperature, humidity));
    }

    static void deleteInfoOfWeather(String key) {
        map.remove(key);
    }

    static void lookAtWeather() {
        for (Map.Entry weather: map.entrySet()) {
            System.out.println(weather.getValue().toString());
        }
    }
}

class WeatherData {
    private String city;
    private String temperature;
    private String humidity;

    public WeatherData(String city, String temperature, String humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}

class MocServies {
    static WeatherData apiWeather() {
        return new WeatherData("Moscow", "15", "1000");
    }
}