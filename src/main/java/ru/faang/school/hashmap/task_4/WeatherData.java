package ru.faang.school.hashmap.task_4;

public class WeatherData {
    private String city;

    private int temperature;
    private int humidity;
    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  "city: '" + city + '\'' +
                ", temperature: " + temperature +
                ", humidity: " + humidity;
    }
}
