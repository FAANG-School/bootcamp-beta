package ru.faang.school.hashmap.task_1;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class Task1Test {
	
	private final Map<String, House> map = new HashMap<>();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@BeforeEach
	void init() {
		map.put("Stark", new House("Stark", "Stark sigil"));
		map.put("Targaryen", new House("Targaryen", "Targaryen sigil"));
		map.put("Lannister", new House("Lannister", "Lannister sigil"));
		map.put("Greyjoy", new House("Greyjoy", "Greyjoy sigil"));
		map.put("Tyrell", new House("Tyrell", "Tyrell sigil"));
		map.put("Baratheon", new House("Baratheon", "Baratheon sigil"));
		map.put("Arryn", new House("Arryn", "Arryn sigil"));
		map.put("Martell", new House("Martell", "Martell sigil"));
		map.put("Tully", new House("Tully", "Tully sigil"));
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	void shutDown() {
		map.clear();
		System.setOut(originalOut);
	}
	
	@Test
	void addingTest() {
		
		Main.addHouse(new House("New House", "New House sigil"), map);
		assertEquals("New House sigil", map.get("New House").getSigil());
		Assert.assertEquals(10, map.size());
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				 											() -> Main.addHouse(null, map));
		
		assertEquals("null arguments", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
					() -> Main.addHouse(new House("Test", "Test House sigil"), null));
		
		assertEquals("null arguments", exception.getMessage());
		
		Main.addHouse(new House("New House", "New House sigil"), map);
		assertEquals("This house already exists"+"\r\n", outContent.toString());
	}
	
	@Test
	void removeTest() {
		
		Assert.assertEquals(9, map.size());
		
		Main.removeHouse("Stark", map);
		Assert.assertEquals(8, map.size());
		
		assertNull(map.get("Stark"));
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
					() -> Main.removeHouse("Stark", null));
		
		assertEquals("null arguments", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> Main.removeHouse(null, map));
		
		assertEquals("null arguments", exception.getMessage());
	}
	
	@Test
	void findHouseByNameReturnSigilTest() {
		assertEquals("Stark sigil", Main.findHouseByNameReturnSigil("Stark", map));
		
		assertEquals("There are no houses with such name", Main.findHouseByNameReturnSigil("BadName", map));
		
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
					() -> Main.findHouseByNameReturnSigil("Stark", null));
		
		assertEquals("null arguments", exception.getMessage());
		
		exception = Assertions.assertThrows(IllegalArgumentException.class,
					() -> Main.findHouseByNameReturnSigil(null, map));
		
		assertEquals("null arguments", exception.getMessage());
	}
	
	@RepeatedTest(5)
	void printHousesWithSigilsTest() {
		map.clear();
		
		map.put("Stark", new House("Stark", "Stark sigil"));
		map.put("Arryn", new House("Arryn", "Arryn sigil"));
		
		Main.printHousesWithSigils(map);
		
		assertEquals("House: Stark - Sigil: Stark sigil"+"\r\n" +
					 "House: Arryn - Sigil: Arryn sigil" + "\r\n", outContent.toString());
	}

}
