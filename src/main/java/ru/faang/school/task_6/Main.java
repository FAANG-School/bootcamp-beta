package ru.faang.school.task_6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, WeatherData> CITY_WEATHER = new HashMap<>();

    public static void main(String[] args) {
        CITY_WEATHER.put("Moscow", new WeatherData("Moscow", 25, 30.00));
        CITY_WEATHER.put("Kiev", new WeatherData("Kiev", 7, 25.33));
        CITY_WEATHER.put("Berlin", new WeatherData("Berlin", -3, 5.11));
        CITY_WEATHER.put("Kopenhagen", new WeatherData("Kopenhagen", 0, 0.0));
        CITY_WEATHER.put("Warshawa", new WeatherData("Warshawa", -18, 40.40));
        Main main = new Main();
        System.out.println(main.getWeather("Kopenhagen"));
        System.out.println(main.getWeather("Belgorod"));
        main.setWeather("Kopenhagen");
        main.setWeather("Balli");
        System.out.println(main.getWeather("Kopenhagen"));
        main.deleteWeatherInfo("Kopenhagen");
        main.showAllCitiesWeathers();

    }

    public String getWeather(String city) {
        if (CITY_WEATHER.get(city) != null) {
            WeatherData weatherData = CITY_WEATHER.get(city);
            return weatherData.toString();
        }
        WeatherData weatherData = WeatherService.getServicesInfoBy(city);
        CITY_WEATHER.put(city, weatherData);
        return weatherData.toString();
    }

    public void setWeather(String city) {
        if (!CITY_WEATHER.containsKey(city)) {
            System.out.printf("Города с таким именем как %s не существует в базе данных.%n", city);
            return;
        }
        WeatherData weatherData = CITY_WEATHER.get(city);
        int temperature = (int) (Math.random() * 73) - 36;
        double humidity = (Math.random() * 21) + 20;
        double roundedHumidity = WeatherService.roundValue(humidity);
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(roundedHumidity);
    }

    public void deleteWeatherInfo(String city) {
        CITY_WEATHER.remove(city);
    }

    public void showAllCitiesWeathers() {
        for (Map.Entry<String, WeatherData> entry : CITY_WEATHER.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
