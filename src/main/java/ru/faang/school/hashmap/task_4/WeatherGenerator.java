package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class WeatherGenerator {
    public static int generateTemperature(){
        Random random = new Random();
        return random.nextInt(101) - 50;
    }

    public static int generateHumidity(){
        Random random = new Random();
        return random.nextInt(101);
    }
}
