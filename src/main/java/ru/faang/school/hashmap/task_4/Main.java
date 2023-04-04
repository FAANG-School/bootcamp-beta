package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private final Map<String, WeatherData> cashedWeatherData;
    private final MockWeatherData mockWeatherData;


    public Main() {
        cashedWeatherData = new HashMap<>();
        mockWeatherData = new MockWeatherData();
        cashedWeatherData.put("Moskva", new WeatherData("Moskva", 10, 80));
        cashedWeatherData.put("Minsk", new WeatherData("Minsk", 12, 70));
        cashedWeatherData.put("Kiev", new WeatherData("Kiev", 15, 60));
        cashedWeatherData.put("Erevan", new WeatherData("Erevan", 20, 20));

    }

    public WeatherData getWeather(String city) {
        WeatherData cachedWeatherData = cashedWeatherData.get(city);
        if (cachedWeatherData == null) {
            WeatherData remoteWeatherData = mockWeatherData.getRemoteWeatherData(city);
            cashedWeatherData.put(city, remoteWeatherData);
            return remoteWeatherData;
        }
        return cachedWeatherData;
    }

    public void updateWeatherInfo(String city) {
        WeatherData remoteWeatherData = mockWeatherData.getRemoteWeatherData(city);
        cashedWeatherData.put(city, remoteWeatherData);
    }

    public void removeWeatherInfo(String city) {
        if (cashedWeatherData.remove(city) == null) {
            System.out.println("City is not found");
        }
    }

    public void showCashedInfo() {
        for (Map.Entry<String, WeatherData> entry : cashedWeatherData.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}

class MockWeatherData {
    final Random random;

    public MockWeatherData() {
        random = new Random();
    }

    public WeatherData getRemoteWeatherData(String city) {
        return new WeatherData(city, random.nextInt(32), random.nextInt(100));
    }
}
