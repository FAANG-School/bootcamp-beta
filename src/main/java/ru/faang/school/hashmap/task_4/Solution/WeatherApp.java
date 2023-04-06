package ru.faang.school.hashmap.task_4.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherApp {
    private final Map<String, WeatherData> data = new HashMap<>();

    public WeatherData getWeather(String city){
        if(!data.containsKey(city)){
            data.put(city, WeatherStation.generateWeather(city));
        }
        return data.get(city);
    }

    /**
     *
     * @param city name to remove
     * @return true if city was successfully removed
     * and false otherwise
     */
    public boolean remove(String city){
        return data.remove(city) != null;
    }

    public List<String> getCities(){
        return data.keySet().stream().sorted().toList();
    }
}
