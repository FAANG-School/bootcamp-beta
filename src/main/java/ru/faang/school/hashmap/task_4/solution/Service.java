package ru.faang.school.hashmap.task_4.solution;

import java.util.Random;

public class Service {

    public static WeatherData getWeatherByCity(String city){
        return new WeatherData(city, new Random().nextFloat(-30f, 30f), new Random().nextInt(100));
    }
}
