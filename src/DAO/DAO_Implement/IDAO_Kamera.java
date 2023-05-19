/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.DAO_Implement;

import java.util.List;
import model.Data_Kamera;

/**
 *
 * @author Raynald Krisnawan
 */
public interface IDAO_Kamera {
    public List<Data_Kamera> getAll();
    public Data_Kamera getById(int id);
}
