package Task_1;

import Task_1.House;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    private static Map<String, House> _vesterosHouse;

    public static void main(String[] args)
    {
        _vesterosHouse = new HashMap<>();

        //Заполняем ассоциативный массив:
        //Input();

        _vesterosHouse.put("Дом Севера", new House("Старк", "Волк"));
        _vesterosHouse.put("Дом богачей", new House("Ланистеры", "Лев"));
        _vesterosHouse.put("Дом Короля", new House("Баратеоны", "Олень"));
        _vesterosHouse.put("Дом медведей", new House("Мармонты", "Медедь"));

        //Добавить новый дом:
        addHouse("Дом моряков", new House("Грейджои", "Кракен"));

        //Удаление дома по его названию(ключу):
        removeHouse("Дом Севера");

        //Поиск дома по ключу и вывод информации о нем:
        searchInfoHouse("Дом богачей");

        //Вывод списка всех домов и их гербов:
        for (Map.Entry<String, House> entry: _vesterosHouse.entrySet()) {
            System.out.println("Название дома: " + entry.getKey() + ", Описание дома: " + entry.getValue().getName() + ", герб: " + entry.getValue().getSigil());
        }
    }

    public static void Input(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            String key = scanner.nextLine();
            String name = scanner.nextLine();
            String sigil = scanner.nextLine();
            _vesterosHouse.put(key, new House(name, sigil));
        }
    }
    public static void addHouse(String key, House house){
        _vesterosHouse.put(key, house);
    }

    public static void removeHouse(String key){
        _vesterosHouse.remove(key);
    }

    public static void searchInfoHouse(String key){
        var house = _vesterosHouse.get(key);
        System.out.println("Дом: " + house.getName() + ", герб: " + house.getSigil());
    }
}

