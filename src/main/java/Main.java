import model.Student;
import repo.StudentDB;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("123", "Adam");
        Student student2 = new Student("456", "Eva");
        Student[] students = {student1, student2};

        StudentDB studentDB = new StudentDB(students);

        System.out.println(studentDB);

    }
}
