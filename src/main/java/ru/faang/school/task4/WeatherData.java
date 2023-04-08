package ru.faang.school.task4;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
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

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return temperature == that.temperature && humidity == that.humidity && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }

    public static void main(String[] args) {
        Map<String, WeatherData> data = new HashMap<>();


    }

    public static WeatherData getWeather(Map<String, WeatherData> data, String city) {
        if (data.containsKey(city)) {
            return data.get(city);
        } else {
            WeatherData weahter = getServiceWeather(city);
            System.out.println(weahter);
            data.put(city, new WeatherData(city, weahter.getTemperature(), weahter.getHumidity()));
            return data.get(city);
        }
    }

    public static WeatherData getServiceWeather(String city) {
        return new WeatherData(city, 12, 70);
    }

    public static void updateWeather(Map<String, WeatherData> data, WeatherData weatherData) {
        if (data.containsKey(weatherData.city)) {
            data.put(weatherData.getCity(), weatherData);
        }
    }

    public static void deleteWeather(Map<String, WeatherData> data, String city) {
        data.remove(city);
    }

    public static void printAllWeatherData(Map<String, WeatherData> data) {
        for (Map.Entry<String, WeatherData> x : data.entrySet()) {
            System.out.println(x);
        }
    }
}
