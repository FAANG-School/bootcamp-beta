package ru.faang.school.hashmap.task_1;


import java.util.HashMap;

public class Main {
    static HashMap<String, House> housesHashMap = new HashMap<>();

    public static void main(String[] args) {
        addHome("HOME_1", "SIGIL_1");
        addHome("HOME_3", "SIGIL_3");
        addHome("HOME_2", "SIGIL_2");
        addHome("HOME_5", "SIGIL_5");
        addHome("HOME_4", "SIGIL_4");
        showInfoAllHouse();

        removeHouse("HOME_1");
        removeHouse("HOME_6");
        removeHouse("HOME_4");

        showInfoAllHouse();

        replaceSigin("HOME_2", "NEW_SIGIL");

        showInfoAllHouse();


    }

    static void removeHouse(String name) {
        if (!housesHashMap.containsKey(name)) {
            System.out.printf("There is no house with the name: %s in the system\n", name);
        } else {
            housesHashMap.remove(name);
        }

    }

    static void addHome(String name, String sigil) {
        if (housesHashMap.containsKey(name)) {
            System.out.printf("The house with the name: %s is already in the system\n", name);
        } else {
            housesHashMap.put(name, new House(name, sigil));
        }
    }

    static void replaceSigin(String name, String sigil) {
        if (!housesHashMap.containsKey(name)) {
            System.out.printf("There is no house with the name: %s in the system\n", name);
        } else {
            findHouse(name).setSigil(sigil);
        }
    }

    static void showInfoHouse(String name) {
        System.out.printf("Sigil house %s = %s\n", name, findHouse(name).getSigil());
    }

    static House findHouse(String name) {
        return housesHashMap.get(name);
    }

    static void showInfoAllHouse() {
        for (String name : housesHashMap.keySet()) {
            showInfoHouse(name);
        }

    }
}
