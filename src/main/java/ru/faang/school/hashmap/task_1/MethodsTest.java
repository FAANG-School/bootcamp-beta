package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodsTest {
    private Map<String, House> map;
    private Methods methods;
    @BeforeEach
    void setUp() {
        methods = new Methods();
        map = new HashMap<>();
    }

    @Test
    void createNewHouse() {
        assertTrue(methods.createNewHouse(map, "�����", new House("�����", "���� ������")));
        assertTrue(map.containsKey("�����"));
    }

    @Test
    void deleteHouse() {
        assertTrue(methods.createNewHouse(map, "�����", new House("�����", "���� ������")));
        assertTrue(methods.deleteHouse(map, "�����"));
        assertFalse(map.containsKey("�����"));
    }

    @Test
    void getSigilByName() {
        assertTrue(methods.createNewHouse(map, "�����", new House("�����", "���� ������")));
        assertEquals("���� ������", methods.getSigilByName(map, "�����"));
    }

    @Test
    void getAllHouses() {
        assertTrue(methods.createNewHouse(map, "�����", new House("�����", "���� ������")));
        assertTrue(methods.createNewHouse(map, "���������", new House("���������", "������ ��� ���")));
        assertTrue(methods.createNewHouse(map, "��������", new House("��������", "��� ������")));
        assertEquals(3, map.size());
    }
}