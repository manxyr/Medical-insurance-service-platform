// ����ҵ���߼�����
package service;

import dao.InfoDao;


public class InfoService {
    // ����InfoDao����
    private InfoDao infoDao = new InfoDao();

    // ����ҽ�����Ż�ȡҽ�������
    public String getBalance(String id) {
        // ����InfoDao�ķ���
        return infoDao.queryBalance(id);
    }

    // ����ҽ�����Ż�ȡҽ����״̬
    public String getStatus(String id) {
        // ����InfoDao�ķ���
        return infoDao.queryStatus(id);
    }

    // ����ҽ�����Ż�ȡ����
    public String getName(String id) {
        // ����InfoDao�ķ���
        return infoDao.queryName(id);
    }

    // ����ҽ�����Ż�ȡ�Ա�
    public String getGender(String id) {
        // ����InfoDao�ķ���
        return infoDao.queryGender(id);
    }

    // ����ҽ�����Ż�ȡ����
    public String getAge(String id) {
        // ����InfoDao�ķ���
        return infoDao.queryAge(id);
    }
}
