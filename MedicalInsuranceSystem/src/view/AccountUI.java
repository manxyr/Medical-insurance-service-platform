//// 个人账户界面
//// 五行式布局
//// 第一行左边插入一张小图片，右边是“姓名“标签和文本框
//// 第二行为“基本信息”按钮，跳转到标题为“基本信息"界面
//// 第三行为“药品分类与代码”按钮，跳转标题为“药品分类与代码"界面
//// 第四行为“谈判药品配备机构”按钮，跳转标题为“谈判药品配备机构"界面
//// 第五行为挂失按钮及“退出登录"按钮
//// 用Java编写，按三层结构分dao，user，service，view，vo，util包编写
//
//// 包含界面设计的类
//package view;
//
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//import service.InfoService;
//import service.UserService;
//import vo.Card;
//import vo.User;
//
//public class AccountUI extends JFrame implements ActionListener {
//    // 创建界面组件
//    private JLabel imageLabel = new JLabel(new ImageIcon("D:\\school\\Java-class\\MI\\medical.jpg")); // 小图片
//    private JLabel nameLabel = new JLabel("姓名"); // 姓名标签
//    private JTextField nameField = new JTextField(); // 姓名文本框
//    private JButton infoButton = new JButton("基本信息"); // 基本信息按钮
//    private JButton drugButton = new JButton("药品分类与代码"); // 药品分类与代码按钮
//    private JButton negotiateButton = new JButton("谈判药品配备机构"); // 谈判药品配备机构按钮
//    private JButton lossButton = new JButton("挂失"); // 挂失按钮
//    private JButton logoutButton = new JButton("退出登录"); // 退出登录按钮
//
//    // 创建UserService对象
//    private UserService userService = new UserService();
//    // 创建User对象
//    private User user;
//
//    // 构造方法
//    public AccountUI(User user) {
//        // 设置界面标题
//        super("个人账户界面");
//        this.user = user; // 初始化User对象
//        // 设置界面布局
//        this.setLayout(new GridLayout(5, 1));
//
//
//        // 添加组件
//        JPanel firstPanel = new JPanel(new BorderLayout()); // 第一行面板
//        firstPanel.add(imageLabel, BorderLayout.WEST); // 左边为小图片
//        JPanel namePanel = new JPanel(new GridLayout(1, 2)); // 姓名面板
//        namePanel.add(nameLabel); // 姓名标签
//        namePanel.add(nameField); // 姓名文本框
//        firstPanel.add(namePanel, BorderLayout.EAST); // 右边为姓名面板
//        this.add(firstPanel); // 第一行为图片和姓名面板
//        this.add(infoButton); // 第二行为基本信息按钮
//        this.add(drugButton); // 第三行为药品分类与代码按钮
//        this.add(negotiateButton); // 第四行为谈判药品配备机构按钮
//        JPanel lastPanel = new JPanel(new GridLayout(1, 2)); // 第五行面板
//        lastPanel.add(lossButton); // 挂失按钮
//        lastPanel.add(logoutButton); // 退出登录按钮
//        this.add(lastPanel); // 第五行为挂失和退出登录按钮
//        // 设置界面大小
//        this.setSize(300, 400);
//        // 设置界面可见
//        this.setVisible(true);
//        // 设置界面关闭操作
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        // 设置界面居中
//        this.setLocationRelativeTo(null);
//        // 添加按钮监听器
//        infoButton.addActionListener(this);
//        drugButton.addActionListener(this);
//        negotiateButton.addActionListener(this);
//        lossButton.addActionListener(this);
//        logoutButton.addActionListener(this);
//        // 设置姓名文本框不可编辑
//        nameField.setEditable(false);
//        // 显示用户姓名
//        nameField.setText(user.getName());
//    }
//
//    // 按钮点击事件处理
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // 获取按钮对象
//        JButton button = (JButton) e.getSource();
////        User user = new User();
//        Card card = new Card();
//        card.setIdNo(user.getId());
//        System.out.println(user.getId());
//        // 判断按钮类型
//        if (button == infoButton) {
//            String id = null;
//            try {
//                id = new LoginUI().getidFieldText();
//            } catch (ClassNotFoundException ex) {
//                throw new RuntimeException(ex);
//            } catch (InstantiationException ex) {
//                throw new RuntimeException(ex);
//            } catch (IllegalAccessException ex) {
//                throw new RuntimeException(ex);
//            } catch (UnsupportedLookAndFeelException ex) {
//                throw new RuntimeException(ex);
//            }
//            if (id != null && !id.isEmpty()) {
//                user = InfoService.getUserInfo(id);
//                if (user != null) {
//                    card.setIdNo(user.getId());
//                    // 跳转到基本信息界面
//                    InfoUI infoUI = new InfoUI(this.user);
//                    // 隐藏当前界面
//                    this.setVisible(false);
//                } else {
//                    // 处理用户不存在的情况
//                    JOptionPane.showMessageDialog(this, "用户不存在");
//                }
//            } else {
//                // 处理ID为空的情况
//                JOptionPane.showMessageDialog(this, "请输入ID");
//            }



// 个人账户界面
// 五行式布局
// 第一行左边插入一张小图片，右边是“姓名“标签和文本框
// 第二行为“基本信息”按钮，跳转到标题为“基本信息"界面
// 第三行为“药品分类与代码”按钮，跳转标题为“药品分类与代码"界面
// 第四行为“谈判药品配备机构”按钮，跳转标题为“谈判药品配备机构"界面
// 第五行为挂失按钮及“退出登录"按钮
// 用Java编写，按三层结构分dao，user，service，view，vo，util包编写

// 包含界面设计的类
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.CardServiceImpl;
import service.UserService;
import vo.Card;
import vo.User;

public class AccountUI extends JFrame implements ActionListener {
    private User user;
    private  Card card;
    // 创建界面组件
//    ImageIcon imageIcon = new ImageIcon("images/logo.png");
//    private JLabel imageLabel = new JLabel(imageIcon); // 小图片
    private JLabel nameLabel = new JLabel("姓名"); // 姓名标签
    private JTextField nameField = new JTextField(); // 姓名文本框
    private JButton infoButton = new JButton("基本信息"); // 基本信息按钮
    private JButton drugButton = new JButton("药品分类与代码"); // 药品分类与代码按钮
    private JButton negotiateButton = new JButton("谈判药品配备机构"); // 谈判药品配备机构按钮
    private JButton lossButton = new JButton("挂失"); // 挂失按钮
    private JButton logoutButton = new JButton("退出登录"); // 退出登录按钮

    // 创建UserService对象
    private UserService userService = new UserService();
    // 创建CardService对象
    private CardServiceImpl cardServiceImpl = new CardServiceImpl();

    // 构造方法
    public AccountUI(User user) {
        // 设置界面标题
        super("个人账户界面");
        // 设置界面布局
        this.setLayout(new GridLayout(4, 1));
        // 添加组件
        JPanel firstPanel = new JPanel(new BorderLayout()); // 第一行面板
//        firstPanel.add(imageLabel, BorderLayout.WEST); // 左边为小图片
        JPanel namePanel = new JPanel(new GridLayout(1, 2)); // 姓名面板
        namePanel.add(nameLabel); // 姓名标签
        namePanel.add(nameField); // 姓名文本框
        firstPanel.add(namePanel, BorderLayout.CENTER); // 右边为姓名面板
        this.add(firstPanel); // 第一行为图片和姓名面板
        this.add(infoButton); // 第二行为基本信息按钮
        this.add(drugButton); // 第三行为药品分类与代码按钮
//        this.add(negotiateButton); // 第四行为谈判药品配备机构按钮
        JPanel lastPanel = new JPanel(new GridLayout(1, 2)); // 第五行面板
        lastPanel.add(lossButton); // 挂失按钮
        lastPanel.add(logoutButton); // 退出登录按钮
        this.add(lastPanel); // 第五行为挂失和退出登录按钮
        // 保存User对象到属性
        this.user = user;

//        this.card = card;//hr add
        // 设置界面大小
        this.setSize(400, 300);
        // 设置界面可见
        this.setVisible(true);
        // 设置界面关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 添加按钮监听器
        infoButton.addActionListener(this);
        drugButton.addActionListener(this);
        negotiateButton.addActionListener(this);
        lossButton.addActionListener(this);
        logoutButton.addActionListener(this);
        // 设置姓名文本框不可编辑
        nameField.setEditable(false);
        // 显示用户姓名
        Card card = cardServiceImpl.getCardByUserId(user.getId());
        nameField.setText(card.getName());
//        nameField.setVisible(true);
//        System.out.println(nameField.getText());
    }




    // 按钮点击事件处理
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取按钮对象
        JButton button = (JButton) e.getSource();
//        User user = new User();
        // 判断按钮类型
        if (button == infoButton) {
            // 基本信息按钮
            // 跳转到基本信息界面
            Card card = cardServiceImpl.getCardByUserId(user.getId());
            //InfoUI的参数应该为Card了
            InfoUI infoUI = new InfoUI(card);
//            System.out.println(card.getIdNo());
//            System.out.println(card.getName());
            // 隐藏当前界面
            this.setVisible(false);
        } else if (button == drugButton) {
            // 药品分类与代码按钮
            // 跳转到药品分类与代码界面
            DrugView drugView=new DrugView();
            // 隐藏当前界面
            this.setVisible(false);
        }else if (button == lossButton) {
            // 挂失按钮
            // 弹出确认对话框
            int option = JOptionPane.showConfirmDialog(this, "您确定要挂失吗？", "挂失确认", JOptionPane.YES_NO_OPTION);
            // 判断用户选择
            if (option == JOptionPane.YES_OPTION) {
                // 用户选择是
                // 调用UserService的方法挂失用户
                userService.lossUser(user.getId());
                // 弹出提示信息
                JOptionPane.showMessageDialog(this, "挂失成功，请及时联系客服");
                // 退出登录
                try {
                    logout();
                } catch (UnsupportedLookAndFeelException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (button == logoutButton) {
            // 退出登录按钮
            // 调用退出登录方法
            try {
                logout();
            } catch (UnsupportedLookAndFeelException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    // 退出登录方法
    private void logout() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 弹出确认对话框
        int option = JOptionPane.showConfirmDialog(this, "您确定要退出登录吗？", "退出登录确认", JOptionPane.YES_NO_OPTION);
        // 判断用户选择
        if (option == JOptionPane.YES_OPTION) {
            this.setVisible(false); // 隐藏当前界面
            LoginUI loginUI = new LoginUI();
            // 跳转到登录界面（不需要创建新的LoginUI对象）
            loginUI.getidField().setText(""); // 清空ID文本框
            loginUI.getPasswordField().setText(""); // 清空密码文本框
            loginUI.setVisible(true); // 显示登录界面
        }
    }
}
