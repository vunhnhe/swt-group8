package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmBookingServlet", urlPatterns = {"/ConfirmBookingServlet"})
public class ConfirmBookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve selected values from the request
        String movieTitle = request.getParameter("movieTitle");
        String cinemaName = request.getParameter("cinemaName");
        String screenName = request.getParameter("screenName");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String seatID = request.getParameter("seatID");
        String seatName = request.getParameter("seatName");

        // Set attributes to pass to the JSP
        request.setAttribute("movieTitle", movieTitle);
        request.setAttribute("cinemaName", cinemaName);
        request.setAttribute("screenName", screenName);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        request.setAttribute("seatID", seatID);
        request.setAttribute("seatName", seatName);

        // Forward to confirmation JSP
        request.getRequestDispatcher("confirmBooking.jsp").forward(request, response);
    }
}