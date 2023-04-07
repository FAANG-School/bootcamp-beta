package BootCamp;

import java.util.Random;

public class SimpleService{

    public WeatherData getWeather(String cityName){
        Random random = new Random();
        return new WeatherData(cityName, Math.round(random.nextDouble(-50,50)), Math.round(random.nextDouble(100)));
    }

}
