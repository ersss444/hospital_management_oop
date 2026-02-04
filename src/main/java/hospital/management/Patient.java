package hospital.management;

public class Patient extends Person {
    private String diagnosis;
    private String lastName;

    public Patient(int id, String name, String diagnosis, String lastName) {
        super(id, name);
        this.diagnosis = diagnosis;
        this.lastName = lastName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getRole() {
        return "Patient";
    }
}
