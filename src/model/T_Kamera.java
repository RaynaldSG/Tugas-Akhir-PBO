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
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "MODEL";
            case 1:
                return "MERK";
            case 2:
                return "PRICE";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return dk.get(rowIndex).getModel();
            case 1:
                return dk.get(rowIndex).getMerk();
            case 2:
                return dk.get(rowIndex).getPrice();
            default:
                return null;
        }
    }


}
