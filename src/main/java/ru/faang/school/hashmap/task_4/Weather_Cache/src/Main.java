import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static void main(String[] args) {
        WeatherData.add("Astana", new WeatherData("Astana", 15, 57));
        WeatherData.add("Aktau", new WeatherData("Aktau", 17, 43));
        WeatherData.add("Kokshetau", new WeatherData("Kokshetau", 10, 64));
        WeatherData.add("Almaty", new WeatherData("Almaty", 26, 39));
        WeatherData.add("Karaganda", new WeatherData("Karaganda", 18, 55));
        WeatherData.add("Pavlodar", new WeatherData("Pavlodar", 14, 46));
        WeatherData.add("Taraz", new WeatherData("Taraz", 22, 40));
        WeatherData.add("Turkestan", new WeatherData("Turkestan", 27, 38));

                                    // Print map
        WeatherData.printAll();

                                    // Update
        System.out.println();
        WeatherData.update("Astana", 3, 59);
        WeatherData.update("Almaty", 19, 40);
        System.out.println();

        WeatherData.printAll();
                                    // Remove
        System.out.println();
        WeatherData.remove("Taraz");
        System.out.println();

        WeatherData.printAll();
                                    // Get
        System.out.println();
        WeatherData.getWeatherInfo("Astana");
        WeatherData.getWeatherInfo("USA");
        System.out.println();

        WeatherData.printAll();
    }
}
