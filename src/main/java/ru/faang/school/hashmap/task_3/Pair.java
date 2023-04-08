package ru.faang.school.hashmap.task_3;

public final class Pair {
    private Faculty faculty;
    private int year;

    private Pair() {
    }

    private Pair(Faculty faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public static Pair of(Faculty faculty, int year) {
        return new Pair(faculty, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (year != pair.year) return false;
        return faculty == pair.faculty;
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Faculty: %s, %d course.", faculty, year);
    }
}
