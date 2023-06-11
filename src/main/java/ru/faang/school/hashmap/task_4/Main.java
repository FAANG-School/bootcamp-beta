package ru.faang.school.hashmap.task_4;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData1 = new WeatherData("Москва", 16, 35);
        WeatherData weatherData2 = new WeatherData("Ульяновск", 18, 60);
        WeatherData weatherData3 = new WeatherData("Брянск", 19, 54);
        WeatherData weatherData4 = new WeatherData("Казань", 17, 44);
        WeatherData weatherData5 = new WeatherData("Ярославль", 13, 42);


        inMemWeatherDataCache.addToCache(weatherData1);
        inMemWeatherDataCache.addToCache(weatherData2);
        inMemWeatherDataCache.addToCache(weatherData3);
        inMemWeatherDataCache.addToCache(weatherData4);
        inMemWeatherDataCache.addToCache(weatherData5);
        inMemWeatherDataCache.addToCache(weatherData5);

        inMemWeatherDataCache.printWeatherCache();

        inMemWeatherDataCache.getWeather("Москва");
        inMemWeatherDataCache.getWeather("Пермь");

        inMemWeatherDataCache.printWeatherCache();

        inMemWeatherDataCache.printCityCache();

        inMemWeatherDataCache.removeWeatherCache("Ярославль");
        inMemWeatherDataCache.printCityCache();

        inMemWeatherDataCache.upsertWeatherCache("Чебы", 15, 21);
        inMemWeatherDataCache.upsertWeatherCache("Москва", 11, 88);

        inMemWeatherDataCache.printWeatherCache();


    }
}


