package ru.faang.school.hashmap.task_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    static {
        WeatherData weatherData1 = new WeatherData("Москва", 20.0, 10.0);
        WeatherData weatherData2 = new WeatherData("Кострома", 14.0, 9.5);
        WeatherData weatherData3 = new WeatherData("Санкт-Петербург", 15.6, 13.7);
        WeatherData weatherData4 = new WeatherData("Краснодар", 32.2, 12.1);
        WeatherData weatherData5 = new WeatherData("Мурманск", 12.7, 11.3);

        weatherDataMap.put("Москва", weatherData1);
        weatherDataMap.put("Кострома", weatherData2);
        weatherDataMap.put("Санкт-Петербург", weatherData3);
        weatherDataMap.put("Краснодар", weatherData4);
        weatherDataMap.put("Мурманск", weatherData5);
    }

    public static void main(String[] args) {
        System.out.println(infoAboutWeather("Москва"));
        System.out.println(infoAboutWeather("Кострома"));
        updateInfo("Кострома", 13.0, 9.3);
        System.out.println(infoAboutWeather("Кострома"));
        deleteInfo("Москва");
        System.out.println(infoAboutWeather("Москва"));

    }

    public static String infoAboutWeather(String city) {
        if (weatherDataMap.containsKey(city)) {
            WeatherData data = weatherDataMap.get(city);
            return "Погода в " + city + ". Температура: " + data.getTemperature() + ", влажность: " + data.getHumidity();
        } else {
            return WeatherDataBase.getWeather(city);
        }
    }

    public static String updateInfo(String city, double temperature, double humidity) {
        if (weatherDataMap.containsKey(city)) {
            WeatherData data = weatherDataMap.get(city);
            data.setTemperature(temperature);
            data.setHumidity(humidity);
            return "Информация о погоде обновлена";
        } else {
            return "Данных о погоде в этом городе нет в кэше";
        }
    }

    public static String deleteInfo(String city) {
        if (weatherDataMap.containsKey(city)) {
            weatherDataMap.remove(city);
            return "Информация удалена";
        } else {
            return "Информации об этом городе нет в кеше";
        }
    }

    public static List<String> getCityList() {
        List<String> cityList = new ArrayList<>();

        for (var entry : weatherDataMap.entrySet()) {
            cityList.add(entry.getKey());
        }
        return cityList;
    }
}
