package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import Model.Showtime;

public class ShowtimeDAO extends DBContext {
    public List<Showtime> getShowtimesByMovieId(int movieID) {
        List<Showtime> showtimes = new ArrayList<>();
        String sql = "SELECT * FROM Showtime WHERE MovieID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, movieID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Showtime showtime = new Showtime();
                showtime.setShowtimeID(rs.getInt("ShowtimeID"));
                showtime.setMovieID(rs.getInt("MovieID"));
                showtime.setScreenID(rs.getInt("ScreenID"));
                showtime.setStartTime(rs.getTimestamp("StartTime"));
                showtime.setEndTime(rs.getTimestamp("EndTime"));
                showtimes.add(showtime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimes;
    }
    
    public Showtime getShowtimeById(int showtimeID) {
        Showtime showtime = null;
        String sql = "SELECT * FROM Showtime WHERE ShowtimeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, showtimeID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                showtime = new Showtime();
                showtime.setShowtimeID(rs.getInt("ShowtimeID"));
                showtime.setMovieID(rs.getInt("MovieID"));
                showtime.setScreenID(rs.getInt("ScreenID"));
                showtime.setStartTime(rs.getTimestamp("StartTime"));
                showtime.setEndTime(rs.getTimestamp("EndTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtime;
    }
}
