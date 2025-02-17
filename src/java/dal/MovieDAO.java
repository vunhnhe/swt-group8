package dal;

import model.Movie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieDAO extends DBContext {

    public Movie getMovieByID(int movieID) {
        Movie movie = null;
        try {
            String sql = "SELECT * FROM Movie WHERE movieID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                movie = new Movie(
                        rs.getInt("movieID"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getDate("releaseDate"),
                        rs.getString("description")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movie;
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Movie";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt("movieID"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getDate("releaseDate"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    public boolean addMovie(Movie movie) {
        try {
            String sql = "INSERT INTO Movie (title, genre, duration, releaseDate, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setDate(4, new Date(movie.getReleaseDate().getTime()));
            ps.setString(5, movie.getDescription());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateMovie(Movie movie) {
        try {
            String sql = "UPDATE Movie SET title = ?, genre = ?, duration = ?, releaseDate = ?, description = ? WHERE movieID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setDate(4, new Date(movie.getReleaseDate().getTime()));
            ps.setString(5, movie.getDescription());
            ps.setInt(6, movie.getMovieID());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteMovie(int movieID) {
        try {
            String sql = "DELETE FROM Movie WHERE movieID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
