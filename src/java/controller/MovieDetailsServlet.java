package controller;

import dal.MovieDAO;
import model.Movie;
import model.Showtime;
import model.Review;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/movieDetails")
public class MovieDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieIdStr = request.getParameter("movieId");
        if (movieIdStr != null) {
            int movieId = Integer.parseInt(movieIdStr);
            MovieDAO movieDAO = new MovieDAO();
            Movie movie = movieDAO.getMovieById(movieId);
            List<Showtime> showtimes = movieDAO.getShowtimesByMovieId(movieId);
            List<Review> reviews = movieDAO.getReviewsByMovieId(movieId);

            // Tính trung bình cộng các đánh giá
            double averageRating = 0;
            if (!reviews.isEmpty()) {
                int totalRating = 0;
                for (Review review : reviews) {
                    totalRating += review.getRating();
                }
                averageRating = (double) totalRating / reviews.size();
            }

            request.setAttribute("movie", movie);
            request.setAttribute("showtimes", showtimes);
            request.setAttribute("reviews", reviews);
            request.setAttribute("averageRating", String.format("%.1f", averageRating));
            request.getRequestDispatcher("movieDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}