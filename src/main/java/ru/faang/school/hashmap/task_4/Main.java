package ru.faang.school.hashmap.task_4;

import ru.faang.school.hashmap.task_4.model.WeatherData;
import ru.faang.school.hashmap.task_4.proxies.GisMeteoWeatherProxy;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData1 = new WeatherData("Perm" , 5, 40);
        WeatherData weatherData2 = new WeatherData("St. Peterburg" , 8, 50);
        WeatherData weatherData3 = new WeatherData("Sochi", 15, 95);
        WeatherData weatherData4 = new WeatherData("Moscow" , 22 , 70);
        Map<String, WeatherData> weatherCache = new HashMap<>();
        weatherCache.put(weatherData1.getCity(), weatherData1);
        weatherCache.put(weatherData2.getCity(), weatherData1);
        weatherCache.put(weatherData3.getCity(), weatherData1);
        weatherCache.put(weatherData4.getCity(), weatherData4);

        WeatherImpl weather = new WeatherImpl();
        weather.setCache(weatherCache);
        weather.setProxy(new GisMeteoWeatherProxy());

        weather.showAllCityFromCache();
        System.out.println();
        weather.showWeather("Moscow");
        weather.deleteWeatherDataFromCache("Moscow");
        System.out.println();
        weather.showAllCityFromCache();
        weather.showWeather("Moscow");
        System.out.println();
        weather.showWeather("Moscow");

    }


}

//Напишем логику тут, чтобы не париться с настройками, но вообще нужно делать все с интерфейсами в отдеальных папках
//а тут должен быть метод showWeather только для пользователя
class WeatherImpl implements Weather {
    private Map<String, WeatherData> cache;
    private GisMeteoWeatherProxy proxy;

    public GisMeteoWeatherProxy getProxy() {
        return proxy;
    }

    public void setProxy(GisMeteoWeatherProxy proxy) {
        this.proxy = proxy;
    }

    public Map<String, WeatherData> getCache() {
        return cache;
    }

    public void setCache(Map<String, WeatherData> cache) {
        this.cache = cache;
    }

    public void showWeather(String city) {
        WeatherData weatherData = getWeatherData(city);
        System.out.println("В городе " + weatherData.getCity() + " температура воздуха- " +
                weatherData.getTemparature() + "°C, влажность- " + weatherData.getHumidity() + "%");
    }

    @Override
    public WeatherData getWeatherData(String city) {
        WeatherData weatherData = cache.get(city);
        if (weatherData == null) {
            weatherData = proxy.getWeatherData(city);
            addWeatherdataToCache(weatherData);
        }
        return weatherData;
    }

    //Логика работы с кешем, но она должна быть не здесь, а лежать отдельно
    public void addWeatherdataToCache(WeatherData weatherData) {
        cache.put(weatherData.getCity(), weatherData);
    }
    //метод не работает из-за заглушки
    public void updateWeather(String city) {
        WeatherData weatherData = proxy.getWeatherData(city);
        addWeatherdataToCache(weatherData);
    }


    public void deleteWeatherDataFromCache(String city) {
        cache.remove(city);
    }

    public void showAllCityFromCache() {
        for (Map.Entry<String, WeatherData> entry : cache.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

}



