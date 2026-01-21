package hospital.management;
import javax.print.Doc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Hospital h1 = new Hospital();

            Doctor d1 = new Doctor(3, "Dr. Ali", "Cardiologist");
            Doctor d2 = new Doctor(4, "Dr. Nur", "Surgeon");

            Patient p1 = new Patient(2, "Aruzhan", "Headches");

            DoctorDAO.InsertDoctor(d1);
            DoctorDAO.InsertDoctor(d2);

            PatientDAO.InsertPatient(p1);

            for(Doctor d : DoctorDAO.readDoctors()) {
                h1.addPerson(d);
            }

            for(Patient p : PatientDAO.readPatients()) {
                h1.addPerson(p);
            }

            System.out.println("=== All people in Hospital ===");
            h1.showAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
