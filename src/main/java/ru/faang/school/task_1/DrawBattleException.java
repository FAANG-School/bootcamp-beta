package ru.faang.school.task_1;

public class DrawBattleException extends RuntimeException {
    public DrawBattleException() {
        super("There was more than 100 round in battle - DRAW");
    }
}
