// ����ҵ���߼�����
package service;

import dao.LoginDao;
import vo.User;

public class LoginService {
    // ����LoginDao����
    private LoginDao loginDao = new LoginDao();

    // �������֤��������֤�û�
    public User checkUser(String id, String password) {
        // ����LoginDao�ķ���
        User user = loginDao.queryUser(id, password);
        // �����û�
        return user;
    }
}
