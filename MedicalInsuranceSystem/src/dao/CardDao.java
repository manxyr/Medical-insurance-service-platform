package dao;

import java.util.List;
import vo.Card;

//����ҽ�������ݷ��ʶ���Ľӿ�
public interface CardDao {
    //�������֤�Ų�ѯҽ������Ϣ
    public Card queryByIdNo(String idNo);
    //����ְ����Ų�ѯҽ������Ϣ
    public Card queryByStaffNo(String staffNo);

    //�������֤�Ų�ѯҽ������Ϣ
    Card queryByUserIdNo(String userIdNo);

    //��ѯ����ҽ������Ϣ
    public List<Card> queryAll();

    public List<Card> queryCard(String cardId);

    //����һ��ҽ������Ϣ
    public int insert(Card card);
    //ɾ��һ��ҽ������Ϣ
    public int delete(String cardNo);
    //����һ��ҽ������Ϣ
    public int update(Card card);
    // ����һ�������������û���id��ѯҽ������Ϣ
    public Card getCardByUserId(String userId);
    // ���һ��ҽ������¼
    public boolean addCard(Card card);
}

