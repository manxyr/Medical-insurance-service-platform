//// �����˻�����
//// ����ʽ����
//// ��һ����߲���һ��СͼƬ���ұ��ǡ���������ǩ���ı���
//// �ڶ���Ϊ��������Ϣ����ť����ת������Ϊ��������Ϣ"����
//// ������Ϊ��ҩƷ��������롱��ť����ת����Ϊ��ҩƷ���������"����
//// ������Ϊ��̸��ҩƷ�䱸��������ť����ת����Ϊ��̸��ҩƷ�䱸����"����
//// ������Ϊ��ʧ��ť�����˳���¼"��ť
//// ��Java��д��������ṹ��dao��user��service��view��vo��util����д
//
//// ����������Ƶ���
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
//    // �����������
//    private JLabel imageLabel = new JLabel(new ImageIcon("D:\\school\\Java-class\\MI\\medical.jpg")); // СͼƬ
//    private JLabel nameLabel = new JLabel("����"); // ������ǩ
//    private JTextField nameField = new JTextField(); // �����ı���
//    private JButton infoButton = new JButton("������Ϣ"); // ������Ϣ��ť
//    private JButton drugButton = new JButton("ҩƷ���������"); // ҩƷ��������밴ť
//    private JButton negotiateButton = new JButton("̸��ҩƷ�䱸����"); // ̸��ҩƷ�䱸������ť
//    private JButton lossButton = new JButton("��ʧ"); // ��ʧ��ť
//    private JButton logoutButton = new JButton("�˳���¼"); // �˳���¼��ť
//
//    // ����UserService����
//    private UserService userService = new UserService();
//    // ����User����
//    private User user;
//
//    // ���췽��
//    public AccountUI(User user) {
//        // ���ý������
//        super("�����˻�����");
//        this.user = user; // ��ʼ��User����
//        // ���ý��沼��
//        this.setLayout(new GridLayout(5, 1));
//
//
//        // ������
//        JPanel firstPanel = new JPanel(new BorderLayout()); // ��һ�����
//        firstPanel.add(imageLabel, BorderLayout.WEST); // ���ΪСͼƬ
//        JPanel namePanel = new JPanel(new GridLayout(1, 2)); // �������
//        namePanel.add(nameLabel); // ������ǩ
//        namePanel.add(nameField); // �����ı���
//        firstPanel.add(namePanel, BorderLayout.EAST); // �ұ�Ϊ�������
//        this.add(firstPanel); // ��һ��ΪͼƬ���������
//        this.add(infoButton); // �ڶ���Ϊ������Ϣ��ť
//        this.add(drugButton); // ������ΪҩƷ��������밴ť
//        this.add(negotiateButton); // ������Ϊ̸��ҩƷ�䱸������ť
//        JPanel lastPanel = new JPanel(new GridLayout(1, 2)); // ���������
//        lastPanel.add(lossButton); // ��ʧ��ť
//        lastPanel.add(logoutButton); // �˳���¼��ť
//        this.add(lastPanel); // ������Ϊ��ʧ���˳���¼��ť
//        // ���ý����С
//        this.setSize(300, 400);
//        // ���ý���ɼ�
//        this.setVisible(true);
//        // ���ý���رղ���
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        // ���ý������
//        this.setLocationRelativeTo(null);
//        // ��Ӱ�ť������
//        infoButton.addActionListener(this);
//        drugButton.addActionListener(this);
//        negotiateButton.addActionListener(this);
//        lossButton.addActionListener(this);
//        logoutButton.addActionListener(this);
//        // ���������ı��򲻿ɱ༭
//        nameField.setEditable(false);
//        // ��ʾ�û�����
//        nameField.setText(user.getName());
//    }
//
//    // ��ť����¼�����
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // ��ȡ��ť����
//        JButton button = (JButton) e.getSource();
////        User user = new User();
//        Card card = new Card();
//        card.setIdNo(user.getId());
//        System.out.println(user.getId());
//        // �жϰ�ť����
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
//                    // ��ת��������Ϣ����
//                    InfoUI infoUI = new InfoUI(this.user);
//                    // ���ص�ǰ����
//                    this.setVisible(false);
//                } else {
//                    // �����û������ڵ����
//                    JOptionPane.showMessageDialog(this, "�û�������");
//                }
//            } else {
//                // ����IDΪ�յ����
//                JOptionPane.showMessageDialog(this, "������ID");
//            }



// �����˻�����
// ����ʽ����
// ��һ����߲���һ��СͼƬ���ұ��ǡ���������ǩ���ı���
// �ڶ���Ϊ��������Ϣ����ť����ת������Ϊ��������Ϣ"����
// ������Ϊ��ҩƷ��������롱��ť����ת����Ϊ��ҩƷ���������"����
// ������Ϊ��̸��ҩƷ�䱸��������ť����ת����Ϊ��̸��ҩƷ�䱸����"����
// ������Ϊ��ʧ��ť�����˳���¼"��ť
// ��Java��д��������ṹ��dao��user��service��view��vo��util����д

// ����������Ƶ���
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
    // �����������
//    ImageIcon imageIcon = new ImageIcon("images/logo.png");
//    private JLabel imageLabel = new JLabel(imageIcon); // СͼƬ
    private JLabel nameLabel = new JLabel("����"); // ������ǩ
    private JTextField nameField = new JTextField(); // �����ı���
    private JButton infoButton = new JButton("������Ϣ"); // ������Ϣ��ť
    private JButton drugButton = new JButton("ҩƷ���������"); // ҩƷ��������밴ť
    private JButton negotiateButton = new JButton("̸��ҩƷ�䱸����"); // ̸��ҩƷ�䱸������ť
    private JButton lossButton = new JButton("��ʧ"); // ��ʧ��ť
    private JButton logoutButton = new JButton("�˳���¼"); // �˳���¼��ť

    // ����UserService����
    private UserService userService = new UserService();
    // ����CardService����
    private CardServiceImpl cardServiceImpl = new CardServiceImpl();

    // ���췽��
    public AccountUI(User user) {
        // ���ý������
        super("�����˻�����");
        // ���ý��沼��
        this.setLayout(new GridLayout(4, 1));
        // ������
        JPanel firstPanel = new JPanel(new BorderLayout()); // ��һ�����
//        firstPanel.add(imageLabel, BorderLayout.WEST); // ���ΪСͼƬ
        JPanel namePanel = new JPanel(new GridLayout(1, 2)); // �������
        namePanel.add(nameLabel); // ������ǩ
        namePanel.add(nameField); // �����ı���
        firstPanel.add(namePanel, BorderLayout.CENTER); // �ұ�Ϊ�������
        this.add(firstPanel); // ��һ��ΪͼƬ���������
        this.add(infoButton); // �ڶ���Ϊ������Ϣ��ť
        this.add(drugButton); // ������ΪҩƷ��������밴ť
//        this.add(negotiateButton); // ������Ϊ̸��ҩƷ�䱸������ť
        JPanel lastPanel = new JPanel(new GridLayout(1, 2)); // ���������
        lastPanel.add(lossButton); // ��ʧ��ť
        lastPanel.add(logoutButton); // �˳���¼��ť
        this.add(lastPanel); // ������Ϊ��ʧ���˳���¼��ť
        // ����User��������
        this.user = user;

//        this.card = card;//hr add
        // ���ý����С
        this.setSize(400, 300);
        // ���ý���ɼ�
        this.setVisible(true);
        // ���ý���رղ���
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ý������
        this.setLocationRelativeTo(null);
        // ��Ӱ�ť������
        infoButton.addActionListener(this);
        drugButton.addActionListener(this);
        negotiateButton.addActionListener(this);
        lossButton.addActionListener(this);
        logoutButton.addActionListener(this);
        // ���������ı��򲻿ɱ༭
        nameField.setEditable(false);
        // ��ʾ�û�����
        Card card = cardServiceImpl.getCardByUserId(user.getId());
        nameField.setText(card.getName());
//        nameField.setVisible(true);
//        System.out.println(nameField.getText());
    }




    // ��ť����¼�����
    @Override
    public void actionPerformed(ActionEvent e) {
        // ��ȡ��ť����
        JButton button = (JButton) e.getSource();
//        User user = new User();
        // �жϰ�ť����
        if (button == infoButton) {
            // ������Ϣ��ť
            // ��ת��������Ϣ����
            Card card = cardServiceImpl.getCardByUserId(user.getId());
            //InfoUI�Ĳ���Ӧ��ΪCard��
            InfoUI infoUI = new InfoUI(card);
//            System.out.println(card.getIdNo());
//            System.out.println(card.getName());
            // ���ص�ǰ����
            this.setVisible(false);
        } else if (button == drugButton) {
            // ҩƷ��������밴ť
            // ��ת��ҩƷ������������
            DrugView drugView=new DrugView();
            // ���ص�ǰ����
            this.setVisible(false);
        }else if (button == lossButton) {
            // ��ʧ��ť
            // ����ȷ�϶Ի���
            int option = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ��ʧ��", "��ʧȷ��", JOptionPane.YES_NO_OPTION);
            // �ж��û�ѡ��
            if (option == JOptionPane.YES_OPTION) {
                // �û�ѡ����
                // ����UserService�ķ�����ʧ�û�
                userService.lossUser(user.getId());
                // ������ʾ��Ϣ
                JOptionPane.showMessageDialog(this, "��ʧ�ɹ����뼰ʱ��ϵ�ͷ�");
                // �˳���¼
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
            // �˳���¼��ť
            // �����˳���¼����
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

    // �˳���¼����
    private void logout() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // ����ȷ�϶Ի���
        int option = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ�˳���¼��", "�˳���¼ȷ��", JOptionPane.YES_NO_OPTION);
        // �ж��û�ѡ��
        if (option == JOptionPane.YES_OPTION) {
            this.setVisible(false); // ���ص�ǰ����
            LoginUI loginUI = new LoginUI();
            // ��ת����¼���棨����Ҫ�����µ�LoginUI����
            loginUI.getidField().setText(""); // ���ID�ı���
            loginUI.getPasswordField().setText(""); // ��������ı���
            loginUI.setVisible(true); // ��ʾ��¼����
        }
    }
}
