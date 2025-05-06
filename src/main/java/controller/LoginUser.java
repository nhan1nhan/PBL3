package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserDAO;
import model.User;

/**
 * Servlet implementation class Dangnhap
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user= request.getParameter("username");
		String password = request.getParameter("password");
		
		User u= new User();
		u.setUser(user);
		u.setPassword(password);
		
		UserDAO ud= new UserDAO();
		User ucheck= ud.selectToLogin(u);
		
		String url="";
		
		if(ucheck!= null && ucheck.isStatus()) {
			HttpSession session= request.getSession();
			session.setAttribute("user",ucheck);
//			session.setAttribute("name", ucheck.getName());
//			session.setAttribute("user", user);
//			session.setAttribute("password", password);
			
		    if(!ucheck.isDecent())//nhan vien (vi decen nhan vien la 0   	
		    	url= "/nhanvien.jsp";
		    else  
		    	url="/boss.jsp";  	 	   
		}
		
		else {
	request.setAttribute("errorLogin","Kiểm tra lại tên đăng nhập, mật khẩu và đảm bảo "
					+ "rằng bạn vẫn còn làm việc trong hệ thống!");
	    url= "/login.jsp";
		}
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
	    rd.forward(request, response);	
	
	
		
	}

}
