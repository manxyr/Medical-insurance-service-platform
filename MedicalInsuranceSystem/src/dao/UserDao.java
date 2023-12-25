// �������ݿ��������
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;
import vo.User;

public class UserDao {
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
                user.setName(rs.getString("name"));
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

    // �������֤����ҽ����״̬
    public void updateStatus(String id, String status) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "update user set status = ? where id = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, status);
            ps.setString(2, id);
            // ִ�и���
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
    }

    public boolean registerUser(User user) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO users(id, password, userType) VALUES(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUserType());
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean existUser(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select * from users where id = ? ";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            // �ر���Դ��ô��
    }



    // ����һ�������������û���id�����û�user��Ϣ
    public User getUserByCardId(String userId) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ׼��SQL���
            String sql = "select * from users where id = ?";
            // ����Ԥ�������
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, userId);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // �жϽ�����Ƿ�������
            if (rs.next()) {
                // ����ҽ��������
                user = new User();
                // ��װ����
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("userType"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // �����û�����
        return user;
    }
}
