package repo;

import model.ComputerScienceStudent;
import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {

    @Test
    void testGetAllStudents_whenAdded_returnStudents(){
        // GIVEN
        Student student1 = new ComputerScienceStudent("123", "Adam", "Java");
        Student student2 = new ComputerScienceStudent("456", "Eva", "Java");
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
        Student student1 = new ComputerScienceStudent("123", "Adam", "Java");
        Student student2 = new ComputerScienceStudent("456", "Eva", "Java");
        Student[] students = {student1, student2};

        StudentDB studentDB = new StudentDB(students);

        // WHEN
        String actual = studentDB.toString();

        // THEN
        String expected = " id: 123 name: Adam favorite lang: Java id: 456 name: Eva favorite lang: Java";
        assertEquals(expected, actual);
    }

    @Test
    void addShouldAddStudentToArray(){
        //GIVEN
        StudentDB studentDb = new StudentDB(new Student[]{
                new ComputerScienceStudent("1","Peter", "Java"),
                new ComputerScienceStudent("2", "Franziska", "Java"),
        });

        //WHEN
        studentDb.add(new ComputerScienceStudent("3", "Maria", "Java"));
        Student[] actual =  studentDb.getAllStudents();

        //THEN
        assertArrayEquals(new Student[]{
                new ComputerScienceStudent("1", "Peter", "Java"),
                new ComputerScienceStudent("2", "Franziska", "Java"),
                new ComputerScienceStudent("3", "Maria", "Java")
        }, actual);
    }

    @Test
    void removeShouldRemoveStudentFromArray(){
        //GIVEN
        StudentDB studentDb = new StudentDB(new Student[]{
                new ComputerScienceStudent("1", "Peter", "Java"),
                new ComputerScienceStudent("2", "Franziska", "Java"),
                new ComputerScienceStudent("3", "Maria", "Java")
        });

        //WHEN
        studentDb.remove("3");
        Student[] actual =  studentDb.getAllStudents();

        //THEN
        assertArrayEquals(new Student[]{
                new ComputerScienceStudent("1","Peter", "Java"),
                new ComputerScienceStudent("2","Franziska", "Java"),

        }, actual);


    }

    @Test
    void noStudentShouldBeRemovedWhenIdDoesNotExist(){
        //GIVEN
        StudentDB studentDb = new StudentDB(new Student[]{
                new ComputerScienceStudent("1", "Peter", "Java"),
                new ComputerScienceStudent("2", "Franziska", "Java"),
                new ComputerScienceStudent("3", "Maria", "Java")
        });

        //WHEN
        studentDb.remove("4");
        Student[] actual =  studentDb.getAllStudents();

        //THEN
        assertArrayEquals(new Student[]{
                new ComputerScienceStudent("1", "Peter", "Java"),
                new ComputerScienceStudent("2", "Franziska", "Java"),
                new ComputerScienceStudent("3", "Maria", "Java")

        }, actual);


    }

}