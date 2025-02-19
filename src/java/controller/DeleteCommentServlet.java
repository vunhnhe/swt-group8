package controller;

import dal.MovieDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int movieId = Integer.parseInt(request.getParameter("movieId"));

        MovieDAO movieDAO = new MovieDAO();
        movieDAO.deleteReview(reviewId);

        response.sendRedirect("movieDetails?movieId=" + movieId);
    }
}