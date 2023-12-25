// 包含业务逻辑的类
package service;

import dao.LoginDao;
import vo.User;

public class LoginService {
    // 创建LoginDao对象
    private LoginDao loginDao = new LoginDao();

    // 根据身份证和密码验证用户
    public User checkUser(String id, String password) {
        // 调用LoginDao的方法
        User user = loginDao.queryUser(id, password);
        // 返回用户
        return user;
    }
}
