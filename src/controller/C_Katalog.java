package controller;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import DAO.DAO.DAO_Kamera;
import errorhandler.H_Error;
import model.Data_Kamera;
import model.Data_User;
import view.UI_Katalog;
import view.UI_MenuUser;

public class C_Katalog {
    List<Data_Kamera> daka;
    UI_Katalog ui;
    DAO_Kamera dKamera;
    final int min = 0;
    int max;
    int curr;
    ImageIcon imageIcon;
    Data_User data_User;

    public C_Katalog(UI_Katalog ui, Data_User data_User){
        this.ui = ui;
        this.dKamera = new DAO_Kamera();
        this.data_User = data_User;
        daka = dKamera.getAll();
        max = daka.size();
        if(daka.isEmpty()){
            H_Error.katalog_Kosong();
        }
    }

    public void awal(){
        if(!daka.isEmpty()){
            ui.getL_Model().setText(daka.get(min).getModel());
            ui.getL_Merk().setText(daka.get(min).getMerk());
            ui.getL_Price().setText("Rp. " + String.valueOf(daka.get(min).getPrice()) + " /hari");
            ui.getL_Stock().setText(String.valueOf(daka.get(min).getStock()));
            if(daka.get(min).getImg().isEmpty()){
                imageIcon = new ImageIcon(getClass().getResource("/assets/icon/I_NoIMG.png"));
            }
            else{
                imageIcon = new ImageIcon(getClass().getResource(daka.get(curr).getImg()));
            }
            ui.getL_IMG().setIcon(imageIcon);
        }
        else{
            ui.getB_Next().setEnabled(false);
            ui.getB_Prev().setEnabled(false);
            ui.getL_Model().setText(" ");
            ui.getL_Merk().setText(" ");
            ui.getL_Price().setText(" ");
            ui.getL_Stock().setText(" ");
            imageIcon = new ImageIcon(getClass().getResource("/assets/icon/I_NoIMG.png"));
            ui.getL_IMG().setIcon(imageIcon);
        }
    }

    public void NextData(){
        this.curr++;

        if(curr >= max){
            this.curr = max-1;
        }
        ShowData(curr);
    }

    public void PrevData(){
        this.curr--;

        if(curr < min){
            this.curr = min;
        }
        ShowData(curr);
    }

    public void ShowData(int curr){
        ui.getL_Model().setText(daka.get(curr).getModel());
        ui.getL_Merk().setText(daka.get(curr).getMerk());
        ui.getL_Price().setText("Rp. " + String.valueOf(daka.get(curr).getPrice()) + " /hari");
        ui.getL_Stock().setText(String.valueOf(daka.get(curr).getStock()));
        try {
            if(daka.get(curr).getImg().isEmpty()){
                imageIcon = new ImageIcon(getClass().getResource("/assets/icon/I_NoIMG.png"));
            }
            else{
                imageIcon = new ImageIcon(getClass().getResource(daka.get(curr).getImg()));
            }
            ui.getL_IMG().setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println("Image tidak ada di folder assets atau image belum dimasukkan");
            imageIcon = new ImageIcon(getClass().getResource("/assets/icon/I_NoIMG.png"));
            ui.getL_IMG().setIcon(imageIcon);
        }
        System.out.println(daka.get(curr).getImg());
        System.out.println(this.curr);
    }
}
