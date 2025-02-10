package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Cinema;

public class CinemaDAO extends DBContext {
    public List<Cinema> getAllCinemas() {
        List<Cinema> cinemas = new ArrayList<>();
        String sql = "SELECT * FROM Cinema";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
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
    
    public Cinema getCinemaById(int cinemaID) {
        Cinema cinema = null;
        String sql = "SELECT * FROM Cinema WHERE CinemaID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cinemaID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cinema = new Cinema();
                cinema.setCinemaID(rs.getInt("CinemaID"));
                cinema.setCinemaName(rs.getString("CinemaName"));
                cinema.setLocation(rs.getString("Location"));
                cinema.setNumberOfScreen(rs.getInt("NumberOfScreen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinema;
    }
}
