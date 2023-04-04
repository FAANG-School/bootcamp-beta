package ru.faang.school.hashmap.task_4;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService {

    private static final ThreadLocalRandom RANDOMIZER = ThreadLocalRandom.current();

    private static final double MINIMUM_TEMPERATURE_THRESHOLD = -89.2;

    private static final double MAXIMUM_TEMPERATURE_THRESHOLD = 56.7;

    private static final double MINIMUM_HUMIDITY_THRESHOLD = 0;

    private static final double MAXIMUM_HUMIDITY_THRESHOLD = 4.0;

    public WeatherData getWeatherDataByCityName(String cityName) throws InterruptedException {
        Thread.sleep(1000);
        return new WeatherData(
                cityName,
                RANDOMIZER.nextDouble(MINIMUM_TEMPERATURE_THRESHOLD, MAXIMUM_TEMPERATURE_THRESHOLD + 1),
                RANDOMIZER.nextDouble(MINIMUM_HUMIDITY_THRESHOLD, MAXIMUM_HUMIDITY_THRESHOLD)
        );
    }
}