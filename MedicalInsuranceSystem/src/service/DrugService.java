
package service;

import java.util.List;
import dao.DrugDao;
import vo.Drug;

// ҩƷҵ���߼���
public class DrugService {
    // ����ҩƷ���ݷ��ʶ���
    private DrugDao drugDao = new DrugDao();

    // ����ҩƷ���Ͳ�ѯҩƷ�б�
    public List<Drug> queryByType(String type) {
        return drugDao.queryByType(type);
    }

    // ����ҩƷ���������ģ����ѯҩƷ�б�
    public List<Drug> queryByCodeOrName(String keyword) {
        return drugDao.queryByCodeOrName(keyword);
    }
}