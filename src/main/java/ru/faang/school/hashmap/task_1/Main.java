package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Создание новых домов
        House house1 = new House("Старк","Волк");
        House house2 = new House("Ланнистер","Лев");
        House house3 = new House("Баратеон","Олень");
        House house4 = new House("Амбер","Великан");

        Map <String, House> map = new HashMap<>();  // Создаем HashMap

        // Добавляем новые дома
        map.put("Дом Севера",house1);
        map.put("Дом богачей",house2);
        map.put("Дом Короля",house3);
        map.put("Дом знаменосцы",house4);

        // Удаление дома по его названию
        map.remove("Дом знаменосцы");

        // Вывод информации о гербе
        House houseName = map.get("Дом Севера");
        System.out.println("Данные о гербе дома " + houseName);

        // Вывода списка всех домов и их гербов
        for(Map.Entry<String, House> entry: map.entrySet()){
            System.out.println(entry.getKey() + ":" +
                     entry.getValue());
        }

    }


}

class House {
    String name;
    String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(sigil, house.sigil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }

}