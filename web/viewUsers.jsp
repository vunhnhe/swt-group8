<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, model.Customer" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Manage Users</title>
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
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Dashboard - Manage Users</h1>
        <a href="logout" class="logout-btn">Đăng xuất</a>
    </div>
    
    <div class="navbar">
        <a href="AdminDashboard.jsp">Home</a>
        <a href="user">Manage Users</a>
        <a href="manageMovies.jsp">Manage Movies</a>
        <a href="Showtime">Manage Showtimes</a>
        <a href="manageBookings.jsp">Manage Bookings</a>
        <a href="manageReviews.jsp">Manage Reviews</a>
        <a href="manageVouchers.jsp">Manage Vouchers</a>
    </div>

    <div class="container">
        <div class="table-container">
            <h2 class="text-center">Danh sách người dùng</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Phone</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                       if (customers != null && !customers.isEmpty()) {
                           for (Customer customer : customers) { %>
                    <tr>
                        <td><%= customer.getId() %></td>
                        <td><%= customer.getPhone() %></td>
                        <td><%= customer.getName() %></td>
                        <td><%= customer.getPassword() %></td>
                        <td><%= customer.getEmail() %></td>
                        <td><%= customer.getAddress() %></td>
                        <td>
                            <a href="editUser.jsp?customerID=<%= customer.getId() %>" class="edit-btn">Edit</a>
                            <form action="User" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="customerID" value="<%= customer.getId() %>">
                                <button type="submit" class="delete-btn">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <% } } else { %>
                    <tr>
                        <td colspan="7">Không có người dùng nào.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>