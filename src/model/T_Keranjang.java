package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class T_Keranjang extends AbstractTableModel{
    List<Data_Keranjang> dk;

    public T_Keranjang(List<Data_Keranjang> dk){
        this.dk = dk;
    }

    @Override
    public int getRowCount() {
        return dk.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "MODEL";
            case 1:
                return "MEREK";
            case 2:
                return "HARGA";
            case 3:
                return "JUMLAH";
            case 4:
                return "HARI";
            case 5:
                return "TOTAL";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dk.get(rowIndex).getModel();
            case 1:
                return dk.get(rowIndex).getMerek();
            case 2:
                return dk.get(rowIndex).getPrice();
            case 3:
                return dk.get(rowIndex).getJumlah();
            case 4:
                return dk.get(rowIndex).getHari();
            case 5:
                return dk.get(rowIndex).getTotal();
            default:
                return null;
        }
    }


}
