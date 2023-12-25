
package vo;

// 药品类
public class Drug {
    // 药品属性
    private String code; // 药品代码
    private String regName; // 注册名称
    private String regForm; // 注册剂型
    private String regSpec; // 注册规格
    private String prodName; // 商品名称
    private String form; // 剂型
    private String spec; // 规格
    private String packMaterial; // 包装材质
    private int minPackNum; // 最小包装数量
    private String minFormUnit; // 最小制剂单位
    private String minPackUnit; // 最小包装单位
    private String company; // 药品企业
    private String approvalNum; // 批准文号
    private String standardCode; // 药品本位码
    private String type; // 药品类型

    // 无参构造方法
    public Drug() {
    }

    // 有参构造方法
    public Drug(String code, String regName, String regForm, String regSpec, String prodName, String form, String spec,
                String packMaterial, int minPackNum, String minFormUnit, String minPackUnit, String company,
                String approvalNum, String standardCode, String type) {
        this.code = code;
        this.regName = regName;
        this.regForm = regForm;
        this.regSpec = regSpec;
        this.prodName = prodName;
        this.form = form;
        this.spec = spec;
        this.packMaterial = packMaterial;
        this.minPackNum = minPackNum;
        this.minFormUnit = minFormUnit;
        this.minPackUnit = minPackUnit;
        this.company = company;
        this.approvalNum = approvalNum;
        this.standardCode = standardCode;
        this.type = type;
    }

    // getter和setter方法
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getRegForm() {
        return regForm;
    }

    public void setRegForm(String regForm) {
        this.regForm = regForm;
    }

    public String getRegSpec() {
        return regSpec;
    }

    public void setRegSpec(String regSpec) {
        this.regSpec = regSpec;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPackMaterial() {
        return packMaterial;
    }

    public void setPackMaterial(String packMaterial) {
        this.packMaterial = packMaterial;
    }

    public int getMinPackNum() {
        return minPackNum;
    }

    public void setMinPackNum(int minPackNum) {
        this.minPackNum = minPackNum;
    }

    public String getMinFormUnit() {
        return minFormUnit;
    }

    public void setMinFormUnit(String minFormUnit) {
        this.minFormUnit = minFormUnit;
    }

    public String getMinPackUnit() {
        return minPackUnit;
    }

    public void setMinPackUnit(String minPackUnit) {
        this.minPackUnit = minPackUnit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(String approvalNum) {
        this.approvalNum = approvalNum;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Drug [code=" + code + ", regName=" + regName + ", regForm=" + regForm + ", regSpec=" + regSpec
                + ", prodName=" + prodName + ", form=" + form + ", spec=" + spec + ", packMaterial=" + packMaterial
                + ", minPackNum=" + minPackNum + ", minFormUnit=" + minFormUnit + ", minPackUnit=" + minPackUnit
                + ", company=" + company + ", approvalNum=" + approvalNum + ", standardCode=" + standardCode + ", type="
                + type + "]";
    }
}
