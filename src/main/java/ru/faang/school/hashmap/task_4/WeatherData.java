package ru.faang.school.hashmap.task_4;

public class WeatherData {

    private final String city;
    private final Integer temperature;
    private final Integer humidity;

    public WeatherData(String city, Integer temperature, Integer humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
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
