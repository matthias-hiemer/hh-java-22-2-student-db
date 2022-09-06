package model;

public class BiologyStudent extends Student implements Citizen {


    public BiologyStudent(String id, String name, String address, String identityCardNumber) {
        super(id, name, address, identityCardNumber);
    }

    @Override
    public String getCourse() {
        return "Biology 101";
    }

}
