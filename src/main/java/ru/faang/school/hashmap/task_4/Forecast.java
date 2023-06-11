package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Forecast {
    private Map<String, WeatherData> weatherReport = new HashMap<>();

    public String getWeatherReport(String city){
        if (weatherReport.containsKey(city)){
            return weatherReport.get(city).toString();
        } else {
            WeatherData newData = new WeatherData(city,
                    WeatherGenerator.generateTemperature(), WeatherGenerator.generateHumidity());
            weatherReport.put(city, newData);
            return newData.toString();
        }
    }

    public int getWeatherReportSize(){
        return weatherReport.size();
    }
}
