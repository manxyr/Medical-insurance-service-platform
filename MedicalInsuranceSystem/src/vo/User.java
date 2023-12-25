
package vo;

public class User {
    // 用户属性
    private String id; // 身份证
    private String password; // 密码
    private String name; // 姓名
    private String userType; // 用户类型
    private Card card;

    // 构造方法
    public User() {
        this.card = new Card(); // 初始化card字段
    }

    public User(String id, String password, String name, String userType) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.card = new Card();

    }

    // get和set方法
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


