package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, WeatherData> weatherMap = new HashMap<>();

    private WeatherService weatherService = new WeatherService();

    public WeatherData getWeather(String city) {
        if (!weatherMap.containsKey(city)) {
            weatherMap.put(city, weatherService.getWeather(city));
        }

        return weatherMap.get(city);
    }

    public void saveWeather(String city, double temperature, double humidity) {
        WeatherData weatherData = new WeatherData(city, temperature, humidity);

        weatherMap.put(city, weatherData);
    }

    public void removeWeather(String city) {
        if (!weatherMap.containsKey(city)) return;

        weatherMap.remove(city);
    }

    public void showWeather() {
        for (Map.Entry<String, WeatherData> entry : weatherMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.weatherMap.put("Москва", new WeatherData("Москва", 8.9, 67.5));

        WeatherData weather1 = main.getWeather("Тюмень");
        WeatherData weather2 = main.getWeather("Москва");

        System.out.println(weather1);
        System.out.println(weather2);
        System.out.println();

        main.showWeather();

        main.saveWeather("Казань",12.3, 55.5);
        System.out.println();

        main.showWeather();
        System.out.println();

        main.removeWeather("Тюмень");
        main.removeWeather("Екатеринбург");

        main.showWeather();
    }

}
