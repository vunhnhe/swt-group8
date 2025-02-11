<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Seat" %>

<%
    String movieTitle = (String) request.getAttribute("movieTitle");
    String cinemaID = (String) request.getAttribute("cinemaID");
    String screenID = (String) request.getAttribute("screenID");
    String showtimeID = (String) request.getAttribute("showtimeID");
    String endTime = (String) request.getAttribute("endTime");

    List<Seat> seats = (List<Seat>) request.getAttribute("seats");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Seat Selection</title>
    <link rel="stylesheet" type="text/css" href="seatselect.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $(".seat").click(function(){
                $(".seat").removeClass("selected");
                $(this).addClass("selected");
                $("#selectedSeatID").val($(this).data("seatid"));
            });
        });
    </script>
</head>
<body>
    
    <h2>Seat Selection</h2>

    <table class="details-table">
            <tr>
                <td>Movie Title:</td>
                <td><%= movieTitle %></td>
            </tr>
            <tr>
                <td>Cinema ID:</td>
                <td><%= cinemaID %></td>
            </tr>
            <tr>
                <td>Screen ID:</td>
                <td><%= screenID %></td>
            </tr>
            <tr>
                <td>Start Time:</td>
                <td><%= showtimeID %></td>
            </tr>
            <tr>
                <td>End Time: </td>
                <td><%= endTime %></td>
            </tr>
     
    </table>

    <form action="ConfirmBookingServlet" method="post">
        <input type="hidden" id="selectedSeatID" name="seatID" value="" />
        <div class="seat-container">
            <div class="seat-grid">
                <% for (Seat seat : seats) { %>
                    <div class="seat <%= seat.getSeatType().toLowerCase() %>" data-seatid="<%= seat.getSeatID() %>">
                        <%= seat.getSeatNumber() %>
                    </div>
                <% } %>
            </div>
            <div class="seat-labels">
                <div class="seat-label">
                    <div class="seat vip"></div>
                    <span>VIP</span>
                </div>
                <div class="seat-label">
                    <div class="seat standard"></div>
                    <span>Standard</span>
                </div>
            </div>
        </div>

        <button type="submit">Confirm Booking</button>
    </form>
</body>
</html>