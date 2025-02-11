package dal;

import Model.Screen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScreenDAO extends DBContext {
    public List<Screen> getScreensByCinemaId(int cinemaID) {
        List<Screen> screens = new ArrayList<>();
        String sql = "SELECT * FROM Screen WHERE CinemaID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cinemaID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Screen screen = new Screen();
                screen.setScreenID(rs.getInt("ScreenID"));
                screen.setCinemaID(rs.getInt("CinemaID"));
                screen.setScreenName(rs.getString("ScreenName"));
                screen.setTotalSeat(rs.getInt("TotalSeat"));
                screens.add(screen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screens;
    }

    public Screen getScreenById(int screenID) {
        Screen screen = null;
        String sql = "SELECT * FROM Screen WHERE ScreenID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, screenID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                screen = new Screen();
                screen.setScreenID(rs.getInt("ScreenID"));
                screen.setCinemaID(rs.getInt("CinemaID"));
                screen.setScreenName(rs.getString("ScreenName"));
                screen.setTotalSeat(rs.getInt("TotalSeat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screen;
    }
}
