package controller;

import java.util.List;

import DAO.DAO.DAO_Riwayat;
import DAO.DAO.DAO_User;
import model.Data_Riwayat;
import model.Data_User;
import model.T_Riwayat;
import view.UI_History;

public class C_History {
    List<Data_Riwayat> data_Riwayats;
    DAO_Riwayat dRiwayat;
    DAO_User dUser;
    Data_User data_User;
    UI_History ui;

    public C_History(UI_History ui){
        this.ui = ui;
        dRiwayat = new DAO_Riwayat();
        this.data_Riwayats = dRiwayat.getAll();
        dUser = new DAO_User();
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
        dRiwayat.update_Status(data_Riwayats.get(row).getId());
        System.out.println(data_Riwayats.get(row).getId());
    }

}
