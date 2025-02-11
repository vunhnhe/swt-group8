package dal;

import model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public Movie getMovieByID(int movieID) {
        Movie movie = null;
        try (Connection conn = new DBContext().getConnection()) {
            String sql = "SELECT * FROM Movie WHERE movieID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setMovieID(rs.getInt("movieID"));
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setDuration(rs.getInt("duration"));
                movie.setReleaseDate(rs.getDate("releaseDate"));
                movie.setDescription(rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }
}