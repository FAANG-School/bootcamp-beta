package BootCamp;

import java.util.HashMap;
import java.util.Objects;

public class WeatherData {

    private String city;
    private double temperature;
    private double humidity;

    public WeatherData(String city, double temperature, double humidity){
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
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Double.compare(that.temperature, temperature) == 0
                && Double.compare(that.humidity, humidity) == 0
                && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }
}
