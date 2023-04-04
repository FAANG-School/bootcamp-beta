package ru.faang.school;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        // Присваюю значения полям класс копейщиков
        Pikeman pikeman = new Pikeman("pikeman",5, 20, 6, 20, 22  );
        // Присваюю значения полям класс мечников
        Swordman swordman = new Swordman("swordman", 6, 25,5, 50, 25 );
        // Присваюю значения полям класс ангелов
        Angel angel = new Angel("angel", 13, 40, 8, 3, 35);
        // Присваюю значения полям класс грифов
        Griffin griffin = new Griffin("griffin", 8, 35, 7, 9, 30 );
    }

}