package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    private static  Map<String, WeatherData> weatherInCountry =new HashMap<>();

    public static void main(String[] args) {
        weatherInCountry.put("Moscow", new WeatherData("Moscow", 15, 234));
        weatherInCountry.put("Odessa", new WeatherData("Odessa", 18, 245));
        weatherInCountry.put("Sochi", new WeatherData("Sochi", 20, 260));
        getWeatherFromMap("Moscow");
        printAllFromWeatherTable();
    }
    public static void getWeatherFromMap(String city){
        if (weatherInCountry.containsKey(city)) System.out.println("City:"+city+" Temperature:"+ weatherInCountry.get(city).getTemperature()+ " Humidity: "+weatherInCountry.get(city).getHumidity());
        else MokServer.addToServer();
    }
    public static void updateInformationInTable(String city, WeatherData weatherData){
        if (weatherInCountry.containsKey(city)) weatherInCountry.put(city, weatherData);
        else System.out.println("Wrong city name");
    }
    public static void removeFromTable(String city){
        weatherInCountry.remove(city);
    }
    public static void printAllFromWeatherTable(){
        for (String city:weatherInCountry.keySet()){
            System.out.println("City: "+city+"\n"+"Temperature: "+weatherInCountry.get(city).getTemperature()+" Humidity: "+weatherInCountry.get(city).getHumidity());
        }
    }
}
