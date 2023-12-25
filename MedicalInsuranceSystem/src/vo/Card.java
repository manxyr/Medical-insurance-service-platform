package vo;

//定义医保卡类
public class Card {
    private String idNo;  //身份证号
    private String staffNo; //职工编号
    private String name;   //姓名
    //定义属性
    private String cardNo; //医保卡号
    private String balance; //医保卡余额
    private String status; //医保卡状态
    private String age;
    private  String sex;


    //定义构造方法
    public Card() {
    }

    public Card(String idNo,String name,String cardNo, String balance, String status, String staffNo,String age,String sex) {
        this.idNo=idNo;
        this.staffNo = staffNo;
        this.name=name;
        this.cardNo = cardNo;
        this.balance = balance;
        this.status = status;

        this.age = age;
        this.sex = sex;

    }

    //定义getter和setter方法

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
