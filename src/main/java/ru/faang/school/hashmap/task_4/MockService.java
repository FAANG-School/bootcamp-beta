package ru.faang.school.hashmap.task_4;

public class MockService {
	
	public static WeatherData doSomeLongOperation(String city) {
		return new WeatherData(city, 25, 83);
	}

}
