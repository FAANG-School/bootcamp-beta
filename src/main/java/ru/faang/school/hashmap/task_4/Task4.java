package ru.faang.school.hashmap.task_4;
import java.util.*;

public class Task4 {
    public static final String SPLITTER = "-----------------------------------";
    public static final String INFO_TEXT = "Выбирите действие" + "\n" + "1. - Информация о всех доступных гордах;" + "\n" + "2. - Погода в введеном городе;" + "\n" + "3. - Удалить информацию о городе из HashMap;" + "\n" + "0. - Выход;" + "\n" + SPLITTER;

    public static void main(String[] args) {
        boolean isExit = false;
        Scanner scan = new Scanner(System.in);

        Map<String, WeatherData> weatherDataMap = new HashMap<>();
        weatherDataMap.put("Гомель", new WeatherData("Гомель", 12, 20));
        weatherDataMap.put("Минск", new WeatherData("Минск", 14, 0));
        weatherDataMap.put("Гродно", new WeatherData("Гродно", 10, 7));
        weatherDataMap.put("Брест", new WeatherData("Брест", 0, 0));
        weatherDataMap.put("Витебск", new WeatherData("Витебск", -5, 41));

        System.out.println(SPLITTER);

        while (!isExit) {
            System.out.println(INFO_TEXT);
            int value = 0;
            try {
                value = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Не верный тип попробуйте еще раз");
                scan.nextLine(); // clear input buffer
                continue; // restart the loop
            }
            System.out.println(SPLITTER);
            switch (value) {
                case 1:
                    getWeatherDataAll(weatherDataMap);
                    break;
                case 2:
                    getWeatherDataCity(weatherDataMap);
                    break;
                case 3:
                    removeWeatherData(weatherDataMap);
                    break;
                case 0:
                    System.out.println("Выход...");
                    isExit = true;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте еще раз");
            }
            System.out.println(SPLITTER);
        }
    }

    public static void removeWeatherData(Map<String, WeatherData> map) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название города, " + "\n" + "информацию о котором нужно удалить: ");
        String cityWeather = scan.nextLine();

        if (map.containsKey(cityWeather)) {
            map.remove(cityWeather);
            System.out.println(SPLITTER + "\n" + "Город найден и удален");
        } else {
            System.out.println(SPLITTER + "\n" + "Такой город не найден в кэшах");
        }
    }

    public static void getWeatherDataAll(Map<String, WeatherData> map) {
        for (Map.Entry maps : map.entrySet()) {
            System.out.println(maps.getKey());
        }
    }

    public static void getWeatherDataCity(Map<String, WeatherData> map) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите город: ");
        String nameCity = scan.nextLine();

        WeatherData weatherData = map.get(nameCity);
        if (weatherData == null) {
            System.out.println(SPLITTER + "\n" + "Обновляю информацию");
            getCityWeatherData(map, nameCity);
            weatherData = map.get(nameCity);
        }
        System.out.println(SPLITTER + "\n" + weatherData);
    }

    public static Map<String, WeatherData> getCityWeatherData(Map<String, WeatherData> map, String nameCity) {
        map.put(nameCity, new WeatherData(nameCity, (int) (Math.random() * 10), (int) (Math.random() * 15)));
        return map;
    }


}

class WeatherData {
    public String city;
    public int temperature;
    public int humidity;

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherData that)) return false;
        return getTemperature() == that.getTemperature() && getHumidity() == that.getHumidity() && Objects.equals(getCity(), that.getCity());
    }

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Город = '" + city + "'" + ", temperature = '" + temperature + "', humidity = '" + humidity + "'";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getTemperature(), getHumidity());
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
