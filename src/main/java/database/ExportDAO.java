package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Barn;
import model.Export;
import model.User;

public class ExportDAO implements DAOInterface<Export> {

    @Override
    public ArrayList<Export> selectAll() {
        ArrayList<Export> ketQua = new ArrayList<Export>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM export";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idExport = rs.getInt("idExport");
                int idBarn = rs.getInt("idBarn");
                Date date = rs.getDate("date");
                int number = rs.getInt("number");
                int idUser = rs.getInt("idUser");

                Barn b1 = new Barn();
                b1.setIdBarn(idBarn);
                Barn barn = (new BarnDAO()).selectById(b1);

                User u1 = new User();
                u1.setIdUser(idUser);
                User user = (new UserDAO()).selectById(u1);

                Export e = new Export(idExport, barn, date, number, user);
                ketQua.add(e);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public Export selectById(Export t) {
        Export ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM export WHERE idExport = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdExport());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int idExport = rs.getInt("idExport");
                int idBarn = rs.getInt("idBarn");
                Date date = rs.getDate("date");
                int number = rs.getInt("number");
                int idUser = rs.getInt("idUser");

                Barn b1 = new Barn();
                b1.setIdBarn(idBarn);
                Barn barn = (new BarnDAO()).selectById(b1);

                User u1 = new User();
                u1.setIdUser(idUser);
                User user = (new UserDAO()).selectById(u1);

                ketQua = new Export(idExport, barn, date, number, user);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(Export t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO export(idExport, idBarn, date, number, idUser) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdExport());
            st.setInt(2, t.getBarn().getIdBarn());
            st.setDate(3, t.getDate());
            st.setInt(4, t.getNumber());
            st.setInt(5, t.getUser().getIdUser());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(Export t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM export WHERE idExport = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getIdExport());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(Export t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE export SET idBarn = ?, date = ?, number = ?, idUser = ? WHERE idExport = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, t.getBarn().getIdBarn());
            st.setDate(2, t.getDate());
            st.setInt(3, t.getNumber());
            st.setInt(4, t.getUser().getIdUser());
            st.setInt(5, t.getIdExport());

            ketQua = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
