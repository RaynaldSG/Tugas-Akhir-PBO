package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Data_Keranjang;
import model.Data_User;
import model.T_Keranjang;
import view.UI_Nota;

public class C_Nota {
    List<Data_Keranjang> data_Keranjangs;
    UI_Nota ui;
    Data_User data_User;

    public C_Nota(UI_Nota ui, Data_User data_User, List<Data_Keranjang> data_Keranjangs){
        this.ui = ui;
        this.data_User = data_User;
        this.data_Keranjangs = data_Keranjangs;
    }

    public void T_Keranjang(){
        T_Keranjang tKeranjang =  new T_Keranjang(data_Keranjangs);
        ui.getT_Keranjang().setModel(tKeranjang);
    }

    public void Firts_Init(){
        int total = 0;

        ui.getL_Nama().setText(data_User.getNama());
        ui.getL_Address().setText(data_User.getAlamat());
        ui.getL_Telepon().setText(data_User.getTelepon());

        ui.getL_Hari().setText(String.valueOf(data_Keranjangs.get(0).getHari()) + " Hari");

        for(int i = 0; i < data_Keranjangs.size(); i++){
            total = total + data_Keranjangs.get(i).getTotal();
        }
        ui.getL_TotalHarga().setText(String.valueOf(total));
        
        T_Keranjang();
        Time_Controller();
    }

    public void Time_Controller(){
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/YYY HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime returnTime;

        returnTime = currentTime.plusDays(data_Keranjangs.get(0).getHari());

        ui.getL_TanggalS().setText(timeFormat.format(currentTime));
        ui.getL_TanggalP().setText(timeFormat.format(returnTime));
    }
}
