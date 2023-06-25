package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class T_Kamera extends AbstractTableModel{
    List<Data_Kamera> dk;

    public T_Kamera(List<Data_Kamera> dk){
        this.dk = dk;
    }

    @Override
    public int getRowCount() {
        return dk.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "NO";
            case 1:
                return "MODEL";
            case 2:
                return "MEREK";
            case 3:
                return "HARGA";
            case 4:
                return "STOK";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return dk.get(rowIndex).getModel();
            case 2:
                return dk.get(rowIndex).getMerk();
            case 3:
                return dk.get(rowIndex).getPrice();
            case 4:
                return dk.get(rowIndex).getStock();
            default:
                return null;
        }
    }


}
