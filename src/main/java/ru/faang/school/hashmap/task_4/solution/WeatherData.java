package ru.faang.school.hashmap.task_4.solution;

public class WeatherData {
    private String city;
    private float temperature;
    private int humidity;

    public WeatherData(String city, float temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature + "°C" +
                ", humidity=" + humidity + "%" +
                '}';
    }
}
