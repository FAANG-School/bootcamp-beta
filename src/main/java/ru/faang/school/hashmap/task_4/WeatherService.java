package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class WeatherService {
    public WeatherData getWeather(String city) {
        Random rnd = new Random();

        return new WeatherData(
                city,
                Math.round(rnd.nextDouble(-30, 30)),
                Math.round(rnd.nextDouble(0, 100))
        );
    }
}
