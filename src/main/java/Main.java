import model.Student;
import repo.StudentDB;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");

        Map<String, Student> students = new HashMap<>(2);
        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);

        StudentDB studentDB = new StudentDB(students);

        System.out.println(studentDB);

    }
}
