import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();
        addHouse(map, new House("Stark house", "Wolf"));
        addHouse(map, new House("Lannister house", "Lion"));
        addHouse(map, new House("Baratheon house", "Stag"));
        addHouse(map, new House("TEST", "tst"));
        deleteHouse(map, "TEST");
        houseInfo(map, "Stark house");
        System.out.println();
        houses(map);
    }

    public static void addHouse(Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    public static void deleteHouse(Map<String, House> map, String name) {
        map.remove(name);
    }

    public static void houseInfo(Map<String, House> map, String name) {
        System.out.println("Name: " + name + ", Sigil: " + map.get(name).getSigil());
    }

    public static void houses(Map<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Sigil: " + entry.getValue().getSigil());
        }
    }
}

class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}