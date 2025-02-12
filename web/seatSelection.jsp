<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Seat" %>

<%
    String movieTitle = (String) request.getAttribute("movieTitle");
    String cinemaName = (String) request.getAttribute("cinemaName");
    String screenName = (String) request.getAttribute("screenName");
    String startTime = (String) request.getAttribute("startTime");
    String endTime = (String) request.getAttribute("endTime");

    List<Seat> seats = (List<Seat>) request.getAttribute("seats");
    if (seats == null) {
        seats = new java.util.ArrayList<>();
    }
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

            // Validate form before submission
            $("#confirmButton").click(function(event){
                if ($("#selectedSeatID").val() === "") {
                    alert("Please select a seat before confirming.");
                    event.preventDefault();
                }
            });

            // Navigate back to the previous page
            $("#backButton").click(function(event){
                event.preventDefault();
                window.history.back();
            });
        });
    </script>
    <style>
        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .button-container button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            margin-right: 10px; /* Add space between buttons */
        }
        .button-container button:last-child {
            margin-right: 0; /* Remove margin from the last button */
        }
    </style>
</head>
<body>
    
    <h2>Seat Selection</h2>

    <table class="details-table">
        <tr>
            <td>Movie Title:</td>
            <td><%= movieTitle %></td>
        </tr>
        <tr>
            <td>Cinema Name:</td>
            <td><%= cinemaName %></td>
        </tr>
        <tr>
            <td>Screen Name:</td>
            <td><%= screenName %></td>
        </tr>
        <tr>
            <td>Start Time:</td>
            <td><%= startTime %></td>
        </tr>
        <tr>
            <td>End Time:</td>
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

        <div class="button-container">
            <button type="button" id="backButton">Back</button>
            <button type="submit" id="confirmButton">Confirm Booking</button>
        </div>
    </form>
</body>
</html>