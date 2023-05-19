/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DAO;

import DAO.DAO_Implement.IDAO_Kamera;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Data_Kamera;
import project.SQL_Connection;

/**
 *
 * @author Raynald Krisnawan
 */
public class DAO_Kamera implements IDAO_Kamera{
    Connection connection;
    final String getAll_query = "SELECT * FROM kamera";
    final String getById_query = "SELECT * FROM kamera WHERE id = ?";

    public DAO_Kamera(){
        connection = SQL_Connection.connection();
    }

    @Override
    public List<Data_Kamera> getAll() {
        List<Data_Kamera> daka = null;
        try {
            daka = new ArrayList<Data_Kamera>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getAll_query);
            while(rs.next()){
                Data_Kamera dakam = new Data_Kamera();
                dakam.setId(rs.getInt("id"));
                dakam.setModel(rs.getString("model"));
                dakam.setMerk(rs.getString("merk"));
                dakam.setPrice(rs.getInt("price"));
                dakam.setImg(rs.getString("img"));
                daka.add(dakam);
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Kamera.class.getName()).log(Level.SEVERE, null, e);
        }
        return daka;
    }

    @Override
    public Data_Kamera getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
