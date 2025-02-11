<%@ page import="java.util.List" %>
<%@ page import="model.Showtime" %>
<!DOCTYPE html>
<html>
<head>
    <title>Showtime List</title>
</head>
<body>
    <h1>Available Showtimes</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${showtimes}" var="showtime">
                <tr>
                    <td>${showtime.startTime}</td>
                    <td>${showtime.endTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
