package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class WeatherTemplate {

    public static WeatherData getWeather(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-20, 30), random.nextInt(-1, 500) + "%");
    }
}
