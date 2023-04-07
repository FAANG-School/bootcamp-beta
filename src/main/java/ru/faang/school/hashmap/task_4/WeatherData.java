package ru.faang.school.hashmap.task_4;

import java.util.Objects;

public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (Double.compare(that.temperature, temperature) != 0) return false;
        if (Double.compare(that.humidity, humidity) != 0) return false;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = city != null ? city.hashCode() : 0;
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(humidity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "City: " + city + ". Temperature: " + String.format("%.1f", temperature) + ". Humidity: " + String.format("%.1f", humidity) + ".";
    }
}
