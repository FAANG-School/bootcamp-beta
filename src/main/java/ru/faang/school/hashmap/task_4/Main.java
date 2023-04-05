package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, WeatherData> weatherCache = new HashMap<>();

    public static WeatherData getWeatherData(String city) {
        WeatherData weatherData = weatherCache.get(city);
        if (weatherData == null) {
            weatherData = weatherMockService(city);
            weatherCache.put(city, weatherData);
        }
        return weatherData;
    }

    private static WeatherData weatherMockService(String city) {
        double temperature = Math.round((Math.random() * 80 - 40) * 10.0) / 10.0;
        double humidity = Math.round((Math.random() * 70 + 20) * 10.0) / 10.0;
        return new WeatherData(city, temperature, humidity);
    }

    public static void updateWeatherData(String city) {
        WeatherData weatherData = weatherCache.get(city);
        if (weatherData != null) {
            WeatherData updatedData = weatherMockService(city);
            weatherData.setTemperature(updatedData.getTemperature());
            weatherData.setHumidity(updatedData.getHumidity());
            System.out.println("Weather data for " + city + " has been updated:");
            System.out.println("Now Temperature is : "+ updatedData.getTemperature() + "°C");
            System.out.println("Now Humidity is : "+ updatedData.getHumidity() + "%");
        } else {
            System.out.println("There is no weather data for city " + city);
        }
    }

    public static void removeWeatherData(String city) {
        WeatherData removedData = weatherCache.remove(city);
        if (removedData != null) {
            System.out.println("Weather data for city " + city + " has been removed from cache");
        } else {
            System.out.println("There is no weather data for city " + city);
        }
    }

    public static void printAllCitiesWithWeatherData() {
        System.out.println("Cities with weather data in cache:");
        for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
            String city = entry.getKey();
            WeatherData weatherData = entry.getValue();
            System.out.println("- " + city + ": temperature = " + weatherData.getTemperature()
                    + ", humidity = " + weatherData.getHumidity());
        }
    }

    public static void main(String[] args) {
        // получаем информацию о погоде для города и сохраняем ее в кэше
        WeatherData weatherData1 = getWeatherData("Moscow");
        WeatherData weatherData3 = getWeatherData("Tbilisi");
        WeatherData weatherData4 = getWeatherData("London");
        System.out.println("Temperature in Moscow: " + weatherData1.getTemperature() +", " +"Humidity in Moscow: " +  weatherData1.getHumidity() );
        WeatherData weatherData2 = getWeatherData("Moscow");
        // повторный запрос должен вернуть данные из кэша, без обращения к внешнему источнику
        System.out.println("Temperature in Moscow (from cache): " + weatherData2.getTemperature()+", " +"Humidity in Moscow (from cache): " +  weatherData2.getHumidity() );

        // 2. Обновление информации о погоде в кэше для определенного города
        updateWeatherData("Moscow");


        // 3. Удаление информации о погоде из кэша по названию города
        removeWeatherData("Moscow");

        // 4. Cписок всех городов, для которых доступна информация о погоде в кэше
        printAllCitiesWithWeatherData();
    }
}
