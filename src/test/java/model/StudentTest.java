package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    @Test
    void testEquals_whenDifferentStudents_returnFalse(){
        // GIVE
        Student student1 = new Student("123", "Anton");
        Student student2 = new Student("567", "Berta");

        // WHEN
        boolean actual = student1.equals(student2);

        // THEN
        assertEquals(false, actual);
    }

    @Test
    void testEquals_whenSameStudents_returnTrue(){
        // GIVE
        Student student1 = new Student("123", "Anton");
        Student student2 = new Student("123", "Anton");

        // WHEN
        boolean actual = student1.equals(student2);

        // THEN
        assertEquals(true, actual);
    }

}