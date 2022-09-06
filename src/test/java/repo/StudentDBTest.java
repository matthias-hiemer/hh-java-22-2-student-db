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
    void addShouldAddStudentToArray(){
        //GIVEN
        StudentDB studentDb = new StudentDB(new Student[]{
                new Student("1","Peter"),
                new Student("2", "Franziska"),
        });

        //WHEN
        studentDb.add(new Student("3", "Maria"));
        Student[] actual =  studentDb.getAllStudents();

        //THEN
        assertArrayEquals(new Student[]{
                new Student("1", "Peter"),
                new Student("2", "Franziska"),
                new Student("3", "Maria")
        }, actual);
    }

    @Test
    void removeShouldRemoveStudentFromArray(){
        //GIVEN
        StudentDB studentDb = new StudentDB(new Student[]{
                new Student("1", "Peter"),
                new Student("2", "Franziska"),
                new Student("3", "Maria")
        });

        //WHEN
        studentDb.remove("3");
        Student[] actual =  studentDb.getAllStudents();

        //THEN
        assertArrayEquals(new Student[]{
                new Student("1","Peter"),
                new Student("2","Franziska"),

        }, actual);


    }

    @Test
    void noStudentShouldBeRemovedWhenIdDoesNotExist(){
        //GIVEN
        StudentDB studentDb = new StudentDB(new Student[]{
                new Student("1", "Peter"),
                new Student("2", "Franziska"),
                new Student("3", "Maria")
        });

        //WHEN
        studentDb.remove("4");
        Student[] actual =  studentDb.getAllStudents();

        //THEN
        assertArrayEquals(new Student[]{
                new Student("1", "Peter"),
                new Student("2", "Franziska"),
                new Student("3", "Maria")

        }, actual);


    }

}