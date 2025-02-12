<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String movieTitle = (String) request.getAttribute("movieTitle");
    String cinemaName = (String) request.getAttribute("cinemaName");
    String screenName = (String) request.getAttribute("screenName");
    String startTime = (String) request.getAttribute("startTime");
    String endTime = (String) request.getAttribute("endTime");
    String seatName = (String) request.getAttribute("seatName");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <link rel="stylesheet" type="text/css" href="confirmBooking.css">
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Booking Confirmation</h2>

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
            <tr>
                <td>Seat Name:</td>
                <td><%= seatName %></td>
            </tr>
        </table>

        <div class="button-container">
            <button type="button" onclick="goBack()">Back</button>
            <form action="SuccessBookingServlet" method="post" style="display: inline;">
                <input type="hidden" name="movieTitle" value="<%= movieTitle %>" />
                <input type="hidden" name="cinemaName" value="<%= cinemaName %>" />
                <input type="hidden" name="screenName" value="<%= screenName %>" />
                <input type="hidden" name="startTime" value="<%= startTime %>" />
                <input type="hidden" name="endTime" value="<%= endTime %>" />
                <input type="hidden" name="seatName" value="<%= seatName %>" />
                <button type="submit">Booking</button>
            </form>
        </div>
    </div>
</body>
</html> 