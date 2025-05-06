package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Barn;
import model.User;
import model.Entry;

public class EntryDAO implements DAOInterface<Entry> {

    @Override
    public ArrayList<Entry> selectAll() {
        ArrayList<Entry> ketQua = new ArrayList<Entry>();
        
        try {
        	Connection con = JDBCUtil.getConnection();
        	
        	String sql = "SELECT * FROM entry";
			PreparedStatement st = con.prepareStatement(sql);

			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

        	while (rs.next()) {
        		int idEntry= rs.getInt("idEntry");
        		int idBarn= rs.getInt("idBarn");
        		Date date= rs.getDate("date");
        		int number= rs.getInt("number");
        		int idUser= rs.getInt("idUser");
        		
        		Barn b1= new Barn();
        		b1.setIdBarn(idBarn);
        		
        		User u1= new User();
        		u1.setIdUser(idUser);
        		
        		Barn b= (new BarnDAO()).selectById(b1);
        		User u= (new UserDAO()).selectById(u1);
        		
        		Entry e= new Entry(idEntry, b, date, number, u);
        		
        		ketQua.add(e);
		
        	}
        	JDBCUtil.closeConnection(con);		
        }
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
        return ketQua;
    }

    @Override
    public Entry selectById(Entry t) {
       Entry ketQua= null;
       try {
    	   Connection con = JDBCUtil.getConnection();
    	   String sql = "SELECT * FROM entry WHERE idEntry=?";
    	   PreparedStatement st = con.prepareStatement(sql);
    	   st.setInt(1, t.getIdEntry());
    	   ResultSet rs = st.executeQuery();
    	 while(rs.next()) {
    		 int idEntry= rs.getInt("idEntry");
     		int idBarn= rs.getInt("idBarn");
     		Date date= rs.getDate("date");
     		int number= rs.getInt("number");
     		int idUser= rs.getInt("idUser");
     		
     		Barn b1= new Barn();
     		b1.setIdBarn(idBarn);
     		
     		User u1= new User();
     		u1.setIdUser(idUser);
     		
     		Barn b= (new BarnDAO()).selectById(b1);
     		User u= (new UserDAO()).selectById(u1);
     		
     		ketQua= new Entry(idEntry, b, date, number, u);
     		
     		break;	 
    	 }
    	 JDBCUtil.closeConnection(con);  
       }
       catch(SQLException e) {
    	   e.printStackTrace();   
       }
	
        return ketQua;
    }

    @Override
    public int insert(Entry t) {
        int ketQua=0;
        
        try {
        	Connection con = JDBCUtil.getConnection();
        	String sql="INSERT INTO entry(idEntry, idBarn, date, number, idUser)"+
        	 " VALUES(?,?,?,?,?)";
        	PreparedStatement st = con.prepareStatement(sql);
        	st.setInt(1, t.getIdEntry());
        	st.setInt(2, t.getbarn().getIdBarn());
        	st.setDate(3, t.getDate());
        	st.setInt(4, t.getNumber());
        	st.setInt(5, t.getuser().getIdUser());
        	ketQua = st.executeUpdate();
        	
        	JDBCUtil.closeConnection(con);
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
    	
        return ketQua;
    }

    @Override
    public int delete(Entry t) {
       int ketQua=0;
       try {
    	   Connection con = JDBCUtil.getConnection();
    	   String sql = "DELETE FROM entry " + " WHERE idEntry=?";
    	   PreparedStatement st = con.prepareStatement(sql);
    	   st.setInt(1, t.getIdEntry());
    	   ketQua = st.executeUpdate();
    	   JDBCUtil.closeConnection(con);   	   
       } catch (SQLException e) {
			
			e.printStackTrace();
		}
       
       
    	
    	
        return ketQua;
    }

    @Override
    public int update(Entry t) {
      int ketQua=0;
      try {
    	  Connection con = JDBCUtil.getConnection();
    	  String sql = "UPDATE chitietdonhang SET idBarn=?, date=?, number=?, idUser=? "
					+ " WHERE idEntry=?";
    	  PreparedStatement st = con.prepareStatement(sql);
    	  st.setInt(1, t.getbarn().getIdBarn());
    	  st.setDate(2, t.getDate());
    	  st.setInt(3, t.getNumber());
    	  st.setInt(4, t.getuser().getIdUser());
    	  st.setInt(5, t.getIdEntry());
    	  
    	  ketQua = st.executeUpdate();
    	  JDBCUtil.closeConnection(con);
      }
      catch (SQLException e) {
		
			e.printStackTrace();
		}
    	
    	
        return ketQua;
    }
}
