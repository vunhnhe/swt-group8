package dal;

import model.Showtime;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowtimeDAO extends DBContext {

    public List<Showtime> getAllShowtimesByScreen() {
        List<Showtime> showtimes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Showtime";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Showtime showtime = new Showtime(
                        rs.getInt("showtimeID"),
                        rs.getInt("movieID"),
                        rs.getInt("screenID"),
                        rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"),
                        rs.getInt("adminID")
                );
                showtimes.add(showtime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return showtimes;
    }

    public List<Showtime> getShowtimesByScreenID(int screenID) {
        List<Showtime> showtimes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Showtime WHERE screenID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, screenID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Showtime showtime = new Showtime(
                        rs.getInt("showtimeID"),
                        rs.getInt("movieID"),
                        rs.getInt("screenID"),
                        rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"),
                        rs.getInt("adminID")
                );
                showtimes.add(showtime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return showtimes;
    }

    public Showtime getShowtimeByID(int showtimeID) {
        try {
            String sql = "SELECT * FROM Showtime WHERE showtimeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, showtimeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Showtime(
                        rs.getInt("showtimeID"),
                        rs.getInt("movieID"),
                        rs.getInt("screenID"),
                        rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"),
                        rs.getInt("adminID")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addShowtime(Showtime showtime) {
        try {
            String sql = "INSERT INTO Showtime (movieID, screenID, startTime, endTime, adminID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, showtime.getMovieID());
            ps.setInt(2, showtime.getScreenID());
            ps.setTimestamp(3, new Timestamp(showtime.getStartTime().getTime()));
            ps.setTimestamp(4, new Timestamp(showtime.getEndTime().getTime()));
            ps.setInt(5, showtime.getAdminID());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShowtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateShowtime(Showtime showtime) {
        try {
            String sql = "UPDATE Showtime SET movieID = ?, screenID = ?, startTime = ?, endTime = ?, adminID = ? WHERE showtimeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, showtime.getMovieID());
            ps.setInt(2, showtime.getScreenID());
            ps.setTimestamp(3, new Timestamp(showtime.getStartTime().getTime()));
            ps.setTimestamp(4, new Timestamp(showtime.getEndTime().getTime()));
            ps.setInt(5, showtime.getAdminID());
            ps.setInt(6, showtime.getShowtimeID());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShowtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteShowtime(int showtimeID) {
        try {
            String sql = "DELETE FROM Showtime WHERE showtimeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, showtimeID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ShowtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
