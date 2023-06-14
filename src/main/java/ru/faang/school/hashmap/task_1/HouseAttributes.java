package ru.faang.school.hashmap.task_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HouseAttributes {

    private String motto;
    private String sigil;

    @Override
    public String toString() {
        return "motto - '" + motto + "', sigil - '" + sigil + "'";
    }

}
