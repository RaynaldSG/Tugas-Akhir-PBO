package DAO.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DAO_Implement.IDAO_Login;
import model.Data_Login;
import project.SQL_Connection;

public class DAO_Login implements IDAO_Login{
    Connection connection;
    final String query = "SELECT * FROM login WHERE username = ? AND password = ?;";
    final String insert = "INSERT INTO login (id, username, password, status, id_user) VALUES (NULL, ?, ?, ?, ?)";
    final String getUnameQuery = "SELECT username FROM login WHERE username = ?";

    public DAO_Login(){
        this.connection = SQL_Connection.connection();
    }

    @Override
    public Data_Login getLoginData(Data_Login data_Login) { //method untuk mencari username dan password yang sesuai
        PreparedStatement st = null;
        ResultSet rs;
        Data_Login data = new Data_Login();

        try{
            st = connection.prepareStatement(query);
            st.setString(1, data_Login.getUsername());
            st.setString(2, data_Login.getPassword());
            rs = st.executeQuery();

            if(rs.next()){
                data.setId(rs.getInt("id"));
                data.setUsername(rs.getString("username"));
                data.setPassword(rs.getString("password"));
                data.setStatus(rs.getString("status"));
                data.setId_user(rs.getInt("id_user"));
                System.out.println("Ketemu"); //Hapus
            }
            else{
                System.out.println("Tidak Ketemu"); //Hapus
                data.setUsername("");
            }
        }catch(SQLException e){
            Logger.getLogger(Data_Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    @Override
    public boolean getUsername(String username) {
        boolean check = false;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            st = connection.prepareStatement(getUnameQuery);
            st.setString(1, username);
            rs = st.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return check;
    }

    @Override
    public void Insert(Data_Login data_Login) {
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement(insert);
            st.setString(1, data_Login.getUsername());
            st.setString(2, data_Login.getPassword());
            st.setString(3, "user");
            st.setInt(4, data_Login.getId_user());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
