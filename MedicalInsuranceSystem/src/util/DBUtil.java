// �������ݿ����ӹ�����
package util;

import java.sql.*;

public class DBUtil {
    // ���ݿ�������Ϣ
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=wisdom_health";
    private static final String USER = "yy";
    private static final String PASSWORD = "123";

    // ��ȡ���ݿ�����
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // ��������
            Class.forName(DRIVER);
            // ��ȡ����
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // �ر����ݿ�����
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