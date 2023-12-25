// �������ݿ��������
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class InfoDao {
    // ����ҽ�����Ų�ѯҽ�������
    public String queryBalance(String id) {
        String balance = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select balance from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                balance = rs.getString("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
        return balance;
    }

    // ����ҽ�����Ų�ѯҽ����״̬
    public String queryStatus(String id) {
        String status = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select status from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
        return status;
    }

    // ����ҽ�����Ų�ѯ����
    public String queryName(String id) {
        String name = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select name from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
        return name;
    }

    // ����ҽ�����Ų�ѯ�Ա�
    public String queryGender(String id) {
        String gender = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select gender from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                gender = rs.getString("gender");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
        return gender;
    }

    // ����ҽ�����Ų�ѯ����
    public String queryAge(String id) {
        String age = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ����Ԥ�������
            String sql = "select age from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, id);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // ������
            if (rs.next()) {
                age = rs.getString("age");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            DBUtil.closeConnection(conn);
        }
        return age;
    }
}
