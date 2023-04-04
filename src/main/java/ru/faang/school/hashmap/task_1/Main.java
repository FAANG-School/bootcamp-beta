package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, House> map = new HashMap<>();
		
		map.put("Stark", new House("Stark", "Stark sigil"));
		map.put("Targaryen", new House("Targaryen", "Targaryen sigil"));
		map.put("Lannister", new House("Lannister", "Lannister sigil"));
		map.put("Greyjoy", new House("Greyjoy", "Greyjoy sigil"));
		map.put("Tyrell", new House("Tyrell", "Tyrell sigil"));
		map.put("Baratheon", new House("Baratheon", "Baratheon sigil"));
		map.put("Arryn", new House("Arryn", "Arryn sigil"));
		map.put("Martell", new House("Martell", "Martell sigil"));
		map.put("Tully", new House("Tully", "Tully sigil"));
		
		System.out.println("Unit_test1(map.size=" + map.size() + "): " );
		printHousesWithSigils(map);
		
		addHouse(new House("New House", "New House sigil"), map);
		
		System.out.println("Unit_test2(map.size=" + map.size() + "): " );
		printHousesWithSigils(map);
		
		removeHouse("New House", map);
		System.out.println("Unit_test3(map.size=" + map.size() + "): " );
		printHousesWithSigils(map);
		System.out.println("Unit_test4(map.size=" + map.size() + "): " );
		System.out.println(findHouseByNameReturnSigil("Greyjoy", map));
		System.out.println(findHouseByNameReturnSigil("Bad_name", map));
		System.out.println(findHouseByNameReturnSigil("", map));
		System.out.println(findHouseByNameReturnSigil(null, map));
	}
	
	public static void addHouse(House house, Map<String, House> map) {
		
		if (house != null && map != null) {
			String name = house.getName();
			if (map.get(name) != null) {
				System.out.println("This house already exists");
			}
			else
				map.put(name, house);
		}
		else
			throw new IllegalArgumentException("null arguments");
		
	}
	
	public static void removeHouse(String name, Map<String, House> map) {
		
		if (name != null && map != null) 
			map.remove(name);
		else
			throw new IllegalArgumentException("null arguments");
		
	}
	
	public static String findHouseByNameReturnSigil(String name, Map<String, House> map) {
		
		if (name == null || map == null)
			throw new IllegalArgumentException("null arguments");
		
		House house = map.get(name);
		
		return house != null ? house.getSigil() : "There are no houses with such name";
	}
	
	public static void printHousesWithSigils(Map<String, House> map) {
		if (map == null)
			throw new IllegalArgumentException("null arguments");
		if (map.isEmpty())
			System.out.println("There are no houses in this map");
		
		map.forEach((k, v) -> System.out.println("House: " + k + " - Sigil: " + v.getSigil()));
	}
	
	

}
