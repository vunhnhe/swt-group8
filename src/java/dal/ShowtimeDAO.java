package dal;

import model.Showtime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeDAO {
    public List<Showtime> getShowtimesByScreenID(int screenID) {
        List<Showtime> showtimes = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection()) {
            String sql = "SELECT * FROM Showtime WHERE screenID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, screenID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Showtime showtime = new Showtime();
                showtime.setShowtimeID(rs.getInt("showtimeID"));
                showtime.setStartTime(rs.getTimestamp("startTime"));
                showtime.setEndTime(rs.getTimestamp("endTime"));
                showtimes.add(showtime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimes;
    }
}