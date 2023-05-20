package controller;

import java.util.ArrayList;
import java.util.List;


import DAO.DAO.DAO_Kamera;
import errorhandler.H_Error;
import model.Data_Kamera;
import model.Data_Keranjang;
import model.T_Kamera;
import model.T_Keranjang;
import view.UI_Sewa;

public class C_Sewa {
    List<Data_Kamera> data_Kameras;
    List<Data_Keranjang> data_Keranjangs;
    Data_Keranjang dk;
    DAO_Kamera dKamera;
    UI_Sewa ui;
    int hari;

    public C_Sewa(UI_Sewa ui){
        this.ui = ui;
        dKamera = new DAO_Kamera();
        this.data_Kameras = dKamera.getAll();
        this.hari = 1;
        this.data_Keranjangs = new ArrayList<Data_Keranjang>();
    }

    public void TabelDataKamera(){
        T_Kamera tabelKamera = new T_Kamera(data_Kameras);
        ui.getT_DataKamera().setModel(tabelKamera);
    }

    public void InfoKamera(int row){
        ui.getL_Model().setText(data_Kameras.get(row).getModel());
        ui.getL_Merk().setText(data_Kameras.get(row).getMerk());
        ui.getL_Harga().setText(String.valueOf(data_Kameras.get(row).getPrice()));
    }

    public void AddKeranjang(){
        int check;
        dk = new Data_Keranjang();

        if(ui.getL_Model().getText().isEmpty()){
            H_Error.empty_data_keranjang();
            return;
        }
        else if(ui.getI_Jumlah().getText().isEmpty()){
            H_Error.empty_field();
            ui.getI_Jumlah().requestFocus();
            return;
        }
        else if(Integer.parseInt(ui.getI_Jumlah().getText()) < 0){
            H_Error.minus_field();
            ui.getI_Jumlah().requestFocus();
            return;
        }

        dk.setModel(ui.getL_Model().getText());
        dk.setMerek(ui.getL_Merk().getText());
        dk.setPrice(Integer.parseInt(ui.getL_Harga().getText()));
        dk.setJumlah(Integer.parseInt(ui.getI_Jumlah().getText()));
        dk.setHari(hari);
        dk.setTotal(dk.getPrice()*dk.getHari()*dk.getJumlah());

        System.out.println(dk);

        if(!data_Keranjangs.isEmpty()){
            check = CheckCopy(dk);
            if(check == -1){
                data_Keranjangs.add(dk);
            }
            else{
                if(dk.getJumlah().equals(0)){
                    HapusDataKeranjang(dk.getModel());
                    System.out.println("Masuk Sistem Hapus");
                }
                else{
                    data_Keranjangs.get(check).setJumlah(dk.getJumlah());
                    data_Keranjangs.get(check).setTotal(dk.getTotal());
                }
            }
        }
        else{
            data_Keranjangs.add(dk);
        }
        TabelKeranjang();
    }

    public void TabelKeranjang(){
        int total = 0;

        T_Keranjang tKeranjang = new T_Keranjang(data_Keranjangs);
        ui.getT_Keranjang().setModel(tKeranjang);
        
        if(!data_Keranjangs.isEmpty()){
            System.out.println("Masuk Data Keranjang not empty");
            for(int i = 0; i < data_Keranjangs.size(); i++){
                total = total + data_Keranjangs.get(i).getTotal();
            }
            ui.getL_Total().setText(String.valueOf(total));
        }
        return;
    }


    public void ControllerHari(){
        this.hari = Integer.parseInt(ui.getI_Hari().getText());

        if(hari <= 0){
            H_Error.minus_hari();
        }
        else{
            for(int i = 0; i < data_Keranjangs.size(); i++){
                data_Keranjangs.get(i).setHari(hari);
                data_Keranjangs.get(i).setTotal(data_Keranjangs.get(i).getPrice()*data_Keranjangs.get(i).getHari()*data_Keranjangs.get(i).getJumlah());
            }
            TabelKeranjang();
        }
    }

    public int CheckCopy(Data_Keranjang dk){
        for(int i = 0; i < data_Keranjangs.size(); i++){
            if(data_Keranjangs.get(i).getModel().equals(dk.getModel()) && !data_Keranjangs.isEmpty()){
                return i;
            }
        }
        return -1;
    }

    public boolean EmptyKeranjangCheck(){
        boolean check;

        if(data_Keranjangs.isEmpty()){
            H_Error.empty_keranjang();
            check = true;
        }
        else{
            System.out.println("Tes"); //TODO
            check = false;
        }
        return check;
    }

    public List<Data_Keranjang> getData_Keranjangs(){
        return this.data_Keranjangs;
    }

    public void HapusDataKeranjang(String model){
        for(int i = 0; i < data_Keranjangs.size(); i++){
            if(data_Keranjangs.get(i).getModel().equals(model)){
                data_Keranjangs.remove(i);
                System.out.println("Hapus Sukses"); //Hapus
            }
        }
    }
}
