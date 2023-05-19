package controller;

import DAO.DAO.DAO_Login;
import DAO.DAO.DAO_User;
import errorhandler.H_Error;
import javax.swing.JOptionPane;
import model.Data_Login;
import model.Data_User;
import view.UI_Login;
import view.UI_MenuUser;

public class C_Login {
    Data_Login data;
    UI_Login ui_Login;
    DAO_Login dlogin;
    DAO_User dUser;
    Data_User data_User;

    public C_Login(UI_Login ui){
        this.data = new Data_Login();
        this.ui_Login = ui;
        this.dlogin = new DAO_Login();
        this.data_User = new Data_User();
        this.dUser = new DAO_User();
    }

    public void check(){
        data.setUsername(ui_Login.getI_username().getText());
        data.setPassword(String.valueOf(ui_Login.getI_password().getPassword()));

        data = dlogin.getLoginData(data);
        if(data.getUsername().isEmpty()){
            H_Error.failure_login();
        }
        else{
            System.out.println(data.getStatus());
            if(data.getStatus().equals("user")){
                data_User = dUser.getById(data.getId_user());
                ui_Login.dispose();
                UI_MenuUser new_ui = new UI_MenuUser(data_User);
                new_ui.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Anda Admin", "ADMIN", JOptionPane.INFORMATION_MESSAGE);

            } 
        }
    }
}
