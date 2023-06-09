package ru.faang.school.hashmap.task_4.Weather;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        addCity("Москва", -10, 60);
        addCity("Дубай", 35, 20);
        addCity("Сингапур", 30, 80);
        addCity("Токио", 5, 75);
        addCity("Рио-де-Жанейро", 25, 70);
        addCity("Сидней", 20, 50);
        addCity("Амстердам", 10, 80);
        addCity("Лос-Анджелес", 20, 40);
        addCity("Берлин", 0, 70);
        addCity("Алматы", 16, 65);

        getInfo("Москва");
        updateInfo("Москва", -8, 70);
        getInfo("Москва");
        getCache();
        removeInfo("Сидней");
        getInfo("Костанай");
        getCache();
    }

    private final static Map<String, WeatherData> cache = new HashMap<>();

    static WeatherData externalService(String city) {
        return new WeatherData(city, ((Math.random() * 40) - 40), (Math.random() * 100));
    }

    static void addCity(String city, double temperature, double humidity) {
        cache.put(city, new WeatherData(city, temperature, humidity));
    }

    static void updateInfo(String city, double temperature, double humidity) {
        if (!cache.containsKey(city)) {
            return;
        }
        cache.get(city).setTemperatureAndHumidity(temperature, humidity);
    }

    static void removeInfo(String city) {
        if (!cache.containsKey(city)) {
            return;
        }
        cache.put(city, null);
    }

    static void getInfo(String city) {
        if (!cache.containsKey(city)) {
            cache.put(city, externalService(city));
        }
        System.out.println(cache.get(city).toString() + "\n");
    }

    static void getCache() {
        for (Map.Entry<String, WeatherData> map : cache.entrySet()) {
            if (map.getValue() != null) {
                System.out.println(map.getValue());
            }
        }
        System.out.println("\n");
    }

}

