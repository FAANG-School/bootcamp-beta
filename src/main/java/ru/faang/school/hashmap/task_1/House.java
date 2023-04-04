package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class House {
	
	private String name;
	private String sigil;
	
	public House(String name, String sigil) {
		this.name = name;
		this.sigil = sigil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSigil() {
		return sigil;
	}

	public void setSigil(String sigil) {
		this.sigil = sigil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, sigil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		return Objects.equals(name, other.name) && Objects.equals(sigil, other.sigil);
	}
	
}
