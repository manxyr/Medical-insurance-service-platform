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

//定义医保管理界面类，继承JFrame
public class CardView extends JFrame {
    //定义组件
    private JLabel labelIdNo; //身份证号标签
    private JTextField textIdNo; //身份证号文本框
    private JButton buttonQuery; //查询按钮
    private JLabel labelTime; //登录时间标签
    private JTable table; //表格
    private Vector<String> columnNames; // 列名向量
    private Vector<Vector<Object>> data; // 数据向量
    private JButton buttonRefresh; //刷新按钮
    private JButton buttonJoin; //入保按钮
    private JButton buttonQuit; //退保按钮
    private JButton buttonReportLoss; //挂失按钮

    //定义业务逻辑对象,创建CardServiceImpl对象
    private CardServiceImpl cardServiceImpl = new CardServiceImpl();

    //定义构造方法
    public CardView() {
        //设置窗体标题
        this.setTitle("医保管理界面");
        //设置窗体大小
        this.setSize(1280, 720);
        //设置窗体居中
        this.setLocationRelativeTo(null);
        //设置窗体关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //初始化组件
        this.initComponents();
        //添加事件监听器
        this.addListeners();
        //设置窗体可见
        this.setVisible(true);
    }

    //初始化组件的方法
    private void initComponents() {
        //创建身份证号标签
        labelIdNo = new JLabel("请输入身份证号：");
        //创建身份证号文本框
        textIdNo = new JTextField(20);
        //创建查询按钮
        buttonQuery = new JButton("查询");
        //创建登录时间标签
        labelTime = new JLabel("登录时间：" + getCurrentTime());
        //创建一个面板，用于放置上述组件
        JPanel panelTop = new JPanel();
        //将组件添加到面板
        panelTop.add(labelIdNo);
        panelTop.add(textIdNo);
        panelTop.add(buttonQuery);
        panelTop.add(labelTime);
        //将面板添加到窗体的北边
        this.add(panelTop, BorderLayout.NORTH);


//默认使用buttonRefresh刷新，初始化定义已经冗余
        // 初始化列名向量
        columnNames = new Vector<>();
        columnNames.add("职工编号");
        columnNames.add("姓名");
        columnNames.add("年龄");
        columnNames.add("性别");
        columnNames.add("医保卡号");
        columnNames.add("医保卡余额");
        columnNames.add("医保卡状态");
        // 初始化数据向量
        data = new Vector<>();
        // 初始化表格
        table = new JTable(data, columnNames);
        //设置JTable的列默认的宽度和高度
        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = table.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(274);
        }

        //设置JTable自动调整列表的状态，此处设置为关闭
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // 设置表格列宽不可拖动
        table.getTableHeader().setResizingAllowed(false);
        //设置表格不可编辑
        table.setEnabled(false);
        // 设置表格列宽不可重新排序
        table.getTableHeader().setReorderingAllowed(false);




        //创建一个滚动面板，用于放置表格
        JScrollPane scrollPane = new JScrollPane(table);
        // 设置滚动面板的水平和竖直滚动条总是显示
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //将滚动面板添加到窗体的中间
        this.add(scrollPane, BorderLayout.CENTER);

        //创建刷新按钮
        buttonRefresh = new JButton("刷  新");
        //创建入保按钮
        buttonJoin = new JButton("入  保");
        //创建退保按钮
        buttonQuit = new JButton("退  保");
        //创建挂失按钮
        buttonReportLoss = new JButton("挂  失");
        //创建一个面板，用于放置下述组件
        JPanel panelBottom = new JPanel();
        //将组件添加到面板
        panelBottom.add(buttonRefresh);
        panelBottom.add(buttonJoin);
        panelBottom.add(buttonQuit);
        panelBottom.add(buttonReportLoss);
        //将面板添加到窗体的南边
        this.add(panelBottom, BorderLayout.SOUTH);
        //刷新医保卡管理界面
        refreshTable();
    }

    //添加事件监听器的方法
    private void addListeners() {
        //为查询按钮添加事件监听器
        buttonQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取身份证号
                String idNo = textIdNo.getText().trim();
//                System.out.print(idNo);   测试身份证号获取成功
                if (idNo.isEmpty()) {
                    //如果身份证号为空，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "请输入身份证号");
                    return;
                }
                //根据身份证号查询医保卡信息
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //如果医保卡信息存在，将其显示在表格中
//                    showCard(card);
                    // 调用业务逻辑方法，根据药品代码或名称模糊查询药品列表
                    List<Card> list = cardServiceImpl.queryCard(card.getIdNo());
                    // 将医保卡列表转换为数据向量
                    data = listToVector(list);
                    // 更新表格的数据模型
                    table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                    //设置JTable的列默认的宽度和高度
                    TableColumn column = null;
                    int colunms = table.getColumnCount();
                    for(int i = 0; i < colunms; i++)
                    {
                        column = table.getColumnModel().getColumn(i);
                        /*将每一列的默认宽度设置为100*/
                        column.setPreferredWidth(270);
                    }

                    //设置JTable自动调整列表的状态，此处设置为关闭
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                } else {
                    //如果医保卡信息不存在，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "该用户没有医保卡信息");
                }
            }
        });

        //为刷新按钮添加事件监听器
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //刷新所有card记录
                refreshTable();
            }
        });


        //为入保按钮添加事件监听器
        buttonJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取身份证号
                String idNo = textIdNo.getText().trim();
                if (idNo.isEmpty()) {
                    //如果身份证号为空，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "请输入身份证号");
                    return;
                }
                //根据身份证号查询医保卡信息
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //如果医保卡信息已经存在，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "该用户已经入保，无需重复操作");
                } else {
                    String idNo2 = textIdNo.getText().trim();
                    //如果医保卡信息不存在，打开入保界面
                    JoinInsuranceView joinInsuranceView=new JoinInsuranceView(idNo2);
                }
            }
        });

        //为退保按钮添加事件监听器
        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取身份证号
                String idNo = textIdNo.getText().trim();
                if (idNo.isEmpty()) {
                    //如果身份证号为空，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "请输入身份证号");
                    return;
                }
                //根据身份证号查询医保卡信息
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //如果医保卡信息存在，弹出确认框
                    int choice = JOptionPane.showConfirmDialog(CardView.this, "确定要退保吗？");
                    if (choice == JOptionPane.YES_OPTION) {
                        //如果选择是，调用业务逻辑对象的方法，执行退保操作
                        boolean result = cardServiceImpl.quit(card.getIdNo());
                        if (result) {
                            //如果退保成功，弹出提示框
                            JOptionPane.showMessageDialog(CardView.this, "退保成功");
                            //刷新医保卡管理界面
                            refreshTable();
                        } else {
                            //如果退保失败，弹出提示框
                            JOptionPane.showMessageDialog(CardView.this, "退保失败");
                        }
                    }
                } else {
                    //如果医保卡信息不存在，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "该用户没有医保卡信息");
                }
            }
        });

        //为挂失按钮添加事件监听器
        buttonReportLoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取身份证号
                String idNo = textIdNo.getText().trim();
                if (idNo.isEmpty()) {
                    //如果身份证号为空，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "请输入身份证号");
                    return;
                }
                //根据身份证号查询医保卡信息
                Card card = cardServiceImpl.getCardByUserId(idNo);
                if (card != null) {
                    //如果医保卡信息存在，弹出确认框
                    int choice = JOptionPane.showConfirmDialog(CardView.this, "确定挂失吗？");
                    if (choice == JOptionPane.YES_OPTION) {
                        //如果选择是，调用业务逻辑对象的方法，执行挂失操作
                        boolean result = cardServiceImpl.reportLoss(card);
                        if (result) {
                            //如果挂失成功，弹出提示框
                            JOptionPane.showMessageDialog(CardView.this, "挂失成功");
                        }
                        else {
                            //如果挂失失败，弹出提示框
                            JOptionPane.showMessageDialog(CardView.this,"挂失失败");
                        }
                    }
                }
                else {
                    //如果医保卡信息不存在，弹出提示框
                    JOptionPane.showMessageDialog(CardView.this, "该用户没有医保卡信息");
                }
            }
        });
    }
    //显示医保卡信息在表格中的方法
    private void showCard(Card card) {
        //创建一个二维数组，用于存放表格数据
        Object[][] data = new Object[1][7];
        //将医保卡信息放入数组
        data[0][0] = card.getStaffNo();
        data[0][1] = card.getName();
        data[0][2] = card.getAge();
        data[0][3] = card.getSex();
        data[0][4] = card.getIdNo();
        data[0][5] = card.getBalance();
        data[0][6] = card.getStatus();
        //创建一个一维数组，用于存放表头
        Object[] columnNames = {"职工编号", "姓名", "年龄","性别","医保卡号", "医保卡余额", "医保卡状态"};
        //创建一个表格模型，用于设置表格数据和表头
        MyTableModel model = new MyTableModel(data, columnNames);
        //将表格模型设置给表格
        table.setModel(model);
        table.setVisible(true);
    }

    //刷新表格的方法
    private void refreshTable() {
        //查询所有医保卡信息
        List<Card> list = cardServiceImpl.queryAll();
        //创建一个二维数组，用于存放表格数据
        Object[][] data = new Object[list.size()][7];
        //创建card存放每一条记录
        Card card = new Card();
        //遍历列表，将医保卡信息放入数组
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
        //创建一个一维数组，用于存放表头
        Object[] columnNames = {"职工编号", "姓名", "年龄","性别","身份证号", "医保卡余额", "医保卡状态"};
        //创建一个表格模型，用于设置表格数据和表头
        MyTableModel model = new MyTableModel(data, columnNames);
        //将表格模型设置给表格
        table.setModel(model);
        table.setVisible(true);

        //设置JTable的列默认的宽度和高度
        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)
        {
            column = table.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(270);
        }

        //设置JTable自动调整列表的状态，此处设置为关闭
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }


    // 将医保卡列表转换为数据向量的方法
    private Vector<Vector<Object>> listToVector(List<Card> list) {
        // 创建一个数据向量
        Vector<Vector<Object>> data = new Vector<>();
        // 遍历药品列表
        for (Card card : list) {
            // 创建一个药品向量
            Vector<Object> row = new Vector<>();
            // 将药品的属性添加到药品向量中
            row.add(card.getStaffNo());
            row.add(card.getName());
            row.add(card.getAge());
            row.add(card.getSex());
            row.add(card.getIdNo());
            row.add(card.getBalance());
            row.add(card.getStatus());
            // 将药品向量添加到数据向量中
            data.add(row);
        }
        // 返回数据向量
        return data;
    }

    //获取当前时间的方法
    private String getCurrentTime() {
        //创建一个日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前日期
        Date date = new Date();
        //格式化日期
        String time = sdf.format(date);
        //返回时间字符串
        return time;
    }



    public static void main(String[] args) {
        // 创建登录界面对象
        CardView cardView = new CardView();
        cardView.setVisible(true);

    }
}
