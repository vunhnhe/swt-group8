package dal;

import model.Screen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScreenDAO extends DBContext {

    public List<Screen> getAllScreens() {
        List<Screen> screens = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Screen";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                screens.add(new Screen(
                        rs.getInt("screenID"),
                        rs.getInt("cinemaID"),
                        rs.getString("screenName"),
                        rs.getInt("totalSeat")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScreenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return screens;
    }
}
