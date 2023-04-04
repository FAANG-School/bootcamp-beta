package ru.faang.school;

import ru.faang.school.hashmap.task_4.Main;

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        main.showCashedInfo();
        System.out.println();
        System.out.println(main.getWeather("Stambul"));
        System.out.println();
        main.showCashedInfo();
        main.updateWeatherInfo("Minsk");
        System.out.println();
        main.showCashedInfo();
        main.removeWeatherInfo("Minskk");
        System.out.println();
        main.showCashedInfo();
    }
}
