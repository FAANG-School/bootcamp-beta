package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<String, WeatherData> weatherMap = new HashMap<>() {{
        put("Saint-Petersburg", new WeatherData("Saint-Petersburg", 3, "48%"));
        put("Moscow", new WeatherData("Moscow", 5, "55%"));
        put("Los-Angeles", new WeatherData("Los-Angeles", 15, "60%"));
        put("New-York", new WeatherData("New-York", 20, "80%"));

    }};

    public Map<String, WeatherData> getWeatherMap() {
        return weatherMap;
    }

    public WeatherData getWeatherInfo(String city) {
        if (city.isBlank()) throw new IllegalArgumentException("Not valid city");
        if (!weatherMap.containsKey(city)) {
            weatherMap.put(city, WeatherTemplate.getWeather(city));
        }
        return weatherMap.get(city);
    }

    public void updateWeatherData(String city, int temperature, String humidity) {
        if (weatherMap.containsKey(city)) {
            weatherMap.get(city).setTemperature(temperature);
            weatherMap.get(city).setHumidity(humidity + "%");
        } else {
            throw new IllegalArgumentException("Not valid city");
        }
    }

    public void updateWeatherData(String city, String humidity) {
        if (weatherMap.containsKey(city)) {
            weatherMap.get(city).setHumidity(humidity + "%");
        } else {
            throw new IllegalArgumentException("Not valid city");
        }
    }

    public void updateWeatherData(String city, int temperature) {
        if (weatherMap.containsKey(city)) {
            weatherMap.get(city).setTemperature(temperature);
        } else {
            throw new IllegalArgumentException("Not valid city");
        }
    }

    public void deleteWeatherData(String city) {
        weatherMap.remove(city);
    }

    public void getForecastAvailableCities() {
        weatherMap.keySet().forEach(System.out::println);
    }
}
