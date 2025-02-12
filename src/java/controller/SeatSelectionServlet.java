package controller;

import dal.SeatDAO;
import model.Seat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SeatSelectionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve selected values from the request
        String movieTitle = request.getParameter("selectedMovieTitle");
        String cinemaName = request.getParameter("selectedCinemaName");
        String screenName = request.getParameter("selectedScreenName");
        String startTime = request.getParameter("selectedStartTime");
        String endTime = request.getParameter("selectedEndTime");

        // Set attributes to pass to the JSP
        request.setAttribute("movieTitle", movieTitle);
        request.setAttribute("cinemaName", cinemaName);
        request.setAttribute("screenName", screenName);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);

        // Retrieve seats for the selected screen (assuming screenID is passed)
        int screenID = Integer.parseInt(request.getParameter("screenID"));
        SeatDAO seatDAO = new SeatDAO();
        List<Seat> seats = seatDAO.getSeatsByScreenID(screenID);
        request.setAttribute("seats", seats);

        // Forward to seat selection JSP
        request.getRequestDispatcher("seatSelection.jsp").forward(request, response);
    }
}