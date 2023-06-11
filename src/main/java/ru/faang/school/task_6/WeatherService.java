package ru.faang.school.task_6;

public class WeatherService {
    public static WeatherData getServicesInfoBy(String city) {
        System.out.printf("Asking for weather in %s....%n", city);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int temperature = (int) (Math.random() * 73) - 36;
        double humidity = (Math.random() * 21) + 20;
        double roundedHumidity = roundValue(humidity);
        return new WeatherData(city, temperature, roundedHumidity);
    }

    public static double roundValue(double value) {
        String newValue = String.valueOf(value).substring(0, 5);
        return Double.parseDouble(newValue);
    }
}
