package DAO.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DAO_Implement.IDAO_DataSewa;
import model.Data_Sewa;
import project.SQL_Connection;

public class DAO_DataSewa implements IDAO_DataSewa{
    Connection connection;
    final String query_getAll = "SELECT * FROM data_sewa";
    final String query_getByHistoryID = "SELECT * FROM data_sewa WHERE id_history = ?";
    final String query_Insert = "INSERT INTO data_sewa (id, id_history, id_kamera, jumlah, status) VALUES (NULL, ?, ?, ?, 'Belum Dikembalikan')";
    final String query_Update = "UPDATE data_sewa SET status = 'Dikembalikan' WHERE id_history = ?";

    public DAO_DataSewa(){
        connection = SQL_Connection.connection();
    }

    @Override
    public List<Data_Sewa> getAll() {
        List<Data_Sewa> dase = null;
        try {
            dase = new ArrayList<Data_Sewa>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_getAll);
            while (rs.next()) {
                Data_Sewa data_Sewa = new Data_Sewa();
                data_Sewa.setId(rs.getInt("id"));
                data_Sewa.setId_history(rs.getInt("id_history"));
                data_Sewa.setId_kamera(rs.getInt("id_kamera"));
                data_Sewa.setJumlah(rs.getInt("jumlah"));
                data_Sewa.setStatus(rs.getString("status"));
                dase.add(data_Sewa);
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Sewa.class.getName()).log(Level.SEVERE, null, e);
        }
        return dase;
    }

    @Override
    public List<Data_Sewa> getByHistoryID(int h_id) {
        PreparedStatement st = null;
        ResultSet rs;
        List<Data_Sewa> dase = null;

        try {
            dase = new ArrayList<Data_Sewa>();
            st = connection.prepareStatement(query_getByHistoryID);
            st.setInt(1, h_id);
            rs = st.executeQuery();

            while(rs.next()){
                Data_Sewa data_Sewa = new Data_Sewa();
                data_Sewa.setId(rs.getInt("id"));
                data_Sewa.setId_history(rs.getInt("id_history"));
                data_Sewa.setId_kamera(rs.getInt("id_kamera"));
                data_Sewa.setJumlah(rs.getInt("jumlah"));
                data_Sewa.setStatus(rs.getString("status"));
                dase.add(data_Sewa);
            }
        } catch (SQLException e) {
            Logger.getLogger(Data_Sewa.class.getName()).log(Level.SEVERE, null, e);
        }
        return dase;
    }

    @Override
    public void insert(Data_Sewa dSewa) {
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement(query_Insert);
            st.setInt(1, dSewa.getId_history());
            st.setInt(2, dSewa.getId_kamera());
            st.setInt(3, dSewa.getJumlah());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void UpdateStatus(int h_id) {
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement(query_Update);
            st.setInt(1, h_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
