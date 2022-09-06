package repo;

import model.Student;

import java.util.Arrays;
import java.util.Objects;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students) {
        this.students = students;
    }

    public Student[] getAllStudents() {
        return this.students;
    }

    public Student getStudentById(String requestedId) {
        Student requestedStudent = new Student();

        for (Student student : students) {
            if (student.getId().equals(requestedId)) {
                requestedStudent = student;
            }
        }

        // Exception werfen, wenn der passende Student nicht gefunden wurde
        // Alternativ prüfen ob Student null ist und anderen Wert zurückgeben
        // Bester Umgang: Optional
        if(Objects.isNull(requestedStudent.getId())) {
            throw new IllegalArgumentException("Es konnte kein Student mit der ID " + requestedId + " gefunden werden");
        }

        return requestedStudent;
    }

    @Override
    public String toString() {
        String dbAsString = "";

        for (Student student : students) {
            dbAsString = dbAsString + " " + student.toString();
        }

        return dbAsString;
    }
}
