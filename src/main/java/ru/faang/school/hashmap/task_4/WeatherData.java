package ru.faang.school.hashmap.task_4;

import java.util.Objects;

public class WeatherData {
	
	private final String city;
	private final Integer temperature;
	private final Integer humidity;
	
	public WeatherData(String city, Integer temperature, Integer humidity) {
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, humidity, temperature);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherData other = (WeatherData) obj;
		return Objects.equals(city, other.city) && Objects.equals(humidity, other.humidity)
				&& Objects.equals(temperature, other.temperature);
	}
	
	
	

}
