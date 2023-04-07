package ru.faang.school.hashmap.task_4;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.net.http.HttpResponse.*;

public class Main {
    static HashMap<String, WeatherData> weatherDataHashMap = new HashMap<>();


    public static void main(String[] args)  {
        getWeatherData("London");
        getWeatherData("Paris");
        getWeatherData("Milan");
        showWeatherDate();
        System.out.println("_______");
        deleteWeatherData("London");
        showWeatherDate();
        System.out.println("_______");
        reloadWeatherData("Milan");
        showWeatherDate();

    }


    static WeatherData getWeatherData (String city) {
        if(!weatherDataHashMap.containsKey(city) || weatherDataHashMap.get(city) == null) {
            reloadWeatherData(city);
        }
        return weatherDataHashMap.get(city);
    }

    static void reloadWeatherData(String city) {
        HttpResponse response =  Mockito.mock(HttpResponse.class);
        Mockito.when(response.body()).thenReturn(city + " " + Math.random() * 25 + " " + Math.random() * 65);
        String stringHttpResponse = (String) response.body();
        String[] s = stringHttpResponse.split(" ");
        WeatherData weatherData = new WeatherData(city, Double.parseDouble(s[1]), Double.parseDouble(s[2]));
        weatherDataHashMap.put(city, weatherData);
    }

    static void deleteWeatherData(String city) {
        weatherDataHashMap.remove(city);
    }

    static void showWeatherDate() {
        for (String city : weatherDataHashMap.keySet()) {
            System.out.println(weatherDataHashMap.get(city));
        }
    }


}
