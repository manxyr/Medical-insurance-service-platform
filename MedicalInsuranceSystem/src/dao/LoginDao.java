// �������ݿ��������
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;
import vo.User;

public class LoginDao {
    // �������֤�������ѯ�û�
    public User queryUser(String id, String password) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select * from users where id = ? and password = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            ps.setString(2, password);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("userType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
        return user;
    }
}
