package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<String, WeatherData> map = new HashMap<>();
    MockServiceDB mockServiceDB = new MockServiceDB();


    public static void main(String[] args) {
        Main main = new Main();

        main.map.put("Москва", new WeatherData("Москва", 8, 67));

        WeatherData weather = main.getWeatherByCity("Санкт-Петербург");
        WeatherData weather1 = main.getWeatherByCity("Москва");

        System.out.println(main.getWeatherByCity("Москва"));
        main.removeWeather("Москва");
        main.updateWeather("Новосибирск", 12, 55);
        main.showWeather();

        main.removeWeather("Новосибирск");

        main.showWeather();
    }


    public WeatherData getWeatherByCity(String city) {
        if (!map.containsKey(city))
            map.put(city, weatherStorage(city));
        return map.get(city);
    }

    public void updateWeather(String city, int temperature, int humidity) {
        WeatherData weather = new WeatherData(city, temperature, humidity);
        map.put(city, weather);
    }

    public void removeWeather(String city) {
        if (!map.containsKey(city)) return;
        map.remove(city);
    }

    public void showWeather() {
        for (Map.Entry<String, WeatherData> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    public WeatherData weatherStorage(String city) {
        return mockServiceDB.getWeather(city);
    }
}
