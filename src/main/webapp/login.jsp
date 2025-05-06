<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập - Quản lý Trang trại</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;600&display=swap" rel="stylesheet">
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url('pictures/farm-blurred.jpg') no-repeat center center/cover;
            font-family: 'Quicksand', sans-serif;
        }
        .page-title {
            color: #8b4513;
            font-size: 28px;
            font-weight: bold;
            letter-spacing: 1px;
            text-align: center;
            margin-bottom: 20px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.4);
        }
        .login-container {
            background: rgba(139, 69, 19, 0.92);
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.4);
            max-width: 420px;
            width: 90%;
            color: #fff;
            animation: fadeIn 1s ease;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(30px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .logo {
            width: 80px;
            display: block;
            margin: 0 auto 15px;
        }
        h2 {
            margin-bottom: 20px;
            text-align: center;
            font-size: 22px;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
            position: relative;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 10px 35px 10px 10px;
            border: none;
            border-radius: 8px;
            transition: 0.3s;
            background-color: #fff;
            color: #333;
        }
        input:focus {
            border: 2px solid #ffb74d;
            outline: none;
        }
        .form-group i.toggle-password {
            position: absolute;
            right: 10px;
            top: 37px;
            cursor: pointer;
            color: #666;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #ffcc80;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #ffb74d;
        }
        .forgot-password {
            margin-top: 10px;
            display: block;
            color: #ffcc80;
            text-align: center;
            text-decoration: none;
        }
        .error {
            color: #ffaaaa;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }
        
        
        
    </style>
  
  
</head>


<body>



<div class="page-title">HỆ THỐNG QUẢN LÝ TRANG TRẠI</div>
     

<div class="login-container">
    <img src="pictures/logo.png" alt="Logo Trang trại" class="logo">
    <h2><i class="fas fa-user-circle"></i> Đăng nhập</h2>
    <form action="${pageContext.request.contextPath}/LoginUser" method="post">
        <div class="form-group">
            <label for="username"><i class="fas fa-user"></i> Tên đăng nhập</label>
            <input type="text" id="username" name="username" placeholder="Nhập tên...">
        </div>
        <div class="form-group">
            <label for="password"><i class="fas fa-lock"></i> Mật khẩu</label>
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu...">
            <i class="fas fa-eye toggle-password" onclick="togglePassword()"></i>
        </div>
        <button type="submit">Đăng nhập</button>
 
        <a href="checkpass.jsp" class="forgot-password">Quên mật khẩu?</a>
        <p id="error-msg" class="error">
    <%
        String errorLogin = (String) request.getAttribute("errorLogin");
        if (errorLogin != null) {
            out.print(errorLogin);
        }
    %>
</p>

    </form>
</div>

<script>


    function togglePassword() {
        const pwdInput = document.getElementById("password");
        const icon = document.querySelector(".toggle-password");
        if (pwdInput.type === "password") {
            pwdInput.type = "text";
            icon.classList.remove("fa-eye");
            icon.classList.add("fa-eye-slash");
        } else {
            pwdInput.type = "password";
            icon.classList.remove("fa-eye-slash");
            icon.classList.add("fa-eye");
        }
    }
</script>
</body>
</html>
