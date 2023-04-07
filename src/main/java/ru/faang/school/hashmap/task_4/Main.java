package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    final Map<String, WeatherData> forecast = new HashMap<>();

    public WeatherData getWeatherByCity(String city) {
        if(!forecast.containsKey(city)) {
            forecast.put(city, ForecastService.getWeatherByCityFromInside(city));
        }
        return forecast.get(city);
    }

    public void updateWeatherForCity(String city) {
        forecast.put(city, ForecastService.getWeatherByCityFromInside(city));
    }

    public void deleteWeatherForCity(String city) {
        forecast.remove(city);
    }

    public void printAllCityWithWeatherData() {
        forecast.forEach((Key, Value) -> {
            if (Value != null) {
                System.out.println(Key);
            }
        });
    }

}

class WeatherData{
    final private String city;
    final private String temperature;
    final private String humidity;

    public WeatherData(String city, String temperature, String humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return city.equals(that.city) && temperature.equals(that.temperature) && humidity.equals(that.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }
}
