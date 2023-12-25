package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import vo.Card;

//实现医保卡数据访问对象的接口
public class CardDaoImpl implements CardDao {
    //根据身份证号查询医保卡信息
    @Override
    public Card queryByIdNo(String idNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = null;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql = "select * from card_manage where id_no = ?";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, idNo);
            //执行查询
            rs = ps.executeQuery();
            //处理结果集
            if (rs.next()) {
                //创建医保卡对象
                card = new Card();
                //封装属性
                card.setIdNo(rs.getString("id_no"));
                card.setIdNo(rs.getString("card_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setStaffNo(rs.getString("staff_no"));
                card.setSex(rs.getString("sex"));
                card.setAge(rs.getString("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(rs, ps, conn);
        }
        //返回医保卡对象
        return card;
    }

    //根据职工编号查询医保卡信息
    @Override
    public Card queryByStaffNo(String staffNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = null;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql = "select * from card_manage where staff_no = ?";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, staffNo);
            //执行查询
            rs = ps.executeQuery();
            //处理结果集
            if (rs.next()) {
                //创建医保卡对象
                card = new Card();
                //封装属性
                card.setIdNo(rs.getString("card_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setStaffNo(rs.getString("staff_no"));
                card.setSex(rs.getString("sex"));
                card.setAge(rs.getString("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(rs, ps, conn);
        }
        //返回医保卡对象
        return card;
    }


    //根据身份证号查询医保卡信息
    @Override
    public Card queryByUserIdNo(String userIdNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = null;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql = "select * from card_manage where id_no = ?";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, userIdNo);
            //执行查询
            rs = ps.executeQuery();
            //处理结果集
            if (rs.next()) {
                //创建医保卡对象
                card = new Card();
                //封装属性
                card.setIdNo(rs.getString("id_no"));
                card.setIdNo(rs.getString("card_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setStaffNo(rs.getString("staff_no"));
                card.setSex(rs.getString("sex"));
                card.setAge(rs.getString("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(rs, ps, conn);
        }
        //返回医保卡对象
        return card;
    }


    //查询所有医保卡信息
    @Override
    public List<Card> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Card> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM card_manage";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Card card = new Card();
                card.setStaffNo(rs.getString("staff_no"));
                card.setName(rs.getString("name"));
                card.setIdNo(rs.getString("id_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setSex(rs.getString("sex"));
                card.setAge(rs.getString("age"));
                list.add(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }


    @Override
    public List<Card> queryCard(String cardId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Card> list = new ArrayList<>();
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql = "select * from card_manage where id_no=?";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, cardId);
            //执行查询
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                //创建医保卡对象
                Card card = new Card();
                //封装属性
                card.setStaffNo(rs.getString("staff_no"));
                card.setName(rs.getString("name"));
                card.setIdNo(rs.getString("id_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setSex(rs.getString("sex"));
                card.setAge(rs.getString("age"));
                //添加到列表
                list.add(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(rs, ps, conn);
        }
        //返回列表
        return list;
    }

    //插入一条医保卡信息
    @Override
    public int insert(Card card) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql = "insert into card_manage values (?,?,?,?,?,?)";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, card.getIdNo());
            ps.setString(2, card.getBalance());
            ps.setString(3, card.getStatus());
            ps.setString(4, card.getStaffNo());
            ps.setString(5, card.getSex());
            ps.setString(6, card.getAge());
            //执行更新
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(null, ps, conn);
        }
        //返回影响行数
        return result;
    }

    //删除一条医保卡信息
    @Override
    public int delete(String idNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql="DELETE FROM users WHERE id IN (SELECT id_no FROM card_manage WHERE id_no=?)";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, idNo);
            //执行更新
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(null, ps, conn);
        }
        //返回影响行数
        return result;
    }

    //更新一条医保卡信息
    @Override
    public int update(Card card) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            //定义SQL语句
            String sql = "update card_manage set status = ? where id_no = ?";
            //创建预编译语句对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, card.getStatus());
            ps.setString(2, card.getIdNo());
            //执行更新
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUtil.close(null, ps, conn);
        }
        //返回影响行数
        return result;
    }

    // 定义一个方法，根据用户的id查询医保卡信息
    public Card getCardByUserId(String userId) {
        Card card = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 准备SQL语句
            String sql = "select * from card_manage where id_no = ?";
            // 创建预编译对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, userId);
            // 执行查询
            rs = ps.executeQuery();
            // 判断结果集是否有数据
            if (rs.next()) {
                // 创建医保卡对象
                card = new Card();
                // 封装属性
                card.setStaffNo(rs.getString("staff_no"));
                card.setName(rs.getString("name"));
                card.setIdNo(rs.getString("id_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setAge(rs.getString("age"));
                card.setSex(rs.getString("sex"));
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
        // 返回医保卡对象
        return card;
    }

    // 添加一条医保卡记录
    public boolean addCard(Card card) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 准备SQL语句
            String sql = "insert into card_manage(id_no,staff_no,name,balance,status,age,sex) values(?,?,?,?,?,?,?)";
            // 创建预编译对象
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, card.getIdNo());
            ps.setString(2, card.getStaffNo());
            ps.setString(3, card.getName());
            ps.setString(4, card.getBalance());
            ps.setString(5, card.getStatus());
            ps.setString(6, card.getAge());
            ps.setString(7, card.getSex());

            // 执行插入操作
            ps.executeUpdate();
            ps.close();
            conn.close();
//            //判断结果集是否有数据
//            if (rs.next()) {
//                // 创建医保卡对象
//                card = new Card();
//                // 封装属性
//                card.setStaffNo(rs.getString("staff_no"));
//                card.setName(rs.getString("name"));
//                card.setIdNo(rs.getString("card_no"));
//                card.setBalance(rs.getString("balance"));
//                card.setStatus(rs.getString("status"));
//                card.setAge(rs.getString("age"));
//                card.setSex(rs.getString("sex"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        return true;
    }

    public int refine_status(String idno){
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        Card card = new Card();
        card.setIdNo(idno);
        card.setStatus("退保");
        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 准备SQL语句
            String sql = "update card_manage set status =? where id_no=?";
            // 创建预编译对象
            ps = conn.prepareStatement(sql);
            //设置参数
            ps.setString(1, card.getStatus());
            ps.setString(2, card.getIdNo());
            //执行更新
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            DBUtil.close(null, ps, conn);
        }
        //返回影响行数
        return result;
    }

}
