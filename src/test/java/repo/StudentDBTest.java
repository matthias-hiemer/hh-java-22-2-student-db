package repo;

import model.Student;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {

    @Test
    void testGetAllStudents_whenAdded_returnStudents(){
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");

        StudentDB studentDB = new StudentDB(new HashMap<>(2));
        studentDB.addStudent(student1);
        studentDB.addStudent(student2);

        // WHEN
        Map<String, Student> actual = studentDB.getAllStudents();

        // THEN
        assertArrayEquals(studentDB.getAllStudents().values().toArray(), actual.values().toArray());
    }

    @Test
    void testToString_whenToString_returnString(){
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");

        StudentDB studentDB = new StudentDB(new HashMap<>(2));
        studentDB.addStudent(student1);
        studentDB.addStudent(student2);

        // WHEN
        String actual = studentDB.toString();

        // THEN
        String expected = "StudentDB{students={456=Student{id='456', name='Eva'}, 123=Student{id='123', name='Adam'}}}";
        assertEquals(expected, actual);
    }
}