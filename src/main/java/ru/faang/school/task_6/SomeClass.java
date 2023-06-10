package ru.faang.school.task_6;

public class SomeClass {
    public static WeatherData doSomething(String city) {
        System.out.printf("Asking for weather in %s....%n", city);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int temperature = (int) (Math.random() * 73) - 36;
        double humidity = (Math.random() * 21) + 20;
        double roundedHumidity = Main.roundValue(humidity);
        return new WeatherData(city, temperature, roundedHumidity);
    }
}
