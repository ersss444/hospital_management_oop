package hospital.management;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
                System.out.println("1. Add new doctor");
                System.out.println("2. Add new patient");
                System.out.println("3. Show all people");
                System.out.println("4. Show doctors sorted by name");
                System.out.println("5. Show patients sorted by name");
                System.out.println("6. Find person by ID");
                System.out.println("7. Delete person by ID");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Specialization: ");
                        String spec = sc.nextLine();

                        Doctor d = new Doctor(id, name, spec);
                        hospital.addDoctor(d);
                    }
                    case 2 -> {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = sc.nextLine();

                        Patient p = new Patient(id, name, diag);
                        hospital.addPatient(p);
                    }
                    case 3 -> {
                        List<Person> people = hospital.getAllPeopleFromDB();
                        for (Person p : people) System.out.println(p);
                    }
                    case 4 -> {
                        List<Doctor> doctors = hospital.getDoctorsSortedByName();
                        for (Doctor d : doctors) System.out.println(d);
                    }
                    case 5 -> {
                        List<Patient> patients = hospital.getPatientsSortedByName();
                        for (Patient p : patients) System.out.println(p);
                    }
                    case 6 -> {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        Person found = hospital.findById(id);
                        System.out.println(found != null ? "Found: " + found : "Person not found.");
                    }
                    case 7 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        hospital.deletePersonById(id);
                    }
                    case 0 -> {
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Wrong choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
