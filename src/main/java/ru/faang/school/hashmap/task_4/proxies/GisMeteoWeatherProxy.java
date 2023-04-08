package ru.faang.school.hashmap.task_4.proxies;

import ru.faang.school.hashmap.task_4.Weather;
import ru.faang.school.hashmap.task_4.model.WeatherData;

public class GisMeteoWeatherProxy implements Weather {

    @Override
    public WeatherData getWeatherData(String city) {
        System.out.println("Загрузили информацию с сайта");
        return new WeatherData("Moscow", 10, 40);
    }
}
