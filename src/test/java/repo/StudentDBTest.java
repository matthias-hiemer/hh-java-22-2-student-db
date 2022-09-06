package repo;

import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {

    @Test
    void testGetAllStudents_whenAdded_returnStudents(){
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");
        Student[] students = {student1, student2};

        StudentDB studentDB = new StudentDB(students);

        // WHEN
        Student[] actual = studentDB.getAllStudents();

        // THEN
        Student[] expectedStudents = {student1, student2};
        assertArrayEquals(expectedStudents, actual);
    }

    @Test
    void testToString_whenToString_returnString(){
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");
        Student[] students = {student1, student2};

        StudentDB studentDB = new StudentDB(students);

        // WHEN
        String actual = studentDB.toString();

        // THEN
        String expected = " Student{id='123', name='Adam'} Student{id='456', name='Eva'}";
        assertEquals(expected, actual);
    }

    @Test
    void getStudentByIdShouldReturnRequestedStudentOnValidId() {
        // GIVEN
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");

        Student[] students = {student1, student2};
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
        Student[] students = new Student[0];
        StudentDB studentDB = new StudentDB(students);

        String faultyId = "";

        // WHEN AND THEN
        assertThrows(RuntimeException.class, () -> studentDB.getStudentById(faultyId));
    }
}