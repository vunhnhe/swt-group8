<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.util.Map, model.Showtime" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Manage Showtimes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #2980b9;
            color: white;
            padding: 10px 0;
            text-align: center;
            position: relative;
        }
        .logout-btn {
            position: absolute;
            top: 10px;
            right: 20px;
            background-color: #333;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }
        .logout-btn:hover {
            background-color: #ddd;
            color: black;
        }
        .navbar {
            overflow: hidden;
            background-color: #333;
            display: flex;
            justify-content: center;
        }
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .container {
            padding: 20px;
        }
        .table-container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #2980b9;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .add-btn {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            background-color: #2980b9;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
        .add-btn:hover {
            background-color: #1c5a85;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Dashboard - Manage Showtimes</h1>
        <a href="logout" class="logout-btn">Đăng xuất</a>
    </div>
    
    <div class="navbar">
        <a href="AdminDashboard.jsp">Home</a>
        <a href="user">Manage Users</a>
        <a href="manageMovies.jsp">Manage Movies</a>
        <a href="manageShowtimes.jsp">Manage Showtimes</a>
        <a href="manageBookings.jsp">Manage Bookings</a>
        <a href="manageReviews.jsp">Manage Reviews</a>
        <a href="manageVouchers.jsp">Manage Vouchers</a>
    </div>

    <div class="container">
        <div class="table-container">
            <h2 class="text-center">Danh sách suất chiếu</h2>
            <div href="addShowtime.jsp" class="add-btn">Thêm suất chiếu</div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Movie Title</th>
                        <th>Screen ID</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Admin ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Showtime> showtimes = (List<Showtime>) request.getAttribute("showtimes");
                       Map<Integer, String> movieMap = (Map<Integer, String>) request.getAttribute("movieMap");
                       Map<Integer, String> screenMap = (Map<Integer, String>) request.getAttribute("screenMap");
                       if (showtimes != null && !showtimes.isEmpty()) {
                           for (Showtime showtime : showtimes) { %>
                    <tr>
                        <td><%= showtime.getShowtimeID() %></td>
                        <td><%= movieMap.get(showtime.getMovieID()) %></td>
                        <td><%= screenMap.get(showtime.getScreenID()) %></td>
                        <td><%= showtime.getStartTime() %></td>
                        <td><%= showtime.getEndTime() %></td>
                        <td><%= showtime.getAdminID() %></td>
                        <td>
                            <form action="Showtime" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="showtimeID" value="<%= showtime.getShowtimeID() %>">
                                <button type="submit" class="delete-btn">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <% } } else { %>
                    <tr>
                        <td colspan="7">Không có suất chiếu nào.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
