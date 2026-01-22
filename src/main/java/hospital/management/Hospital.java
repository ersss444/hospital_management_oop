package hospital.management;

import java.util.*;

public class Hospital {
    public List<Person> getAllPeopleFromDB() throws Exception {
        List<Person> list = new ArrayList<>();
        list.addAll(DoctorDAO.readDoctor());
        list.addAll(PatientDAO.readPatients());
        return list;
    }

    public Person findById(int id) throws Exception {
        Doctor d = DoctorDAO.findDoctorById(id);
        Patient p = PatientDAO.findPatientById(id);

        if(d != null) {
            return d;
        }

        if(p != null) {
            return p;
        }

        return null;
    }

    public void deletePersonById(int id) throws Exception {
        Doctor d = DoctorDAO.findDoctorById(id);
        if(d != null) {
            DoctorDAO.deleteDoctorById(id);
            return;
        }

        Patient p = PatientDAO.findPatientById(id);
        if(p != null) {
            PatientDAO.deleteDoctorById(id);
            return;
        }

        System.out.println("Not found");
    }


    public List<Doctor> getDoctors() throws Exception {
        return DoctorDAO.readDoctor();
    }

    public List<Doctor>  getDoctorsSortedByName() throws Exception {
        return DoctorDAO.readDoctorSortedByName();
    }

    public  List<Patient> getPatients() throws Exception {
        return PatientDAO.readPatients();
    }

    public List<Patient> getPatientsSortedByName() throws Exception {
        return PatientDAO.readPatientsSortedByName();
    }

    public void addDoctor(Doctor d) throws Exception {
        DoctorDAO.insertDoctor(d);
    }

    public void addPatient(Patient p) throws Exception {
        PatientDAO.insertPatient(p);
    }

}
