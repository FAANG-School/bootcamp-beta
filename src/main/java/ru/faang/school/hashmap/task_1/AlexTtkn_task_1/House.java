package ru.faang.school.hashmap.task_1.AlexTtkn_task_1;
import java.util.Objects;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getSigil() {
        return sigil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        House house = (House) obj;
        return  Objects.equals(name, house.name) &&
                Objects.equals(sigil, house.sigil);

    }
}
