package repo;

import model.Student;

import java.util.Arrays;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students){
        this.students = students;
    }

    public Student[] getAllStudents(){
        return this.students;
    }

    public Student getRandomStudent() {
        double random = Math.random();
        int randomIndex = (int) (random * students.length);
        return students[randomIndex];
    }

    public void add(Student student) {
        Student[] updatedStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            updatedStudents[i] = students[i];
        }

        updatedStudents[students.length] = student;

        this.students = updatedStudents;
    }

    public void remove(String id) {
        if (!containsId(id)) {
            return;
        }

        Student[] updatedStudents = new Student[students.length - 1];
        boolean idFound = false;
        for (int i = 0; i < students.length - 1; i++) {
            Student student = students[i];
            if (student.getId().equals(id)) {
                idFound = true;
            }
            int newIndex;
            if (idFound) {
                newIndex = i + 1;
            } else {
                newIndex = i;
            }
            updatedStudents[i] = students[newIndex];

        }
        students = updatedStudents;
    }

    private boolean containsId(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String dbAsString = "";

        for (Student student: students) {
            dbAsString = dbAsString + " " + student.toString();
        }

        return dbAsString;
    }
}
