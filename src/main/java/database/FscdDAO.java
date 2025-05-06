package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Fscd;
import model.Food;
import model.User;

public class FscdDAO implements DAOInterface<Fscd> {

    @Override
    public ArrayList<Fscd> selectAll() {
        ArrayList<Fscd> ketQua = new ArrayList<>();

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM fscd";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idFcsd = rs.getInt("idFcsd");
                Date date = rs.getDate("date");
                int weight = rs.getInt("weight");
                int idUser = rs.getInt("idUser");
                int idFood = rs.getInt("idFood");

                // Tạo đối tượng trung gian
                User u1 = new User();
                u1.setIdUser(idUser);
                User user = new UserDAO().selectById(u1);

                Food f1 = new Food();
                f1.setIdFood(idFood);
                Food food = new FoodDAO().selectById(f1);

                Fscd fscd = new Fscd(idFcsd, date, weight, user, food);
                ketQua.add(fscd);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public Fscd selectById(Fscd t) {
        Fscd ketQua = null;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM fscd WHERE idFcsd = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdFcsd());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idFcsd = rs.getInt("idFcsd");
                Date date = rs.getDate("date");
                int weight = rs.getInt("weight");
                int idUser = rs.getInt("idUser");
                int idFood = rs.getInt("idFood");

                User u1 = new User();
                u1.setIdUser(idUser);
                User user = new UserDAO().selectById(u1);

                Food f1 = new Food();
                f1.setIdFood(idFood);
                Food food = new FoodDAO().selectById(f1);

                ketQua = new Fscd(idFcsd, date, weight, user, food);
                break;
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(Fscd t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO fscd (idFcsd, date, weight, idUser, idFood) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdFcsd());
            st.setDate(2, t.getDate());
            st.setInt(3, t.getWeight());
            st.setInt(4, t.getUser().getIdUser());
            st.setInt(5, t.getFood().getIdFood());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(Fscd t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM fscd WHERE idFcsd = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdFcsd());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(Fscd t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE fscd SET date = ?, weight = ?, idUser = ?, idFood = ? WHERE idFcsd = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1, t.getDate());
            st.setInt(2, t.getWeight());
            st.setInt(3, t.getUser().getIdUser());
            st.setInt(4, t.getFood().getIdFood());
            st.setInt(5, t.getIdFcsd());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
