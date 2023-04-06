package hashmap.task_1;

import java.util.Map;

public class House {
    private String name;
    private Sigil sigil;

    public House(String name, Sigil sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public Sigil getSigil() {
        return sigil;
    }

    public void addHouse(Map<String, House> map) {
        map.put(getName(), this);
    }

    public static void removeHouse(Map<String, House> map, String name) {
        map.remove(name);
    }

    public static Sigil getHouseSigil(Map<String, House> map, String name) {
        return map.get(name).getSigil();
    }

    public String toString() {
        return name;
    }
}

class Sigil {}