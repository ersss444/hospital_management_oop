package hospital.management;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        hospital.addPerson(new Doctor(1, "Dr. Ali", "Cardiologist"));
        hospital.addPerson(new Patient(2, "Aruzhan", "Flu"));
        hospital.addPerson(new Doctor(3, "Dr. Nur", "Surgeon"));

        System.out.println("=== All People ===");
        hospital.showAll();

        System.out.println("\n=== Doctors Only ===");
        hospital.showDoctors();

        System.out.print("\nEnter ID to search: ");
        int id = sc.nextInt();
        Person p = hospital.findById(id);

        if (p != null) {
            System.out.println("Found: " + p);
        } else {
            System.out.println("Person not found");
        }

        System.out.println("\n=== Sorted by Name ===");
        hospital.sortByName();
        hospital.showAll();

        sc.close();
    }
}
