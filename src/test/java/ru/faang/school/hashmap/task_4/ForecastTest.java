package ru.faang.school.hashmap.task_4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForecastTest {

    @Test
    void weatherReportTest(){
        Forecast forecast = new Forecast();

        forecast.getWeatherReport("Minsk");
        forecast.getWeatherReport("Roma");
        int expectedMapSize = 2;
        int actualMapSize = forecast.getWeatherReportSize();
        assertEquals(expectedMapSize, actualMapSize);
    }
}
