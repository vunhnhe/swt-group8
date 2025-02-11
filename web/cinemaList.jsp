<%@ page import="java.util.List" %>
<%@ page import="model.Cinema" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cinema List</title>
</head>
<body>
    <h1>Available Cinemas</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Cinema Name</th>
                <th>Location</th>
                <th>Number of Screens</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cinemas}" var="cinema">
                <tr>
                    <td>${cinema.cinemaName}</td>
                    <td>${cinema.location}</td>
                    <td>${cinema.numberOfScreen}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
