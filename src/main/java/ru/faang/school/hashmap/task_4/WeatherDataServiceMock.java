package ru.faang.school.hashmap.task_4;

public class WeatherDataServiceMock {

    public WeatherData getWeatherData(String city){
        WeatherData mock = new WeatherData("city", 25, 15);
        System.out.printf("Getting weather data for %s...\n",city);
        mock.setCity(city);
        System.out.println("Response received.");
        return mock;
    }

}
