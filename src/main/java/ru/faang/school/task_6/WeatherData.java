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

    public WeatherData() {
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

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "В городе: " + getCity() + ", температура: " + getTemperature() + ", влажность: " + getHumidity();
    }
}
