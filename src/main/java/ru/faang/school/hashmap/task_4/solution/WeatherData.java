package ru.faang.school.hashmap.task_4.solution;

import java.util.Objects;

public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity =  humidity;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }

    @Override
    public String toString() {
        return "Город: " + city + " | " + temperature + " °С" + " | " + humidity + " %";
    }
}
