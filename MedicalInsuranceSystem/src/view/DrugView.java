
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

// 药品分类与代码的界面类
public class DrugView extends JFrame {
    // 创建药品业务逻辑对象
    private DrugService drugService = new DrugService();

    // 创建界面组件
    private JTextField textField; // 文本框
    private JButton button; // 按钮
    private JLabel[] labels; // 标签数组
    private JTable table; // 表格
    private Vector<String> columnNames; // 列名向量
    private Vector<Vector<Object>> data; // 数据向量

    // 构造方法
    public DrugView() {
        // 设置窗口标题
        setTitle("药品分类与代码界面");
        // 设置窗口大小
        setSize(1150, 600);
        // 设置窗口居中
        setLocationRelativeTo(null);
        // 设置窗口关闭时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口布局为边界布局
        setLayout(new BorderLayout());

        // 初始化界面组件
        initComponent();
        // 添加界面组件
        addComponent();
        // 添加事件监听器
        addListener();
        // 设置窗口可见
        setVisible(true);
    }

    // 初始化界面组件
    private void initComponent() {
        // 初始化文本框
        textField = new JTextField(20);
        // 初始化按钮
        button = new JButton("搜索");
        // 初始化标签数组
        labels = new JLabel[4];
        labels[0] = new JLabel("西药           ");       //十一个中文空格
        labels[1] = new JLabel("中成药           ");
        labels[2] = new JLabel("中草药           ");
        labels[3] = new JLabel("自制剂           ");
        // 初始化列名向量
        columnNames = new Vector<>();
        columnNames.add("药品代码");
        columnNames.add("注册名称");
        columnNames.add("注册剂型");
        columnNames.add("注册规格");
        columnNames.add("商品名称");
        columnNames.add("剂型");
        columnNames.add("规格");
        columnNames.add("包装材质");
        columnNames.add("最小包装数量");
        columnNames.add("最小制剂单位");
        columnNames.add("最小包装单位");
        columnNames.add("药品企业");
        columnNames.add("批准文号");
        columnNames.add("药品本位码");
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
            column.setPreferredWidth(150);
        }

        //设置JTable自动调整列表的状态，此处设置为关闭
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // 设置表格列宽不可拖动
        table.getTableHeader().setResizingAllowed(false);
        //设置表格不可编辑
        table.setEnabled(false);
        // 设置表格列宽不可重新排序
        table.getTableHeader().setReorderingAllowed(false);
    }

    // 添加界面组件
    private void addComponent() {
        JPanel panel = new JPanel();
        // 创建一个面板，用于放置文本框和按钮
        JPanel panel1 = new JPanel();

// 将文本框和按钮添加到面板中
        panel1.add(textField);
        panel1.add(button);
        panel1.add(new Label());

// 创建一个面板，用于放置标签
        JPanel panel2 = new JPanel();

// 将标签添加到面板中
        for (JLabel label : labels) {
            panel2.add(label);
        }
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(new Label(),BorderLayout.SOUTH);

// 创建一个滚动面板，用于放置表格
        JScrollPane scrollPane = new JScrollPane(table);
// 设置滚动面板的水平和竖直滚动条总是显示
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

// 创建一个边界布局对象
        BorderLayout layout = new BorderLayout();
// 设置容器的布局管理器为边界布局
        setLayout(layout);
// 将面板1添加到容器的北部
        add(panel, BorderLayout.NORTH);
//// 将面板2添加到容器的中部
//        add(panel2, BorderLayout.CENTER);
// 将滚动面板添加到容器的南部
        add(scrollPane, BorderLayout.CENTER);
    }


        // 添加事件监听器
    private void addListener() {
        // 为按钮添加动作监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取文本框中的关键字
                String keyword = textField.getText().trim();
                // 如果关键字不为空
                if (!keyword.isEmpty()) {
                    // 调用业务逻辑方法，根据药品代码或名称模糊查询药品列表
                    List<Drug> list = drugService.queryByCodeOrName(keyword);
                    // 将药品列表转换为数据向量
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
                        column.setPreferredWidth(150);
                    }

                    //设置JTable自动调整列表的状态，此处设置为关闭
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    // 设置表格列宽不可拖动
                    table.getTableHeader().setResizingAllowed(false);
                    //设置表格不可编辑
                    table.setEnabled(false);
                    // 设置表格列宽不可重新排序
                    table.getTableHeader().setReorderingAllowed(false);
                }
            }
        });

        // 为标签添加动作监听器
        for (int i = 0; i < labels.length; i++) {
            // 获取标签对应的药品类型
            String type = labels[i].getText().trim();
            // 为标签添加匿名内部类的动作监听器
            labels[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // 调用业务逻辑方法，根据药品类型查询药品列表
                    List<Drug> list = drugService.queryByType(type);
                    // 将药品列表转换为数据向量
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
                        column.setPreferredWidth(150);
                    }

                    //设置JTable自动调整列表的状态，此处设置为关闭
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    // 设置表格列宽不可拖动
                    table.getTableHeader().setResizingAllowed(false);
                    //设置表格不可编辑
                    table.setEnabled(false);
                    // 设置表格列宽不可重新排序
                    table.getTableHeader().setReorderingAllowed(false);
                }
            });
        }
    }

    // 将药品列表转换为数据向量的方法
    private Vector<Vector<Object>> listToVector(List<Drug> list) {
        // 创建一个数据向量
        Vector<Vector<Object>> data = new Vector<>();
        // 遍历药品列表
        for (Drug drug : list) {
            // 创建一个药品向量
            Vector<Object> row = new Vector<>();
            // 将药品的属性添加到药品向量中
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
            // 将药品向量添加到数据向量中
            data.add(row);
        }
        // 返回数据向量
        return data;
    }
    public static void main(String[] args) {
        // 创建登录界面对象
       DrugView drugView = new DrugView();
       drugView.setVisible(true);
    }
}
