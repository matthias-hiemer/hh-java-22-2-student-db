import model.BiologyStudent;
import model.Citizen;
import model.ComputerScienceStudent;
import model.Student;


public class Main {

    public static void main(String[] args) {
        ComputerScienceStudent csStudent = new ComputerScienceStudent("789", "James", "Java","Weg 1", "ABC100");
        System.out.println(csStudent);

        Student student = new ComputerScienceStudent("123", "Sally", "Java","Weg 1", "ABC100");
        System.out.println(student);

        Student bioStudent = new BiologyStudent("123", "Sally", "Weg 1", "ABC100");
        System.out.println(bioStudent);

        Citizen citizen = new BiologyStudent("4711", "Herbert", "Weg 1", "ABC100");
        System.out.println(citizen);
    }

}
