package controller;

import DAO.DAO.DAO_Login;
import DAO.DAO.DAO_User;
import errorhandler.H_Error;
import model.Data_Login;
import model.Data_User;
import view.UI_Register;

public class C_Register {
    Data_User data_User;
    Data_Login data_Login;
    DAO_User dUser;
    DAO_Login dLogin;
    UI_Register ui;
    Integer id_user;

    public C_Register(UI_Register ui){
        this.data_User = new Data_User();
        this.data_Login = new Data_Login();
        this.dUser = new DAO_User();
        this.dLogin = new DAO_Login();
        this.ui = ui;
    }

    public void inputUser(){
        this.id_user = -1;

        data_User.setNama(ui.getI_Nama().getText());
        data_User.setAlamat(ui.getI_Alamat().getText());
        data_User.setTelepon(ui.getI_Telepon().getText());
        data_Login.setUsername(ui.getI_username().getText());

        if(dLogin.getUsername(data_Login.getUsername())){
            H_Error.sama_uname();
            return;
        }
        
        this.id_user = dUser.Insert(data_User);

        data_Login.setPassword(String.valueOf(ui.getI_password().getPassword()));
        data_Login.setId_user(id_user);

        dLogin.Insert(data_Login);
       
    }

    public boolean Check_Data(){
        boolean check;

        if(id_user == -1){
            check = false;
        }
        else{
            check = true;
        }

        return check;
    }

    public boolean Null_Checker(){
        if(ui.getI_username().getText().isEmpty()){
            ui.getI_username().requestFocus();
            H_Error.empty_username();
            return true;
        }
        else if(ui.getI_password().getPassword().length == 0){
            ui.getI_password().requestFocus();
            H_Error.empty_password();
            return true;
        }
        else if(ui.getI_Nama().getText().isEmpty()){
            ui.getI_Nama().requestFocus();
            H_Error.empty_nama();
            return true;
        }
        else if(ui.getI_Alamat().getText().isEmpty()){
            ui.getI_Alamat().requestFocus();
            H_Error.empty_alamat();
            return true;
            }
        else if(ui.getI_Telepon().getText().isEmpty()){
            ui.getI_Telepon().requestFocus();
            H_Error.empty_telepon();
            return true;
        }
        else{
            return false;
        }
    }
}
