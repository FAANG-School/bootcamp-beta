package ru.faang.school.hashmap.task_4;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class DataLoader {
    public static WeatherData loadWeatherData(String city) {
        Random random = new Random(city.hashCode());

        return new WeatherData(city,random.nextDouble(-5,20),random.nextDouble(30,40));
    }
}
