
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import service.CardServiceImpl;
import vo.Card;


public class JoinInsuranceView extends JFrame {
    private JTextField idField; // ְ������ı���
    private JTextField nameField; // �����ı���
    private JTextField ageField; // �����ı���
    private JTextField genderField; // �Ա��ı���
    private JTextField cardNoField; // ҽ�������ı���
    private JTextField balanceField; // ҽ��������ı���
    private JTextField statusField; // ҽ����״̬�ı���
    private JButton joinButton; // �뱣��ť
    private JButton cancelButton; // ȡ����ť
    private CardServiceImpl cardServiceImpl; // ҵ���߼�����

    public JoinInsuranceView(String idNo) {
        super("�뱣����");
        this.initComponents();
        this.initListeners(idNo);
        this.cardServiceImpl = new CardServiceImpl();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // ��ʼ�����
    private void initComponents() {
        JLabel idLabel = new JLabel("�� �� �� �ţ�"); // �û���ű�ǩ
        idField = new JTextField(); // ְ������ı���
        JLabel nameLabel = new JLabel("��      ����"); // ������ǩ
        nameField = new JTextField(); // �����ı���
        JLabel ageLabel = new JLabel("��      �䣺"); // �����ǩ
        ageField = new JTextField(); // �����ı���
        JLabel genderLabel = new JLabel("��      ��"); // �Ա��ǩ
        genderField = new JTextField(); // �Ա��ı���
        JLabel cardNoLabel = new JLabel("ҽ �� �� �ţ�"); // ҽ�����ű�ǩ
        cardNoField = new JTextField(); // ҽ�������ı���
        JLabel balanceLabel = new JLabel("ҽ������"); // ҽ��������ǩ
        balanceField = new JTextField(); // ҽ��������ı���
        JLabel statusLabel = new JLabel("ҽ����״̬��"); // ҽ����״̬��ǩ
        statusField = new JTextField(); // ҽ����״̬�ı���
        joinButton = new JButton("��  ��"); // �뱣��ť
        cancelButton = new JButton("��  ��"); // ȡ����ť

        //���Զ�λ
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

        //��������
        Font font = new Font("����", Font.PLAIN, 20);
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

    // ��ʼ��������
    private void initListeners(String idNo) {
        // �뱣��ť�ļ�����
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ��ȡ�û��������Ϣ
                String id = idField.getText();
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = genderField.getText();
                String cardNo = cardNoField.getText();
                String balance = balanceField.getText();
                String status = statusField.getText();
                // �ж��Ƿ�Ϊ��
                if (id.isEmpty() || name.isEmpty() || age.isEmpty() || gender.isEmpty() || cardNo.isEmpty() || balance.isEmpty() || status.isEmpty()) {
                    JOptionPane.showMessageDialog(JoinInsuranceView.this, "����д������Ϣ��");
                    return;
                }
                // ��װ��Ա������
                Card card = new Card();
                card.setStaffNo(id);
                card.setName(name);
                card.setAge(age);
                card.setSex(gender);
                card.setIdNo(cardNo);   //��ֵ
                card.setBalance(balance);
                card.setStatus(status);
                // ����ȷ�Ͽ�
                int choice = JOptionPane.showConfirmDialog(JoinInsuranceView.this, "ȷ���뱣��", "��ʾ", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // ����ҵ���߼�����
                    boolean result = cardServiceImpl.joinInsurance(card);
                    if (result) {
                        JOptionPane.showMessageDialog(JoinInsuranceView.this, "�뱣�ɹ���");
                    } else {
                        JOptionPane.showMessageDialog(JoinInsuranceView.this, "�뱣ʧ�ܣ�");
                    }
                }
            }
        });

        // ȡ����ť�ļ�����
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ����ı���
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
        // ������¼�������
        JoinInsuranceView joinInsuranceView=new JoinInsuranceView("430521200402202859");
        joinInsuranceView.setVisible(true);
    }
}