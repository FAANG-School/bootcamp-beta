package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task1 {
    public static final String SPLITTER = "-----------------------------------";
    public static final String INFO_TEXT = "Выбирите действие" + "\n" + "1. - Добавить элемент в HashMap;" + "\n" + "2. - Удалить элемент из HashMap;" + "\n" + "3. - Найти элемент в HashMap;" + "\n" + "4. - Показать содержимое HashMap;" + "\n" + "0. - Выход;" + "\n" + SPLITTER;

    public static void main(String[] args) {
        boolean isExit = false;
        Scanner scan = new Scanner(System.in);

        Map<String, House> housesHashMap = new HashMap<>();
        housesHashMap.put("Дом1", new House("Дом1", "Герб дома 1"));
        housesHashMap.put("Дом2", new House("Дом2", "Герб дома 2"));
        housesHashMap.put("Дом3", new House("Дом3", "Герб дома 3"));

        System.out.println(SPLITTER);

        while (!isExit) {
            System.out.println(INFO_TEXT);
            try {
                int value = Integer.valueOf(scan.nextLine());
                System.out.println(SPLITTER);
                switch (value) {
                    case 1:
                        addPairHashMap(housesHashMap);
                        break;
                    case 2:
                        deletePairHashMap(housesHashMap);
                        break;
                    case 3:
                        findPairHashMap(housesHashMap);
                        break;
                    case 4:
                        getAllPairsHashMap(housesHashMap);
                        break;
                    case 0:
                        System.out.println("Выход...");
                        isExit = true;
                        break;
                }
                System.out.println(SPLITTER);
            } catch (NumberFormatException nfe) {
                System.out.println("Не верный тип попробуйте еще раз");
            }
        }
    }

    public static void getAllPairsHashMap(Map<String, House> housesHashMap) {
        for (Map.Entry maps : housesHashMap.entrySet()) {
            System.out.print("Ключ \"" + maps.getKey() + "\" - " + maps.getValue() + "\n");
        }
    }

    public static void addPairHashMap(Map<String, House> housesHashMap) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        String HashKey = scan.nextLine();
        System.out.print("Введите имя дома: ");
        String houseName = scan.nextLine();
        System.out.print("Введите герб дома: ");
        String sigilName = scan.nextLine();

        if ((housesHashMap.get(HashKey) != null)) {
            System.out.println(SPLITTER + "\n" + "Значение с таким ключом существует, пара не добавлена!");
        } else {
            housesHashMap.put(HashKey, new House(houseName, sigilName));
            System.out.println(SPLITTER + "\n" + "Пара добавлена!");
        }
    }

    public static void findPairHashMap(Map<String, House> housesHashMap) {
        System.out.print("Введите ключ, значение которого нужно отобразить: ");
        Scanner scan = new Scanner(System.in);
        String findKey = scan.nextLine();

        if (housesHashMap.get(findKey) != null) {
            House house = housesHashMap.get(findKey);
            System.out.println(SPLITTER + "\n" + "Герб дома \"" + findKey + "\" -  \"" + house.getSigil() + "\"");
        } else {
            System.out.println(SPLITTER + "\n" + "Значения с таким ключом не найдено!");
        }
    }

    public static void deletePairHashMap(Map<String, House> housesHashMap) {
        System.out.print("Введите ключ, значение которого нужно удалить: ");
        Scanner scan = new Scanner(System.in);
        String findKey = scan.nextLine();

        if (housesHashMap.get(findKey) != null) {
            housesHashMap.remove(findKey);
            System.out.println(SPLITTER + "\n" + "Пара удалена!");
        } else {
            System.out.println(SPLITTER + "\n" + "Не удаеться найти такую пару!");
        }
    }

}



class House {
    public String name;
    public String sigil;

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

    @Override
    public String toString() {
        return "Имя дома = " + name + ", Герб дома = " + sigil;
    }

    public void setSigil(String sigil) {
        this.sigil = sigil;
    }
}
