package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessBookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve selected values from the request
        String movieTitle = request.getParameter("movieTitle");
        String cinemaName = request.getParameter("cinemaName");
        String screenName = request.getParameter("screenName");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String seatName = request.getParameter("seatName");

        // Here you would typically save the booking information to the database

        // Set attributes to pass to the JSP
        request.setAttribute("movieTitle", movieTitle);
        request.setAttribute("cinemaName", cinemaName);
        request.setAttribute("screenName", screenName);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        request.setAttribute("seatName", seatName);

        // Forward to success JSP
        request.getRequestDispatcher("bookingSuccess.jsp").forward(request, response);
    }
}