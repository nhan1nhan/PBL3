package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;
        String url = "jdbc:mysql://localhost:3306/databasepbl3";
        String username = "root";
        String password = "123456"; // Kiểm tra lại mật khẩu này!

        try {
            // *** BƯỚC QUAN TRỌNG NHẤT: Tải và đăng ký driver tường minh ***
            // Sử dụng "com.mysql.cj.jdbc.Driver" cho Connector/J 8.x trở lên (như 9.2.0)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("----> MySQL JDBC Driver registered successfully via Class.forName()."); // Thêm log để xác nhận

            // Cố gắng lấy kết nối
            System.out.println("----> Attempting to connect to DB: " + url);
            c = DriverManager.getConnection(url, username, password);
            System.out.println("----> Database connection successful!");

        } catch (ClassNotFoundException e) {
            // Lỗi này nghĩa là file JAR không được tìm thấy hoặc tên class sai
            System.err.println("!!! LỖI NGHIÊM TRỌNG: Không tìm thấy lớp MySQL JDBC Driver !!!");
            System.err.println("!!! Đảm bảo 'mysql-connector-j-*.jar' có trong WEB-INF/lib và tên lớp là 'com.mysql.cj.jdbc.Driver' !!!");
            e.printStackTrace();
            throw new RuntimeException("Không tìm thấy JDBC Driver trong WEB-INF/lib hoặc tên class sai", e);
        } catch (SQLException e) {
            // Lỗi này là kết nối thất bại (sai pass, db tắt, sai url, v.v...)
            System.err.println("!!! LỖI NGHIÊM TRỌNG: Kết nối CSDL thất bại !!!");
            System.err.println("URL: " + url);
            System.err.println("User: " + username);
            e.printStackTrace(); // In chi tiết lỗi SQL gốc
            throw new RuntimeException("Kết nối CSDL thất bại: " + e.getMessage(), e);
        }

        return c; // Chỉ trả về c nếu kết nối thành công
    }

     public static void closeConnection(Connection c) {
         try {
             if(c!=null && !c.isClosed()) { // Kiểm tra null VÀ chưa đóng
                 c.close();
                 // System.out.println("----> Database connection closed.");
             }
         } catch (SQLException e) {
             System.err.println("Lỗi khi đóng kết nối CSDL.");
             e.printStackTrace();
         }
     }

     public static void printInfo(Connection c) {
 		try {
 			if(c!=null) {
 				DatabaseMetaData mtdt = c.getMetaData();
 				System.out.println(mtdt.getDatabaseProductName());
 				System.out.println(mtdt.getDatabaseProductVersion());
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
}