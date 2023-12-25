
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Drug;

// 药品数据访问对象类
public class DrugDao {
    // 根据药品类型查询药品列表
    public List<Drug> queryByType(String type) {
        List<Drug> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from drug where type = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug();
                drug.setCode(rs.getString("code"));
                drug.setRegName(rs.getString("reg_name"));
                drug.setRegForm(rs.getString("reg_form"));
                drug.setRegSpec(rs.getString("reg_spec"));
                drug.setProdName(rs.getString("prod_name"));
                drug.setForm(rs.getString("form"));
                drug.setSpec(rs.getString("spec"));
                drug.setPackMaterial(rs.getString("pack_material"));
                drug.setMinPackNum(rs.getInt("min_pack_num"));
                drug.setMinFormUnit(rs.getString("min_form_unit"));
                drug.setMinPackUnit(rs.getString("min_pack_unit"));
                drug.setCompany(rs.getString("company"));
                drug.setApprovalNum(rs.getString("approval_num"));
                drug.setStandardCode(rs.getString("standard_code"));
                list.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }

    // 根据药品代码或名称模糊查询药品列表
    public List<Drug> queryByCodeOrName(String keyword) {
        List<Drug> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from drug where code like ? or reg_name like ? or prod_name like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug();
                drug.setCode(rs.getString("code"));
                drug.setRegName(rs.getString("reg_name"));
                drug.setRegForm(rs.getString("reg_form"));
                drug.setRegSpec(rs.getString("reg_spec"));
                drug.setProdName(rs.getString("prod_name"));
                drug.setForm(rs.getString("form"));
                drug.setSpec(rs.getString("spec"));
                drug.setPackMaterial(rs.getString("pack_material"));
                drug.setMinPackNum(rs.getInt("min_pack_num"));
                drug.setMinFormUnit(rs.getString("min_form_unit"));
                drug.setMinPackUnit(rs.getString("min_pack_unit"));
                drug.setCompany(rs.getString("company"));
                drug.setApprovalNum(rs.getString("approval_num"));
                drug.setStandardCode(rs.getString("standard_code"));
                list.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }
}
