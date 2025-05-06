package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Food;

public class FoodDAO implements DAOInterface<Food> {
    
    public ArrayList<Food> data = new ArrayList<>();

    @Override
    public ArrayList<Food> selectAll() {
        ArrayList<Food> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM food";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idFood = rs.getInt("idFood");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                Food f = new Food(idFood, name, price);
                ketQua.add(f);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Food selectById(Food t) {
        Food ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM food WHERE idFood = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdFood());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int idFood = rs.getInt("idFood");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                ketQua = new Food(idFood, name, price);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(Food t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO food (idFood, name, price) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdFood());
            st.setString(2, t.getName());
            st.setInt(3, t.getPrice());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(Food t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM food WHERE idFood = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdFood());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(Food t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE food SET name = ?, price = ? WHERE idFood = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getName());
            st.setInt(2, t.getPrice());
            st.setInt(3, t.getIdFood());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
