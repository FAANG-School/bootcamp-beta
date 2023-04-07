package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, WeatherData> weatherMap = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.updateWeatherInfo("Saint-Petersburg");
        main.updateWeatherInfo("Moscow");
        main.updateWeatherInfo("Amsterdam");
        System.out.println(main.getWeatherInfo("Moscow"));
        System.out.println(main.getWeatherInfo("Pskov"));
        main.removeWeatherInfo("Pskov");
        main.printWeatherInfo();
        main.updateWeatherInfo("Saint-Petersburg");
        System.out.println(main.getWeatherInfo("Saint-Petersburg"));
    }

    public WeatherData getWeatherInfo(String city) {
        if (!weatherMap.containsKey(city)) {
            updateWeatherInfo(city);
        }
        return weatherMap.get(city);
    }

    public void updateWeatherInfo(String city) {
        int[] weatherData = WeatherService.getWeather(city);
        weatherMap.put(city,new WeatherData(city,weatherData[0],weatherData[1]));
    }

    public void removeWeatherInfo(String city) {
        weatherMap.remove(city);
    }

    public void printWeatherInfo() {
        System.out.println("Сводка о погоде:");
        for(Map.Entry<String, WeatherData> entry : weatherMap.entrySet()) {
            System.out.println("г."+entry.getKey()
                            +": температура "+ entry.getValue().getTemperature()
                            +", влажность "+entry.getValue().getHumidity()+"%"
                    );
        }
    }


}
