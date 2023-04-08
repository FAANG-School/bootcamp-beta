package ru.faang.school.hashmap.task_4.model;

import java.util.Objects;

public class WeatherData {
    private String city;
    private int temparature;
    private int humidity;

    public WeatherData(String city, int temparature, int humidity) {
        this.city = city;
        this.temparature = temparature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemparature() {
        return temparature;
    }

    public void setTemparature(int temparature) {
        this.temparature = temparature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temparature=" + temparature +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (temparature != that.temparature) return false;
        if (humidity != that.humidity) return false;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + temparature;
        result = 31 * result + humidity;
        return result;
    }
}
