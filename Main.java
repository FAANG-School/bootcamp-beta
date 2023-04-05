import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map <String, House > houses = new HashMap<>();
        houses.put("Дом 1", new House("Ланисстеры", "Лев"));
        houses.put("Дом 2", new House("Баратеоны", "Олень"));
        houses.put("Дом 3", new House("Тиреллы", "Клевер"));
        houses.put("Дом 4", new House("Сиворты", "Корабль"));
        houses.put("Дом 5", new House("Толхарты", "Лес"));

        houses.put("Новый дом", new House("House", "Emblem")); // добав нового дома.

        houses.remove("Дом 2"); // удаление по названию.

        House nameHouse = houses.get("Дом 4"); // поиск дома.
        System.out.println("Info: " + nameHouse);

        for (Map.Entry <String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
