package controller;

import dal.ShowtimeDAO;
import model.Showtime;
import java.io.IOException;
import dal.MovieDAO;
import model.Movie;
import dal.ScreenDAO;
import model.Screen;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ManageShowtimeController", urlPatterns = {"/Showtime"})
public class ManageShowtimeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShowtimeDAO showtimeDAO = new ShowtimeDAO();
        List<Showtime> showtimes = showtimeDAO.getAllShowtimesByScreen(); // Example screenID, should be dynamic
        MovieDAO movieDAO = new MovieDAO();
        List<Movie> movies = movieDAO.getAllMovies();

        ScreenDAO screenDAO = new ScreenDAO();
        List<Screen> screens = screenDAO.getAllScreens();

        // Create a map for movie titles based on movieID
        Map<Integer, String> movieMap = new HashMap<>();
        for (Movie movie : movies) {
            movieMap.put(movie.getMovieID(), movie.getTitle());
        }
        Map<Integer, String> screenMap = new HashMap<>();
        for (Screen screen : screens) {
            screenMap.put(screen.getScreenID(), screen.getScreenName());
        }
        request.setAttribute("showtimes", showtimes);
        request.setAttribute("movieMap", movieMap);
        request.setAttribute("screenMap", screenMap);
        request.setAttribute("movies", movies);
        request.setAttribute("screens", screens);

        request.getRequestDispatcher("showtime.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShowtimeDAO showtimeDAO = new ShowtimeDAO();

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            int movieID = Integer.parseInt(request.getParameter("movieID"));
            int screenID = Integer.parseInt(request.getParameter("screenID"));
//            java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(request.getParameter("startTime"));
//            java.sql.Timestamp endTime = java.sql.Timestamp.valueOf(request.getParameter("endTime"));
            String startTimeStr = request.getParameter("startTime").replace("T", " ") + ":00";
            String endTimeStr = request.getParameter("endTime").replace("T", " ") + ":00";

            Timestamp startTime = Timestamp.valueOf(startTimeStr);
            Timestamp endTime = Timestamp.valueOf(endTimeStr);
            int adminID = Integer.parseInt(request.getParameter("adminID"));

            Showtime showtime = new Showtime(0, movieID, screenID, startTime, endTime, adminID);
            showtimeDAO.addShowtime(showtime);
        } else if ("delete".equals(action)) {
            int showtimeID = Integer.parseInt(request.getParameter("showtimeID"));
            showtimeDAO.deleteShowtime(showtimeID);
        }

        response.sendRedirect(request.getContextPath() + "/Showtime");
    }

    @Override
    public String getServletInfo() {
        return "Manage Showtime Controller";
    }
}
