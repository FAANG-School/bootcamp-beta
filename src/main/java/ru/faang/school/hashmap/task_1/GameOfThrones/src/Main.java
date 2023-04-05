import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, House> vestHouses = new HashMap<>();

    public static void main(String[] args) {
        House.add("Targaryen", new House("Targaryen", "A Three-Headed Dragon Breathing Flames"));
        House.add("Stark", new House("Stark", "Direwolf"));
        House.add("Lannister", new House("Lannister", "Lion Rampant"));
        House.add("Greyjoy", new House("Greyjoy", "Golden Kraken"));
        House.add("Baratheon", new House("Baratheon", "Black Crowned Deer"));
        House.add("Tarly", new House("Tarly", "Red Hunter On The Emerald Field"));

        House.printAll(vestHouses);

        System.out.println();

        House.sigilInfo("Stark");

        System.out.println();

        House.remove("Greyjoy");
        House.remove("Tarly");

        House.printAll(vestHouses);
    }
}
