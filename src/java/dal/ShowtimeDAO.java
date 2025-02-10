package dal;

import Model.Showtime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeDAO {
    public List<Showtime> getShowtimesByMovie(int movieID) throws SQLException {
        List<Showtime> showtimes = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM Showtime WHERE MovieID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, movieID);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Showtime showtime = new Showtime();
            showtime.setShowtimeID(resultSet.getInt("ShowtimeID"));
            showtime.setMovieID(resultSet.getInt("MovieID"));
            showtime.setScreenID(resultSet.getInt("ScreenID"));
            showtime.setStartTime(resultSet.getTimestamp("StartTime"));
            showtime.setEndTime(resultSet.getTimestamp("EndTime"));
            showtimes.add(showtime);
        }

        conn.close();
        return showtimes;
    }
}
