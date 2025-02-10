<%@page import="java.util.List, model.Movie, model.Cinema, model.Screen, model.Showtime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Choose Showtime</title>
<!--        <script>
            function updateScreens() {
                var cinemaID = document.getElementById("cinemaSelect").value;
                fetch("getScreens?cinemaID=" + cinemaID)
                        .then(response => response.json())
                        .then(data => {
                            var screenSelect = document.getElementById("screenSelect");
                            screenSelect.innerHTML = "";
                            data.forEach(screen => {
                                screenSelect.innerHTML += `<option value="${screen.screenID}">${screen.screenName}</option>`;
                            });
                        });
            }

            function updateShowtimes() {
                var movieID = document.getElementById("movieSelect").value;
                var screenID = document.getElementById("screenSelect").value;
                fetch("getShowtimes?movieID=" + movieID + "&screenID=" + screenID)
                        .then(response => response.json())
                        .then(data => {
                            var startTimeSelect = document.getElementById("startTimeSelect");
                            startTimeSelect.innerHTML = "";
                            data.forEach(showtime => {
                                startTimeSelect.innerHTML += `<option value="${showtime.startTime}">${showtime.startTime}</option>`;
                            });
                        });
            }

            function calculateEndTime() {
                var startTime = new Date(document.getElementById("startTimeSelect").value);
                var duration = parseInt(document.getElementById("movieSelect").selectedOptions[0].dataset.duration);
                var endTime = new Date(startTime.getTime() + duration * 60000);
                document.getElementById("endTimeDisplay").value = endTime.toLocaleTimeString();
            }
        </script>-->
    </head>
    <body>
        <form>
            <label>Movie Title:</label>
            <select id="movieSelect" name="movieID" onchange="updateShowtimes()">
                <% for (Movie movie : (List<Movie>) request.getAttribute("movies")) { %>
                <option value="<%= movie.getMovieID() %>" data-duration="<%= movie.getDuration() %>">
                    <%= movie.getTitle() %>
                </option>
                <% } %>
            </select>
            <br>

            <label>Cinema Name:</label>
            <select id="cinemaSelect" name="cinemaID" onchange="updateScreens()">
                <% for (Cinema cinema : (List<Cinema>) request.getAttribute("cinemas")) { %>
                <option value="<%= cinema.getCinemaID() %>"><%= cinema.getCinemaName() %></option>
                <% } %>
            </select>
            <br>

            <label>Screen Name:</label>
            <select id="screenSelect" name="screenID" onchange="updateShowtimes()"></select>
            <br>

            <label>Start Time:</label>
            <select id="startTimeSelect" name="startTime" onchange="calculateEndTime()"></select>
            <br>

            <label>End Time:</label>
            <input type="text" id="endTimeDisplay" readonly>
            <br>

            <input type="submit" value="Confirm">
        </form>
    </body>
</html>
