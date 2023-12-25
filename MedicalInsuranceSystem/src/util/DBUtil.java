// 包含数据库连接工具类
package util;

import java.sql.*;

public class DBUtil {
    // 数据库连接信息
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=wisdom_health";
    private static final String USER = "yy";
    private static final String PASSWORD = "123";

    // 获取数据库连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 加载驱动
            Class.forName(DRIVER);
            // 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭数据库连接
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
    }

    public static void closeResultSet(ResultSet resultSet) {
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
    }
}