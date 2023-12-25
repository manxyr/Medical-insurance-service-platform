
package vo;

public class User {
    // �û�����
    private String id; // ���֤
    private String password; // ����
    private String name; // ����
    private String userType; // �û�����
    private Card card;

    // ���췽��
    public User() {
        this.card = new Card(); // ��ʼ��card�ֶ�
    }

    public User(String id, String password, String name, String userType) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.card = new Card();

    }

    // get��set����
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}


