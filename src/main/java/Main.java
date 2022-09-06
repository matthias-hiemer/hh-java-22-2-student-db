import model.ComputerScienceStudent;


public class Main {

    public static void main(String[] args) {
        ComputerScienceStudent csStudent = new ComputerScienceStudent("789", "James", "Java");

        csStudent.setId("456");
        csStudent.setName("Berta");
        csStudent.setFavoriteLanguage("C#");

        System.out.println(csStudent);

    }
}
