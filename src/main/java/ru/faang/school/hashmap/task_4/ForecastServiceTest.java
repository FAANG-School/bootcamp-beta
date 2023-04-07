package ru.faang.school.hashmap.task_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForecastServiceTest {

    @Test
    void getTemperatureBetweenParam() {
        int temperature = Integer.parseInt(ForecastService.getRandomTemperature());
        assertTrue(temperature >= -50 && temperature <= 50);
    }

    @Test
    void getHumidityBetweenParam() {
        int humidity = Integer.parseInt(ForecastService.getRandomHumidity());
        assertTrue(humidity >= 10 && humidity <=100);
    }

}