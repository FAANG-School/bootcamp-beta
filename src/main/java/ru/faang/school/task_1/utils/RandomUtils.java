package ru.faang.school.task_1.utils;

import java.util.Random;
import java.util.Set;

public class RandomUtils {
    public static int getRandomNumberFromRange(int from, int to) {
        int range = (to - from) + 1;
        return (int)(Math.random() * range) + from;
    }
    public static <E> E getRandomSetElement(Set<E> set) {
        return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
    }
}