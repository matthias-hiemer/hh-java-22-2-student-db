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

        Map<String, Student> students = new HashMap<>(2);
        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);

        StudentDB studentDB = new StudentDB(students);

        // WHEN
        Map<String, Student> actual = studentDB.getAllStudents();

        // THEN
        assertArrayEquals(students.values().toArray(), actual.values().toArray());
    }

    @Test
    void testToString_whenToString_returnString(){
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");

        Map<String, Student> students = new HashMap<>(2);
        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);

        StudentDB studentDB = new StudentDB(students);

        // WHEN
        String actual = studentDB.toString();

        // THEN
        String expected = "StudentDB{students={456=Student{id='456', name='Eva'}, 123=Student{id='123', name='Adam'}}}";
        assertEquals(expected, actual);
    }

    @Test
    void getStudentByIdShouldReturnRequestedStudentOnValidId() {
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");

        Map<String, Student> students = new HashMap<>(2);
        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);

        StudentDB studentDB = new StudentDB(students);

        Student requestedStudent = student2;
        String requestedId = requestedStudent.getId();

        // WHEN
        Student foundStudent = studentDB.getStudentById(requestedId);
        String foundId = foundStudent.getId();

        // THEN
        assertEquals(requestedId, foundId);
    }

    @Test
    void getStudentByIdShouldThrowExceptionOnInvalidId() {
        // GIVEN
        Map<String, Student> students = new HashMap<>(0);
        StudentDB studentDB = new StudentDB(students);

        String faultyId = "";

        // WHEN AND THEN
        assertThrows(IllegalArgumentException.class, () -> studentDB.getStudentById(faultyId));
    }

    @Test
    void getStudentByIdShouldThrowExceptionOnInvalidId_try_catch() {
        // GIVEN
        Map<String, Student> students = new HashMap<>(0);
        StudentDB studentDB = new StudentDB(students);

        String faultyId = "";
        boolean exceptionWasThrown = false;

        // WHEN
        try {
            studentDB.getStudentById(faultyId);
        } catch (IllegalArgumentException exception) {
            exceptionWasThrown = true;
        }

        // THEN
        assertTrue(exceptionWasThrown);
    }
}