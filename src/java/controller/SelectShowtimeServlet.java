package controller;

import dal.CinemaDAO;
import dal.MovieDAO;
import dal.ScreenDAO;
import dal.ShowtimeDAO;
import model.Cinema;
import model.Movie;
import model.Screen;
import model.Showtime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectShowtimeServlet", urlPatterns = {"/SelectShowtimeServlet"})
public class SelectShowtimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieIDParam = request.getParameter("movieID");
        if (movieIDParam != null) {
            int movieID = Integer.parseInt(movieIDParam);
            MovieDAO movieDAO = new MovieDAO();
            Movie movie = movieDAO.getMovieByID(movieID);
            request.setAttribute("movie", movie);
        }

        CinemaDAO cinemaDAO = new CinemaDAO();
        List<Cinema> cinemas = cinemaDAO.getAllCinemas();
        request.setAttribute("cinemas", cinemas);

        request.getRequestDispatcher("selectShowtime.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("loadScreens".equals(action)) {
            int cinemaID = Integer.parseInt(request.getParameter("cinemaID"));
            ScreenDAO screenDAO = new ScreenDAO();
            List<Screen> screens = screenDAO.getScreensByCinemaID(cinemaID);
            request.setAttribute("screens", screens);
            request.getRequestDispatcher("screens.jsp").forward(request, response);
        } else if ("loadShowtimes".equals(action)) {
            int screenID = Integer.parseInt(request.getParameter("screenID"));
            ShowtimeDAO showtimeDAO = new ShowtimeDAO();
            List<Showtime> showtimes = showtimeDAO.getShowtimesByScreenID(screenID);
            request.setAttribute("showtimes", showtimes);
            request.getRequestDispatcher("showtimes.jsp").forward(request, response);
        }
    }
}