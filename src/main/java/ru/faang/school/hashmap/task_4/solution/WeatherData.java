package ru.faang.school.hashmap.task_4.solution;

public class WeatherData {

  private String city;
  private Short temperature;

  public String getCity() {
    return city;
  }

  public Short getTemperature() {
    return temperature;
  }

  public Short getHumidity() {
    return humidity;
  }

  private Short humidity;

  public WeatherData(String city, Short temperature, Short humidity) {
    this.city = city;
    this.temperature = temperature;
    this.humidity = humidity;
  }

  @Override
  public String toString() {
    return "WeatherData{" +
        "city: '" + city + '\'' +
        ", temperature: " + temperature +
        ", humidity: " + humidity +
        '}';
  }
}
