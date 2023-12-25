// ����������Ƶ���
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.CardServiceImpl;
import service.LoginService;
import vo.User;

public class LoginUI extends JFrame implements ActionListener {
    // �����������
    private JLabel titleLabel = new JLabel("�ǻ�ҽ����");
    private JLabel idLabel = new JLabel("���֤");
    private JTextField idField = new JTextField();
    private JLabel passwordLabel = new JLabel("����");
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("��¼");
    private JButton registerButton = new JButton("ע��");
//
    // ����LoginService����
    private LoginService loginService = new LoginService();

    private CardServiceImpl cardServiceImpl = new CardServiceImpl();

    Font font = new Font("����", Font.PLAIN, 20);

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
            this.setTitle("�ǻ�ҽ����\n��¼����");
            this.setSize(600, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel idLabel = new JLabel("���֤�ţ�");
            JLabel passwordLabel = new JLabel("��   �룺");
            idLabel.setFont(font);
            passwordLabel.setFont(font);

            idField = new JTextField();
            passwordField = new JPasswordField();
            idField.setFont(font);
            passwordField.setFont(font);

            JButton loginButton = new JButton("��¼");
            JButton registerButton = new JButton("ע��");
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


        // ��Ӱ�ť������
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
    }
    // ��ť����¼�����
    @Override
    public void actionPerformed(ActionEvent e) {

        // �жϰ�ť����
        if (e.getActionCommand().equals("��¼")) {
            // ��¼��ť
            // ��ȡ���֤������
            String id = idField.getText();
            String password = new String(passwordField.getPassword());
            // ��֤���֤������
            User user = loginService.checkUser(id,password);
            // �ж��û�
            if (user == null) {
                // �û������ڻ��������
                JOptionPane.showMessageDialog(this, "�û������ڻ��������\n    �����������ע��");

            } else if (user.getUserType().trim().equals("user")) {
                // �û���
                System.out.println("��¼�ɹ�����ӭ�û�" + id);

                JOptionPane.showMessageDialog(this, "��¼�ɹ�����ӭ�û�" + id);
                // ��ת���û�����
                AccountUI accountUI = new AccountUI(user);
                accountUI.setVisible(true); // ��ʾ�����˻�����
                accountUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.dispose();
            } else if (user.getUserType().trim().equals("admin")) {
                // ����Ա��
                JOptionPane.showMessageDialog(this, "��¼�ɹ�����ӭ����Ա" + id);
                // ��ת������Ա����
                CardView cardView = new CardView();
                this.dispose();
            }
        } else if (e.getActionCommand().equals("ע��")) {
            // ע�ᰴť
            // ��ת��ע�����
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


    // ������
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // ������¼�������
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);

    }
}