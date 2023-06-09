package ru.faang.school.hashmap.task_4.Weather;

import ru.faang.school.hashmap.task_3.Students.GroupingOfStudents;

public class WeatherData {
    private final String city;
    private double temperature;
    private double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        if (city == null || humidity < 0 || humidity > 100) {
            throw new RuntimeException("Invalid value!");
        }
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public void setTemperatureAndHumidity(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return String.format("City: %s\nTemperature: %s°C. Humidity: %s", city, temperature, humidity);
    }
}
