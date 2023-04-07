package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class WeatherService {
    public static int[] getWeather(String city) {
        Random random = new Random();
        int[] tempHumidity = new int[2];
        tempHumidity[0] = -25 + random.nextInt(50);
        tempHumidity[1] = random.nextInt(100);
        return tempHumidity;
    }
}
