import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private int ColumnCount = 3;
    public ArrayList<String []> MyArray;

    public MyModel() {
        MyArray = new ArrayList<String []>();
        for(int i = 0; i < MyArray.size(); i++) {
            MyArray.add(new String[getColumnCount()] );
        }



    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return ColumnCount;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return MyArray.size();
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        String []Dop = MyArray.get(rowIndex);
        return Dop[columnIndex];
    }
    @Override
    public String getColumnName(int ColumnIndex) {
        switch(ColumnIndex) {
            case 0:return "Date";
            case 1:return "Value";
            default :return "CharCode";
        }

    }
    public void MyAdd(String[] MyRow) {

        String []RowTable = new String[getColumnCount()];
        RowTable = MyRow;
        MyArray.add(RowTable);
    }
    public void MyDeleteAll() {
        MyArray.clear();
    }
}
