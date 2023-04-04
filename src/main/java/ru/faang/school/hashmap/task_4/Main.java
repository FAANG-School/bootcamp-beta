import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, WeatherData> cache = new HashMap<>();
        createCache(cache);
        getCityWeather(cache, "Gomel");

        getCityWeather(cache, "Tokyo");
        System.out.println();

        deleteWeatherInfo(cache, "TEST");

        updateWeatherInfo(cache, "Gomel", 19, 35);

        allWeatherInfoFromCache(cache);
    }

    public static void createCache(Map<String, WeatherData> map) {
        map.put("Gomel", new WeatherData("Gomel", 22.1, 40));
        map.put("Minsk", new WeatherData("Minsk", 17, 33.33));
        map.put("Moscow", new WeatherData("Moscow", 15, 25));
        map.put("Amsterdam", new WeatherData("Amsterdam", 12, 20));
        map.put("Los Angeles", new WeatherData("Los Angeles", 30, 60.5));
        map.put("TEST", new WeatherData("TEST", 0, 0));
    }

    public static void getCityWeather(Map<String, WeatherData> cache, String cityName) {
        if (cache.containsKey(cityName)) {
            System.out.println(cache.get(cityName));
        } else {
            addWeatherInfo(cache,Mock.findWeather());
        }
    }

    public static void addWeatherInfo(Map<String, WeatherData> cache, WeatherData data) {
        cache.put(data.getCity(),data);
    }

    public static void updateWeatherInfo(Map<String, WeatherData> cache, String cityName, double temperature, double humidity) {
        if (cache.containsKey(cityName)) {
            cache.put(cityName, new WeatherData(cityName, temperature, humidity));
        } else {
            System.out.println("City is not in a cache");
        }
    }

    public static void deleteWeatherInfo(Map<String, WeatherData> cache, String cityName) {
        if (cache.containsKey(cityName)) {
            cache.remove(cityName);
        } else {
            System.out.println("City is not in a cache");
        }
    }

    public static void allWeatherInfoFromCache(Map<String, WeatherData> cache) {
        for (Map.Entry<String, WeatherData> entry : cache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}