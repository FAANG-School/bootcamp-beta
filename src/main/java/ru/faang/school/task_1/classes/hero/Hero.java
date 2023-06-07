package ru.faang.school.task_1.classes.hero;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.faang.school.task_1.classes.util.Fraction;

import java.util.HashMap;

@RequiredArgsConstructor
public class Hero {
    @NonNull
    private String name;
    @NonNull
    private Fraction fraction;
    @NonNull
    private int experience;
    @NonNull
    private int level;
    private Map<> creatures = new HashMap();


}
