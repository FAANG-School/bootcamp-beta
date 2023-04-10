package ru.faang.school.hashmap.task_4;


import java.util.*;


public class WeCache {

    public static void main(String[] args){
        Map<String, WeatherData> weatherDataMap = new HashMap<>();
        WeatherData kyiv = new WeatherData("Kyiv", 20 ,15);
        weatherDataMap.put(kyiv.getCity(), kyiv );
        weatherDataMap.put("Borispol", new WeatherData("Borispol", 26 ,28) );
        weatherDataMap.put("Brovaru", new WeatherData("Brovaru", 18,33) );
        weatherDataMap.put("Dnipro", new WeatherData("Dnipro", 13 ,25) );
        System.out.println(weatherInfo(weatherDataMap, "Kyiv"));
        updateCityInfo(kyiv);
        System.out.println(weatherInfo(weatherDataMap, "Kyiv"));
        removeWeatherInfo(weatherDataMap, "Kyiv");
        System.out.println(weatherInfo(weatherDataMap, "Kyiv"));
        System.out.println(weatherInfo(weatherDataMap, "Kyiv"));
    }

    private static void removeWeatherInfo(Map<String, WeatherData> weatherDataMap, String city) {
        if(weatherDataMap.containsKey(city)){
            weatherDataMap.remove(city);
        }
    }

    public static String weatherInfo(Map<String, WeatherData> weatherDataMap, String city){
        for (Map.Entry<String, WeatherData> entry : weatherDataMap.entrySet()) {
            if (city.equals(entry.getValue().getCity())) {
                WeatherData weatherData = entry.getValue();
                return "Temperature: " + weatherData.getTemperature() + ", Humidity: " + weatherData.getHumidity();
            }
        }
        weatherDataMap.put(city, new WeatherData(city , 13, 33));
        return  "Information about weather in " + city + " cached.";
    }

    public static void updateCityInfo(WeatherData weatherData){
        weatherData.setHumidity(10);
        weatherData.setTemperature(10);
    }


}
