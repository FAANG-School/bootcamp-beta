package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class ForecastService {
    public static WeatherData getWeatherByCityFromInside(String city) {
        return new WeatherData(city, getRandomTemperature(), getRandomHumidity());
    }

    static String getRandomTemperature() {
        Random random = new Random();
        return String.valueOf(random.nextInt(-50, 50));
    }

     static String getRandomHumidity() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10, 100));
    }
}
