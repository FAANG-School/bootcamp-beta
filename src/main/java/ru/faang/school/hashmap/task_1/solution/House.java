package ru.faang.school.hashmap.task_1.solution;

public class House {

  private final String name;

  private final String sigil;

  public String getName() {
    return name;
  }

  public String getSigil() {
    return sigil;
  }

  public House(String name, String sigil) {
    this.name = name;
    this.sigil = sigil;
  }
  public House() {
    this.name = null;
    this.sigil = null;
  }

  @Override
  public String toString() {
    return "House{ "+"name='" + name + "', sigil='" + sigil + "' }";
  }
}
