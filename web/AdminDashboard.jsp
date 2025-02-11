<%-- 
    Document   : AdminDashboard
    Created on : Feb 11, 2025, 1:38:24 AM
    Author     : tovie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Admin"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("admin") == null) {
        response.sendRedirect("AdminLogin.jsp");
        return;
    }
    Admin admin = (Admin) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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
        }
        .container {
            padding: 20px;
        }
        .welcome {
            margin-bottom: 20px;
        }
        .admin-actions {
            list-style-type: none;
            padding: 0;
        }
        .admin-actions li {
            margin: 10px 0;
        }
        .admin-actions a {
            text-decoration: none;
            color: #2980b9;
        }
        .admin-actions a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Dashboard</h1>
    </div>
    <div class="container">
        <div class="welcome">
            <h2>Welcome, <%= admin.getName() %>!</h2>
            <p>You have successfully logged in as an admin.</p>
        </div>
        <ul class="admin-actions">
            <li><a href="manageUsers.jsp">Manage Users</a></li>
            <li><a href="manageMovies.jsp">Manage Movies</a></li>
            <li><a href="manageShowtimes.jsp">Manage Showtimes</a></li>
            <li><a href="manageBookings.jsp">Manage Bookings</a></li>
            <li><a href="manageReviews.jsp">Manage Reviews</a></li>
            <li><a href="manageVouchers.jsp">Manage Vouchers</a></li>
        </ul>
    </div>
</body>
</html>
