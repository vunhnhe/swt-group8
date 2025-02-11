package controller;

import model.Seat;
import dal.ScreenDAO;
import dal.SeatDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SeatSelectionServlet", urlPatterns = {"/SeatSelectionServlet"})
public class SeatSelectionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String movieTitle = request.getParameter("movieTitle");
        String cinemaID = request.getParameter("cinemaID");
        String screenID = request.getParameter("screenID");
        String showtimeID = request.getParameter("showtimeID");
        String endTime = request.getParameter("endTime");

        // Set attributes to pass to the seat selection page
        request.setAttribute("movieTitle", movieTitle);
        request.setAttribute("cinemaID", cinemaID);
        request.setAttribute("screenID", screenID);
        request.setAttribute("showtimeID", showtimeID);
        request.setAttribute("endTime", endTime);

        // Retrieve total number of seats for the selected screen
        ScreenDAO screenDAO = new ScreenDAO();
        int totalSeats = screenDAO.getTotalSeatsByScreenID(Integer.parseInt(screenID));

        // Generate seats
        List<Seat> seats = new ArrayList<>();
        char row = 'A';
        for (int i = 1; i <= totalSeats; i++) {
            String seatNumber = row + String.valueOf((i - 1) % 10 + 1);
            String seatType = (i % 2 == 0) ? "Standard" : "VIP";
            double price = (i % 2 == 0) ? 7.50 : 10.00;
            seats.add(new Seat(i, Integer.parseInt(screenID), seatNumber, seatType, price));

            // Move to the next row after every 10 seats
            if (i % 10 == 0) {
                row++;
            }
        }

        // Set seats attribute to pass to the seat selection page
        request.setAttribute("seats", seats);

        // Forward to the seat selection page
        request.getRequestDispatcher("seatSelection.jsp").forward(request, response);
    }
}