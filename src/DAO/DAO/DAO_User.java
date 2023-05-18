/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DAO_Implement.IDAO_User;
import model.Data_User;
import project.SQL_Connection;

/**
 *
 * @author Raynald Krisnawan
 */
public class DAO_User implements IDAO_User{
    Connection connection;
    final String getById_query = "SELECT * FROM user WHERE id = ?";
    final String getLastData_query = "SELECT * FROM user ORDER BY id DESC LIMIT 1";
    final String insert_query = "INSERT INTO user (id, nama, alamat, telepon) VALUES (NULL, ?, ?, ?)";

    public DAO_User(){
        connection = SQL_Connection.connection();
    }

    @Override
    public Data_User getById(int id) {
        PreparedStatement st = null;
        ResultSet rs;
        Data_User data_User = new Data_User();

        try {
            st = connection.prepareStatement(getById_query);
            st.setInt(1, id);
            rs = st.executeQuery();

            if(rs.next()){
                data_User.setId_User(rs.getInt("id"));
                data_User.setNama(rs.getString("nama"));
                data_User.setAlamat(rs.getString("alamat"));
                data_User.setTelepon(rs.getString("telepon"));
            }
            else{
                System.out.println("Tidak Ketemu"); //hapus
                data_User.setNama("");
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_User.class.getName()).log(Level.SEVERE, null, e);
        }
        return data_User;
    }

    @Override
    public Data_User getLastData() {
        Data_User data_User = new Data_User();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getLastData_query);

            if(rs.next()){
                data_User.setId_User(rs.getInt("id"));
                data_User.setNama(rs.getString("nama"));
                data_User.setAlamat(rs.getString("alamat"));
                data_User.setTelepon(rs.getString("telepon"));
            }
            else{
                System.out.println("Tidak Ketemu"); //hapus
                data_User.setNama("");
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_User.class.getName()).log(Level.SEVERE, null, e);
        }
        return data_User;

    }

    @Override
    public int Insert(Data_User data_user) {
        PreparedStatement st = null;
        Integer id = null;

        try {
            st = connection.prepareStatement(insert_query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, data_user.getNama());
            st.setString(2, data_user.getAlamat());
            st.setString(3, data_user.getTelepon());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
    
}
