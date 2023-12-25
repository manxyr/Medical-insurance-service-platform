
package service;

import java.util.List;
import dao.DrugDao;
import vo.Drug;

// 药品业务逻辑类
public class DrugService {
    // 创建药品数据访问对象
    private DrugDao drugDao = new DrugDao();

    // 根据药品类型查询药品列表
    public List<Drug> queryByType(String type) {
        return drugDao.queryByType(type);
    }

    // 根据药品代码或名称模糊查询药品列表
    public List<Drug> queryByCodeOrName(String keyword) {
        return drugDao.queryByCodeOrName(keyword);
    }
}