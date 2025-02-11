package dal;

import model.Cinema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO {
    public List<Cinema> getAllCinemas() {
        List<Cinema> cinemas = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection()) {
            String sql = "SELECT * FROM Cinema";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setCinemaID(rs.getInt("cinemaID"));
                cinema.setCinemaName(rs.getString("cinemaName"));
                cinemas.add(cinema);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cinemas;
    }
}