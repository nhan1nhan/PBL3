<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Dashboard Admin</title>
  <style>
    * { box-sizing: border-box; }
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      display: flex;
      height: 100vh;
      overflow: hidden;
    }
    .sidebar {
      width: 250px;
      background: #8B4513;
      color: white;
      display: flex;
      flex-direction: column;
      padding: 20px;
      position: fixed;
      top: 0;
      left: 0;
      height: 100vh;
      overflow-y: auto;
    }
    .sidebar img {
      width: 100px;
      margin: 0 auto 20px;
      background: white;
      border-radius: 10px;
      padding: 5px;
    }
    .sidebar a {
      color: white;
      text-decoration: none;
      padding: 10px;
      border-bottom: 1px solid rgba(255, 255, 255, 0.3);
      display: block;
    }
    .sidebar hr {
      margin: 15px 0;
      border: none;
      border-top: 1px solid rgba(255,255,255,0.3);
    }
    .logout-btn {
      background: red;
      color: white;
      padding: 12px;
      border: none;
      border-radius: 10px;
      font-weight: bold;
      cursor: pointer;
      margin-top: 10px;
    }
    .content {
      margin-left: 250px;
      flex: 1;
      background: #f5deb3;
      padding: 30px;
      height: 100vh;
      overflow-y: auto;
    }
  </style>
</head>
<body>
         <% 
       Object obj = session.getAttribute("user");
        User user= null;
        if(obj!=null)
        	user = (User) obj;
      //nguoc lai
    %>
     

  <div class="sidebar">
    <img src="pictures/logo.png" alt="Logo" />
    <a href="tk_heo_con_lai.jsp">Thống kê heo còn lại</a>
    <a href="tk_thang_tuoi.jsp">Thống kê theo tháng tuổi</a>
    <a href="tk_thuc_an.jsp">Chi phí thức ăn</a>
    <a href="tk_xuat_heo.jsp">Thống kê xuất heo</a>
    <a href="them_nhan_vien.jsp">Thêm nhân viên</a>
    <button class="logout-btn" onclick="logout()">Đăng xuất</button>
  </div>

  <div class="content">
    <h1>Chào mừng quản lý trang trại <%= user.getName() %>!</h1>
  </div>

  <script>
    function logout() {
      window.location.href = "login.jsp";
    }
  </script>
</body>
</html>
