package hospital.management;

public class Patient extends Person {
    private String diagnosis;

    public Patient(int id, String name, String diagnosis) {
        super(id, name);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String getRole() {
        return "Patient";
    }
}
