package ru.faang.school.hashmap.task_4;

import java.util.Objects;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "В городе " + city +
                " температура " + temperature +
                " влажность " + humidity;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }
}
