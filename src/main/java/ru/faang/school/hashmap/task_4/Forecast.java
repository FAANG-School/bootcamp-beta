package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Forecast {
    private Map<String, WeatherData> weatherReport = new HashMap<>();

    public String getWeatherReport(String city){
        if (weatherReport.containsKey(city)){
            return weatherReport.get(city).toString();
        } else {
            WeatherData newData = generateWhetherData(city);
            weatherReport.put(city, newData);
            return newData.toString();
        }
    }

    public String updateWeatherReport(String city){
        WeatherData newData = generateWhetherData(city);
        weatherReport.put(city, newData);
        return newData.toString();
    }

    public String getAllAvailableData(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, WeatherData> entry : weatherReport.entrySet()) {
            sb.append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }

    public String deleteForecast(String city){
        if (weatherReport.containsKey(city)){
            weatherReport.remove(city);
            return String.format(Message.CITY_DELETED, city);
        } else {
            throw new ForecastException(String.format(Message.NO_SUCH_CITY, city));
        }
    }

    private WeatherData generateWhetherData(String city){
        return new WeatherData(city,
                WeatherGenerator.generateTemperature(), WeatherGenerator.generateHumidity());
    }

    public int getWeatherReportSize(){
        return weatherReport.size();
    }
}
