package ru.faang.school.hashmap.task_4;

public class WeatherData {

    private String city;
    private Integer temperature;
    private Double humidity;

    public WeatherData(String city, Integer temperature, Double humidity) {
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

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
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
}
