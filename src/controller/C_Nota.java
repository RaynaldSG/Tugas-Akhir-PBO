package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import DAO.DAO.DAO_Riwayat;
import model.Data_Keranjang;
import model.Data_Riwayat;
import model.Data_User;
import model.T_Keranjang;
import view.UI_Nota;

public class C_Nota {
    List<Data_Keranjang> data_Keranjangs;
    UI_Nota ui;
    Data_User data_User;
    Data_Riwayat data_Riwayat;
    DAO_Riwayat dRiwayat;
    String ct;
    String rt;
    int total = 0;

    public C_Nota(UI_Nota ui, Data_User data_User, List<Data_Keranjang> data_Keranjangs){
        this.ui = ui;
        this.data_User = data_User;
        this.data_Keranjangs = data_Keranjangs;
        dRiwayat = new DAO_Riwayat();
    }

    public void T_Keranjang(){
        T_Keranjang tKeranjang =  new T_Keranjang(data_Keranjangs);
        ui.getT_Keranjang().setModel(tKeranjang);
    }

    public void Firts_Init(){

        ui.getL_Nama().setText(data_User.getNama());
        ui.getL_Address().setText(data_User.getAlamat());
        ui.getL_Telepon().setText(data_User.getTelepon());

        ui.getL_Hari().setText(String.valueOf(data_Keranjangs.get(0).getHari()) + " Hari");

        for(int i = 0; i < data_Keranjangs.size(); i++){
            this.total = this.total + data_Keranjangs.get(i).getTotal();
        }
        ui.getL_TotalHarga().setText(String.valueOf(total));
        
        T_Keranjang();
        Time_Controller();
    }

    public void Time_Controller(){
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/YYY HH:mm:ss");
        DateTimeFormatter timeFormatSQL = DateTimeFormatter.ofPattern("YYY/MM/dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime returnTime;

        returnTime = currentTime.plusDays(data_Keranjangs.get(0).getHari());

        ui.getL_TanggalS().setText(timeFormat.format(currentTime));
        ui.getL_TanggalP().setText(timeFormat.format(returnTime));

        this.ct = timeFormatSQL.format(currentTime);
        this.rt = timeFormatSQL.format(returnTime);

    }

    public void History_Insert(){
        data_Riwayat = new Data_Riwayat();

        data_Riwayat.setName(data_User.getNama());
        data_Riwayat.setHari(data_Keranjangs.get(0).getHari());
        data_Riwayat.setTotal(total);
        data_Riwayat.setDesc(makeDesc());
        data_Riwayat.setT_pinjam(ct);
        data_Riwayat.setT_tenggat(rt);
        data_Riwayat.setUser_id(data_User.getId_User());

        dRiwayat.insert(data_Riwayat);
    }

    public String makeDesc(){
        String desc = "";
        int limit;

        limit = data_Keranjangs.size();

        for(int i = 0; i < limit-1; i++){
            desc = desc + data_Keranjangs.get(i).getModel() + "(" + data_Keranjangs.get(i).getJumlah() + "x), ";
        }
        desc = desc + data_Keranjangs.get(limit-1).getModel() + "(" + data_Keranjangs.get(limit-1).getJumlah() + "x) ";

        return desc;
    }
}
