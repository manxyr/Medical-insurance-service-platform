package view;

import javax.swing.table.AbstractTableModel;

//定义自定义的表格模型类，继承AbstractTableModel类
public class MyTableModel extends AbstractTableModel {
    //定义属性
    private Object[][] data; //用于存放表格数据的二维数组
    private Object[] columnNames; //用于存放表格表头的一维数组

    //定义构造方法，接收data和columnNames作为参数，并赋值给属性
    public MyTableModel(Object[][] data, Object[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
        fireTableDataChanged(); // 数据初始化完成后调用
    }

    //重写父类的getRowCount方法，返回表格的行数
    @Override
    public int getRowCount() {
        return data.length;
    }

    //重写父类的getColumnCount方法，返回表格的列数
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    //重写父类的getValueAt方法，返回指定单元格的值
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    //重写父类的getColumnName方法，返回指定列的列名
    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }

    //重写父类的isCellEditable方法，返回指定单元格是否可编辑，这里返回false，表示不可编辑
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
