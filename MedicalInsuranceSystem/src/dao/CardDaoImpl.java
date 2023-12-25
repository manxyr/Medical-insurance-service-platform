package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import vo.Card;

//ʵ��ҽ�������ݷ��ʶ���Ľӿ�
public class CardDaoImpl implements CardDao {
    //�������֤�Ų�ѯҽ������Ϣ
    @Override
    public Card queryByIdNo(String idNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = null;
        try {
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql = "select * from card_manage where id_no = ?";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, idNo);
            //ִ�в�ѯ
            rs = ps.executeQuery();
            //��������
            if (rs.next()) {
                //����ҽ��������
                card = new Card();
                //��װ����
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
            //�ر���Դ
            DBUtil.close(rs, ps, conn);
        }
        //����ҽ��������
        return card;
    }

    //����ְ����Ų�ѯҽ������Ϣ
    @Override
    public Card queryByStaffNo(String staffNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = null;
        try {
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql = "select * from card_manage where staff_no = ?";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, staffNo);
            //ִ�в�ѯ
            rs = ps.executeQuery();
            //��������
            if (rs.next()) {
                //����ҽ��������
                card = new Card();
                //��װ����
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
            //�ر���Դ
            DBUtil.close(rs, ps, conn);
        }
        //����ҽ��������
        return card;
    }


    //�������֤�Ų�ѯҽ������Ϣ
    @Override
    public Card queryByUserIdNo(String userIdNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Card card = null;
        try {
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql = "select * from card_manage where id_no = ?";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, userIdNo);
            //ִ�в�ѯ
            rs = ps.executeQuery();
            //��������
            if (rs.next()) {
                //����ҽ��������
                card = new Card();
                //��װ����
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
            //�ر���Դ
            DBUtil.close(rs, ps, conn);
        }
        //����ҽ��������
        return card;
    }


    //��ѯ����ҽ������Ϣ
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
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql = "select * from card_manage where id_no=?";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, cardId);
            //ִ�в�ѯ
            rs = ps.executeQuery();
            //��������
            while (rs.next()) {
                //����ҽ��������
                Card card = new Card();
                //��װ����
                card.setStaffNo(rs.getString("staff_no"));
                card.setName(rs.getString("name"));
                card.setIdNo(rs.getString("id_no"));
                card.setBalance(rs.getString("balance"));
                card.setStatus(rs.getString("status"));
                card.setSex(rs.getString("sex"));
                card.setAge(rs.getString("age"));
                //��ӵ��б�
                list.add(card);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            DBUtil.close(rs, ps, conn);
        }
        //�����б�
        return list;
    }

    //����һ��ҽ������Ϣ
    @Override
    public int insert(Card card) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql = "insert into card_manage values (?,?,?,?,?,?)";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, card.getIdNo());
            ps.setString(2, card.getBalance());
            ps.setString(3, card.getStatus());
            ps.setString(4, card.getStaffNo());
            ps.setString(5, card.getSex());
            ps.setString(6, card.getAge());
            //ִ�и���
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            DBUtil.close(null, ps, conn);
        }
        //����Ӱ������
        return result;
    }

    //ɾ��һ��ҽ������Ϣ
    @Override
    public int delete(String idNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql="DELETE FROM users WHERE id IN (SELECT id_no FROM card_manage WHERE id_no=?)";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, idNo);
            //ִ�и���
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            DBUtil.close(null, ps, conn);
        }
        //����Ӱ������
        return result;
    }

    //����һ��ҽ������Ϣ
    @Override
    public int update(Card card) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            //��ȡ���ݿ�����
            conn = DBUtil.getConnection();
            //����SQL���
            String sql = "update card_manage set status = ? where id_no = ?";
            //����Ԥ����������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, card.getStatus());
            ps.setString(2, card.getIdNo());
            //ִ�и���
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            DBUtil.close(null, ps, conn);
        }
        //����Ӱ������
        return result;
    }

    // ����һ�������������û���id��ѯҽ������Ϣ
    public Card getCardByUserId(String userId) {
        Card card = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ׼��SQL���
            String sql = "select * from card_manage where id_no = ?";
            // ����Ԥ�������
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, userId);
            // ִ�в�ѯ
            rs = ps.executeQuery();
            // �жϽ�����Ƿ�������
            if (rs.next()) {
                // ����ҽ��������
                card = new Card();
                // ��װ����
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
        // ����ҽ��������
        return card;
    }

    // ���һ��ҽ������¼
    public boolean addCard(Card card) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ׼��SQL���
            String sql = "insert into card_manage(id_no,staff_no,name,balance,status,age,sex) values(?,?,?,?,?,?,?)";
            // ����Ԥ�������
            ps = conn.prepareStatement(sql);
            // ���ò���
            ps.setString(1, card.getIdNo());
            ps.setString(2, card.getStaffNo());
            ps.setString(3, card.getName());
            ps.setString(4, card.getBalance());
            ps.setString(5, card.getStatus());
            ps.setString(6, card.getAge());
            ps.setString(7, card.getSex());

            // ִ�в������
            ps.executeUpdate();
            ps.close();
            conn.close();
//            //�жϽ�����Ƿ�������
//            if (rs.next()) {
//                // ����ҽ��������
//                card = new Card();
//                // ��װ����
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
        card.setStatus("�˱�");
        try {
            // ��ȡ����
            conn = DBUtil.getConnection();
            // ׼��SQL���
            String sql = "update card_manage set status =? where id_no=?";
            // ����Ԥ�������
            ps = conn.prepareStatement(sql);
            //���ò���
            ps.setString(1, card.getStatus());
            ps.setString(2, card.getIdNo());
            //ִ�и���
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //�ر���Դ
            DBUtil.close(null, ps, conn);
        }
        //����Ӱ������
        return result;
    }

}
