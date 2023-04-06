package ru.faang.school.hashmap.task_4.Solution;

@FunctionalInterface
public interface Weather {
    WeatherData getWeather(String city);
}
