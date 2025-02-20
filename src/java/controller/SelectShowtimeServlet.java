package controller;

import dal.ShowtimeDAO;
import dal.MovieDAO; // Assuming you have a MovieDAO to get movie details
import model.Showtime;
import model.Cinema;
import model.Screen;
import model.Seat;
import model.Movie; // Assuming you have a Movie model

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectShowtimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieIdParam = request.getParameter("movieId");
        if (movieIdParam != null) {
            int movieId = Integer.parseInt(movieIdParam);
            ShowtimeDAO showtimeDAO = new ShowtimeDAO();
            MovieDAO movieDAO = new MovieDAO(); // Assuming you have a MovieDAO to get movie details
            List<Showtime> showtimes = showtimeDAO.getShowtimesByMovieId(movieId);
            List<Cinema> cinemas = showtimeDAO.getAllCinemas();
            List<Screen> screens = showtimeDAO.getAllScreens();
            
            Movie movie = movieDAO.getMovieById(movieId); // Assuming you have a method to get movie details by ID
            request.setAttribute("showtimes", showtimes);
            request.setAttribute("cinemas", cinemas);
            request.setAttribute("screens", screens);

            request.setAttribute("movieTitle", movie.getTitle()); // Pass the movie title to the JSP
        }
        request.getRequestDispatcher("/selectShowtime.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cinemaIdParam = request.getParameter("cinemaId");
        String screenIdParam = request.getParameter("screenId");
        String movieIdParam = request.getParameter("movieId");
        if (cinemaIdParam != null && screenIdParam != null && movieIdParam != null) {
            int cinemaId = Integer.parseInt(cinemaIdParam);
            int screenId = Integer.parseInt(screenIdParam);
            int movieId = Integer.parseInt(movieIdParam);
            ShowtimeDAO showtimeDAO = new ShowtimeDAO();
            List<Showtime> showtimes = showtimeDAO.getShowtimesByCinemaScreenAndMovie(cinemaId, screenId, movieId);

            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < showtimes.size(); i++) {
                Showtime showtime = showtimes.get(i);
                json.append("{")
                    .append("\"showtimeID\":").append(showtime.getShowtimeID()).append(",")
                    .append("\"startTime\":\"").append(showtime.getStartTime()).append("\",")
                    .append("\"endTime\":\"").append(showtime.getEndTime()).append("\"")
                    .append("}");
                if (i < showtimes.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json.toString());
        } else if (cinemaIdParam != null && movieIdParam != null) {
            int cinemaId = Integer.parseInt(cinemaIdParam);
            int movieId = Integer.parseInt(movieIdParam);
            ShowtimeDAO showtimeDAO = new ShowtimeDAO();
            List<Screen> screens = showtimeDAO.getScreensByCinemaAndMovie(cinemaId, movieId);

            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < screens.size(); i++) {
                Screen screen = screens.get(i);
                json.append("{")
                    .append("\"screenID\":").append(screen.getScreenID()).append(",")
                    .append("\"screenName\":\"").append(screen.getScreenName()).append("\"")
                    .append("}");
                if (i < screens.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json.toString());
        }
    }
}