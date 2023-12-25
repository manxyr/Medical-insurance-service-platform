// 包含数据库操作的类
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;
import vo.User;

public class UserDao {
    // 根据身份证和密码查询用户
    public User queryUser(String id, String password) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select * from users where id = ? and password = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            ps.setString(2, password);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
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
            // 关闭资源
            DBUtil.closeConnection(conn);
        }
        return user;
    }

    // 根据身份证更新医保卡状态
    public void updateStatus(String id, String status) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "update user set status = ? where id = ?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, status);
            ps.setString(2, id);
            // 执行更新
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
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
            // 获取连接
            conn = DBUtil.getConnection();
            // 创建预编译语句
            String sql = "select * from users where id = ? ";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行查询
            rs = ps.executeQuery();
            // 处理结果
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            // 关闭资源怎么改
    }



    // 定义一个方法，根据用户的id返回用户user信息
    public User getUserByCardId(String userId) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 准备SQL语句
            String sql = "select * from users where id = ?";
            // 创建预编译对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, userId);
            // 执行查询
            rs = ps.executeQuery();
            // 判断结果集是否有数据
            if (rs.next()) {
                // 创建医保卡对象
                user = new User();
                // 封装属性
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("userType"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
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
        // 返回用户对象
        return user;
    }
}
