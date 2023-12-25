package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import service.InfoService;
import service.UserService;
import vo.Card;
import vo.User;

public class InfoUI extends JFrame implements ActionListener {
    private User user;
    // 创建界面组件
    private JLabel cardLabel = new JLabel("医保卡号"); // 医保卡号标签
    private JTextField cardField = new JTextField(); // 医保卡号文本框
    private JLabel balanceLabel = new JLabel("医保卡余额"); // 医保卡余额标签
    private JTextField balanceField = new JTextField(); // 医保卡余额文本框
    private JLabel statusLabel = new JLabel("医保卡状态"); // 医保卡状态标签
    private JTextField statusField = new JTextField(); // 医保卡状态文本框
    private JLabel nameLabel = new JLabel("姓名"); // 姓名标签
    private JTextField nameField = new JTextField(); // 姓名文本框
    private JLabel genderLabel = new JLabel("性别"); // 性别标签
    private JTextField genderField = new JTextField(); // 性别文本框
    private JLabel ageLabel = new JLabel("年龄"); // 年龄标签
    private JTextField ageField = new JTextField(); // 年龄文本框
    private JButton backButton = new JButton("返回"); // 返回按钮


    private JPanel jp  = new JPanel();
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private JPanel jp5 = new JPanel();
    private JPanel jp6 = new JPanel();

    // 创建InfoService对象
    private InfoService infoService = new InfoService();
    private UserService userService = new UserService();

    // 构造方法
    public InfoUI(Card card) {
        // 设置界面标题
//        super("职工医保基本信息界面");
        this.user=userService.getCardByUserId(card.getIdNo());


        // 设置标签和文本框的大小
        Dimension labelSize = new Dimension(100, 30);
        Dimension fieldSize = new Dimension(200, 30);

        // 设置标签大小
        cardLabel.setPreferredSize(labelSize);
        balanceLabel.setPreferredSize(labelSize);
        statusLabel.setPreferredSize(labelSize);
        nameLabel.setPreferredSize(labelSize);
        genderLabel.setPreferredSize(labelSize);
        ageLabel.setPreferredSize(labelSize);

        // 设置文本框大小
        cardField.setPreferredSize(fieldSize);
        balanceField.setPreferredSize(fieldSize);
        statusField.setPreferredSize(fieldSize);
        nameField.setPreferredSize(fieldSize);
        genderField.setPreferredSize(fieldSize);
        ageField.setPreferredSize(fieldSize);


        // 添加组件
        jp1.add(cardLabel); // 医保卡号标签
        jp1.add(cardField); // 医保卡号文本框
        jp2.add(balanceLabel); // 医保卡余额标签
        jp2.add(balanceField); // 医保卡余额文本框
        jp3.add(statusLabel); // 医保卡状态标签
        jp3.add(statusField); // 医保卡状态文本框
        jp4.add(nameLabel); // 姓名标签
        jp4.add(nameField); // 姓名文本框
        jp5.add(genderLabel); // 性别标签
        jp5.add(genderField); // 性别文本框
        jp6.add(ageLabel); // 年龄标签
        jp6.add(ageField); // 年龄文本框
        this.add(backButton); // 返回按钮


        // 设置界面布局
        jp.setLayout(new GridLayout(6, 2));
        this.setLayout(new BorderLayout(0,5));

        jp.add(jp1);
        jp.add(jp2);
        jp.add(jp3);
        jp.add(jp4);
        jp.add(jp5);
        jp.add(jp6);
        this.add(jp,BorderLayout.CENTER);
        this.add(backButton,BorderLayout.SOUTH);

        // 设置界面大小
        this.setSize(400, 300);
        // 设置界面可见
        this.setVisible(true);
        // 设置界面关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 添加按钮监听器
        backButton.addActionListener(this);
        // 设置文本框不可编辑
        cardField.setEditable(false);
        balanceField.setEditable(false);
        statusField.setEditable(false);
        nameField.setEditable(false);
        genderField.setEditable(false);
        ageField.setEditable(false);


        // 显示用户医保信息
        System.out.println(card.getName());

        cardField.setText(card.getIdNo());
        balanceField.setText(card.getBalance());
        statusField.setText(card.getStatus());
        nameField.setText(card.getName());
        genderField.setText(card.getSex());
        ageField.setText(card.getAge());
    }

    // 按钮点击事件处理
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取按钮对象
        JButton button = (JButton) e.getSource();
        // 判断按钮类型
        if (button == backButton) {
            // 返回按钮
            // 跳转到个人账户界面
            this.dispose();
            AccountUI accountUI = new AccountUI(user);
            accountUI.setVisible(true);
            // 销毁当前界面
            this.dispose();
        }
    }


//    public static void main(String[] args) {
//        Card card = new Card();
//       InfoUI infoUI = new InfoUI(card);
//       infoUI.setVisible(true);
//    }
}


