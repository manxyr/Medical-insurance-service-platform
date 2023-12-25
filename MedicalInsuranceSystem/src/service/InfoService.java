// 包含业务逻辑的类
package service;

import dao.InfoDao;


public class InfoService {
    // 创建InfoDao对象
    private InfoDao infoDao = new InfoDao();

    // 根据医保卡号获取医保卡余额
    public String getBalance(String id) {
        // 调用InfoDao的方法
        return infoDao.queryBalance(id);
    }

    // 根据医保卡号获取医保卡状态
    public String getStatus(String id) {
        // 调用InfoDao的方法
        return infoDao.queryStatus(id);
    }

    // 根据医保卡号获取姓名
    public String getName(String id) {
        // 调用InfoDao的方法
        return infoDao.queryName(id);
    }

    // 根据医保卡号获取性别
    public String getGender(String id) {
        // 调用InfoDao的方法
        return infoDao.queryGender(id);
    }

    // 根据医保卡号获取年龄
    public String getAge(String id) {
        // 调用InfoDao的方法
        return infoDao.queryAge(id);
    }
}
