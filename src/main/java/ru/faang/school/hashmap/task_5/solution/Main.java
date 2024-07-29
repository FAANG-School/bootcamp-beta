package ru.faang.school.hashmap.task_5.solution;

import java.util.*;

public class Main {

    private WebIndexes indexes = new WebIndexes();

    public static void main(String[] args) {
        new Main().start();
    }

    public void start(){
        List<WebPage> webPages = new ArrayList<>();
        webPages.add(new WebPage("https://faang-school.com/courses/mvyz9jdk/bvd6v8d9", "Variables and data types", "— Today we will transform animals into vessels for liquids. One, two, three — Fera Verto!"));
        webPages.add(new WebPage("https://faang-school.com/courses/mvyz9jdk/9nzw38zj", "Strings", "You enter the Charms Professor's huge office and sit at a long, U-shaped table."));
        webPages.add(new WebPage("https://faang-school.com/courses/mvyz9jdk/63dkm5dm", "Branching", "You make your way through the crowd of students closer to the forester's house."));
        webPages.add(new WebPage("https://faang-school.com/courses/mvyz9jdk/gnzgm6z6", "Cycles", "When your boggart turns into the moon, students have questions."));

        indexes.index(webPages);
        indexes.addToIndex(new WebPage("https://faang-school.com/courses/mvyz9jdk/89z89rdp", "Arrays", "You carefully drop a small green myrtle leaf into the bubbling cauldron, and the liquid immediately changes color from dirty brown to sky blue."));

        indexes.printIndexes();

        System.out.println(indexes.getWebPagesByKeyWord("into"));

        indexes.deleteWebPageByUrl("https://faang-school.com/courses/mvyz9jdk/bvd6v8d9");

        indexes.printIndexes();
    }
}
