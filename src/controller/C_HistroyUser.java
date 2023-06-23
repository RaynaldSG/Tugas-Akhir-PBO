package controller;

import java.util.List;

import DAO.DAO.DAO_DataSewa;
import DAO.DAO.DAO_Kamera;
import DAO.DAO.DAO_Riwayat;
import FileMaker.NotaMaker;
import model.Data_Riwayat;
import model.Data_Sewa;
import model.Data_User;
import model.T_RiwayatUser;
import view.UI_UserHistory;

public class C_HistroyUser {
    UI_UserHistory ui;
    DAO_Riwayat dRiwayat;
    DAO_DataSewa dSewa;
    DAO_Kamera dKamera;
    List<Data_Riwayat> data_Riwayats;
    List<Data_Sewa> data_Sewas;
    Data_User data_User;
    int row;

    public C_HistroyUser(UI_UserHistory ui, Data_User data_User) {
        this.ui = ui;
        this.data_User = data_User;
        dRiwayat = new DAO_Riwayat();
        dSewa = new DAO_DataSewa();
        dKamera = new DAO_Kamera();
        ui.getL_Nama().setText(data_User.getNama());
        ShowTable();
    }

    public void ShowTable() {
        this.data_Riwayats = dRiwayat.getByUserID(data_User.getId_User());
        T_RiwayatUser tRiwayatUser = new T_RiwayatUser(data_Riwayats);
        ui.getT_HistroyUser().setModel(tRiwayatUser);
    }

    public void SelectedRow(int row) {
        this.row = row;

        ui.getL_NoHistory().setText(String.valueOf(row + 1));
    }

    public void makeFile() {
        data_Sewas = dSewa.getByHistoryID(data_Riwayats.get(row).getId());
        NotaMaker.makeFile(data_User, data_Sewas, data_Riwayats.get(row));
    }

    // public List<Data_Keranjang> DataKeranjangMaker() {
    //     List<Data_Sewa> data_Sewas = null;
    //     List<Data_Keranjang> data_Keranjangs;
    //     Data_Keranjang data_Keranjang;
    //     Data_Kamera data_Kamera;

    //     data_Sewas = dSewa.getByHistoryID(data_Riwayats.get(row).getId());
    //     data_Keranjangs = new ArrayList<Data_Keranjang>();

    //     for (int i = 0; i < data_Sewas.size(); i++) {
    //         if(data_Sewas.get(i).getId_kamera() == null){
    //             data_Keranjang = new Data_Keranjang();
    //             data_Keranjang.setId_kamera(null);
    //             data_Keranjang.setModel(data_Kamera.getModel());
    //             data_Keranjang.setMerek(data_Kamera.getMerk());
    //             data_Keranjang.setPrice(data_Kamera.getPrice());
    //             data_Keranjang.setJumlah(data_Sewas.get(i).getJumlah());
    //             data_Keranjang.setHari(data_Riwayats.get(row).getHari());
    //             data_Keranjang.setTotal(data_Keranjang.getPrice() * data_Keranjang.getJumlah() * data_Keranjang.getHari());
    //         }
    //         else{
    //             data_Kamera = dKamera.getById(data_Sewas.get(i).getId_kamera());

    //             data_Keranjang = new Data_Keranjang();
    //             data_Keranjang.setId_kamera(data_Kamera.getId());
    //             data_Keranjang.setModel(data_Kamera.getModel());
    //             data_Keranjang.setMerek(data_Kamera.getMerk());
    //             data_Keranjang.setPrice(data_Kamera.getPrice());
    //             data_Keranjang.setJumlah(data_Sewas.get(i).getJumlah());
    //             data_Keranjang.setHari(data_Riwayats.get(row).getHari());
    //             data_Keranjang.setTotal(data_Keranjang.getPrice() * data_Keranjang.getJumlah() * data_Keranjang.getHari());
    //         } 
    //         data_Keranjangs.add(data_Keranjang);
    //     }

    //     return data_Keranjangs;
    // }

    // public String GetModelInHistory(int i){
    //     String result;


    //     return result;
    // }
}
