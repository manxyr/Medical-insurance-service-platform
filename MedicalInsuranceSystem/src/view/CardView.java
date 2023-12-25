package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.TableColumn;

import service.CardServiceImpl;
import vo.Card;

//����ҽ����������࣬�̳�JFrame
public class CardView extends JFrame {
    //�������
    private JLabel labelIdNo; //���֤�ű�ǩ
    private JTextField textIdNo; //���֤���ı���
    private JButton buttonQuery; //��ѯ��ť
    private JLabel labelTime; //��¼ʱ���ǩ
    private JTable table; //���
    private Vector<String> columnNames; // ��������
    private Vector<Vector<Object>> data; // ��������
    private JButton buttonRefresh; //ˢ�°�ť
    private JButton buttonJoin; //�뱣��ť
    private JButton buttonQuit; //�˱���ť
    private JButton buttonReportLoss; //��ʧ��ť

    //����ҵ���߼�����,����CardServiceImpl����
    private CardServiceImpl cardServiceImpl = new CardServiceImpl();

    //���幹�췽��
    public CardView() {
        //���ô������
        this.setTitle("ҽ���������");
        //���ô����С
        this.setSize(1280, 720);
        //���ô������
        this.setLocationRelativeTo(null);
        //���ô���رշ�ʽ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //��ʼ�����
        this.initComponents();
        //����¼�������
        this.addListeners();
        //���ô���ɼ�
        this.setVisible(true);
    }

    //��ʼ������ķ���
    private void initComponents() {
        //�������֤�ű�ǩ
        labelIdNo = new JLabel("���������֤�ţ�");
        //�������֤���ı���
        textIdNo = new JTextField(20);
        //������ѯ��ť
        buttonQuery = new JButton("��ѯ");
        //������¼ʱ���ǩ
        labelTime = new JLabel("��¼ʱ�䣺" + getCurrentTime());
        //����һ����壬���ڷ����������
        JPanel panelTop = new JPanel();
        //�������ӵ����
        panelTop.add(labelIdNo);
        panelTop.add(textIdNo);
        panelTop.add(buttonQuery);
        panelTop.add(labelTime);
        //�������ӵ�����ı���
        this.add(panelTop, BorderLayout.NORTH);


//Ĭ��ʹ��buttonRefreshˢ�£���ʼ�������Ѿ�����
        // ��ʼ����������
        columnNames = new Vector<>();
        columnNames.add("ְ�����");
        columnNames.add("����");
        columnNames.add("����");
        columnNames.add("�Ա�");
        columnNames.add("ҽ������");
        columnNames.add("ҽ�������");
        columnNames.add("ҽ����״̬");
        // ��ʼ����������
        data = new Vector<>();
        // ��ʼ�����
        table = new JTable(data, columnNames);
        //����JTable����Ĭ�ϵĿ�Ⱥ͸߶�
        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = table.getColumnModel().getColumn(i);
            /*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
            column.setPreferredWidth(274);
        }

        //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // ���ñ���п����϶�
        table.getTableHeader().setResizingAllowed(false);
        //���ñ�񲻿ɱ༭
        table.setEnabled(false);
        // ���ñ���п�����������
        table.getTableHeader().setReorderingAllowed(false);




        //����һ��������壬���ڷ��ñ��
        JScrollPane scrollPane = new JScrollPane(table);
        // ���ù�������ˮƽ����ֱ������������ʾ
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //�����������ӵ�������м�
        this.add(scrollPane, BorderLayout.CENTER);

        //����ˢ�°�ť
        buttonRefresh = new JButton("ˢ  ��");
        //�����뱣��ť
        buttonJoin = new JButton("��  ��");
        //�����˱���ť
        buttonQuit = new JButton("��  ��");
        //������ʧ��ť
        buttonReportLoss = new JButton("��  ʧ");
        //����һ����壬���ڷ����������
        JPanel panelBottom = new JPanel();
        //�������ӵ����
        panelBottom.add(buttonRefresh);
        panelBottom.add(buttonJoin);
        panelBottom.add(buttonQuit);
        panelBottom.add(buttonReportLoss);
        //�������ӵ�������ϱ�
        this.add(panelBottom, BorderLayout.SOUTH);
        //ˢ��ҽ�����������
        refreshTable();
    }

    //����¼��������ķ���
    private void addListeners() {
        //Ϊ��ѯ��ť����¼�������
        buttonQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��ȡ���֤��
                String idNo = textIdNo.getText().trim();
//                System.out.print(idNo);   �������֤�Ż�ȡ�ɹ�
                if (idNo.isEmpty()) {
                    //������֤��Ϊ�գ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���������֤��");
                    return;
                }
                //�������֤�Ų�ѯҽ������Ϣ
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //���ҽ������Ϣ���ڣ�������ʾ�ڱ����
//                    showCard(card);
                    // ����ҵ���߼�����������ҩƷ���������ģ����ѯҩƷ�б�
                    List<Card> list = cardServiceImpl.queryCard(card.getIdNo());
                    // ��ҽ�����б�ת��Ϊ��������
                    data = listToVector(list);
                    // ���±�������ģ��
                    table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                    //����JTable����Ĭ�ϵĿ�Ⱥ͸߶�
                    TableColumn column = null;
                    int colunms = table.getColumnCount();
                    for(int i = 0; i < colunms; i++)
                    {
                        column = table.getColumnModel().getColumn(i);
                        /*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
                        column.setPreferredWidth(270);
                    }

                    //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                } else {
                    //���ҽ������Ϣ�����ڣ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���û�û��ҽ������Ϣ");
                }
            }
        });

        //Ϊˢ�°�ť����¼�������
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ˢ������card��¼
                refreshTable();
            }
        });


        //Ϊ�뱣��ť����¼�������
        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��ȡ���֤��
                String idNo = textIdNo.getText().trim();
                if (idNo.isEmpty()) {
                    //������֤��Ϊ�գ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���������֤��");
                    return;
                }
                //�������֤�Ų�ѯҽ������Ϣ
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //���ҽ������Ϣ�Ѿ����ڣ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���û��Ѿ��뱣�������ظ�����");
                } else {
                    String idNo2 = textIdNo.getText().trim();
                    //���ҽ������Ϣ�����ڣ����뱣����
                    JoinInsuranceView joinInsuranceView=new JoinInsuranceView(idNo2);
                }
            }
        });

        //Ϊ�˱���ť����¼�������
        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��ȡ���֤��
                String idNo = textIdNo.getText().trim();
                if (idNo.isEmpty()) {
                    //������֤��Ϊ�գ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���������֤��");
                    return;
                }
                //�������֤�Ų�ѯҽ������Ϣ
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //���ҽ������Ϣ���ڣ�����ȷ�Ͽ�
                    int choice = JOptionPane.showConfirmDialog(CardView.this, "ȷ��Ҫ�˱���");
                    if (choice == JOptionPane.YES_OPTION) {
                        //���ѡ���ǣ�����ҵ���߼�����ķ�����ִ���˱�����
                        boolean result = cardServiceImpl.quit(card.getIdNo());
                        if (result) {
                            //����˱��ɹ���������ʾ��
                            JOptionPane.showMessageDialog(CardView.this, "�˱��ɹ�");
                            //ˢ��ҽ�����������
                            refreshTable();
                        } else {
                            //����˱�ʧ�ܣ�������ʾ��
                            JOptionPane.showMessageDialog(CardView.this, "�˱�ʧ��");
                        }
                    }
                } else {
                    //���ҽ������Ϣ�����ڣ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���û�û��ҽ������Ϣ");
                }
            }
        });

        //Ϊ��ʧ��ť����¼�������
        buttonReportLoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��ȡ���֤��
                String idNo = textIdNo.getText().trim();
                if (idNo.isEmpty()) {
                    //������֤��Ϊ�գ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���������֤��");
                    return;
                }
                //�������֤�Ų�ѯҽ������Ϣ
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //���ҽ������Ϣ���ڣ�����ȷ�Ͽ�
                    int choice = JOptionPane.showConfirmDialog(CardView.this, "ȷ����ʧ��");
                    if (choice == JOptionPane.YES_OPTION) {
                        //���ѡ���ǣ�����ҵ���߼�����ķ�����ִ�й�ʧ����
                        boolean result = cardServiceImpl.reportLoss(card);
                        if (result) {
                            //�����ʧ�ɹ���������ʾ��
                            JOptionPane.showMessageDialog(CardView.this, "��ʧ�ɹ�");
                        }
                        else {
                            //�����ʧʧ�ܣ�������ʾ��
                            JOptionPane.showMessageDialog(CardView.this,"��ʧʧ��");
                        }
                    }
                }
                else {
                    //���ҽ������Ϣ�����ڣ�������ʾ��
                    JOptionPane.showMessageDialog(CardView.this, "���û�û��ҽ������Ϣ");
                }
            }
        });
    }
    //��ʾҽ������Ϣ�ڱ���еķ���
    private void showCard(Card card) {
        //����һ����ά���飬���ڴ�ű������
        Object[][] data = new Object[1][7];
        //��ҽ������Ϣ��������
        data[0][0] = card.getStaffNo();
        data[0][1] = card.getName();
        data[0][2] = card.getAge();
        data[0][3] = card.getSex();
        data[0][4] = card.getIdNo();
        data[0][5] = card.getBalance();
        data[0][6] = card.getStatus();
        //����һ��һά���飬���ڴ�ű�ͷ
        Object[] columnNames = {"ְ�����", "����", "����","�Ա�","ҽ������", "ҽ�������", "ҽ����״̬"};
        //����һ�����ģ�ͣ��������ñ�����ݺͱ�ͷ
        MyTableModel model = new MyTableModel(data, columnNames);
        //�����ģ�����ø����
        table.setModel(model);
        table.setVisible(true);
    }

    //ˢ�±��ķ���
    private void refreshTable() {
        //��ѯ����ҽ������Ϣ
        List<Card> list = cardServiceImpl.queryAll();
        //����һ����ά���飬���ڴ�ű������
        Object[][] data = new Object[list.size()][7];
        //����card���ÿһ����¼
        Card card = new Card();
        //�����б���ҽ������Ϣ��������
        for (int i = 0; i < list.size(); i++) {
            card = list.get(i);
            data[i][0] = card.getStaffNo();
            data[i][1] = card.getName();
            data[i][2] = card.getAge();
            data[i][3] = card.getSex();
            data[i][4] = card.getIdNo();
            data[i][5] = card.getBalance();
            data[i][6] = card.getStatus();
        }
        //����һ��һά���飬���ڴ�ű�ͷ
        Object[] columnNames = {"ְ�����", "����", "����","�Ա�","���֤��", "ҽ�������", "ҽ����״̬"};
        //����һ�����ģ�ͣ��������ñ�����ݺͱ�ͷ
        MyTableModel model = new MyTableModel(data, columnNames);
        //�����ģ�����ø����
        table.setModel(model);
        table.setVisible(true);

        //����JTable����Ĭ�ϵĿ�Ⱥ͸߶�
        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = table.getColumnModel().getColumn(i);
            /*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
            column.setPreferredWidth(270);
        }

        //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }


    // ��ҽ�����б�ת��Ϊ���������ķ���
    private Vector<Vector<Object>> listToVector(List<Card> list) {
        // ����һ����������
        Vector<Vector<Object>> data = new Vector<>();
        // ����ҩƷ�б�
        for (Card card : list) {
            // ����һ��ҩƷ����
            Vector<Object> row = new Vector<>();
            // ��ҩƷ��������ӵ�ҩƷ������
            row.add(card.getStaffNo());
            row.add(card.getName());
            row.add(card.getAge());
            row.add(card.getSex());
            row.add(card.getIdNo());
            row.add(card.getBalance());
            row.add(card.getStatus());
            // ��ҩƷ������ӵ�����������
            data.add(row);
        }
        // ������������
        return data;
    }

    //��ȡ��ǰʱ��ķ���
    private String getCurrentTime() {
        //����һ�����ڸ�ʽ������
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //��ȡ��ǰ����
        Date date = new Date();
        //��ʽ������
        String time = sdf.format(date);
        //����ʱ���ַ���
        return time;
    }



    public static void main(String[] args) {
        // ������¼�������
        CardView cardView = new CardView();
        cardView.setVisible(true);

    }
}
