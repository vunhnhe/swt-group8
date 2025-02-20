package dal;

import model.Seat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO extends DBContext {

    public List<Seat> getAvailableSeats(int cinemaId, int screenId, int showtimeId) {
        List<Seat> availableSeats = new ArrayList<>();
        String sql = "SELECT s.* FROM Seat s " +
                     "WHERE s.ScreenID = ? AND s.SeatID NOT IN " +
                     "(SELECT r.SeatID FROM Reservation r WHERE r.ShowtimeID = ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, screenId);
            ps.setInt(2, showtimeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Seat seat = new Seat();
                    seat.setSeatID(rs.getInt("SeatID"));
                    seat.setSeatNumber(rs.getString("SeatNumber"));
                    seat.setSeatType(rs.getString("SeatType"));
                    seat.setPrice(rs.getDouble("Price"));
                    availableSeats.add(seat);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availableSeats;
    }
}