package DAO.DAO_Implement;

import java.util.List;

import model.Data_Sewa;

public interface IDAO_DataSewa {
    public List<Data_Sewa> getAll();
    public List<Data_Sewa> getByHistoryID(int h_id);
    public void insert(Data_Sewa dSewa);
    public void UpdateStatus(int h_id);
}
