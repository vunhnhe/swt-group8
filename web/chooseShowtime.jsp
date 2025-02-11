<%@ page import="java.util.List" %>
<%@ page import="Model.Movie" %>
<%@ page import="Model.Cinema" %>
<%@ page import="Model.Screen" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Choose Showtime</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }

            h1 {
                text-align: center;
                color: #333;
            }

            form {
                max-width: 600px;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            form label {
                display: block;
                margin-bottom: 10px;
                color: #555;
            }

            form select,
            form input[type="datetime-local"],
            form input[type="text"],
            form button {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            form button {
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                font-size: 16px;
            }

            form button:hover {
                background-color: #45a049;
            }

            table {
                width: 80%;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            table, th, td {
                border: 1px solid #ccc;
            }

            th, td {
                padding: 15px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
                color: #333;
            }

        </style>
    </head>
    <body>
        <h1>Choose Showtime</h1>
        <form action="ShowtimeServlet" method="post">
            <label for="movie">Movie Title:</label>
            <input type="hidden" id="movie" name="movie">
            <span id="movieTitle"></span>

            <label for="cinema">Cinema Name:</label>
            <select id="cinema" name="cinema" onchange="updateScreens()">
                <c:forEach items="${cinemas}" var="cinema">
                    <option value="${cinema.cinemaID}" ${cinema.cinemaID == defaultCinemaID ? 'selected' : ''}>${cinema.cinemaName}</option>
                </c:forEach>
            </select>

            <label for="screen">Screen Name:</label>
            <select id="screen" name="screen">
                <c:forEach items="${screens}" var="screen">
                    <option value="${screen.screenID}">${screen.screenName}</option>
                </c:forEach>
            </select>

            <label for="startTime">Start Time:</label>
            <input type="datetime-local" id="startTime" name="startTime" required>

            <label for="endTime">End Time:</label>
            <input type="text" id="endTime" name="endTime" readonly>

            <button type="submit">Submit</button>
        </form>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const movieTitleElement = document.getElementById('movieTitle');
                const movieInput = document.getElementById('movie');
                const movieSelect = document.createElement('select');
                movieSelect.style.display = 'none'; // Hide the actual dropdown

                // Populate the hidden dropdown with movies
                <% for (Movie movie : (List<Movie>) request.getAttribute("movies")) { %>
                    const option = document.createElement('option');
                    option.value = '<%= movie.getMovieID() %>';
                    option.textContent = '<%= movie.getTitle() %>';
                    option.setAttribute('data-duration', '<%= movie.getDuration() %>');
                    movieSelect.appendChild(option);
                <% } %>

                // Listen for changes in the dropdown and update the movie title and duration
                movieSelect.addEventListener('change', function () {
                    const selectedMovie = movieSelect.options[movieSelect.selectedIndex];
                    movieInput.value = selectedMovie.value;
                    movieTitleElement.textContent = selectedMovie.textContent;
                    updateDuration(selectedMovie.getAttribute('data-duration'));
                });

                // Trigger the initial update
                movieSelect.dispatchEvent(new Event('change'));

                document.body.appendChild(movieSelect); // Append the hidden dropdown to the body

                function updateDuration(duration) {
                    const startTimeInput = document.getElementById('startTime');
                    const endTimeInput = document.getElementById('endTime');

                    startTimeInput.addEventListener('change', function () {
                        const startTime = new Date(this.value);
                        const endTime = new Date(startTime.getTime() + duration * 60000);
                        endTimeInput.value = endTime.toISOString().slice(0, 16);
                    });
                }

                updateScreens = function () {
                    const cinemaSelect = document.getElementById('cinema');
                    const cinemaID = cinemaSelect.value;
                    // Fetch the screens for the selected cinema (you might need an AJAX call here)
                    // For simplicity, we're assuming the screens are already available in JavaScript
                }
            });
        </script>
    </body>
</html>
