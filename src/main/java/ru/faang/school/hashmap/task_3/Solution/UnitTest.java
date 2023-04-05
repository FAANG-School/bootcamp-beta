package ru.faang.school.hashmap.task_3.Solution;

import org.junit.Before;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class UnitTest {

    public StudentDB db;
    public Student s;
    public Student s1;
    public Student s2;
    public Student s3;
    @Before
    public void prepare() throws IOException {
        db = new StudentDB();
        s = new Student("name", "faculty", 1);
        s1 = new Student("alex", "math", 2);
        s2 = new Student("vlad", "FAANG", 4);
        s3 = new Student("john", "ComputerScience", 3);
    }

    public void pushAll(StudentDB db){
        db.add(s);
        db.add(s1);
        db.add(s2);
        db.add(s3);
    }


    @org.junit.Test
    public void addTest(){
        try {
            db.add(s);
            db.add(s1);
            db.add(s2);
            db.add(s3);
        } catch(Exception e){
            fail("There was an error somewhere");
        }
    }

    @org.junit.Test
    public void createInvalidStudentTest(){
        try {
            new Student("", "", -1);
        } catch(IOException e){
            return;
        }
        fail("invalid Student successfully created");
    }

    @org.junit.Test
    public void equalsTest() throws IOException{
        StudentDB db2 = new StudentDB();

        pushAll(db);
        pushAll(db2);

        assertEquals(db, db2);
        assertEquals(s, new Student("name", "faculty", 1));
    }

    @org.junit.Test
    public void removeTest(){
        StudentDB db2 = new StudentDB();

        db.add(s1);
        db.add(s2);

        pushAll(db2);

        assertNotEquals(db, db2);

        db2.remove(s);
        db2.remove("john", "ComputerScience", 3);

        assertEquals(db, db2);
    }

    @org.junit.Test
    public void removeNonExistingValueTest(){
        assertFalse(db.remove(s));
        assertFalse(db.remove("john", "ComputerScience", 3));

        db.add(s);

        assertFalse(db.remove(s1));

        db.remove(s);

        assertFalse(db.remove(s));
    }

    @org.junit.Test
    public void getTest() throws IOException {
        assertArrayEquals("Empty", new Student[]{}, db.get("", 1));

        pushAll(db);

        assertArrayEquals("Single", new Student[]{s2}, db.get("FAANG", 4));

        db.add("me:)", "FAANG", 4);
        assertTrue("Multiple",
                Arrays.equals(new Student[]{
                        s2, new Student("me:)", "FAANG", 4)
                }, db.get("FAANG", 4)) ||
                        Arrays.equals(new Student[]{
                        new Student("me:)", "FAANG", 4), s2
                }, db.get("FAANG", 4))
        );

    }

    @org.junit.Test
    public void getAllTest(){
        pushAll(db);
        System.out.println(db);
        //IDK how to assert so I will check it manually
    }
}
