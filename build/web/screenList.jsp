<%@ page import="java.util.List" %>
<%@ page import="model.Screen" %>
<!DOCTYPE html>
<html>
<head>
    <title>Screen List</title>
</head>
<body>
    <h1>Available Screens</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Screen Name</th>
                <th>Total Seat</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${screens}" var="screen">
                <tr>
                    <td>${screen.screenName}</td>
                    <td>${screen.totalSeat}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
s