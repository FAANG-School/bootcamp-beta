package ru.faang.school.hashmap.task_4;

public class WhatsWeatherService {
    static WeatherData getWeather(String city) {
        return new WeatherData(city, 10,10);
    }
}
