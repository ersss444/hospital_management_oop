package hospital.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public static void InsertPatient(Patient p) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO patient VALUES(?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setString(2, p.getName());
        ps.setString(3, p.getDiagnosis());
        ps.executeUpdate();
        conn.close();
    }

    public static List<Patient> readPatients() throws Exception {
        List<Patient> patients = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patient");

        while(rs.next()) {
            patients.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        conn.close();

        return patients;
    }
}
