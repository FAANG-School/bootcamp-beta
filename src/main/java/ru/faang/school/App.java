package ru.faang.school;

import ru.faang.school.hashmap.task_1.Main;

public class App {
    public static void main(String[] args) {
        Main main = new Main();


        main.showAllHomeInfo();
        main.showHomeInfo("House Arryn");
        main.showHomeInfo("House Stark");
        main.showHomeInfo("House Starkk");

        main.removeHouseFromMap("House Arryn");
        main.showHomeInfo("House Arryn");
    }
}
