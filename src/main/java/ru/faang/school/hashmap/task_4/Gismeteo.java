package ru.faang.school.hashmap.task_4;

public class Gismeteo {
    public static WeatherData getInfoWeather(String city) {
        int temperature = (int) (Math.random() * 30);
        int humidity = (int) (Math.random() * 80 + 20);
        return new WeatherData(city, temperature, humidity);
    }
}
