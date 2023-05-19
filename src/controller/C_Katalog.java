package controller;

import java.util.List;

import javax.swing.ImageIcon;

import DAO.DAO.DAO_Kamera;
import model.Data_Kamera;
import view.UI_Katalog;

public class C_Katalog {
    List<Data_Kamera> daka;
    UI_Katalog ui;
    DAO_Kamera dKamera;
    final int min = 0;
    int max;
    int curr;
    ImageIcon imageIcon;

    public C_Katalog(UI_Katalog ui){
        this.ui = ui;
        this.dKamera = new DAO_Kamera();
        daka = dKamera.getAll();
        max = daka.size();
    }

    public void awal(){
        ui.getL_Model().setText(daka.get(min).getModel());
        ui.getL_Merk().setText(daka.get(min).getMerk());
        ui.getL_Price().setText("Rp. " + String.valueOf(daka.get(min).getPrice()) + " /hari");
        imageIcon = new ImageIcon(getClass().getResource(daka.get(min).getImg()));
        ui.getL_IMG().setIcon(imageIcon);
        System.out.println(daka.get(min).getImg());
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
        imageIcon = new ImageIcon(getClass().getResource(daka.get(curr).getImg()));
        ui.getL_IMG().setIcon(imageIcon);
        System.out.println(daka.get(curr).getImg());
    }
}
