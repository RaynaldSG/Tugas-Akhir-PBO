package DAO.DAO;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DAO_Implement.IDAO_Riwayat;
import errorhandler.H_Error;
import model.Data_Riwayat;
import project.SQL_Connection;

public class DAO_Riwayat implements IDAO_Riwayat{
    Connection connection;
    final String getAll_query = "SELECT * FROM history";
    final String getByUserID_query = "SELECT * FROM history WHERE user_id = ?";
    final String insert_query = "INSERT INTO history (id, name, lama_sewa, total, description, tanggal_pinjam, tanggal_tenggat, user_id, status) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String update_query = "UPDATE history SET status = ? WHERE id = ?";

    public DAO_Riwayat(){
        connection = SQL_Connection.connection();
    }

    @Override
    public List<Data_Riwayat> getAll() {
        List<Data_Riwayat> dari = null;
        try {
            dari = new ArrayList<Data_Riwayat>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getAll_query);
            while(rs.next()){
                Data_Riwayat data_Riwayat = new Data_Riwayat();
                data_Riwayat.setId(rs.getInt("id"));
                data_Riwayat.setName(rs.getString("name"));
                data_Riwayat.setHari(rs.getInt("lama_sewa"));           
                data_Riwayat.setTotal(rs.getInt("total"));  
                data_Riwayat.setDesc(rs.getString("description"));         
                data_Riwayat.setT_pinjam(rs.getString("tanggal_pinjam"));
                data_Riwayat.setT_tenggat(rs.getString("tanggal_tenggat"));         
                data_Riwayat.setUser_id(rs.getInt("user_id")); 
                data_Riwayat.setStatus(rs.getString("status"));  
                dari.add(data_Riwayat);      
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Riwayat.class.getName()).log(Level.SEVERE, null, e);
        }
        return dari;
    }

    public List<Data_Riwayat> getByUserID(int id){
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Data_Riwayat> data_Riwayats = null;
        Data_Riwayat data_Riwayat;

        try {
            data_Riwayats = new ArrayList<Data_Riwayat>();
            st = connection.prepareStatement(getByUserID_query);
            st.setInt(1, id);
            rs = st.executeQuery();

            while(rs.next()){
                data_Riwayat = new Data_Riwayat();
                data_Riwayat.setId(rs.getInt("id"));
                data_Riwayat.setName(rs.getString("name"));
                data_Riwayat.setHari(rs.getInt("lama_sewa"));           
                data_Riwayat.setTotal(rs.getInt("total"));  
                data_Riwayat.setDesc(rs.getString("description"));         
                data_Riwayat.setT_pinjam(rs.getString("tanggal_pinjam"));
                data_Riwayat.setT_tenggat(rs.getString("tanggal_tenggat"));         
                data_Riwayat.setUser_id(rs.getInt("user_id")); 
                data_Riwayat.setStatus(rs.getString("status"));
                data_Riwayats.add(data_Riwayat);
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Riwayat.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return data_Riwayats;
    }

    @Override
    public int insert(Data_Riwayat data_Riwayat) {
        PreparedStatement st = null;
        Integer h_id = null;

        try {
            st = connection.prepareStatement(insert_query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, data_Riwayat.getName());
            st.setInt(2, data_Riwayat.getHari());
            st.setInt(3, data_Riwayat.getTotal());
            st.setString(4, data_Riwayat.getDesc());
            st.setString(5, data_Riwayat.getT_pinjam());
            st.setString(6, data_Riwayat.getT_tenggat());
            st.setInt(7, data_Riwayat.getUser_id());
            st.setString(8, "INCOMPLETED");
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                h_id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return h_id;
    }

    @Override
    public void update_Status(int id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(update_query);
            st.setString(1, "COMPLETED");
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            H_Error.data_notfound();
        }finally{
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
