/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.DAO_Implement;

import java.util.List;

import model.Data_Riwayat;

/**
 *
 * @author Raynald Krisnawan
 */
public interface IDAO_Riwayat {
    public List<Data_Riwayat> getAll();
    public List<Data_Riwayat> getByUserID(int id);
    public int insert(Data_Riwayat data_Riwayat);
    public void update_Status(int id);
}
