package ru.faang.school.hashmap.task_4.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {
  private static final Map<String, WeatherData> map = new HashMap<>();

  public static String requestToAnExternalSource() {
    final String message = "\n...doing request to an external source";
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      return message + "...threw InterruptedException";
    }
    return message ;
  }

  public static WeatherData getWeatherData(String city) {

    if (city==null || city.isBlank()) return null;

    var weatherData = map.get(city);

    if (weatherData != null) {

      return weatherData;

    } else {

      System.out.println(requestToAnExternalSource());

      short randomVal =  (short) (city.chars().sum() / city.length());
      var randomWeatherData = new WeatherData(city, randomVal , (short) (randomVal/3));

      map.put(city,randomWeatherData);

      return randomWeatherData;
    }
  }

  public static void updateWeatherData(String city, Short temperature , Short humidity) {
    if (city==null || city.isBlank()) return;

    map.put(city, new WeatherData(city,temperature,humidity));
  }

  public static void deleteWeatherData(String city) {
    if (city==null || city.isBlank()) return;

    map.remove(city);
  }

  public static void printWeatherDataForAllCities() {

    map.forEach((key, value) -> System.out.printf("City: %s, weather: %s", key, value));
  }

  public static void main(String[] args) {
    var weather1 = new WeatherData("Berlin", (short) 33, (short) 12);
    var weather2 = new WeatherData("London", (short) 12, (short) 55);
    var weather3 = new WeatherData("Boston", (short) 23, (short) 34);
    var weather4 = new WeatherData("Washington", (short) 19, (short) 33);
    var weather5 = new WeatherData("Kiew", (short) 33, (short) 43);
    var weather6 = new WeatherData("Moscow", (short) 10, (short) 22);

    updateWeatherData(weather1.getCity(), weather1.getTemperature(), weather1.getHumidity());
    updateWeatherData(weather3.getCity(), weather3.getTemperature(), weather3.getHumidity());
    updateWeatherData(weather2.getCity(), weather2.getTemperature(), weather2.getHumidity());
    updateWeatherData(weather4.getCity(), weather4.getTemperature(), weather4.getHumidity());

    printWeatherDataForAllCities();

    System.out.println(getWeatherData(weather5.getCity()));

    System.out.println(getWeatherData(null));
    System.out.println(getWeatherData("  "));

    deleteWeatherData(weather1.getCity());
    deleteWeatherData(null);
    deleteWeatherData(weather2.getCity());

    updateWeatherData(weather5.getCity(), weather5.getTemperature(), weather5.getHumidity());
    updateWeatherData(weather6.getCity(), weather6.getTemperature(), weather6.getHumidity());

    printWeatherDataForAllCities();


  }
}
