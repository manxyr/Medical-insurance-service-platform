package service;

import java.util.List;
import vo.Card;

//定义医保卡业务逻辑接口
public interface CardService {

    //查询所有医保卡信息
    public List<Card> queryAll();


    //根据身份证号查询医保卡记录
    public List<Card> queryCard(String cardId);
    //入保，即添加一条医保卡信息
    public boolean join(Card card);
    //退保，即删除一条医保卡信息
    public boolean quit(String cardNo);
    //挂失，即将医保卡状态改为挂失状态
    public boolean reportLoss(Card card);
    public Card getCardByUserId(String userId);
    //添加一条医保卡记录
    public boolean joinInsurance(Card card);
}

