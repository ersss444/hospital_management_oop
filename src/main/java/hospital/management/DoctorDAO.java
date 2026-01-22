package hospital.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public static void insertDoctor(Doctor d) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO doctor VALUES(?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, d.getId());
        ps.setString(2, d.getName());
        ps.setString(3, d.getSpecialization());
        ps.executeUpdate();
        conn.close();;
    }

    public static List<Doctor> readDoctor() throws Exception {
        List<Doctor>  doctors = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM doctor");

        while(rs.next()) {
            doctors.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        conn.close();;

        return doctors;

    }

    public static List<Doctor> readDoctorSortedByName() throws Exception {
        List<Doctor> doctors = new ArrayList<>();
        Connection conn = DBConnection.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM doctor ORDER BY name");

        while(rs.next()) {
            doctors.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        conn.close();

        return doctors;
    }

    public static Doctor findDoctorById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "SELECT * FROM doctor WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Doctor d = null;
        while(rs.next()) {
            d = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3));
        }

        conn.close();

        return d;
    }

    public static void deleteDoctorById(int id) throws Exception {
        Connection conn = DBConnection.connect();
        String sql = "DELETE FROM doctor WHERE id = ?";
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
