package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	private static final Map<String, WeatherData> map = new HashMap<>();
	
	static {
		map.put("Roma", new WeatherData("Roma", 18, 44));
		map.put("Vilnius", new WeatherData("Vilnius", 8, 85));
		map.put("Praha", new WeatherData("Praha", 14, 45));
		map.put("Sydney", new WeatherData("Sydney", 16, 93));
		map.put("San Diego", new WeatherData("San Diego", 19, 30));
	}
	
	public static WeatherData getWeather(String city) {
		
		if (city == null || city.isBlank())
			throw new IllegalArgumentException("Null or blank args");
		
		if (map.containsKey(city))
			return map.get(city);
		else {
			WeatherData weather = MockService.doSomeLongOperationGet(city);
			map.put(city, weather);
			return weather;
		}
	}
	
	public static void updateWeather(String city) {
		
		if (city == null || city.isBlank())
			throw new IllegalArgumentException("Null or blank args");
		
			WeatherData weather = MockService.doSomeLongOperationUpdate(city);
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
	
	public static void printCities() {
		List<String> cities = getCities();
		
		if (cities.isEmpty())
			System.out.println("No info yet, please update");
		else
			cities.stream().forEach(System.out::println);
	}
	
	/* just for testing. 
	 * pending delete */
	public static void removeTest(String city) {
		map.remove(city);
	}
	
	/* just for testing. 
	 * pending delete */
	public static boolean containsTest(String city) {
		return map.containsKey(city);
	}

	public static void main(String[] args) {
		
		/* just test print. 
		 * pending delete */
		getCities().stream().forEach(System.out::println);

	}

}
