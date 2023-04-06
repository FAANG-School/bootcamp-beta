package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	private static final Map<String, WeatherData> map = new HashMap<>();
	
	static {
		map.put("Roma", new WeatherData("Roma", 18, 20));
		map.put("Vilnius", new WeatherData("Vilnius", 18, 20));
		map.put("Praha", new WeatherData("Praha", 18, 20));
		map.put("Sydney", new WeatherData("Sydney", 18, 20));
		map.put("San Diego", new WeatherData("San Diego", 18, 20));
	}
	
	public static WeatherData getWeather(String city) {
		
		if (city == null || city.isBlank())
			throw new IllegalArgumentException("Null or blank args");
		
		if (map.containsKey(city))
			return map.get(city);
		else {
			WeatherData weather = MockService.doSomeLongOperation(city);
			map.put(city, weather);
			return weather;
		}
	}
	
	public static void updateWeather(String city) {
		
		if (city == null || city.isBlank())
			throw new IllegalArgumentException("Null or blank args");
		
			WeatherData weather = MockService.doSomeLongOperation(city);
			map.put(city, weather);
	}
	
	public static void removeWeather(String city) {
		
		if (city == null || city.isBlank())
			throw new IllegalArgumentException("Null or blank args");

		if (map.containsKey(city))
			map.remove(city);
		else
			System.out.println("Nothing to delete");
	}
	
	public static List<String> getCities() {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}
	
	public void printCities() {
		List<String> cities = getCities();
		
		if (cities.isEmpty())
			System.out.println("No info yet, please update");
		else
			cities.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		
		getCities().stream().forEach(System.out::println);

	}

}
