package ru.faang.school.hashmap.task_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Через задание, то есть уже второй раз, ловлю ошибку при запуске:
 * Execution failed for task ':Main.main()'.
 * > Process 'command 'C:/Program Files/Java/jdk-17/bin/java.exe'' finished with non-zero exit value 1
 *
 * Invalid cache did not help.
 */
public class Main {

    public static Map<String, WeatherData> map = Map.of(
            "Minsk", new WeatherData("Minsk", 15, 35.5),
            "London", new WeatherData("London", 11, 63.1),
            "Dubai", new WeatherData("Dubai", 36, 15.5)
    );

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getInfo("Minsk"));
        main.getInfo("Brest");

        System.out.println("***********************");
        main.updateInfo("London", new WeatherData("London", 9, 55.9));
        System.out.println(map);

        System.out.println("***********************");
        main.removeInfo("London");
        System.out.println(map);

        System.out.println(main.getCities());
    }

    public WeatherData getInfo(String city) {
        if (map.get(city) != null) {
            return map.get(city);
        } else {
            findOutTheWeather(city);
            return null;
        }
    }

    public void updateInfo(String city, WeatherData updatedData) {
        map.put(city, updatedData);
    }

    public void removeInfo(String city) {
        map.remove(city);
    }

    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        for (Map.Entry<String, WeatherData> entry: map.entrySet()) {
            cities.add(entry.getKey());
        }
        return cities;
    }

    private static void findOutTheWeather(String city) {
        System.out.println("Getting information about the weather in the city " + city + " ....");
    }
}
