package ru.faang.school.hashmap.task_4;

import java.util.Random;


import java.util.HashMap;

public class Main {

    static HashMap<String,WeatherData> weatherHash = new HashMap<>();

    public static void main(String[] args) {

        WeatherData wd1 = new WeatherData("Moscow", 15, 70);
        WeatherData wd2 = new WeatherData("Tel Aviv", 25, 65);
        WeatherData wd3 = new WeatherData("New York", 14, 75);
        WeatherData wd4 = new WeatherData("Lissabon", 22, 76);
        WeatherData wd5 = new WeatherData("Astana", 25, 68);

        //добавить в зешмап инфо
        weatherHash.put(wd1.getCity(),wd1);
        weatherHash.put(wd2.getCity(),wd2);
        weatherHash.put(wd3.getCity(),wd3);
        weatherHash.put(wd4.getCity(),wd4);
        weatherHash.put(wd5.getCity(),wd5);
        weatherHash.put("Moscow",new WeatherData("Moscow",1,1));

        showAllCities();

        System.out.println("---------------------------------");

        refreshData("Moscow");

        showAllCities();

        System.out.println("---------------------------------");

        delWeatherInfo("Astana");

        showAllCities();

        System.out.println("---------------------------------");

        refreshData("Astana");

        showAllCities();

        System.out.println("---------------------------------");

        showWeatherInfo("Lissabon");
        showWeatherInfo("Spb");

    }

    public static void showWeatherInfo(String city){
        if (weatherHash.get(city) == null) {
            weatherHash.put(city,getInfoFromOutService(city));
            System.out.println(weatherHash.get(city).toString());
        } else {
            System.out.println(weatherHash.get(city).toString());
        }
    }

    private static WeatherData getInfoFromOutService(String city) {
        Random rand = new Random();
        int temp = rand.nextInt((40 - 0) + 1) + 0;
        int humid = rand.nextInt((95 - 50) + 1) + 50;
        WeatherData wd = new WeatherData(city, temp, humid);
        return wd;
    }

    public static void refreshData(String city) {
        weatherHash.put(city,getInfoFromOutService(city));
    }

    public static void delWeatherInfo(String city) {
        weatherHash.put(city,null);
    }

    public static void showAllCities(){
        weatherHash.entrySet().stream().filter(x -> x.getValue()!= null).forEach(System.out::println);
    }

}
