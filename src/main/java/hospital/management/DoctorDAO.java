package hospital.management;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public static void InsertDoctor(Doctor d) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO doctor VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, d.getId());
        ps.setString(2, d.getName());
        ps.setString(3, d.getSpecialization());
        ps.executeUpdate();
        conn.close();
    }

    public static List<Doctor> readDoctors() throws Exception {
        List<Doctor> doctors = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM doctor");

        while(rs.next()) {
            doctors.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        conn.close();

        return doctors;
    }
}
