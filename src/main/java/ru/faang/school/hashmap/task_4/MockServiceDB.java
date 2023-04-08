package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class MockServiceDB {
    public WeatherData getWeather(String city) {
        Random rand = new Random();

        return new WeatherData(
                city,
                rand.nextInt(-30, 30),
                rand.nextInt(0, 100)
        );
    }
}
