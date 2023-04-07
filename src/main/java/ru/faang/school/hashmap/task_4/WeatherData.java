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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return temperature == that.temperature && Double.compare(that.humidity, humidity) == 0 && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
