package ru.faang.school.hashmap.task_4;

import ru.faang.school.hashmap.task_4.models.WeatherData;

import java.util.HashMap;
import java.util.Map;

public class Task_4 {
    public static void main(String[] args) {
        var weatherMap = new HashMap<String, WeatherData>();
        weatherMap.put("Berlin", new WeatherData("Berlin", 5d, 0.48d));
        weatherMap.put("London", new WeatherData("London", 5d, 0.85d));
        weatherMap.put("Paris", new WeatherData("Paris", 5d, 0.85d));
        weatherMap.put("Tokyo", new WeatherData("Tokyo", 19d, 0.61d));

        PrintAllowedWeather(weatherMap);
        UpdateWeather(weatherMap, "Berlin");
        System.out.println('\n');
        RemoveWeatherData(weatherMap, "London");
        PrintAllowedWeather(weatherMap);
    }

    private static WeatherData UpdateWeather(Map<String, WeatherData> weather, String key) {
        var data = weather.get(key);

        data.setTemperature(Math.random() * 40 - 10);
        data.setHumidity(Math.random());

        return data;
    }
    private static WeatherData RemoveWeatherData(Map<String, WeatherData> weather, String key) {
        return weather.remove(key);
    }
    private static void PrintAllowedWeather(Map<String, WeatherData> weathers) {
        for (var weather : weathers.entrySet()) {
            System.out.println(weather.getValue());
        }
    }
}
