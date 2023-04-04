package ru.faang.school.hashmap.task_1.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {
  private final static Map<String, House> map = new HashMap<>();

  public static void putHouse(House house) {

    map.put(house.getName(), house);
  }

  public static House removeHouse(String nameHouse) {

    return map.remove(nameHouse);
  }

  public static void printSigilOfHouse(String nameHouse) {

    System.out.println(map.getOrDefault(nameHouse, new House()).getSigil());
  }

  public static void printAllHouses() {

    map.forEach((key, value) ->
        System.out.printf("\nHouse: %s, sigil: %s", key, value!=null? value.getSigil() : null));
  }

  public static void main(String[] args) {
    var lanistersHouse = new House("Ланнистеры", "На гербе Ланнистеров изображён лев, из-за чего представители этого дома часто именуют себя «львами» или «львицами».");
    var barateonsHouse = new House("Баратеоны", "На гербе Баратеонов изображён олень, их девиз — «Нам ярость».");
    var tallyHouse = new House("Талли", "На гербе Талли изображена серебряная форель, их девиз — «Семья, долг, честь».");
    var arrenssHouse = new House("Аррены ", "Герб Арренов — белые сокол и месяц, девиз — «Высокий как честь».");
    var GreyjoisHouse = new House("Грейджои", "На гербе Грейджоев изображён золотой кракен, их девиз — «Мы не сеем».");
    var BronnHouse = new House("Дом Бронна", "Символом дома является пылающая стрела, отсылающая к подвигу Бронна во время битвы у Черноводной. Девиз и фамильное имя неизвестны.");


    putHouse(lanistersHouse);
    putHouse(barateonsHouse);
    putHouse(tallyHouse);
    putHouse(arrenssHouse);
    putHouse(GreyjoisHouse);
    putHouse(BronnHouse);

    printAllHouses();

    putHouse(BronnHouse);

    printSigilOfHouse(BronnHouse.getName());

    System.out.println("\nREMOVE HOUSE - " + removeHouse(tallyHouse.getName()).getName());
    System.out.println("\nREMOVE HOUSE - " + removeHouse(BronnHouse.getName()).getName());

    printAllHouses();

    System.out.println("\nREMOVE UNKNOWN HOUSE || return value:" + removeHouse("MyHouse"));

    putHouse(new House());
    System.out.println("\nPUT EMPTY HOUSE");

    System.out.println("\nPRINT WITH EMPTY HOUSE");
    printAllHouses();
  }

}
