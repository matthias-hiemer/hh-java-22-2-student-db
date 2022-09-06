import model.ComputerScienceStudent;
import model.Student;


public class Main {

    public static void main(String[] args) {
        ComputerScienceStudent csStudent = new ComputerScienceStudent("789", "James", "Java");

        csStudent.setId("456");
        csStudent.setName("Berta");
        csStudent.setFavoriteLanguage("C#");

        System.out.println(csStudent);


        Student student = new ComputerScienceStudent("123", "Sally", "Java");

        System.out.println(student);

    }
}
