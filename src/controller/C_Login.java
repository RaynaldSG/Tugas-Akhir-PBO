package controller;

import DAO.DAO.DAO_Login;
import errorhandler.H_Error;
import model.Data_Login;
import view.UI_Login;

public class C_Login {
    Data_Login data;
    UI_Login ui_Login;
    DAO_Login dlogin;

    public C_Login(UI_Login ui){
        this.data = new Data_Login();
        this.ui_Login = ui;
        this.dlogin = new DAO_Login();
    }

    public void check(){
        data.setUsername(ui_Login.getI_username().getText());
        data.setPassword(String.valueOf(ui_Login.getI_password().getPassword()));

        data = dlogin.getLoginData(data);
        if(data.getUsername().isEmpty()){
            H_Error.failure_login();
        }
        else{
            System.out.println("Login Berhasil");
        }
    }
}
