package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Barn;

public class BarnDAO implements DAOInterface<Barn>  {
	
	public ArrayList<Barn> data= new ArrayList<>();

	@Override
	public ArrayList<Barn> selectAll() {
		ArrayList<Barn> ketQua= new ArrayList<>();
	 try {
            Connection con=JDBCUtil.getConnection();
            
            String sql="SELECT * FROM barn";
    		PreparedStatement st= con.prepareStatement(sql);
    		
    		ResultSet rs= st.executeQuery();
    		
    		while(rs.next()) {
    			int idBarn = rs.getInt("idBarn");
    			String nameBarn= rs.getString("nameBarn");
    			int numPig= rs.getInt("numPig");
    			int capacity= rs.getInt("capacity");
    			
    			Barn b= new Barn(idBarn, nameBarn, numPig, capacity);
    			ketQua.add(b);
    		}
    		JDBCUtil.closeConnection(con);
	 }
	 catch(SQLException e) {
		 e.printStackTrace();
	 }
		
		
		return ketQua;
	}

	@Override
	public Barn selectById(Barn t) {
		Barn ketQua=null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql= "SELECT * FROM barn WHERE idBarn=?";
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, t.getIdBarn());
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				int idBarn = rs.getInt("idBarn");
    			String nameBarn= rs.getString("nameBarn");
    			int numPig= rs.getInt("numPig");
    			int capacity= rs.getInt("capacity");
    			
    			ketQua = new Barn(idBarn, nameBarn, numPig, capacity);
			}
			JDBCUtil.closeConnection(con);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return ketQua;
	}

	@Override
	public int insert(Barn t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO barn (idBarn, nameBarn, numPig, capacity) "
					+ " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getIdBarn());
			st.setString(2, t.getNameBarn());
			st.setInt(3, t.getNumPig());
			st.setInt(4, t.getCapacity());


			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:


			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int delete(Barn t) {
      int ketQua=0; 
		
		try {
			//b1: tao va ket noi csdl
			Connection con= JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement
			String sql= "DELETE FROM barn"+ " WHERE idBarn=?";
			
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, t.getIdBarn());
			
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
	public int update(Barn t) {
		int ketQua=0;
		try {
			//b1: tao va ket noi csdl
			Connection con= JDBCUtil.getConnection();
			
			//b2: tao doi tuong statement 
			String sql="UPDATE barn SET nameBarn = ?, numPig = ?, capacity = ? WHERE idBarn=?";
			
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, t.getNameBarn());
			st.setInt(2, t.getNumPig());
			st.setInt(3, t.getCapacity());
			st.setInt(4, t.getIdBarn());

			
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
