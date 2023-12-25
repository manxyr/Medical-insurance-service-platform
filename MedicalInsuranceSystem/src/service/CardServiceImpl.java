package service;

import java.util.List;
import dao.CardDao;
import dao.CardDaoImpl;
import vo.Card;

//实现医保卡业务逻辑接口
public class CardServiceImpl implements CardService {


    //创建医保卡数据访问对象的实例
    private CardDaoImpl cardDaoimpl = new CardDaoImpl();

    private CardDao cardDao;

    public  CardServiceImpl(){}

    //查询所有医保卡信息
    @Override
    public List<Card> queryAll(){
        //调用医保卡数据访问对象的方法
        return cardDaoimpl.queryAll();
    }

    @Override
    public List<Card> queryCard(String cardId) {
        //调用医保卡数据访问对象的方法
        return cardDaoimpl.queryCard(cardId);
    }

    //入保，即添加一条医保卡信息
    @Override
    public boolean join(Card card) {
        //调用医保卡数据访问对象的方法，返回是否成功
        return cardDaoimpl.insert(card) > 0;
    }

    //退保，即删除一条医保卡信息
    @Override
    public boolean quit(String idNo) {
        //调用医保卡数据访问对象的方法，返回是否成功
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

    //挂失，即将医保卡状态改为挂失状态(更具)
    @Override
    public boolean reportLoss(Card card) {
        //将状态改为挂失
        card.setStatus("挂失");
        //调用医保卡数据访问对象的方法，返回是否成功
        int rowAffect=cardDaoimpl.update(card);
        if(rowAffect>0){
            //更新成功
            return true;
        }
        else {
            return false;
        }
    }


    public Card getCardByUserId(String userId) {
        // 调用CardDao的方法
        return cardDaoimpl.getCardByUserId(userId);
    }

    // 入保业务
    public boolean joinInsurance(Card card) {
        return cardDaoimpl.addCard(card);
    }

}
