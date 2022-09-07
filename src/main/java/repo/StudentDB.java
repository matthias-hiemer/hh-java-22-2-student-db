package repo;

import model.Student;

import java.util.Map;
import java.util.Objects;

public class StudentDB {

    private Map<String, Student> students;

    public StudentDB(Map<String, Student> students) {
        this.students = students;
    }

    public Map<String, Student> getAllStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDB studentDB = (StudentDB) o;
        return Objects.equals(students, studentDB.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
    }

    @Override
    public String toString() {
        return "StudentDB{" +
                "students=" + students +
                '}';
    }
}
