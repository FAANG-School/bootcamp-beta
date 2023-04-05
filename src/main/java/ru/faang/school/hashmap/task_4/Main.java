package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private final Map<String, WeatherData> weatherDataMap = new HashMap<>();

    {
        weatherDataMap.put("Almaty", new WeatherData("Almaty", 22.5, 5.0));
        weatherDataMap.put("Barcelona", new WeatherData("Barcelona", 35.5, 30.0));
        weatherDataMap.put("London", new WeatherData("London", 10.0, 77.0));
        weatherDataMap.put("Glasgow", new WeatherData("Glasgow", 14.5, 45.0));
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.showAllCityWeatherDataFromCache();

        main.getCityWeatherDataFromCache("Almaty");
        main.getCityWeatherDataFromCache("Miami");

        main.updateCityWeatherData("London", 11.5, 75.0);

        main.removeCityWeatherData("Glasgow");

        main.showAllCityWeatherDataFromCache();
    }

    private WeatherData getCityWeatherDataFromCache(String city) {
        if (!weatherDataMap.containsKey(city)) {
            weatherDataMap.put(city, getCityWeatherDataFromSensor(city));
        }
        return weatherDataMap.get(city);
    }

    private WeatherData getCityWeatherDataFromSensor(String city) {
        return new WeatherData(city, Math.floor(new Random().nextDouble() * 50), Math.floor(new Random().nextDouble() * 100));
    }

    private void updateCityWeatherData(String city, double temperature, double humidity) {
        WeatherData updatedWeatherData = weatherDataMap.get(city);
        updatedWeatherData.setTemperature(temperature);
        updatedWeatherData.setHumidity(humidity);
    }

    private void removeCityWeatherData(String city) {
        weatherDataMap.remove(city);
    }

    private void showAllCityWeatherDataFromCache() {
        weatherDataMap.forEach((city, weatherData) -> System.out.println(city + ": " + weatherData));
    }
}