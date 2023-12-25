package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import service.UserService;
import vo.User;


public class RegisterUI extends JFrame implements ActionListener {
    JButton jb1 = new JButton("注册");
    JButton jb2 = new JButton("取消");
    JLabel jl1 = new JLabel("身份证号：");
    JLabel jl2 = new JLabel("密   码：");
    JLabel jl3 = new JLabel("确认密码：");
    JTextField jft1 = new JTextField(20);
    JPasswordField jft2 = new JPasswordField(20);
    JPasswordField jft3 = new JPasswordField(20);
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    //设置字体
    Font font = new Font("宋体", Font.PLAIN, 20);

    public RegisterUI() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// 设置外观，抛异常
        this.setLayout(new GridLayout(6, 1));
        this.setSize(600, 400);
        this.setTitle("账户注册");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jp1.add(jl1);
        jp1.add(jft1);
        jp2.add(jl2);
        jp2.add(jft2);
        jp3.add(jl3);
        jp3.add(jft3);
        jp4.add(jb1);
        jp4.add(jb2);
        this.add(new JLabel());
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(new Label());
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        //设置字体
        jb1.setFont(font);
        jl1.setFont(font);
        jft1.setFont(font);
        jb2.setFont(font);
        jl2.setFont(font);
        jft2.setFont(font);
        jl3.setFont(font);
        jft3.setFont(font);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserService us = new UserService();
        if (e.getActionCommand().equals("注册")) {
            if (!jl1.getText().equals("") && !jft2.getText().trim().equals("") && !jft3.getText().trim().equals("")) {//先判断昵称、密码和确认密码是否为空
                //trim()函数用来删除字符串前后的空格
                if (!jft2.getText().trim().equals(jft3.getText().trim())) {//判断密码和确认密码是否一致
                    JOptionPane.showMessageDialog(null, "密码和确认密码不一致", "密码错误", JOptionPane.ERROR_MESSAGE);
                    jft3.setText("");//设置确认密码的输入框为空
                    jft3.requestFocus();//获取光标，文本框会成为输入焦点，方便用户进行输入
                    return;
                }
                if (jft1.getText().trim().length() != 18) {
                    JOptionPane.showMessageDialog(null, "身份证输入有误", "密码错误", JOptionPane.ERROR_MESSAGE);
                    jft1.setText("");//设置确认密码的输入框为空
                    jft1.requestFocus();//获取光标，文本框会成为输入焦点，方便用户进行输入
                    return;
                }
                //去数据库中进行注册，注册成功进行提示，顺便跳转到登录界面！！
                //进行数据库操作！！
                User user = new User();
                user.setPassword(jft2.getText());
                user.setId(jft1.getText());
                user.setUserType("user");

                try {
                    if (us.exsitUser(jft1.getText())) {
                        //提示已经存在用户！
                        JOptionPane.showMessageDialog(null, "该用户已存在，请勿重复注册", "重复注册",
                                JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        LoginUI loginUI = null;
                        try {
                            loginUI = new LoginUI();
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (InstantiationException ex) {
                            throw new RuntimeException(ex);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        } catch (UnsupportedLookAndFeelException ex) {
                            throw new RuntimeException(ex);
                        }
                        loginUI.setVisible(true);
                    } else {
                        us.userRegistered(user);
                        JOptionPane.showMessageDialog(null, "用户注册成功！！！", "注册成功",
                                JOptionPane.INFORMATION_MESSAGE);
                        //创建成功看能否跳转登录界面
                        this.dispose();//会销毁指定的图形界面资源，但不会影响数据资源,可以使用pack()或show()方法恢复，并且可以恢复到dispose前的状态
                        LoginUI loginUI = null;
                        try {
                            loginUI = new LoginUI();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (InstantiationException instantiationException) {//实例化异常，表示无法创建对象
                            instantiationException.printStackTrace();
                        } catch (IllegalAccessException illegalAccessException) {
                            illegalAccessException.printStackTrace();
                        } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                            unsupportedLookAndFeelException.printStackTrace();
                        }
                        loginUI.setVisible(true);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码不能为空！ ，请重新输入！", "错误",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getActionCommand().equals("取消")) {
            this.dispose();
            try {
                LoginUI loginUI = new LoginUI();
                loginUI.setVisible(true);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedLookAndFeelException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 创建登录界面对象
          RegisterUI registerUI=new RegisterUI();
    }
}


