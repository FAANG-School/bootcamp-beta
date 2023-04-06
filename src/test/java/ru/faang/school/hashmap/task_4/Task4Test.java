package ru.faang.school.hashmap.task_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task4Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final WeatherData testWeather1 = new WeatherData("San Diego", 19, 30);
	private final WeatherData testWeather2 = new WeatherData("Tokio", 25, 83);
	private final WeatherData testWeather3 = new WeatherData("Tokio", 19, 95);
	private final List<String> cities = List.of("Praha", "Roma", "San Diego", "Sydney", "Vilnius");
	
	@BeforeEach
	void init() {
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	void reset() {
		System.setOut(originalOut);
		Main.removeTest("Tokio");
	}
	
	@Test
	void getWeather() {
		assertEquals(testWeather1, Main.getWeather("San Diego"));
		assertFalse(Main.containsTest("Tokio"));
		assertEquals(testWeather2, Main.getWeather("Tokio"));
		assertTrue(Main.containsTest("Tokio"));
	}

	@Test
	void getWeatherNullOrBlankArgs() {
		
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
																() -> Main.getWeather(null));
		assertEquals("Null or blank args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> Main.getWeather(""));
		assertEquals("Null or blank args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> Main.getWeather("   "));
		assertEquals("Null or blank args", ex.getMessage());
	}
	
	@Test
	void updateWeather() {
		assertFalse(Main.containsTest("Tokio"));
		assertEquals(testWeather2, Main.getWeather("Tokio"));
		assertTrue(Main.containsTest("Tokio"));
		Main.updateWeather("Tokio");
		assertEquals(testWeather3, Main.getWeather("Tokio"));
	}
	
	@Test
	void updateWeatherNullOrBlankArgs() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
				() -> Main.updateWeather(null));
		assertEquals("Null or blank args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> Main.updateWeather(""));
		assertEquals("Null or blank args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> Main.updateWeather("   "));
		assertEquals("Null or blank args", ex.getMessage());
	}
	
	@Test
	void removeWeather() {
		assertFalse(Main.containsTest("Tokio"));
		assertEquals(testWeather2, Main.getWeather("Tokio"));
		assertTrue(Main.containsTest("Tokio"));
		Main.removeWeather("Tokio");
		assertFalse(Main.containsTest("Tokio"));
		
	}
	
	@Test
	void removeWeatherNullOrBlankArgs() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, 
															() -> Main.removeWeather(null));
		assertEquals("Null or blank args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> Main.removeWeather(""));
		assertEquals("Null or blank args", ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> Main.removeWeather("   "));
		assertEquals("Null or blank args", ex.getMessage());
	}
	
	@Test
	void getCities() {
		assertEquals(cities, Main.getCities());
	}
	
	@Test
	void printCities() {
		Main.printCities();
		
		assertEquals("Praha\r\n" + "Roma\r\n" + "San Diego\r\n" + "Sydney\r\n" + "Vilnius\r\n", 
																			outContent.toString());
	}
}
