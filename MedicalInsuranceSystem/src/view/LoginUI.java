// 包含界面设计的类
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.CardServiceImpl;
import service.LoginService;
import vo.User;

public class LoginUI extends JFrame implements ActionListener {
    // 创建界面组件
    private JLabel titleLabel = new JLabel("智慧医保屋");
    private JLabel idLabel = new JLabel("身份证");
    private JTextField idField = new JTextField();
    private JLabel passwordLabel = new JLabel("密码");
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("登录");
    private JButton registerButton = new JButton("注册");
//
    // 创建LoginService对象
    private LoginService loginService = new LoginService();

    private CardServiceImpl cardServiceImpl = new CardServiceImpl();

    Font font = new Font("宋体", Font.PLAIN, 20);

    public  JTextField getidField() {
        return idField;
    }

    public  JPasswordField getPasswordField() {
        return passwordField;
    }

    public String getidFieldText() {
        return idField.getText();
    }
    public LoginUI() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            this.setLayout(null);
            this.setTitle("智慧医保屋\n登录界面");
            this.setSize(600, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel idLabel = new JLabel("身份证号：");
            JLabel passwordLabel = new JLabel("密   码：");
            idLabel.setFont(font);
            passwordLabel.setFont(font);

            idField = new JTextField();
            passwordField = new JPasswordField();
            idField.setFont(font);
            passwordField.setFont(font);

            JButton loginButton = new JButton("登录");
            JButton registerButton = new JButton("注册");
            loginButton.setFont(font);
            registerButton.setFont(font);

            idLabel.setBounds(100, 40, 150, 30);
            idField.setBounds(200, 40, 200, 30);
            passwordLabel.setBounds(100, 90, 150, 30);
            passwordField.setBounds(200, 90, 200, 30);
            loginButton.setBounds(120, 170, 100, 30);
            registerButton.setBounds(280, 170, 100, 30);

            this.add(idLabel);
            this.add(idField);
            this.add(passwordLabel);
            this.add(passwordField);
            this.add(loginButton);
            this.add(registerButton);


        // 添加按钮监听器
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
    }
    // 按钮点击事件处理
    @Override
    public void actionPerformed(ActionEvent e) {

        // 判断按钮类型
        if (e.getActionCommand().equals("登录")) {
            // 登录按钮
            // 获取身份证和密码
            String id = idField.getText();
            String password = new String(passwordField.getPassword());
            // 验证身份证和密码
            User user = loginService.checkUser(id,password);
            // 判断用户
            if (user == null) {
                // 用户不存在或密码错误
                JOptionPane.showMessageDialog(this, "用户不存在或密码错误\n    请重新输入或注册");

            } else if (user.getUserType().trim().equals("user")) {
                // 用户端
                System.out.println("登录成功，欢迎用户" + id);

                JOptionPane.showMessageDialog(this, "登录成功，欢迎用户" + id);
                // 跳转到用户界面
                AccountUI accountUI = new AccountUI(user);
                accountUI.setVisible(true); // 显示个人账户界面
                accountUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.dispose();
            } else if (user.getUserType().trim().equals("admin")) {
                // 管理员端
                JOptionPane.showMessageDialog(this, "登录成功，欢迎管理员" + id);
                // 跳转到管理员界面
                CardView cardView = new CardView();
                this.dispose();
            }
        } else if (e.getActionCommand().equals("注册")) {
            // 注册按钮
            // 跳转到注册界面
            try {
                RegisterUI registerUI = new RegisterUI();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedLookAndFeelException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }
    }


    // 主方法
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 创建登录界面对象
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);

    }
}