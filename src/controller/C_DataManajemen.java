package controller;

import java.nio.file.*;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import DAO.DAO.DAO_Kamera;
import errorhandler.H_Error;
import model.Data_Kamera;
import model.T_Kamera;
import view.UI_DataManajemen;

public class C_DataManajemen {
    Data_Kamera data_Kamera;
    DAO_Kamera dKamera;
    UI_DataManajemen ui;
    T_Kamera tKamera;
    List <Data_Kamera> data_Kameras;
    JFileChooser jc;

    public C_DataManajemen(UI_DataManajemen ui){
        this.ui = ui;
        dKamera = new DAO_Kamera();
        data_Kameras = dKamera.getAll();
    }

    public void DataTabel(){
        data_Kameras = dKamera.getAll();
        tKamera = new T_Kamera(data_Kameras);
        ui.getT_DataKamera().setModel(tKamera);
    }

    public void SetField(int row){
        ui.getI_Model().setText(data_Kameras.get(row).getModel());
        ui.getI_Merk().setText(data_Kameras.get(row).getMerk());
        ui.getI_Price().setText(String.valueOf(data_Kameras.get(row).getPrice()));
        ui.getI_Stock().setText(String.valueOf(data_Kameras.get(row).getStock()));
    }

    public Data_Kamera getDataTable(int row){
        data_Kamera = new Data_Kamera();

        data_Kamera.setId(data_Kameras.get(row).getId());
        data_Kamera.setModel(data_Kameras.get(row).getModel());
        data_Kamera.setMerk(data_Kameras.get(row).getMerk());
        data_Kamera.setPrice(data_Kameras.get(row).getPrice());
        data_Kamera.setStock(data_Kameras.get(row).getStock());
        data_Kamera.setImg(data_Kameras.get(row).getImg());

        return data_Kamera;
    }

    public void showDataKamera(int row){
        Data_Kamera daka;

        daka = getDataTable(row);

        ui.getI_Model().setText(daka.getModel());
        ui.getI_Merk().setText(daka.getMerk());
        ui.getI_Price().setText(String.valueOf(daka.getPrice()));
        ui.getI_Stock().setText(String.valueOf(daka.getStock()));
        ui.getL_FileName().setText(daka.getImg());
        
        ui.getB_Delete().setEnabled(true);
        ui.getB_Edit().setEnabled(true);
    }

    public Data_Kamera getDataInput(){
        data_Kamera = new Data_Kamera();

        data_Kamera.setModel(ui.getI_Model().getText());
        data_Kamera.setMerk(ui.getI_Merk().getText());
        data_Kamera.setPrice(Integer.parseInt(ui.getI_Price().getText()));
        data_Kamera.setStock(Integer.parseInt(ui.getI_Stock().getText()));
        
        if(ui.getL_FileName().getText() == null){
            System.out.println("Tes Condition");
            data_Kamera.setImg("");
        }
        else{
            data_Kamera.setImg(ui.getL_FileName().getText());
        }

        return data_Kamera;
    }

    public void getImage(){
        FileNameExtensionFilter formatFilter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
        jc = new JFileChooser();
        jc.setFileFilter(formatFilter);
        int pil = jc.showOpenDialog(null);
        String file_path;
        String currPath;
        String file_dest;
        String file_name;
        String db_path;

        if(pil == JFileChooser.APPROVE_OPTION){
            file_path = jc.getSelectedFile().getPath();
        }
        else{
            return;
        }

        Path path = Paths.get("");
        currPath = path.toAbsolutePath().toString();

        file_dest = currPath + "\\src\\assets\\image";
        fileCopy(file_path, file_dest);

        file_name = jc.getSelectedFile().getName();
        db_path = "/assets/image/" + file_name;

        ui.getL_FileName().setText(db_path);
    }

    public void fileCopy(String alamat, String tujuan){
        String file_name;

        Path source = Paths.get(alamat);
        Path dest = Paths.get(tujuan);

        file_name = String.valueOf(source.getFileName());

        try {
            Files.createDirectories(dest);

            Path new_file = dest.resolve(file_name);
            Files.copy(source, new_file, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertData(){
        Data_Kamera daka;

        if(emptyCheck()){
            return;
        }
        daka = getDataInput();
        for(int i = 0; i < data_Kameras.size(); i++){
            if(daka.getModel().toLowerCase().equals(data_Kameras.get(i).getModel().toLowerCase())){
                H_Error.data_exist();
                return;
            }
        }
        dKamera.InsertData(daka);
        reset();
        DataTabel();
    }

    public void UpdateData(int row){
        Data_Kamera dakaT, dakaI;

        if(emptyCheck()){
            return;
        }

        dakaT = getDataTable(row);
        dakaI = getDataInput();
        dakaI.setId(dakaT.getId());
        dKamera.UpdateData(dakaI);
        reset();
        DataTabel();
    }

    public void DeleteData(int row){
        Data_Kamera daka;

        daka = getDataTable(row);
        dKamera.DeleteData(daka.getId());
        reset();
        DataTabel();
    }

    public boolean emptyCheck(){

        if(ui.getI_Model().getText().isEmpty()){
            H_Error.empty_field();
            ui.getI_Model().requestFocus();
            return true;
        }
        else if(ui.getI_Merk().getText().isEmpty()){
            H_Error.empty_field();
            ui.getI_Merk().requestFocus();
            return true;
        }
        else if(ui.getI_Price().getText().isEmpty()){
            H_Error.empty_field();
            ui.getI_Price().requestFocus();
            return true;
        }
        else if(ui.getI_Stock().getText().isEmpty()){
            H_Error.empty_field();
            ui.getI_Stock().requestFocus();
            return true;
        }
        else{
            return false;
        }
    }

    public void reset(){
        ui.getI_Model().setText(null);
        ui.getI_Merk().setText(null);
        ui.getI_Price().setText(null);
        ui.getI_Stock().setText(null);
        ui.getL_FileName().setText(null);
        ui.getB_Edit().setEnabled(false);
        ui.getB_Delete().setEnabled(false);
    }

    public void resetButton(){
        ui.getI_Model().setText(null);
        ui.getI_Merk().setText(null);
        ui.getI_Price().setText(null);
        ui.getI_Stock().setText(null);
        ui.getL_FileName().setText(null);
        ui.getB_Edit().setEnabled(true);
        ui.getB_Delete().setEnabled(true);
    }
}
