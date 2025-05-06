package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Barn;
import model.Lost;
import model.User;

public class LostDAO implements DAOInterface<Lost> {

    @Override
    public ArrayList<Lost> selectAll() {
        ArrayList<Lost> ketQua = new ArrayList<>();

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM lost";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idLost = rs.getInt("idLost");
                int idBarn = rs.getInt("idBarn");
                int idUser = rs.getInt("idUser");
                Date date = rs.getDate("date");
                int number = rs.getInt("number");
                String reason = rs.getString("reason");

                Barn b1 = new Barn();
                b1.setIdBarn(idBarn);
                Barn barn = (new BarnDAO()).selectById(b1);

                User u1 = new User();
                u1.setIdUser(idUser);
                User user = (new UserDAO()).selectById(u1);

                Lost l = new Lost(idLost, barn, user, date, number, reason);
                ketQua.add(l);
            }

            rs.close();
            st.close();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public Lost selectById(Lost t) {
        Lost ketQua = null;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM lost WHERE idLost=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdLost());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int idLost = rs.getInt("idLost");
                int idBarn = rs.getInt("idBarn");
                int idUser = rs.getInt("idUser");
                Date date = rs.getDate("date");
                int number = rs.getInt("number");
                String reason = rs.getString("reason");

                Barn b1 = new Barn();
                b1.setIdBarn(idBarn);
                Barn barn = (new BarnDAO()).selectById(b1);

                User u1 = new User();
                u1.setIdUser(idUser);
                User user = (new UserDAO()).selectById(u1);

                ketQua = new Lost(idLost, barn, user, date, number, reason);
            }

            rs.close();
            st.close();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(Lost t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO lost(idLost, idBarn, idUser, date, number, reason) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdLost());
            st.setInt(2, t.getBarn().getIdBarn());
            st.setInt(3, t.getUser().getIdUser());
            st.setDate(4, t.getDate());
            st.setInt(5, t.getNumber());
            st.setString(6, t.getReason());

            ketQua = st.executeUpdate();

            st.close();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(Lost t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM lost WHERE idLost=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdLost());

            ketQua = st.executeUpdate();

            st.close();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(Lost t) {
        int ketQua = 0;

        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE lost SET idBarn=?, idUser=?, date=?, number=?, reason=? WHERE idLost=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getBarn().getIdBarn());
            st.setInt(2, t.getUser().getIdUser());
            st.setDate(3, t.getDate());
            st.setInt(4, t.getNumber());
            st.setString(5, t.getReason());
            st.setInt(6, t.getIdLost());

            ketQua = st.executeUpdate();

            st.close();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
