package vo;

//����ҽ������
public class Card {
    private String idNo;  //���֤��
    private String staffNo; //ְ�����
    private String name;   //����
    //��������
    private String cardNo; //ҽ������
    private String balance; //ҽ�������
    private String status; //ҽ����״̬
    private String age;
    private  String sex;


    //���幹�췽��
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

    //����getter��setter����

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
