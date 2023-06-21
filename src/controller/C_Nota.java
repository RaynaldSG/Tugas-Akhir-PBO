package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import DAO.DAO.DAO_DataSewa;
import DAO.DAO.DAO_Riwayat;
import model.Data_Keranjang;
import model.Data_Riwayat;
import model.Data_Sewa;
import model.Data_User;
import model.T_Keranjang;
import view.UI_Nota;

public class C_Nota {
    List<Data_Keranjang> data_Keranjangs;
    UI_Nota ui;
    Data_User data_User;
    Data_Riwayat data_Riwayat;
    DAO_Riwayat dRiwayat;
    DAO_DataSewa DAOSewa;
    String ct;
    String rt;
    int total = 0;
    Integer id_history;
    String fileName;
    private File file;

    public C_Nota(UI_Nota ui, Data_User data_User, List<Data_Keranjang> data_Keranjangs){
        this.ui = ui;
        this.data_User = data_User;
        this.data_Keranjangs = data_Keranjangs;
        dRiwayat = new DAO_Riwayat();
        DAOSewa = new DAO_DataSewa();
    }

    public void T_Keranjang(){
        T_Keranjang tKeranjang =  new T_Keranjang(data_Keranjangs);
        ui.getT_Keranjang().setModel(tKeranjang);
    }

    public void Firts_Init(){

        ui.getL_Nama().setText(data_User.getNama());
        ui.getL_Address().setText(data_User.getAlamat());
        ui.getL_Telepon().setText(data_User.getTelepon());

        ui.getL_Hari().setText(String.valueOf(data_Keranjangs.get(0).getHari()) + " Hari");

        for(int i = 0; i < data_Keranjangs.size(); i++){
            this.total = this.total + data_Keranjangs.get(i).getTotal();
        }
        ui.getL_TotalHarga().setText(String.valueOf(total));
        
        T_Keranjang();
        Time_Controller();
    }

    public void Time_Controller(){
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/YYY HH:mm:ss");
        DateTimeFormatter timeFormatSQL = DateTimeFormatter.ofPattern("YYY/MM/dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime returnTime;

        returnTime = currentTime.plusDays(data_Keranjangs.get(0).getHari());

        ui.getL_TanggalS().setText(timeFormat.format(currentTime));
        ui.getL_TanggalP().setText(timeFormat.format(returnTime));

        this.ct = timeFormatSQL.format(currentTime);
        this.rt = timeFormatSQL.format(returnTime);

    }

    public void History_Insert(){
        data_Riwayat = new Data_Riwayat();

        data_Riwayat.setName(data_User.getNama());
        data_Riwayat.setHari(data_Keranjangs.get(0).getHari());
        data_Riwayat.setTotal(total);
        data_Riwayat.setDesc(makeDesc());
        data_Riwayat.setT_pinjam(ct);
        data_Riwayat.setT_tenggat(rt);
        data_Riwayat.setUser_id(data_User.getId_User());

        this.id_history = dRiwayat.insert(data_Riwayat);
        DataSewa_Insert();
    }

    public void DataSewa_Insert(){
        Data_Sewa dSewa;

        for (int i = 0; i < data_Keranjangs.size(); i++) {
            dSewa = new Data_Sewa();
            dSewa.setId_history(id_history);
            dSewa.setId_kamera(data_Keranjangs.get(i).getId_kamera());
            dSewa.setJumlah(data_Keranjangs.get(i).getJumlah());
            DAOSewa.insert(dSewa);
        }
    }

    public String makeDesc(){
        String desc = "";
        int limit;

        limit = data_Keranjangs.size();

        for(int i = 0; i < limit-1; i++){
            desc = desc + data_Keranjangs.get(i).getModel() + "(" + data_Keranjangs.get(i).getJumlah() + "x), ";
        }
        desc = desc + data_Keranjangs.get(limit-1).getModel() + "(" + data_Keranjangs.get(limit-1).getJumlah() + "x) ";

        return desc;
    }

    public void makeFile(){
        String docPath;

        docPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        fileName = docPath + "\\" + data_User.getNama() + ".txt";

        this.file = new File(fileName);
        try {
            if(file.createNewFile()){
                System.out.println("FIle Created");
            }
            else{
                System.out.println("File Already Exist");
            }
            writeFile();
        } catch (IOException e) {
            System.out.println("Gagal");
            e.printStackTrace();
        }
    }

    public void writeFile(){
        PrintStream writer = null;

        try {
            writer = new PrintStream(file);
            writer.println(String.format("%112s", "=").replace(" ", "="));
            writer.println("||" + String.format("%59s%51s" , "NOTA SEWA", "||"));
            writer.println(String.format("%112s", "=").replace(" ", "="));
            writer.println("|| " + textLeft("Data Penyewa: ", 107) + "||");
            writer.println("|| Nama" + textRight(": ", 11) + data_User.getNama() + textRight("||", 97 - 7));
            writer.println("|| Alamat" + textRight(": ", 9) + data_User.getAlamat() + textRight("||", 97 - 7));
            writer.println("|| Telepon" + textRight(": ", 8) + data_User.getTelepon() + textRight("||", 97 - 7));
            writer.println("||" + textRight("||", 110));
            writer.println("|| Data Kamera:" + textRight("||", 97));
            writer.println("|| -" + String.format("%105s", "-").replace(" ", "-") + " ||");
            writer.println("|| | NO |             MODEL             |        MERK        |     PRICE     | JUMLAH |        TOTAL        | ||");
            for(int i = 0; i < data_Keranjangs.size(); i++){
                writer.println("|| |" + textRight(String.valueOf(i + 1), 3) + " | " + textLeft(data_Keranjangs.get(i).getModel(), 30) + "| " + textLeft(data_Keranjangs.get(i).getMerek(), 19) + "| Rp" + textLeft(String.valueOf(data_Keranjangs.get(i).getPrice()), 12) + "| " + textLeft(String.valueOf(data_Keranjangs.get(i).getJumlah()), 7) + "| " + textLeft("Rp" + String.valueOf(data_Keranjangs.get(i).getTotal()), 20) + "| ||");
            }
            writer.println("|| -" + String.format("%105s", "-").replace(" ", "-") + " ||");
            writer.println("|| |" + textRight(" ", 41) + textLeft("Total", 41) + "| " + textRight("Rp" + data_Riwayat.getTotal(), 20) + "| ||");
            writer.println("|| -" + String.format("%105s", "-").replace(" ", "-") + " ||");
            writer.println("||" + textRight("||", 110));
            writer.println("||" + textRight("||", 110));
            writer.println("|| Tanggal Sewa    : " + textLeft(ui.getL_TanggalS().getText(), 89) + "||");
            writer.println("|| Tanggal Kembali : " + textLeft(ui.getL_TanggalP().getText(), 89) + "||");
            writer.println("||" + textRight("||", 110));
            writer.println(String.format("%112s", "=").replace(" ", "="));
            System.out.println("File Is Written");
            JOptionPane.showMessageDialog(null, "File nota anda tersimpan pada folder " + fileName , "Nota", JOptionPane.INFORMATION_MESSAGE);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String textLeft(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String textRight(String s, int n) {
        return String.format("%" + n + "s", s);
    }

}
