package ru.faang.school.task_1.utils;

public class RandomUtils {
    public static int getRandomNumberFromRange(int from, int to) {
        int range = (to - from) + 1;
        return (int) (Math.random() * range) + from;
    }
}