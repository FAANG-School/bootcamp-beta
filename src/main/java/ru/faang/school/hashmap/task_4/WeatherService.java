package ru.faang.school.hashmap.task_4;

import java.util.Random;

public class WeatherService {

    static double minTemp = -15.0;
    static double maxTemp = 50.0;

    static int minHumidity = 0;
    static int maxHumidity = 50;


    public static WeatherData getWeather(String city){
        Random random = new Random();
        Double temperature = minTemp + (maxTemp - minTemp) * random.nextDouble();
        int humidity = random.nextInt(maxHumidity - minHumidity + 1) + minHumidity;
        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        return weatherData;
    }
}
