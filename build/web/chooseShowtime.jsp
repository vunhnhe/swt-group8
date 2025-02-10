<%@ page import="java.util.List" %>
<%@ page import="your.package.Movie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Choose Showtime</title>
</head>
<body>
    <h1>Choose Showtime</h1>
    <form action="YourNextServlet" method="post">
        <label for="movie">Movie Title:</label>
        <select id="movie" name="movie">
            <c:forEach items="${movies}" var="movie">
                <option value="${movie.movieID}">${movie.title}</option>
            </c:forEach>
        </select>
        <label for="cinema">Cinema Name:</label>
        <select id="cinema" name="cinema">
            <c:forEach items="${cinemas}" var="cinema">
                <option value="${cinema.cinemaID}">${cinema.cinemaName}</option>
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
        document.getElementById('startTime').addEventListener('change', function() {
            var duration = /* get duration from selected movie */;
            var startTime = new Date(this.value);
            var endTime = new Date(startTime.getTime() + duration * 60000);
            document.getElementById('endTime').value = endTime.toISOString().slice(0, 16);
        });
    </script>
</body>
</html>
