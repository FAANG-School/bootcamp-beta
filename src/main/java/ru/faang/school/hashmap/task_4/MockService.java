package ru.faang.school.hashmap.task_4;

import java.util.concurrent.ThreadLocalRandom;

public class MockService {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    public WeatherData doSomeLongOperation(String city) {
        return new WeatherData(city, random.nextDouble(50), random.nextDouble(50));
    }
}
