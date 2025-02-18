package dal;

import model.Movie;
import model.Showtime;
import model.Screen;
import model.Cinema;
import model.Admin;
import model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DBContext {

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM Movie";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieID(rs.getInt("MovieID"));
                movie.setTitle(rs.getString("Title"));
                movie.setGenre(rs.getString("Genre"));
                movie.setDuration(rs.getInt("Duration"));
                movie.setReleaseDate(rs.getDate("ReleaseDate"));
                movie.setDescription(rs.getString("Description"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public Movie getMovieById(int movieID) {
        Movie movie = null;
        String sql = "SELECT * FROM Movie WHERE MovieID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, movieID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    movie = new Movie();
                    movie.setMovieID(rs.getInt("MovieID"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setGenre(rs.getString("Genre"));
                    movie.setDuration(rs.getInt("Duration"));
                    movie.setReleaseDate(rs.getDate("ReleaseDate"));
                    movie.setDescription(rs.getString("Description"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

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

    public List<Review> getReviewsByMovieId(int movieID) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM Review WHERE MovieID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, movieID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Review review = new Review();
                    review.setReviewID(rs.getInt("ReviewID"));
                    review.setCustomerID(rs.getInt("CustomerID"));
                    review.setMovieID(rs.getInt("MovieID"));
                    review.setRating(rs.getInt("Rating"));
                    review.setComment(rs.getString("Comment"));
                    review.setReviewDate(rs.getDate("ReviewDate"));
                    reviews.add(review);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }
}