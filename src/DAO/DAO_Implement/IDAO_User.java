/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.DAO_Implement;

import model.Data_User;

/**
 *
 * @author Raynald Krisnawan
 */
public interface IDAO_User {
    public Data_User getById(int id);
    public Data_User getLastData();
    public int Insert(Data_User data_user);
}
