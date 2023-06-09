package ru.faang.school.task_6;

public class WeatherData {
    String city;
    int temperature;
    double humidity;

    public WeatherData(String city, int temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "В городе: " + getCity() + ", температура: " + getTemperature() + ", влажность: " + getHumidity();
    }
}
