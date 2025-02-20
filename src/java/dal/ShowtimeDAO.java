package dal;

import model.Showtime;
import model.Cinema;
import model.Screen;
import model.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Admin;

public class ShowtimeDAO extends DBContext {

    
    public List<Showtime> getShowtimesByMovieId(int movieID) {
        List<Showtime> showtimes = new ArrayList<>();
        String sql = "SELECT s.*, sc.*, c.*, a.* FROM Showtime s " +
                     "JOIN Screen sc ON s.ScreenID = sc.ScreenID " +
                     "JOIN Cinema c ON sc.CinemaID = c.CinemaID " +
                     "JOIN Admin a ON s.AdminID = a.AdminID " +
                     "WHERE s.MovieID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, movieID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Showtime showtime = new Showtime();
                    showtime.setShowtimeID(rs.getInt("ShowtimeID"));
                    showtime.setStartTime(rs.getTimestamp("StartTime"));
                    showtime.setEndTime(rs.getTimestamp("EndTime"));

                    Screen screen = new Screen();
                    screen.setScreenID(rs.getInt("ScreenID"));
                    screen.setScreenName(rs.getString("ScreenName"));
                    screen.setTotalSeat(rs.getInt("TotalSeat"));

                    Cinema cinema = new Cinema();
                    cinema.setCinemaID(rs.getInt("CinemaID"));
                    cinema.setCinemaName(rs.getString("CinemaName"));
                    cinema.setLocation(rs.getString("Location"));
                    cinema.setNumberOfScreen(rs.getInt("NumberOfScreen"));

                    Admin admin = new Admin();
                    admin.setAdminID(rs.getInt("AdminID"));
                    admin.setName(rs.getString("Name"));
                    admin.setEmail(rs.getString("Email"));
                    admin.setPassword(rs.getString("Password"));

                    screen.setCinemaID(cinema);
                    showtime.setScreenID(screen);
                    showtime.setAdminID(admin);

                    showtimes.add(showtime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimes;
    }
    
    public List<Screen> getScreensByCinemaAndMovie(int cinemaId, int movieId) {
        List<Screen> screens = new ArrayList<>();
        String sql = "SELECT DISTINCT sc.ScreenID, sc.ScreenName, sc.TotalSeat " +
                     "FROM Screen sc " +
                     "JOIN Showtime s ON sc.ScreenID = s.ScreenID " +
                     "WHERE sc.CinemaID = ? AND s.MovieID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cinemaId);
            ps.setInt(2, movieId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Screen screen = new Screen();
                    screen.setScreenID(rs.getInt("ScreenID"));
                    screen.setScreenName(rs.getString("ScreenName"));
                    screen.setTotalSeat(rs.getInt("TotalSeat"));
                    screens.add(screen);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screens;
    }
    
    
    public List<Showtime> getShowtimesByCinemaScreenAndMovie(int cinemaId, int screenId, int movieId) {
        List<Showtime> showtimes = new ArrayList<>();
        String sql = "SELECT s.* FROM Showtime s " +
                     "JOIN Screen sc ON s.ScreenID = sc.ScreenID " +
                     "WHERE sc.CinemaID = ? AND sc.ScreenID = ? AND s.MovieID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cinemaId);
            ps.setInt(2, screenId);
            ps.setInt(3, movieId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Showtime showtime = new Showtime();
                    showtime.setShowtimeID(rs.getInt("ShowtimeID"));
                    showtime.setStartTime(rs.getTimestamp("StartTime"));
                    showtime.setEndTime(rs.getTimestamp("EndTime"));
                    showtimes.add(showtime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtimes;
    }
    
    

    public List<Cinema> getAllCinemas() {
        List<Cinema> cinemas = new ArrayList<>();
        String sql = "SELECT * FROM Cinema";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setCinemaID(rs.getInt("CinemaID"));
                cinema.setCinemaName(rs.getString("CinemaName"));
                cinema.setLocation(rs.getString("Location"));
                cinema.setNumberOfScreen(rs.getInt("NumberOfScreen"));
                cinemas.add(cinema);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinemas;
    }

    public List<Screen> getAllScreens() {
        List<Screen> screens = new ArrayList<>();
        String sql = "SELECT * FROM Screen";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Screen screen = new Screen();
                screen.setScreenID(rs.getInt("ScreenID"));
                screen.setScreenName(rs.getString("ScreenName"));
                screen.setTotalSeat(rs.getInt("TotalSeat"));
                screens.add(screen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screens;
    }

    public List<Seat> getAllSeats() {
        List<Seat> seats = new ArrayList<>();
        String sql = "SELECT s.SeatID, s.SeatNumber, s.ScreenID, sc.ScreenName, sc.CinemaID, c.CinemaName, c.Location " +
                     "FROM Seat s " +
                     "JOIN Screen sc ON s.ScreenID = sc.ScreenID " +
                     "JOIN Cinema c ON sc.CinemaID = c.CinemaID";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Seat seat = new Seat();
                seat.setSeatID(rs.getInt("SeatID"));
                seat.setSeatNumber(rs.getString("SeatNumber"));

                Screen screen = new Screen();
                screen.setScreenID(rs.getInt("ScreenID"));
                screen.setScreenName(rs.getString("ScreenName"));

                Cinema cinema = new Cinema();
                cinema.setCinemaID(rs.getInt("CinemaID"));
                cinema.setCinemaName(rs.getString("CinemaName"));
                cinema.setLocation(rs.getString("Location"));

                screen.setCinemaID(cinema);
                seat.setScreen(screen);

                seats.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seats;
    }
    
    
}