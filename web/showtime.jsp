<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showtimes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 700px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            border-radius: 10px;
            overflow: hidden;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        select {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Choose Showtime</h1>
        <form action="booking" method="post">
            <table>
                <tr>
                    <th>Showtime ID</th>
                    <th>Movie ID</th>
                    <th>Screen ID</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                </tr>
                <c:forEach var="showtime" items="${showtimes}">
                    <tr>
                        <td><input type="hidden" name="showtimeID" value="${showtime.showtimeID}" />${showtime.showtimeID}</td>
                        <td><input type="hidden" name="movieID" value="${showtime.movieID}" />${showtime.movieID}</td>
                        <td>
                            <select name="screenID">
                                <option value="${showtime.screenID}" selected>${showtime.screenID}</option>
                                <!-- Add more options here as needed -->
                            </select>
                        </td>
                        <td>${showtime.startTime}</td>
                        <td>${showtime.endTime}</td>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit">Book Showtime</button>
        </form>
    </div>
</body>
</html>
