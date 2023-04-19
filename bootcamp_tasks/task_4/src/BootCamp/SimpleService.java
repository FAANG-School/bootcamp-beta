package BootCamp;

import java.util.Random;

public class SimpleService{

    private static final Random RANDOM = new Random();

    private static final double TEMPERATURE = Math.round(RANDOM.nextDouble(-50,50));
    private static final double HUMIDITY = Math.round(RANDOM.nextDouble(100));

    public WeatherData getWeather(String cityName){
        return new WeatherData(cityName, TEMPERATURE, HUMIDITY);
    }

}
