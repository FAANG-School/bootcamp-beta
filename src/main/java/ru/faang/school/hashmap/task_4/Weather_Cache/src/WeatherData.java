import java.util.Random;

public class WeatherData {
    private final String city;
    private final Integer temperature;
    private final Integer humidity;

    public WeatherData(String city, Integer temperature, Integer humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public static void add(String city, WeatherData weatherData) {
        Main.weatherDataMap.put(city, weatherData);
    }

    public static void update(String city, Integer temperature, Integer humidity) {
        add(city, new WeatherData(city, temperature, humidity));
        System.out.println(city + " weather information updated!");
    }

    public static void remove(String city) {
        try {
            Main.weatherDataMap.remove(city);
            System.out.println(city + " weather information removed!");
        } catch (NullPointerException e) {
            throw new RuntimeException("This city is not on the list");
        }
    }

    public static void getWeatherInfo(String city) {
        var temp = Main.weatherDataMap;
        if (temp.containsKey(city))
            System.out.println(temp.get(city));
        else {
            System.out.println("---".repeat(14));
            System.out.println("Searching weather info in " + city + "...");
            System.out.println("---".repeat(14));
            WeatherData newWeatherData = WeatherDataMoc.createWeatherInfo(city);
            System.out.println(newWeatherData);
            add(city, newWeatherData);
        }
    }

    private static class WeatherDataMoc {
        private static WeatherData createWeatherInfo(String city) {
            Random random = new Random();
            Integer temperature = random.nextInt(10, 30);
            Integer humidity = random.nextInt(30, 60);
            return new WeatherData(city, temperature, humidity);
        }
    }

    public static void printAll() {
        Main.weatherDataMap.values().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return city + " [temperature: " + temperature + ", humidity: " + humidity + "]";
    }
}
