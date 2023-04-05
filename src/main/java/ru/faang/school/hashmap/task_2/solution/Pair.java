package ru.faang.school.hashmap.task_2.solution;

import java.util.Objects;

public class Pair {
    public String fst;
    public int snd;

    public Pair(String fst, int snd) {
        this.fst = fst;
        this.snd = snd;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return snd == pair.snd && Objects.equals(fst, pair.fst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }
}
