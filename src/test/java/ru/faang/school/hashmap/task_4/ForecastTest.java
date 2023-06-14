package ru.faang.school.hashmap.task_4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ForecastTest {

    private Forecast forecast;

    @BeforeEach
    void setUp(){
        forecast = new Forecast();
        forecast.getWeatherReport("Minsk");
        forecast.getWeatherReport("Roma");
    }

    @Test
    void weatherReportTest(){
        int expectedMapSize = 2;
        int actualMapSize = forecast.getWeatherReportSize();

        assertEquals(expectedMapSize, actualMapSize);
    }

    @Test
    void deleteWeatherReportExistingCityTest(){
        forecast.deleteForecast("Minsk");
        int expectedMpSize = 1;
        int actualMapSize = forecast.getWeatherReportSize();

        assertEquals(expectedMpSize, actualMapSize);
    }

    @Test
    void deleteWeatherReportNonExistingCityTest(){
        String nonExistingCity = "Milano";
        ForecastException forecastException = assertThrows(ForecastException.class,
                () -> forecast.deleteForecast(nonExistingCity));

        String expectedResult = String.format(Message.NO_SUCH_CITY, nonExistingCity);
        String actualResult = forecastException.getMessage();

        assertEquals(expectedResult, actualResult);
    }
}
