<%@page import="model.User"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard Nhân viên</title>
  <style>
    body {
      display: flex;
      height: 100vh;
      margin: 0;
      font-family: Arial, sans-serif;
    }

    .sidebar {
      width: 250px;
      background: #8B4513;
      color: white;
      padding: 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .sidebar img {
      width: 100px;
      margin-bottom: 20px;
      border-radius: 10px;
      background: white;
      padding: 5px;
    }

    .sidebar h2 {
      margin-bottom: 20px;
    }

    .sidebar a {
      color: white;
      text-decoration: none;
      padding: 10px;
      display: block;
      width: 100%;
      text-align: center;
      border-bottom: 1px solid rgba(255, 255, 255, 0.3);
      transition: background 0.3s;
    }

    .sidebar a:hover {
      background: #A0522D;
      border-radius: 5px;
    }

    .sidebar a.logout {
      background: red;
      margin-top: 20px;
      border-radius: 5px;
    }

    .content {
      flex: 1;
      background: #D2B48C;
      padding: 20px;
      position: relative;
    }

    .page-header {
      text-align: center;
      font-size: 28px;
      font-weight: bold;
      color: #8B4513;
      margin-top: 20px;
    }

    .grid {
      display: grid;
      grid-template-columns: repeat(2, 1fr);
      gap: 20px;
      margin-top: 40px;
      justify-items: center;
    }

    .stat-box {
      background: white;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
      text-align: center;
      width: 250px;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      transition: transform 0.3s;
    }

    .stat-box:hover {
      transform: scale(1.03);
    }

    .welcome {
      text-align: center;
      font-size: 18px;
      margin-top: 40px;
      font-weight: bold;
      color: #5A3A1A;
    }
  </style>
  <script>
    function logout() {
      window.location.href = "login.jsp";
    }
  </script>
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
    <img src="pictures/logo.png" alt="Logo">
    <h2>Chức năng</h2>
    <a href="danhsach-chuong.jsp">Danh mục chuồng</a>
    <a href="nhap_heo.jsp">Nhập heo</a>
    <a href="xuat_heo.jsp">Xuất heo</a>
    <a href="hao_hut.jsp">Hao hụt</a>
    <a href="thuc_an.jsp">Thức ăn</a>
    <a href="tieu_thu_thuc_an.jsp">Tiêu thụ hằng ngày</a>
    <a href="#" class="logout" onclick="logout()">Đăng xuất</a>
  </div>

  <div class="content">
    <div class="page-header">Chào mừng nhân viên <%= user.getName()  %> vào làm việc!</div>
    <div class="grid">
      <%-- Nội dung thống kê hoặc bảng điều khiển có thể thêm ở đây --%>
    </div>
  </div>
</body>
</html>
