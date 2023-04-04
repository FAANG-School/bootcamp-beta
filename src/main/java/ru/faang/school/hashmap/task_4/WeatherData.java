package ru.faang.school.hashmap.task_4;

import java.util.Objects;

public class WeatherData {
    private final String city;
    private final int temperature;
    private final int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return temperature == that.temperature && humidity == that.humidity && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }
}
