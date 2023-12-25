package service;

import java.util.List;
import vo.Card;

//����ҽ����ҵ���߼��ӿ�
public interface CardService {

    //��ѯ����ҽ������Ϣ
    public List<Card> queryAll();


    //�������֤�Ų�ѯҽ������¼
    public List<Card> queryCard(String cardId);
    //�뱣�������һ��ҽ������Ϣ
    public boolean join(Card card);
    //�˱�����ɾ��һ��ҽ������Ϣ
    public boolean quit(String cardNo);
    //��ʧ������ҽ����״̬��Ϊ��ʧ״̬
    public boolean reportLoss(Card card);
    public Card getCardByUserId(String userId);
    //���һ��ҽ������¼
    public boolean joinInsurance(Card card);
}

