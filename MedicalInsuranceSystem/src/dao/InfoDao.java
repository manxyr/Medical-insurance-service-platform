// 包含数据库操作的类
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class InfoDao {
    // 根据医保卡号查询医保卡余额
    public String queryBalance(String id) {
        String balance = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select balance from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
            if (rs.next()) {
                balance = rs.getString("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnection(conn);
        }
        return balance;
    }

    // 根据医保卡号查询医保卡状态
    public String queryStatus(String id) {
        String status = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select status from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnection(conn);
        }
        return status;
    }

    // 根据医保卡号查询姓名
    public String queryName(String id) {
        String name = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select name from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnection(conn);
        }
        return name;
    }

    // 根据医保卡号查询性别
    public String queryGender(String id) {
        String gender = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select gender from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
            if (rs.next()) {
                gender = rs.getString("gender");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnection(conn);
        }
        return gender;
    }

    // 根据医保卡号查询年龄
    public String queryAge(String id) {
        String age = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select age from card_manage where id_no = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
            if (rs.next()) {
                age = rs.getString("age");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.closeConnection(conn);
        }
        return age;
    }
}
