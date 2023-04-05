import java.util.Map;

public class House {
    private final String name;
    private final String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getSigil() {
        return sigil;
    }

    public static void printAll(Map<String, House> vestHouses) {
        vestHouses.forEach((k, v) -> System.out.println(v));
    }

    public static void add(String houseName, House house) {
        Main.vestHouses.put(houseName, house);
    }

    public static void remove(String houseName) {
        Main.vestHouses.remove(houseName);
    }

    public  static void sigilInfo(String houseName) {
        System.out.println(Main.vestHouses.get(houseName).getSigil());
    }

    @Override
    public String toString() {
        return "House: " + name + ", sigil: " + sigil;
    }
}
