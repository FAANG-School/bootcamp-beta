package ru.faang.school;

import ru.faang.school.hashmap.task_1.Main;

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        main.putHouseToMap("House Martell", "A red sun pierced by a gold spear on an orange field. A gold spear on an orange field (historical)");
        main.putHouseToMap("House House Lannister", "A golden lion rampant on a crimson field");
        main.putHouseToMap("House Baratheon", "A crowned black stag salient on a gold field");
        main.putHouseToMap("House Arryn", "A white falcon volant and crescent moon on a blue field");
        main.putHouseToMap("House Greyjoy", "A gold kraken on a black field");
        main.putHouseToMap("House Stark", "A grey direwolf's head facing sinister on a white field and a green base");

        main.showAllHomeInfo();
        main.showHomeInfo("House Arryn");
        main.showHomeInfo("House Stark");
        main.showHomeInfo("House Starkk");

        main.removeHouseFromMap("House Arryn");
        main.showHomeInfo("House Arryn");
    }
}
