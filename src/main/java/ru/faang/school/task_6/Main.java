package ru.faang.school.task_6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String,WeatherData> hashMap = new HashMap<>();

    public String getWeather(String city){
        if (hashMap.containsKey(city)) {
            WeatherData weatherData = hashMap.get(city);
            return weatherData.toString();
        }else {

        }
    }

}
