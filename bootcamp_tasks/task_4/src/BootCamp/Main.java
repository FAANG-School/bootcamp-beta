package BootCamp;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class Main {

    static void getWeatherInfo(String cityName){
        if (WeatherData.weatherDataHashMap.get(cityName) != null) {
            System.out.println(WeatherData.weatherDataHashMap.get(cityName));
        } else {
            WeatherData.weatherDataHashMap.put(cityName, new SimpleService().getWeather(cityName));
            System.out.println(new SimpleService().getWeather(cityName));
        }
    }

    static void changeInfoCash(WeatherData weatherData){
        if (WeatherData.weatherDataHashMap.get(weatherData.getCity()) != null) {
            WeatherData.weatherDataHashMap.put(weatherData.getCity(), weatherData);
        } else {

            System.out.println("Нет такого города в хэше!!!");
        }
    }

    static void deleteInfoCash(String cityName){
        if (WeatherData.weatherDataHashMap.get(cityName) != null) {
            WeatherData.weatherDataHashMap.remove(cityName);
        } else {
            System.out.println("Нет такого города в хэше!!!");
        }
    }

    static void cashInfo(){
        WeatherData.weatherDataHashMap.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {

        WeatherData.weatherDataHashMap.put("Moscow", new WeatherData("Moscow",25,25));
        WeatherData.weatherDataHashMap.put("Minsk", new WeatherData("Minsk",15,60));
        WeatherData.weatherDataHashMap.put("Brest", new WeatherData("Brest",9,78));
        WeatherData.weatherDataHashMap.put("Saint-Petersburg", new WeatherData("Saint-Petersburg",15,85));

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
