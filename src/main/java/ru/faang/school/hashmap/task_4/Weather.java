package ru.faang.school.hashmap.task_4;

import ru.faang.school.hashmap.task_4.model.WeatherData;

public interface Weather {
    WeatherData getWeatherData(String city);
}
