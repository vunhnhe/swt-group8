<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Cinema" %>
<%@page import="model.Movie" %>

<%
    Movie movie = (Movie) request.getAttribute("movie");
    List<Cinema> cinemas = (List<Cinema>) request.getAttribute("cinemas");
    if (cinemas == null) {
        cinemas = new java.util.ArrayList<>();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Select Showtime</title>
    <link rel="stylesheet" type="text/css" href="showtimecss.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function(){
            // Load screens when a cinema is selected
            $("#cinemaSelect").change(function(){
                var cinemaID = $(this).val();
                $.ajax({
                    url: "SelectShowtimeServlet",
                    type: "POST",
                    data: {action: "loadScreens", cinemaID: cinemaID},
                    success: function(response){
                        $("#screenSelect").html(response);
                        $("#showtimeSelect").html('<option value="">Select Start Time</option>');
                        $("#endTime").val('');
                    }
                });
            });

            // Load showtimes when a screen is selected
            $("#screenSelect").change(function(){
                var screenID = $(this).val();
                $.ajax({
                    url: "SelectShowtimeServlet",
                    type: "POST",
                    data: {action: "loadShowtimes", screenID: screenID},
                    success: function(response){
                        $("#showtimeSelect").html(response);
                        $("#endTime").val('');
                    }
                });
            });

            // Auto-fill End Time when Start Time is selected
            $("#showtimeSelect").change(function(){
                var endTime = $("#showtimeSelect option:selected").attr("data-endtime");
                $("#endTime").val(endTime);
            });

            // Validate form before submission
            $("#continueButton").click(function(event){
                if ($("#cinemaSelect").val() === "" || $("#screenSelect").val() === "" || $("#showtimeSelect").val() === "") {
                    alert("Please select Cinema, Screen, and Showtime before continuing.");
                    event.preventDefault();
                } else {
                    // Set hidden fields with selected values
                    $("#selectedMovieTitle").val($("#movieTitle").val());
                    $("#selectedCinemaName").val($("#cinemaSelect option:selected").text());
                    $("#selectedScreenName").val($("#screenSelect option:selected").text());
                    $("#selectedStartTime").val($("#showtimeSelect option:selected").text());
                    $("#selectedEndTime").val($("#endTime").val());
                }
            });
        });
    </script>
</head>
<body>
    <h2>Select Showtime</h2>

    <form action="SeatSelectionServlet" method="post">
        <div class="form-group">
            <label>Movie Title:</label>
            <input type="text" id="movieTitle" name="movieTitle" value="<%= movie != null ? movie.getTitle() : "" %>" readonly />
        </div>

        <div class="form-group">
            <label>Cinema Name:</label>
            <select id="cinemaSelect" name="cinemaID">
                <option value="">Select Cinema</option>
                <% for (Cinema c : cinemas) { %>
                    <option value="<%= c.getCinemaID() %>"><%= c.getCinemaName() %></option>
                <% } %>
            </select>
        </div>

        <div class="form-group">
            <label>Screen Name:</label>
            <select id="screenSelect" name="screenID">
                <option value="">Select Screen</option>
            </select>
        </div>

        <div class="form-group">
            <label>Start Time:</label>
            <select id="showtimeSelect" name="showtimeID">
                <option value="">Select Start Time</option>
            </select>
        </div>

        <div class="form-group">
            <label>End Time:</label>
            <input type="text" id="endTime" name="endTime" readonly />
        </div>

        <!-- Hidden fields to pass selected values -->
        <input type="hidden" id="selectedMovieTitle" name="selectedMovieTitle" />
        <input type="hidden" id="selectedCinemaName" name="selectedCinemaName" />
        <input type="hidden" id="selectedScreenName" name="selectedScreenName" />
        <input type="hidden" id="selectedStartTime" name="selectedStartTime" />
        <input type="hidden" id="selectedEndTime" name="selectedEndTime" />

        <button type="submit" id="continueButton">Continue</button>
    </form>
<a href="SelectShowtimeServlet?movieID=1">Movie 1</a>   

</body>
</html>