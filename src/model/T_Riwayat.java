package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class T_Riwayat extends AbstractTableModel{
    List<Data_Riwayat> dr;

    public T_Riwayat(List<Data_Riwayat> dr){
        this.dr = dr;
    }

    @Override
    public int getRowCount() {
        return dr.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "NO";
            case 1:
                return "USERNAME";
            case 2:
                return "DESKRIPSI";
            case 3:
                return "LAMA";
            case 4:
                return "TOTAL BIAYA";
            case 5:
                return "TANGGAL PINJAM";
            case 6:
                return "TANGGAL TENGGAT";
            case 7:
                return "STATUS";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return dr.get(rowIndex).getName();
            case 2:
                return dr.get(rowIndex).getDesc();
            case 3:
                return dr.get(rowIndex).getHari();
            case 4:
                return dr.get(rowIndex).getTotal();
            case 5:
                return dr.get(rowIndex).getT_pinjam();
            case 6:
                return dr.get(rowIndex).getT_tenggat();
            case 7:
                return dr.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
        
}
