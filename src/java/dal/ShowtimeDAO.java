package dal;

import Model.Showtime;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public void saveShowtime(Showtime showtime) {
        String sql = "INSERT INTO Showtime (MovieID, ScreenID, StartTime, EndTime) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, showtime.getMovieID());
            stmt.setInt(2, showtime.getScreenID());
            stmt.setTimestamp(3, showtime.getStartTime());
            stmt.setTimestamp(4, showtime.getEndTime());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
