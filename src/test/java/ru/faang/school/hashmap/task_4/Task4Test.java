package ru.faang.school.hashmap.task_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    public void task4Tests() {
        Main main = new Main();
        Assertions.assertEquals("Saint-Petersburg", main.getWeatherInfo("Saint-Petersburg").getCity()); // get already existing city weather data
        Assertions.assertEquals("Not existing city", main.getWeatherInfo("Not existing city").getCity()); // get city weather data using mock class

        main.updateWeatherData("Saint-Petersburg", 30);
        Assertions.assertEquals(30, main.getWeatherInfo("Saint-Petersburg").getTemperature());

        main.updateWeatherData("Saint-Petersburg", "70");
        Assertions.assertEquals("70%", main.getWeatherInfo("Saint-Petersburg").getHumidity());

        main.updateWeatherData("Saint-Petersburg", 40, "50");
        Assertions.assertEquals(40, main.getWeatherInfo("Saint-Petersburg").getTemperature());
        Assertions.assertEquals("50%", main.getWeatherInfo("Saint-Petersburg").getHumidity());

        Assertions.assertThrows(IllegalArgumentException.class, () -> main.updateWeatherData("Throw exception", 30));
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.updateWeatherData("Throw exception", "50"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.updateWeatherData("Throw exception", 40, "50"));

        main.deleteWeatherData("Saint-Petersburg");
        Assertions.assertFalse(main.getWeatherMap().containsKey("Saint-Petersburg"));

        main.getForecastAvailableCities();
    }
}
