package dao;

import java.util.List;
import vo.Card;

//定义医保卡数据访问对象的接口
public interface CardDao {
    //根据身份证号查询医保卡信息
    public Card queryByIdNo(String idNo);
    //根据职工编号查询医保卡信息
    public Card queryByStaffNo(String staffNo);

    //根据身份证号查询医保卡信息
    Card queryByUserIdNo(String userIdNo);

    //查询所有医保卡信息
    public List<Card> queryAll();

    public List<Card> queryCard(String cardId);

    //插入一条医保卡信息
    public int insert(Card card);
    //删除一条医保卡信息
    public int delete(String cardNo);
    //更新一条医保卡信息
    public int update(Card card);
    // 定义一个方法，根据用户的id查询医保卡信息
    public Card getCardByUserId(String userId);
    // 添加一条医保卡记录
    public boolean addCard(Card card);
}

