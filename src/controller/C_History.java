package controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.DAO.DAO_DataSewa;
import DAO.DAO.DAO_Kamera;
import DAO.DAO.DAO_Riwayat;
import DAO.DAO.DAO_User;
import model.Data_Kamera;
import model.Data_Riwayat;
import model.Data_Sewa;
import model.Data_User;
import model.T_Riwayat;
import view.UI_History;

public class C_History {
    List<Data_Riwayat> data_Riwayats;
    DAO_Riwayat dRiwayat;
    DAO_User dUser;
    DAO_DataSewa DAOSewa;
    DAO_Kamera DAOKamera;
    Data_User data_User;
    UI_History ui;

    public C_History(UI_History ui){
        this.ui = ui;
        dRiwayat = new DAO_Riwayat();
        this.data_Riwayats = dRiwayat.getAll();
        dUser = new DAO_User();
        DAOSewa = new DAO_DataSewa();
        DAOKamera = new DAO_Kamera();
    }

    public void show_Table(){
        this.data_Riwayats = dRiwayat.getAll();
        T_Riwayat TRiwayat = new T_Riwayat(data_Riwayats);
        ui.getT_Riwayat().setModel(TRiwayat);
    }

    public void show_Data(int row){
        data_User = dUser.getById(data_Riwayats.get(row).getUser_id());

        ui.getL_Nama().setText(data_User.getNama());
        ui.getL_Alamat().setText(data_User.getAlamat());
        ui.getL_Telepon().setText(data_User.getTelepon());
    }

    public void markData(int row){
        List<Data_Sewa> dSewa;
        Data_Kamera data_Kamera;

        dRiwayat.update_Status(data_Riwayats.get(row).getId());
        dSewa = DAOSewa.getByHistoryID(data_Riwayats.get(row).getId());
        for(int i = 0; i < dSewa.size(); i++){
            System.out.println(dSewa.get(i).getId_kamera());
            if(dSewa.get(i).getId_kamera() == 0){
                JOptionPane.showMessageDialog(null, "Terdapat Data Kamera yang Telah dihapus atau Hilang." , "Missing Data", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                data_Kamera = DAOKamera.getById(dSewa.get(i).getId_kamera());
                data_Kamera.setStock(data_Kamera.getStock() + dSewa.get(i).getJumlah());
                DAOKamera.UpdateData(data_Kamera);
            }
        }
        DAOSewa.UpdateStatus(data_Riwayats.get(row).getId());
        System.out.println(data_Riwayats.get(row).getId());
    }

}
