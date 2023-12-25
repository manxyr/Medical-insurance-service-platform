// 包含数据库操作的类
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;
import vo.User;

public class LoginDao {
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
}
