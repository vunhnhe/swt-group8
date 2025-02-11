package controller;

import dal.CinemaDAO;
import dal.ShowtimeDAO;
import dal.ScreenDAO;
import dal.MovieDAO;
import Model.Cinema;
import Model.Movie;
import Model.Showtime;
import Model.Screen;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowtimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all movies, cinemas, and screens
        MovieDAO movieDAO = new MovieDAO();
        CinemaDAO cinemaDAO = new CinemaDAO();
        ScreenDAO screenDAO = new ScreenDAO();

        List<Movie> movies = movieDAO.getAllMovies();
        List<Cinema> cinemas = cinemaDAO.getAllCinemas();

        // Default to first cinema's screens if cinemaID is not specified
        int defaultCinemaID = cinemas.get(0).getCinemaID();
        List<Screen> screens = screenDAO.getScreensByCinemaId(defaultCinemaID);

        request.setAttribute("movies", movies);
        request.setAttribute("cinemas", cinemas);
        request.setAttribute("screens", screens);
        request.setAttribute("defaultCinemaID", defaultCinemaID);
        request.getRequestDispatcher("chooseShowtime.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from request
        int movieID = Integer.parseInt(request.getParameter("movie"));
        int cinemaID = Integer.parseInt(request.getParameter("cinema"));
        int screenID = Integer.parseInt(request.getParameter("screen"));
        String startTimeParam = request.getParameter("startTime");
        String endTimeParam = request.getParameter("endTime");

        java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(startTimeParam.replace("T", " ") + ":00");
        java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(endTimeParam.replace("T", " ") + ":00");

        // Save showtime to the database
        ShowtimeDAO showtimeDAO = new ShowtimeDAO();
        Showtime showtime = new Showtime();
        showtime.setMovieID(movieID);
        showtime.setScreenID(screenID);
        showtime.setStartTime(startTime);
        showtime.setEndTime(endTime);

        // Implement saveShowtime method in ShowtimeDAO
        showtimeDAO.saveShowtime(showtime);

        response.sendRedirect("showtimeList.jsp");
    }
}
