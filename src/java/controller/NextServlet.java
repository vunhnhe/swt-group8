package controller;

import dal.ShowtimeDAO;
import Model.Showtime;
import java.io.IOException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int movieID = Integer.parseInt(request.getParameter("movie"));
        int cinemaID = Integer.parseInt(request.getParameter("cinema"));
        int screenID = Integer.parseInt(request.getParameter("screen"));
        Timestamp startTime = Timestamp.valueOf(request.getParameter("startTime").replace("T", " ") + ":00");
        Timestamp endTime = Timestamp.valueOf(request.getParameter("endTime").replace("T", " ") + ":00");

        Showtime showtime = new Showtime();
        showtime.setMovieID(movieID);
        showtime.setScreenID(screenID);
        showtime.setStartTime(startTime);
        showtime.setEndTime(endTime);

        ShowtimeDAO showtimeDAO = new ShowtimeDAO();
        showtimeDAO.saveShowtime(showtime);

        response.sendRedirect("showtimeList.jsp");
    }
}
