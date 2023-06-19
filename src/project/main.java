package project;

import DAO.DAO.DAO_Login;
import model.Data_Login;
import view.UI_Login;

public class main {
    public static void main(String[] args) {
        Data_Login dataa = new Data_Login();
        Data_Login datan = new Data_Login();

        dataa.setUsername("admin");
        dataa.setPassword("admina");

        DAO_Login dao_Login = new DAO_Login();

        datan = dao_Login.getLoginData(dataa);
        if(datan == null){
            System.out.println("Null");
        }

        UI_Login ui = new UI_Login();
        ui.setVisible(true);
    }
}
