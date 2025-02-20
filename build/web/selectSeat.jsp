<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Seat" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/selectSeat.css">
        <title>Select Seat</title>
        <script>
            window.addEventListener('scroll', function () {
                var nav = document.getElementById('main-nav');
                if (window.scrollY > 0) {
                    nav.classList.add('sticky');
                } else {
                    nav.classList.remove('sticky');
                }
            });

        </script>
    </head>
    <body>
        <header class="header">
            <h1>Select Your Seats</h1>
        </header>

        <nav id="main-nav">
            <a href="index.jsp">Home</a>
            <a href="movies.jsp">Movies</a>
            <a href="contact.jsp">Contact</a>
        </nav>

        <div class="container">
            <h2>Available Seats for <%= request.getAttribute("movieTitle") %></h2>
            <form action="confirmBooking.jsp" method="post">
                <input type="hidden" name="cinemaId" value="<%= request.getAttribute("cinemaId") %>">
                <input type="hidden" name="screenId" value="<%= request.getAttribute("screenId") %>">
                <input type="hidden" name="showtimeId" value="<%= request.getAttribute("showtimeId") %>">
                
                <div class="seat-selection">
                    <%
                        List<Seat> availableSeats = (List<Seat>) request.getAttribute("availableSeats");
                        if (availableSeats != null && !availableSeats.isEmpty()) {
                            for (Seat seat : availableSeats) {
                    %>
                    <div class="seat">
                        <input type="checkbox" id="seat_<%= seat.getSeatID() %>" name="selectedSeats" value="<%= seat.getSeatID() %>">
                        <label for="seat_<%= seat.getSeatID() %>"><%= seat.getSeatNumber() %> - <%= seat.getSeatType() %></label>
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <p>No available seats for this showtime.</p>
                    <%
                        }
                    %>
                </div>

                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
                <button type="submit" class="confirm-booking-button">Confirm Booking</button><br>
            </form>
        </div>

        <footer class="footer">
            <div class="contact-container">
                <div class="contact-info">
                    <h2>LIÊN HỆ</h2>
                    <p>
                        CÔNG TY CỔ PHẦN XYZ TECHNOLOGIES<br><br>
                        Giấy chứng nhận ĐKKD số: 0101234567 - Đăng ký lần đầu ngày 01/01/2015 tại Sở Kế hoạch và Đầu
                        tư Thành phố Hồ Chí Minh<br><br>
                        Địa chỉ trụ sở: Tầng 2, số 123, đường Nguyễn Trãi, phường 5, quận 3, thành phố Hồ Chí
                        Minh<br><br>
                        Hotline: 1800 123 456 / 0901 234 567<br><br>
                        Email: contact@xyztechnologies.vn
                    </p>
                </div>
                <div class="business-contact">
                    <h2>HỢP TÁC KINH DOANH:</h2>
                    <p>
                        Hotline: 1800 987 654<br><br>
                        Email: partnership@xyzgroup.vn
                    </p>
                </div>
            </div>
        </footer>
    </body>
</html>