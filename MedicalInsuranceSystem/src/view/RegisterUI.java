package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import service.UserService;
import vo.User;


public class RegisterUI extends JFrame implements ActionListener {
    JButton jb1 = new JButton("ע��");
    JButton jb2 = new JButton("ȡ��");
    JLabel jl1 = new JLabel("���֤�ţ�");
    JLabel jl2 = new JLabel("��   �룺");
    JLabel jl3 = new JLabel("ȷ�����룺");
    JTextField jft1 = new JTextField(20);
    JPasswordField jft2 = new JPasswordField(20);
    JPasswordField jft3 = new JPasswordField(20);
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    //��������
    Font font = new Font("����", Font.PLAIN, 20);

    public RegisterUI() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// ������ۣ����쳣
        this.setLayout(new GridLayout(6, 1));
        this.setSize(600, 400);
        this.setTitle("�˻�ע��");
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
        //��������
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
        if (e.getActionCommand().equals("ע��")) {
            if (!jl1.getText().equals("") && !jft2.getText().trim().equals("") && !jft3.getText().trim().equals("")) {//���ж��ǳơ������ȷ�������Ƿ�Ϊ��
                //trim()��������ɾ���ַ���ǰ��Ŀո�
                if (!jft2.getText().trim().equals(jft3.getText().trim())) {//�ж������ȷ�������Ƿ�һ��
                    JOptionPane.showMessageDialog(null, "�����ȷ�����벻һ��", "�������", JOptionPane.ERROR_MESSAGE);
                    jft3.setText("");//����ȷ������������Ϊ��
                    jft3.requestFocus();//��ȡ��꣬�ı�����Ϊ���뽹�㣬�����û���������
                    return;
                }
                if (jft1.getText().trim().length() != 18) {
                    JOptionPane.showMessageDialog(null, "���֤��������", "�������", JOptionPane.ERROR_MESSAGE);
                    jft1.setText("");//����ȷ������������Ϊ��
                    jft1.requestFocus();//��ȡ��꣬�ı�����Ϊ���뽹�㣬�����û���������
                    return;
                }
                //ȥ���ݿ��н���ע�ᣬע��ɹ�������ʾ��˳����ת����¼���棡��
                //�������ݿ��������
                User user = new User();
                user.setPassword(jft2.getText());
                user.setId(jft1.getText());
                user.setUserType("user");

                try {
                    if (us.exsitUser(jft1.getText())) {
                        //��ʾ�Ѿ������û���
                        JOptionPane.showMessageDialog(null, "���û��Ѵ��ڣ������ظ�ע��", "�ظ�ע��",
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
                        JOptionPane.showMessageDialog(null, "�û�ע��ɹ�������", "ע��ɹ�",
                                JOptionPane.INFORMATION_MESSAGE);
                        //�����ɹ����ܷ���ת��¼����
                        this.dispose();//������ָ����ͼ�ν�����Դ��������Ӱ��������Դ,����ʹ��pack()��show()�����ָ������ҿ��Իָ���disposeǰ��״̬
                        LoginUI loginUI = null;
                        try {
                            loginUI = new LoginUI();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (InstantiationException instantiationException) {//ʵ�����쳣����ʾ�޷���������
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
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ� �����������룡", "����",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getActionCommand().equals("ȡ��")) {
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
        // ������¼�������
          RegisterUI registerUI=new RegisterUI();
    }
}


