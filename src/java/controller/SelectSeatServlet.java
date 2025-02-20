package controller;

import dal.SeatDAO;
import dal.ShowtimeDAO;
import model.Seat;
import model.Showtime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectSeatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cinemaIdParam = request.getParameter("cinemaId");
        String screenIdParam = request.getParameter("screenId");
        String showtimeIdParam = request.getParameter("showtimeId");

        if (cinemaIdParam != null && screenIdParam != null && showtimeIdParam != null) {
            int cinemaId = Integer.parseInt(cinemaIdParam);
            int screenId = Integer.parseInt(screenIdParam);
            int showtimeId = Integer.parseInt(showtimeIdParam);

            SeatDAO seatDAO = new SeatDAO();
            List<Seat> availableSeats = seatDAO.getAvailableSeats(cinemaId, screenId, showtimeId);

            ShowtimeDAO showtimeDAO = new ShowtimeDAO();
            Showtime showtime = showtimeDAO.getShowtimeById(showtimeId);

            request.setAttribute("availableSeats", availableSeats);
            request.setAttribute("cinemaId", cinemaId);
            request.setAttribute("screenId", screenId);
            request.setAttribute("showtimeId", showtimeId);
            request.setAttribute("movieTitle", showtime.getMovieID().getTitle());
        }

        request.getRequestDispatcher("/selectSeat.jsp").forward(request, response);
    }
}