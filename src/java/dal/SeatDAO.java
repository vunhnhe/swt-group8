package dal;

import model.Seat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {
    public List<Seat> getSeatsByScreenID(int screenID) {
        List<Seat> seats = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection()) {
            String sql = "SELECT * FROM Seat WHERE screenID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, screenID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat();
                seat.setSeatID(rs.getInt("seatID"));
                seat.setSeatNumber(rs.getString("seatNumber"));
                seat.setSeatType(rs.getString("seatType"));
                seats.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seats;
    }
}