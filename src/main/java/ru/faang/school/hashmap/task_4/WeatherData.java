package ru.faang.school.hashmap.task_4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherData {

    String city;
    int temperature;
    int humidity;

    @Override
    public String toString() {
        return "In " + city + " the temperature is " + temperature + " degrees and humidity is " + humidity + " %.";
    }
}
