package ru.faang.school.hashmap.task_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class House {

    String motto;
    String sigil;

    @Override
    public String toString() {
        return "motto - '" + motto + "', sigil - '" + sigil + "'.";
    }

}
