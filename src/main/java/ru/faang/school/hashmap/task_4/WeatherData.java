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

    @Override
    public String toString(){
        return "Temperature: " + temperature + " Humidity: " + humidity + " (" + city + ")";
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(city);
//    }
//    @Override
//    public boolean equals(Object object) {
//        WeatherData wd = (WeatherData) object;
//        return wd.city.equals(this.city);
//    }
}
