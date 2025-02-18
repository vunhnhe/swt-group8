<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Movie Details</title>
        <link rel="stylesheet" type="text/css" href="css/movieDetails.css">
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
            <h1>Movie Detail</h1>
        </header>

        <nav id="main-nav">
            <a href="index.jsp">Home</a>
            <a href="movies.jsp">Movies</a>
            <a href="contact.jsp">Contact</a>
        </nav>

        <div class="container">
            <c:if test="${not empty movie}">
                <div class="movie-details">
                    <h1>${movie.title}</h1>
                    <div class="movie-info">
                        <img src="images/${movie.movieID}.jpg" alt="${movie.title} Poster" class="movie-poster">
                        <div class="movie-meta">
                            <p><strong>Genre:</strong> ${movie.genre}</p>
                            <p><strong>Duration:</strong> ${movie.duration} minutes</p>
                            <p><strong>Release Date:</strong> ${movie.releaseDate}</p>
                            <p><strong>Rating:</strong> ${averageRating} / 5</p>
                            <p><strong>Description:</strong> ${movie.description}</p>
                        </div>
                    </div>
                </div>
                <div class="movie-reviews">
                    <h2>Comment</h2>
                    <ul>
                        <c:forEach var="review" items="${reviews}">
                            <li>
                                <p><strong>Rating:</strong> ${review.rating}</p>
                                <p><strong>Comment:</strong> ${review.comment}</p>
                                <p><strong>Date:</strong> ${review.reviewDate}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <c:if test="${empty movie}">
                <p>Movie not found.</p>
            </c:if>
        </div>

        <footer class="footer">
            <div class="contact-container">
                <div class="contact-info">
                    <h2>LIÊN HỆ</h2>
                    <p>
                        CÔNG TY CỔ PHẦN XYZ TECHNOLOGIES<br><br>
                        Giấy chứng nhận ĐKKD số: 0101234567 - Đăng ký lần đầu ngày 01/01/2015 tại Sở Kế hoạch và Đầu tư Thành phố Hồ Chí Minh<br><br>
                        Địa chỉ trụ sở: Tầng 2, số 123, đường Nguyễn Trãi, phường 5, quận 3, thành phố Hồ Chí Minh<br><br>
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