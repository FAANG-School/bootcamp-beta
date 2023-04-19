package BootCamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class Main {

    private static HashMap<String, WeatherData> weatherDataHashMap = new HashMap<>();

    static void getWeatherInfo(String cityName){
        if (weatherDataHashMap.get(cityName) != null) {
            System.out.println(weatherDataHashMap.get(cityName));
        } else {
            weatherDataHashMap.put(cityName, new SimpleService().getWeather(cityName));
            System.out.println(new SimpleService().getWeather(cityName));
        }
    }

    static void changeInfoCash(WeatherData weatherData){
        if (weatherDataHashMap.get(weatherData.getCity()) != null) {
            weatherDataHashMap.put(weatherData.getCity(), weatherData);
        }
    }

    static void deleteInfoCash(String cityName){
        if (weatherDataHashMap.get(cityName) != null) {
            weatherDataHashMap.remove(cityName);
        }
    }

    static void cashInfo(){
        weatherDataHashMap.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        weatherDataHashMap.put("Moscow", new WeatherData("Moscow",25,25));
        weatherDataHashMap.put("Minsk", new WeatherData("Minsk",15,60));
        weatherDataHashMap.put("Brest", new WeatherData("Brest",9,78));
        weatherDataHashMap.put("Saint-Petersburg", new WeatherData("Saint-Petersburg",15,85));

        getWeatherInfo("Brest");
        getWeatherInfo("Pinsk");
        changeInfoCash(new WeatherData("Pinsk", 12,80));
        changeInfoCash(new WeatherData("Novosibirsk", -25,12));
        cashInfo();
        deleteInfoCash("Pinsk");
        deleteInfoCash("Novosibirsk");
        cashInfo();
    }
}
