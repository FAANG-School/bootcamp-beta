package ru.faang.school.hashmap.task_4;

public class MockService {
	
	public static WeatherData doSomeLongOperationGet(String city) {
		return new WeatherData(city, 25, 83);
	}
	
	public static WeatherData doSomeLongOperationUpdate(String city) {
		return new WeatherData(city, 19, 95);
	}

}
