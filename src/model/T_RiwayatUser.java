package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class T_RiwayatUser extends AbstractTableModel {
    List<Data_Riwayat> data_Riwayats;

    public T_RiwayatUser(List<Data_Riwayat> data_Riwayats){
        this.data_Riwayats = data_Riwayats;
    }

    @Override
    public int getRowCount() {
        return data_Riwayats.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "NO";
            case 1:
                return "DESCRIPTION";
            case 2:
                return "LAMA SEWA";
            case 3:
                return "TOTAL BIAYA";
            case 4:
                return "TANGGAL PINJAM";
            case 5:
                return "TANGGAL TENGGAT";
            case 6:
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
                return data_Riwayats.get(rowIndex).getDesc();
            case 2:
                return data_Riwayats.get(rowIndex).getHari();
            case 3:
                return data_Riwayats.get(rowIndex).getTotal();
            case 4:
                return data_Riwayats.get(rowIndex).getT_pinjam();
            case 5:
                return data_Riwayats.get(rowIndex).getT_tenggat();
            case 6:
                return data_Riwayats.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
}
