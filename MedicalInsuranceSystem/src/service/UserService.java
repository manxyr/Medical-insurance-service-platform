// 包含业务逻辑的类
package service;

import dao.UserDao;
import vo.User;

import java.sql.SQLException;

public class UserService {
    // 创建UserDao对象
    private UserDao userDao = new UserDao();

    // 根据身份证和密码验证用户
    public User checkUser(String id, String password) {
        // 调用UserDao的方法
        User user = userDao.queryUser(id, password);
        // 判断用户是否存在
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新输入正确的身份证和密码。");
        }
        // 返回用户
        return user;
    }


    // 根据身份证挂失用户
    public void lossUser(String id) {
        // 调用UserDao的方法
        userDao.updateStatus(id, "挂失");
    }

    public boolean isRight(String id, String password) {
        //数据访问层的方法
        UserDao userDao=new UserDao();
        User user = userDao.queryUser(id,password);
        if (user.getId() != null && password.equals(user.getPassword().trim())) {
            return true;
        }else
            return false;
    }
    public boolean userRegistered(User user){//用户是否注册成功
        UserDao userDao=new UserDao();
        boolean users = userDao.registerUser(user);
        return users;
    }

    public boolean exsitUser(String id) throws SQLException {
        UserDao userDao= new UserDao();
        boolean exsition = userDao.existUser(id);
        return exsition;
    }

//    根据用户的id返回用户user信息
    public User getCardByUserId(String cardId) {
        // 调用CardDao的方法
        return userDao.getUserByCardId(cardId);
    }
}