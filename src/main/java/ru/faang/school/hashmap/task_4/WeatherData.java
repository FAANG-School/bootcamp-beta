package ru.faang.school.hashmap.task_4;

import java.util.Objects;

public class WeatherData {
    String city;
    Double temperature;
    Double humidity;

    public WeatherData(String city, Double temperature, Double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
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
        return city != null ? city.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "В городе " + city + " сейчас температура " + temperature + " градусов с относительной влажностью " + humidity + "%";
    }
}
