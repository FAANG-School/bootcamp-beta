package ru.faang.school.hashmap.task_1;

public class Main {

    static HouseHashMap storageOfHouses = new HouseHashMap();

   // Как видно по содержанию -- я не смотрел :)
    House stark = new House("Stark", "Stark's sigil");
    House lannyster = new House("Lannyster", "Lannyster's sigil");
    House barateon = new House("Barateon", "Barateon's sigil");

    public static void main(String[] args) {
        new Main().initStorage();

        storageOfHouses.addNewHouse("House_Name", "House_Sigil");
        storageOfHouses.deleteHouse("Stark");
        storageOfHouses.showInfo();
    }

    private void initStorage() {
        storageOfHouses.addNewHouse(stark.getName(), stark.getSigil());
        storageOfHouses.addNewHouse(lannyster.getName(), lannyster.getSigil());
        storageOfHouses.addNewHouse(barateon.getName(), barateon.getSigil());
    }

}
