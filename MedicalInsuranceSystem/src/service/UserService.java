// ����ҵ���߼�����
package service;

import dao.UserDao;
import vo.User;

import java.sql.SQLException;

public class UserService {
    // ����UserDao����
    private UserDao userDao = new UserDao();

    // �������֤��������֤�û�
    public User checkUser(String id, String password) {
        // ����UserDao�ķ���
        User user = userDao.queryUser(id, password);
        // �ж��û��Ƿ����
        if (user == null) {
            throw new RuntimeException("�û������ڣ�������������ȷ�����֤�����롣");
        }
        // �����û�
        return user;
    }


    // �������֤��ʧ�û�
    public void lossUser(String id) {
        // ����UserDao�ķ���
        userDao.updateStatus(id, "��ʧ");
    }

    public boolean isRight(String id, String password) {
        //���ݷ��ʲ�ķ���
        UserDao userDao=new UserDao();
        User user = userDao.queryUser(id,password);
        if (user.getId() != null && password.equals(user.getPassword().trim())) {
            return true;
        }else
            return false;
    }
    public boolean userRegistered(User user){//�û��Ƿ�ע��ɹ�
        UserDao userDao=new UserDao();
        boolean users = userDao.registerUser(user);
        return users;
    }

    public boolean exsitUser(String id) throws SQLException {
        UserDao userDao= new UserDao();
        boolean exsition = userDao.existUser(id);
        return exsition;
    }

//    �����û���id�����û�user��Ϣ
    public User getCardByUserId(String cardId) {
        // ����CardDao�ķ���
        return userDao.getUserByCardId(cardId);
    }
}