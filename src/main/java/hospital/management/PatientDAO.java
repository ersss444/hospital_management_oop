package hospital.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public static void insertPatient(Patient p) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO patient VALUES(?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setString(2, p.getName());
        ps.setString(3, p.getDiagnosis());
        ps.setString(4, p.getLastName());
        ps.executeUpdate();
        conn.close();
    }

    public static List<Patient> readPatients() throws Exception {
        List<Patient> patients = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patient");

        while(rs.next()) {
            patients.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        conn.close();

        return patients;
    }

    public static List<Patient> readPatientsSortedByName() throws Exception {
        List<Patient> patients = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patient ORDER BY name");

        while(rs.next()) {
            patients.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        conn.close();

        return patients;
    }

    public static Patient findPatientById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "SELECT * FROM patient WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Patient p = null;
        while(rs.next()) {
            p = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }

        conn.close();

        return p;
    }

    public static void deletePatientById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "DELETE FROM patient WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {
            System.out.println("Deleted successfully");
        }
        else{
            System.out.println("Not found");
        }

        ps.close();
        conn.close();
    }
}
