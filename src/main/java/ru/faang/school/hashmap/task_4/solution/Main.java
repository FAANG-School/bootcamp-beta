package ru.faang.school.hashmap.task_4.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<String, WeatherData> weatherData = new HashMap<>();

    public static void main(String[] args) {
        new Main().start();
    }

    public void start(){
        weatherData.put("Киев", new WeatherData("Киев", 19f, 79));
        weatherData.put("Луцк", new WeatherData("Луцк", 13f, 84));
        weatherData.put("Ровно", new WeatherData("Ровно", 13f, 82));
        weatherData.put("Житомир", new WeatherData("Житомир", 16f, 77));
        weatherData.put("Варшава", new WeatherData("Варшава", 16f, 76));

        printWeathers();

        printWeatherByCity("Киев");

        printWeatherByCity("Краков");

        deleteWeatherDataByCity("Киев");

        printWeathers();
    }

    private void deleteWeatherDataByCity(String city){
        weatherData.remove(city);
    }

    private void addOrUpdateWeatherData(String city, WeatherData newWeatherData){
        weatherData.put(city, newWeatherData);
    }

    private void printWeathers(){
        for(Map.Entry<String, WeatherData> set : weatherData.entrySet()){
            System.out.println(set);
        }
        System.out.println();
    }

    private void printWeatherByCity(String city){
        if(weatherData.containsKey(city)) {
            System.out.println(weatherData.get(city));
        }else{
            WeatherData newWeatherData = Service.getWeatherByCity(city);
            addOrUpdateWeatherData(city, newWeatherData);
            System.out.println(newWeatherData);
        }
        System.out.println();
    }
}
