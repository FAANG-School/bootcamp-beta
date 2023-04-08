package ru.faang.school.hashmap.task_4.models;

public class WeatherData {
    private final String _city;
    private Double _temperature;
    private Double _humidity;

    public WeatherData(String city, Double temperature, Double humidity) {
        _city = city;
        _temperature = temperature;
        _humidity = humidity;
    }

    public String getCity() {
        return _city;
    }
    public Double getTemperature() {
        return _temperature;
    }
    public void setTemperature(Double temperature) {
        _temperature = temperature;
    }
    public Double getHumidity() {
        return _humidity;
    }
    public void setHumidity(Double humidity) {
        _humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + _city + '\'' +
                ", temperature=" + _temperature +
                ", humidity=" + _humidity +
                '}';
    }
}
