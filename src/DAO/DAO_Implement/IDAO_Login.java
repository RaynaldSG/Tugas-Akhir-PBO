package DAO.DAO_Implement;

import model.Data_Login;

public interface IDAO_Login {
    public Data_Login getLoginData(Data_Login data_Login);
    public boolean getUsername(String username);
    public void Insert(Data_Login data_Login);
}
