package dal;

import model.Screen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScreenDAO {
    public List<Screen> getScreensByCinemaID(int cinemaID) {
        List<Screen> screens = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection()) {
            String sql = "SELECT * FROM Screen WHERE cinemaID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cinemaID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Screen screen = new Screen();
                screen.setScreenID(rs.getInt("screenID"));
                screen.setScreenName(rs.getString("screenName"));
                screens.add(screen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screens;
    }
    
    public int getTotalSeatsByScreenID(int screenID) {
        int totalSeats = 0;
        try (Connection conn = new DBContext().getConnection()) {
            String sql = "SELECT totalSeat FROM Screen WHERE screenID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, screenID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalSeats = rs.getInt("totalSeat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalSeats;
    }
}