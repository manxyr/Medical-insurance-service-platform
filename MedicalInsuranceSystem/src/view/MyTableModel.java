package view;

import javax.swing.table.AbstractTableModel;

//�����Զ���ı��ģ���࣬�̳�AbstractTableModel��
public class MyTableModel extends AbstractTableModel {
    //��������
    private Object[][] data; //���ڴ�ű�����ݵĶ�ά����
    private Object[] columnNames; //���ڴ�ű���ͷ��һά����

    //���幹�췽��������data��columnNames��Ϊ����������ֵ������
    public MyTableModel(Object[][] data, Object[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
        fireTableDataChanged(); // ���ݳ�ʼ����ɺ����
    }

    //��д�����getRowCount���������ر�������
    @Override
    public int getRowCount() {
        return data.length;
    }

    //��д�����getColumnCount���������ر�������
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    //��д�����getValueAt����������ָ����Ԫ���ֵ
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    //��д�����getColumnName����������ָ���е�����
    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }

    //��д�����isCellEditable����������ָ����Ԫ���Ƿ�ɱ༭�����ﷵ��false����ʾ���ɱ༭
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
