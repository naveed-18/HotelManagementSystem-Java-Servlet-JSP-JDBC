import java.sql.*;
import java.util.ArrayList;
import model.Reservation;

public class HotelManagementSystemDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL = "...";
    private static final String USER = "...";
    private static final String PASS = "...";

    // 1. Reserve room
    public boolean reserveRoom(String guestName, int roomNumber, String phoneNumber) {

        String sql =  "INSERT INTO reservations (guest_name, room_number, phone_number) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, guestName);
            pst.setInt(2, roomNumber);
            pst.setString(3, phoneNumber);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. View reservations
    public ArrayList<Reservation> viewReservations() {

        ArrayList<Reservation> list = new ArrayList<>();

        String sql = "SELECT * FROM reservations";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getString("guest_name"),
                        rs.getInt("room_number"),
                        rs.getString("phone_number"),
                        rs.getTimestamp("reservation_date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 3. Get room number
    public Integer getRoomNumber(int id, String name) {

        String sql =
                "SELECT room_number FROM reservations WHERE reservation_id = ? AND guest_name = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.setString(2, name);

            ResultSet rs = pst.executeQuery();
            return rs.next() ? rs.getInt("room_number") : null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 4. Update reservation
    public boolean updateReservation(int id, String name, int room, String phone) {

        String sql =
                "UPDATE reservations SET guest_name=?, room_number=?, phone_number=? WHERE reservation_id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setInt(2, room);
            pst.setString(3, phone);
            pst.setInt(4, id);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 5. Delete reservation
    public boolean deleteReservation(int id) {

        String sql = "DELETE FROM reservations WHERE reservation_id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
