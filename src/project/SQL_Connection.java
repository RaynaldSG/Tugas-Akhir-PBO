/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author Raynald Krisnawan
 */
public class SQL_Connection {
    static Connection con;

    public static Connection connection(){
        if(con == null){
            MysqlDataSource db_data = new MysqlDataSource();
            db_data.setDatabaseName("sewa_kamera");
            db_data.setUser("root");
            db_data.setPassword("");
            try {
                con = db_data.getConnection();
                System.out.println("Koneksi Berhasil");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Gagal Melakukan Koneksi Dengan Database");
            }
        }
        return con;
    }
}
