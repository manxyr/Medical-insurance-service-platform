
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.CardServiceImpl;
import vo.Card;


public class JoinInsuranceView extends JFrame {
    private JTextField idField; // 职工编号文本框
    private JTextField nameField; // 姓名文本框
    private JTextField ageField; // 年龄文本框
    private JTextField genderField; // 性别文本框
    private JTextField cardNoField; // 医保卡号文本框
    private JTextField balanceField; // 医保卡余额文本框
    private JTextField statusField; // 医保卡状态文本框
    private JButton joinButton; // 入保按钮
    private JButton cancelButton; // 取消按钮
    private CardServiceImpl cardServiceImpl; // 业务逻辑对象

    public JoinInsuranceView(String idNo) {
        super("入保界面");
        this.initComponents();
        this.initListeners(idNo);
        this.cardServiceImpl = new CardServiceImpl();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // 初始化组件
    private void initComponents() {
        JLabel idLabel = new JLabel("用 户 编 号："); // 用户编号标签
        idField = new JTextField(); // 职工编号文本框
        JLabel nameLabel = new JLabel("姓      名："); // 姓名标签
        nameField = new JTextField(); // 姓名文本框
        JLabel ageLabel = new JLabel("年      龄："); // 年龄标签
        ageField = new JTextField(); // 年龄文本框
        JLabel genderLabel = new JLabel("性      别："); // 性别标签
        genderField = new JTextField(); // 性别文本框
        JLabel cardNoLabel = new JLabel("医 保 卡 号："); // 医保卡号标签
        cardNoField = new JTextField(); // 医保卡号文本框
        JLabel balanceLabel = new JLabel("医保卡余额："); // 医保卡余额标签
        balanceField = new JTextField(); // 医保卡余额文本框
        JLabel statusLabel = new JLabel("医保卡状态："); // 医保卡状态标签
        statusField = new JTextField(); // 医保卡状态文本框
        joinButton = new JButton("入  保"); // 入保按钮
        cancelButton = new JButton("清  空"); // 取消按钮

        //绝对定位
        idLabel.setBounds(225,50,150,40);
        nameLabel.setBounds(225,102,150,40);
        ageLabel.setBounds(225,154,150,40);
        genderLabel.setBounds(225,206,150,40);
        cardNoLabel.setBounds(225,258,150,40);
        balanceLabel.setBounds(225,310,150,40);
        statusLabel.setBounds(225,362,150,40);
        joinButton.setBounds(250,424,100,40);

        idField.setBounds(375,50,200,35);
        nameField.setBounds(375,102,200,35);
        ageField.setBounds(375,154,200,35);
        genderField.setBounds(375,206,200,35);
        cardNoField.setBounds(375,258,200,35);
        balanceField.setBounds(375,310,200,35);
        statusField.setBounds(375,362,200,35);
        cancelButton.setBounds(400,424,100,40);

        this.setLayout(null);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(ageLabel);
        this.add(genderLabel);
        this.add(cardNoLabel);
        this.add(balanceLabel);
        this.add(statusLabel);

        this.add(idField);
        this.add(nameField);
        this.add(ageField);
        this.add(genderField);
        this.add(cardNoField);
        this.add(balanceField);
        this.add(statusField);

        this.add(joinButton);
        this.add(cancelButton);

        //设置字体
        Font font = new Font("宋体", Font.PLAIN, 20);
        idLabel.setFont(font);
        nameLabel.setFont(font);
        ageLabel.setFont(font);
        genderLabel.setFont(font);
        cardNoLabel.setFont(font);
        balanceLabel.setFont(font);
        statusLabel.setFont(font);

        idField.setFont(font);
        nameField.setFont(font);
        ageField.setFont(font);
        genderField.setFont(font);
        cardNoField.setFont(font);
        balanceField.setFont(font);
        statusField.setFont(font);

        joinButton.setFont(font);
        cancelButton.setFont(font);

    }

    // 初始化监听器
    private void initListeners(String idNo) {
        // 入保按钮的监听器
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户输入的信息
                String id = idField.getText();
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = genderField.getText();
                String cardNo = cardNoField.getText();
                String balance = balanceField.getText();
                String status = statusField.getText();
                // 判断是否为空
                if (id.isEmpty() || name.isEmpty() || age.isEmpty() || gender.isEmpty() || cardNo.isEmpty() || balance.isEmpty() || status.isEmpty()) {
                    JOptionPane.showMessageDialog(JoinInsuranceView.this, "请填写完整信息！");
                    return;
                }
                // 封装成员工对象
                Card card = new Card();
                card.setStaffNo(id);
                card.setName(name);
                card.setAge(age);
                card.setSex(gender);
                card.setIdNo(cardNo);   //传值
                card.setBalance(balance);
                card.setStatus(status);
                // 弹出确认框
                int choice = JOptionPane.showConfirmDialog(JoinInsuranceView.this, "确认入保吗？", "提示", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // 调用业务逻辑方法
                    boolean result = cardServiceImpl.joinInsurance(card);
                    if (result) {
                        JOptionPane.showMessageDialog(JoinInsuranceView.this, "入保成功！");
                    } else {
                        JOptionPane.showMessageDialog(JoinInsuranceView.this, "入保失败！");
                    }
                }
            }
        });

        // 取消按钮的监听器
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空文本框
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                genderField.setText("");
                balanceField.setText("");
                statusField.setText("");
            }
        });
    }

    public static void main(String[] args)  {
        // 创建登录界面对象
        JoinInsuranceView joinInsuranceView=new JoinInsuranceView("430521200402202859");
        joinInsuranceView.setVisible(true);
    }
}