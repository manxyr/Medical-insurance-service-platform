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
    // �����������
    private JLabel cardLabel = new JLabel("ҽ������"); // ҽ�����ű�ǩ
    private JTextField cardField = new JTextField(); // ҽ�������ı���
    private JLabel balanceLabel = new JLabel("ҽ�������"); // ҽ��������ǩ
    private JTextField balanceField = new JTextField(); // ҽ��������ı���
    private JLabel statusLabel = new JLabel("ҽ����״̬"); // ҽ����״̬��ǩ
    private JTextField statusField = new JTextField(); // ҽ����״̬�ı���
    private JLabel nameLabel = new JLabel("����"); // ������ǩ
    private JTextField nameField = new JTextField(); // �����ı���
    private JLabel genderLabel = new JLabel("�Ա�"); // �Ա��ǩ
    private JTextField genderField = new JTextField(); // �Ա��ı���
    private JLabel ageLabel = new JLabel("����"); // �����ǩ
    private JTextField ageField = new JTextField(); // �����ı���
    private JButton backButton = new JButton("����"); // ���ذ�ť


    private JPanel jp  = new JPanel();
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private JPanel jp5 = new JPanel();
    private JPanel jp6 = new JPanel();

    // ����InfoService����
    private InfoService infoService = new InfoService();
    private UserService userService = new UserService();

    // ���췽��
    public InfoUI(Card card) {
        // ���ý������
//        super("ְ��ҽ��������Ϣ����");
        this.user=userService.getCardByUserId(card.getIdNo());


        // ���ñ�ǩ���ı���Ĵ�С
        Dimension labelSize = new Dimension(100, 30);
        Dimension fieldSize = new Dimension(200, 30);

        // ���ñ�ǩ��С
        cardLabel.setPreferredSize(labelSize);
        balanceLabel.setPreferredSize(labelSize);
        statusLabel.setPreferredSize(labelSize);
        nameLabel.setPreferredSize(labelSize);
        genderLabel.setPreferredSize(labelSize);
        ageLabel.setPreferredSize(labelSize);

        // �����ı����С
        cardField.setPreferredSize(fieldSize);
        balanceField.setPreferredSize(fieldSize);
        statusField.setPreferredSize(fieldSize);
        nameField.setPreferredSize(fieldSize);
        genderField.setPreferredSize(fieldSize);
        ageField.setPreferredSize(fieldSize);


        // ������
        jp1.add(cardLabel); // ҽ�����ű�ǩ
        jp1.add(cardField); // ҽ�������ı���
        jp2.add(balanceLabel); // ҽ��������ǩ
        jp2.add(balanceField); // ҽ��������ı���
        jp3.add(statusLabel); // ҽ����״̬��ǩ
        jp3.add(statusField); // ҽ����״̬�ı���
        jp4.add(nameLabel); // ������ǩ
        jp4.add(nameField); // �����ı���
        jp5.add(genderLabel); // �Ա��ǩ
        jp5.add(genderField); // �Ա��ı���
        jp6.add(ageLabel); // �����ǩ
        jp6.add(ageField); // �����ı���
        this.add(backButton); // ���ذ�ť


        // ���ý��沼��
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

        // ���ý����С
        this.setSize(400, 300);
        // ���ý���ɼ�
        this.setVisible(true);
        // ���ý���رղ���
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ý������
        this.setLocationRelativeTo(null);
        // ��Ӱ�ť������
        backButton.addActionListener(this);
        // �����ı��򲻿ɱ༭
        cardField.setEditable(false);
        balanceField.setEditable(false);
        statusField.setEditable(false);
        nameField.setEditable(false);
        genderField.setEditable(false);
        ageField.setEditable(false);


        // ��ʾ�û�ҽ����Ϣ
        System.out.println(card.getName());

        cardField.setText(card.getIdNo());
        balanceField.setText(card.getBalance());
        statusField.setText(card.getStatus());
        nameField.setText(card.getName());
        genderField.setText(card.getSex());
        ageField.setText(card.getAge());
    }

    // ��ť����¼�����
    @Override
    public void actionPerformed(ActionEvent e) {
        // ��ȡ��ť����
        JButton button = (JButton) e.getSource();
        // �жϰ�ť����
        if (button == backButton) {
            // ���ذ�ť
            // ��ת�������˻�����
            this.dispose();
            AccountUI accountUI = new AccountUI(user);
            accountUI.setVisible(true);
            // ���ٵ�ǰ����
            this.dispose();
        }
    }


//    public static void main(String[] args) {
//        Card card = new Card();
//       InfoUI infoUI = new InfoUI(card);
//       infoUI.setVisible(true);
//    }
}


