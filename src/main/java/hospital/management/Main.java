package hospital.management;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Hospital", "Almaty");

        Patient p1 = new Patient(1, "Ali", 20, "Flu");
        Patient p2 = new Patient(2, "Aruzhan", 22, "Cold");
        Patient p3 = new Patient(3, "Dana", 25, "Allergy");

        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        Doctor d1 = new Doctor("Dr. Smith", "Therapist");
        Doctor d2 = new Doctor("Dr. Khan", "Allergist");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        d1.assignPateint(p1);
        d1.assignPateint(p2);
        d2.assignPateint(p3);

        hospital.showAllPatients();
        hospital.showAllDoctors();

        if (p1.getAge() > p2.getAge()) {
            System.out.println(p1.getName() + " is older than " + p2.getName());
        } else if (p1.getAge() < p2.getAge()) {
            System.out.println(p2.getName() + " is older than " + p1.getName());
        } else {
            System.out.println(p1.getName() + " and " + p2.getName() + " are the same age");
        }
    }
}
