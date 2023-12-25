
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableColumn;

import service.DrugService;
import vo.Drug;

// ҩƷ���������Ľ�����
public class DrugView extends JFrame {
    // ����ҩƷҵ���߼�����
    private DrugService drugService = new DrugService();

    // �����������
    private JTextField textField; // �ı���
    private JButton button; // ��ť
    private JLabel[] labels; // ��ǩ����
    private JTable table; // ���
    private Vector<String> columnNames; // ��������
    private Vector<Vector<Object>> data; // ��������

    // ���췽��
    public DrugView() {
        // ���ô��ڱ���
        setTitle("ҩƷ������������");
        // ���ô��ڴ�С
        setSize(1150, 600);
        // ���ô��ھ���
        setLocationRelativeTo(null);
        // ���ô��ڹر�ʱ�˳�����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ô��ڲ���Ϊ�߽粼��
        setLayout(new BorderLayout());

        // ��ʼ���������
        initComponent();
        // ��ӽ������
        addComponent();
        // ����¼�������
        addListener();
        // ���ô��ڿɼ�
        setVisible(true);
    }

    // ��ʼ���������
    private void initComponent() {
        // ��ʼ���ı���
        textField = new JTextField(20);
        // ��ʼ����ť
        button = new JButton("����");
        // ��ʼ����ǩ����
        labels = new JLabel[4];
        labels[0] = new JLabel("��ҩ           ");       //ʮһ�����Ŀո�
        labels[1] = new JLabel("�г�ҩ           ");
        labels[2] = new JLabel("�в�ҩ           ");
        labels[3] = new JLabel("���Ƽ�           ");
        // ��ʼ����������
        columnNames = new Vector<>();
        columnNames.add("ҩƷ����");
        columnNames.add("ע������");
        columnNames.add("ע�����");
        columnNames.add("ע����");
        columnNames.add("��Ʒ����");
        columnNames.add("����");
        columnNames.add("���");
        columnNames.add("��װ����");
        columnNames.add("��С��װ����");
        columnNames.add("��С�Ƽ���λ");
        columnNames.add("��С��װ��λ");
        columnNames.add("ҩƷ��ҵ");
        columnNames.add("��׼�ĺ�");
        columnNames.add("ҩƷ��λ��");
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
            column.setPreferredWidth(150);
        }

        //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // ���ñ���п����϶�
        table.getTableHeader().setResizingAllowed(false);
        //���ñ�񲻿ɱ༭
        table.setEnabled(false);
        // ���ñ���п�����������
        table.getTableHeader().setReorderingAllowed(false);
    }

    // ��ӽ������
    private void addComponent() {
        JPanel panel = new JPanel();
        // ����һ����壬���ڷ����ı���Ͱ�ť
        JPanel panel1 = new JPanel();

// ���ı���Ͱ�ť��ӵ������
        panel1.add(textField);
        panel1.add(button);
        panel1.add(new Label());

// ����һ����壬���ڷ��ñ�ǩ
        JPanel panel2 = new JPanel();

// ����ǩ��ӵ������
        for (JLabel label : labels) {
            panel2.add(label);
        }
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(new Label(),BorderLayout.SOUTH);

// ����һ��������壬���ڷ��ñ��
        JScrollPane scrollPane = new JScrollPane(table);
// ���ù�������ˮƽ����ֱ������������ʾ
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

// ����һ���߽粼�ֶ���
        BorderLayout layout = new BorderLayout();
// ���������Ĳ��ֹ�����Ϊ�߽粼��
        setLayout(layout);
// �����1��ӵ������ı���
        add(panel, BorderLayout.NORTH);
//// �����2��ӵ��������в�
//        add(panel2, BorderLayout.CENTER);
// �����������ӵ��������ϲ�
        add(scrollPane, BorderLayout.CENTER);
    }


        // ����¼�������
    private void addListener() {
        // Ϊ��ť��Ӷ���������
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ��ȡ�ı����еĹؼ���
                String keyword = textField.getText().trim();
                // ����ؼ��ֲ�Ϊ��
                if (!keyword.isEmpty()) {
                    // ����ҵ���߼�����������ҩƷ���������ģ����ѯҩƷ�б�
                    List<Drug> list = drugService.queryByCodeOrName(keyword);
                    // ��ҩƷ�б�ת��Ϊ��������
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
                        column.setPreferredWidth(150);
                    }

                    //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    // ���ñ���п����϶�
                    table.getTableHeader().setResizingAllowed(false);
                    //���ñ�񲻿ɱ༭
                    table.setEnabled(false);
                    // ���ñ���п�����������
                    table.getTableHeader().setReorderingAllowed(false);
                }
            }
        });

        // Ϊ��ǩ��Ӷ���������
        for (int i = 0; i < labels.length; i++) {
            // ��ȡ��ǩ��Ӧ��ҩƷ����
            String type = labels[i].getText().trim();
            // Ϊ��ǩ��������ڲ���Ķ���������
            labels[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // ����ҵ���߼�����������ҩƷ���Ͳ�ѯҩƷ�б�
                    List<Drug> list = drugService.queryByType(type);
                    // ��ҩƷ�б�ת��Ϊ��������
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
                        column.setPreferredWidth(150);
                    }

                    //����JTable�Զ������б��״̬���˴�����Ϊ�ر�
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    // ���ñ���п����϶�
                    table.getTableHeader().setResizingAllowed(false);
                    //���ñ�񲻿ɱ༭
                    table.setEnabled(false);
                    // ���ñ���п�����������
                    table.getTableHeader().setReorderingAllowed(false);
                }
            });
        }
    }

    // ��ҩƷ�б�ת��Ϊ���������ķ���
    private Vector<Vector<Object>> listToVector(List<Drug> list) {
        // ����һ����������
        Vector<Vector<Object>> data = new Vector<>();
        // ����ҩƷ�б�
        for (Drug drug : list) {
            // ����һ��ҩƷ����
            Vector<Object> row = new Vector<>();
            // ��ҩƷ��������ӵ�ҩƷ������
            row.add(drug.getCode());
            row.add(drug.getRegName());
            row.add(drug.getRegForm());
            row.add(drug.getRegSpec());
            row.add(drug.getProdName());
            row.add(drug.getForm());
            row.add(drug.getSpec());
            row.add(drug.getPackMaterial());
            row.add(drug.getMinPackNum());
            row.add(drug.getMinFormUnit());
            row.add(drug.getMinPackUnit());
            row.add(drug.getCompany());
            row.add(drug.getApprovalNum());
            row.add(drug.getStandardCode());
            // ��ҩƷ������ӵ�����������
            data.add(row);
        }
        // ������������
        return data;
    }
    public static void main(String[] args) {
        // ������¼�������
       DrugView drugView = new DrugView();
       drugView.setVisible(true);
    }
}
