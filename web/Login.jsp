<%-- 
    Document   : Login
    Created on : Feb 10, 2025, 1:38:24 AM
    Author     : tovie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; font-family: Arial, sans-serif; }
        body {
            background: url('images/quaybanve.jpg') no-repeat center center/cover;
            height: 99vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Nền mờ khi hiển thị form */
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }

        /* Form đăng nhập */
        .login-box {
            width: 350px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
            text-align: center;
        }
        .login-box input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .login-box button {
            width: 100%;
            padding: 12px;
            background: #2980b9;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .login-box button:hover { background: #1f618d; }

        /* Nút đóng */
        .close-btn {
            float: right;
            cursor: pointer;
            font-size: 20px;
            color: #333;
        }

        /* Nút đăng nhập */
        .navbar {
            position: fixed;
            top: 10px;
            right: 20px;
        }
        .login-btn {
            background: #2980b9;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .login-btn:hover { background: #1f618d; }
    </style>
</head>
<body>

    <!-- Nút đăng nhập góc trên phải -->
    <div class="navbar">
        <button class="login-btn" onclick="toggleLogin()">Đăng nhập</button>
    </div>

    <!-- Form đăng nhập -->
    <div class="overlay" id="overlay">
        <div class="login-box">
            <span class="close-btn" onclick="toggleLogin()">&times;</span>
            <h3>Đăng nhập</h3>
            <form action="LoginServlet" method="post">
                <input type="text" name="username" placeholder="Tên đăng nhập" required>
                <input type="password" name="password" placeholder="Mật khẩu" required>
                <button type="submit">Đăng nhập</button>
            </form>
        </div>
    </div>

    <script>
        function toggleLogin() {
            var overlay = document.getElementById("overlay");
            overlay.style.display = (overlay.style.display === "flex") ? "none" : "flex";
        }
    </script>

</body>
</html>