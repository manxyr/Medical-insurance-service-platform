package service;

import java.util.List;
import dao.CardDao;
import dao.CardDaoImpl;
import vo.Card;

//ʵ��ҽ����ҵ���߼��ӿ�
public class CardServiceImpl implements CardService {


    //����ҽ�������ݷ��ʶ����ʵ��
    private CardDaoImpl cardDaoimpl = new CardDaoImpl();

    private CardDao cardDao;

    public  CardServiceImpl(){}

    //��ѯ����ҽ������Ϣ
    @Override
    public List<Card> queryAll(){
        //����ҽ�������ݷ��ʶ���ķ���
        return cardDaoimpl.queryAll();
    }

    @Override
    public List<Card> queryCard(String cardId) {
        //����ҽ�������ݷ��ʶ���ķ���
        return cardDaoimpl.queryCard(cardId);
    }

    //�뱣�������һ��ҽ������Ϣ
    @Override
    public boolean join(Card card) {
        //����ҽ�������ݷ��ʶ���ķ����������Ƿ�ɹ�
        return cardDaoimpl.insert(card) > 0;
    }

    //�˱�����ɾ��һ��ҽ������Ϣ
    @Override
    public boolean quit(String idNo) {
        //����ҽ�������ݷ��ʶ���ķ����������Ƿ�ɹ�
        boolean result = false;

        try {
            cardDaoimpl.delete(idNo);
            cardDaoimpl.refine_status(idNo);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    //��ʧ������ҽ����״̬��Ϊ��ʧ״̬(����)
    @Override
    public boolean reportLoss(Card card) {
        //��״̬��Ϊ��ʧ
        card.setStatus("��ʧ");
        //����ҽ�������ݷ��ʶ���ķ����������Ƿ�ɹ�
        int rowAffect=cardDaoimpl.update(card);
        if(rowAffect>0){
            //���³ɹ�
            return true;
        }
        else {
            return false;
        }
    }


    public Card getCardByUserId(String userId) {
        // ����CardDao�ķ���
        return cardDaoimpl.getCardByUserId(userId);
    }

    // �뱣ҵ��
    public boolean joinInsurance(Card card) {
        return cardDaoimpl.addCard(card);
    }

}
