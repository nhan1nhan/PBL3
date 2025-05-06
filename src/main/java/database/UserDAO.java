package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;


public class UserDAO implements DAOInterface<User> {
   public ArrayList<User> data= new ArrayList<>();
	
	
	@Override
	public ArrayList<User> selectAll() {
		 ArrayList<User> ketQua= new ArrayList<User>();
		    try {
		    	//B1: ket noi csdl 
		    	Connection con= JDBCUtil.getConnection();
		    	
		    	//B2: tao ra doi tuong statement
		    	String sql= "SELECT * FROM user";
		    	PreparedStatement st= con.prepareStatement(sql); //cau lenh chuan bi de truy cap den csdl
		    	
		    	
		    	//B3: thuc thi cau lenh sql in ra cau lenh
		    	// System.out.printf(sql); k can dau
		    	
		    	ResultSet rs= st.executeQuery();  // truy van va tra ve kq duoi dang bang du lieu
		        
		    	
		    	//B4: in ra
		    	
		    	while (rs.next()){
		    		int idUser= rs.getInt("idUser");
		    		String name= rs.getString("name");
		    		String user= rs.getString("user");
		    		String password= rs.getString("password");
		    		boolean status= rs.getBoolean("status");
		    		boolean decent= rs.getBoolean("decent");
		    		
		    	User us= new User(idUser, name, user, password, status, decent); 
		    	  
		    	ketQua.add(us);	
		    	}
		    	
		    	JDBCUtil.closeConnection(con);
		    }
		catch(SQLException e) {
			e.printStackTrace(); // in ra loi neu ket noi that bai
		}
		
		
		return ketQua;
	}

	@Override
	public User selectById(User t) {
      User ketQua= null;
    		  try {
  		    	//B1: ket noi csdl 
  		    	Connection con= JDBCUtil.getConnection();
  		    	
  		    	//B2: tao ra doi tuong statement
  		    	String sql= "SELECT * FROM user WHERE idUser=?";
  		    	PreparedStatement st= con.prepareStatement(sql); //cau lenh chuan bi de truy cap den csdl
  		        st.setInt(1, t.getIdUser());
  		        	
  		    	
  		    	//B3: thuc thi cau lenh sql in ra cau lenh
  		    	// System.out.printf(sql); k can dau
  		   
  		    	ResultSet rs= st.executeQuery();  // truy van va tra ve kq duoi dang bang du lieu
  		        
  		    	
  		    	//B4: in ra
  		    	
  		    	while (rs.next()){
  		    		int idUser= rs.getInt("idUser");
  		    		String name= rs.getString("name");
  		    		String user= rs.getString("user");
  		    		String password= rs.getString("password");
  		    		boolean status= rs.getBoolean("status");
  		    		boolean decent= rs.getBoolean("decent");
  		    		
  		         ketQua = new User(idUser, name, user, password, status, decent); 
  		    	  
  		    	}
  		    	
  		    	JDBCUtil.closeConnection(con);
  		    }
  		catch(SQLException e) {
  			e.printStackTrace(); // in ra loi neu ket noi that bai
  		}		
  		return ketQua;
	}
	
	public User selectToLogin(User t) {
	      User ketQua= null;
	    		  try {
	  		    	//B1: ket noi csdl 
	  		    	Connection con= JDBCUtil.getConnection();
	  		    	
	  		    	
	  		    	//B2: tao ra doi tuong statement
	  		    	String sql= "SELECT *  FROM user WHERE user=? AND password=?";
	  		    	PreparedStatement st= con.prepareStatement(sql); //cau lenh chuan bi de truy cap den csdl
	  		        st.setString(1, t.getUser());
	  		        st.setString(2, t.getPassword());	
	  		    	
	  		    	//B3: thuc thi cau lenh sql in ra cau lenh
	  		    	// System.out.printf(sql); k can dau
	  		   
	  		    	ResultSet rs= st.executeQuery();  // truy van va tra ve kq duoi dang bang du lieu
	  		        
	  		    	
	  		    	//B4: in ra
	  		    	
	  		    	while (rs.next()){
	  		    		int idUser= rs.getInt("idUser");
	  		    		String name= rs.getString("name");
	  		    		String user= rs.getString("user");
	  		    		String password= rs.getString("password");
	  		    		boolean status= rs.getBoolean("status");
	  		    		boolean decent= rs.getBoolean("decent");
	  		    		
	  		         ketQua = new User(idUser, name, user, password, status, decent); 
	  		    	  
	  		    	}
	  		    	
	  		    	JDBCUtil.closeConnection(con);
	  		    }
	  		catch(SQLException e) {
	  			e.printStackTrace(); // in ra loi neu ket noi that bai
	  		}		
	  		return ketQua;
		}
	
	
	


	@Override
	public int insert(User t) {
		int ketQua= 0;
		try {
			//b1: tao ket noi csdl
		    Connection con= JDBCUtil.getConnection();
		    
		    //b2: tao ra doi tuong statement
		    String sql="INSERT INTO user (idUser, name, user, password, status, decent)"+ "VALUES (?,?,?,?,?,?)";
		    PreparedStatement st = con.prepareStatement(sql);		
		    
		    st.setInt(1, t.getIdUser());
		    st.setString(2, t.getName());
		    st.setString(3,t.getUser());
		    st.setString(4, t.getPassword());
		    st.setBoolean(5,t.isStatus());
		    st.setBoolean(6,t.isDecent());
		    
		    
		    //B3: thuc thi cau lenh
		    ketQua= st.executeUpdate();
		    
		    
		    //B4: Them cau lenh 
		    
		    //B5: 
		    JDBCUtil.closeConnection(con);
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		      

		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua=0; 
		
		try {
			//b1: tao va ket noi csdl
			Connection con= JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			String sql= "UPDATE user SET status= ? WHERE idUser= ?";
			
			PreparedStatement st= con.prepareStatement(sql);
			st.setBoolean(1, false);
			st.setInt(2, t.getIdUser());
			
			//b3: thuc thi cau lenh sql
			ketQua= st.executeUpdate();
			
			//b4:
			
			//b5: 
			JDBCUtil.closeConnection(con);
		}
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
	
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua=0;
		try {
			//b1: tao va ket noi csdl
			Connection con= JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement 
			String sql="UPDATE user SET name = ?, user = ?, password = ?, decent = ? WHERE idUser = ?";
			
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getUser());
			st.setString(3, t.getPassword());
			st.setBoolean(4, t.isDecent());
			st.setInt(5, t.getIdUser());
			
			//b3: thuc thi cau lenh
			ketQua= st.executeUpdate();
			
			//b4
			//b5
			JDBCUtil.closeConnection(con);		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	  


}
