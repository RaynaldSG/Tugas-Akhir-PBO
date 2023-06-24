package FileMaker;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import model.Data_Sewa;
import model.Data_Riwayat;
import model.Data_User;

public class NotaMaker {
    static String fileName;
    static private File file;
    static Data_User data_User;
    static List<Data_Sewa> data_Sewas;

    public static void makeFile(Data_User data_User, List<Data_Sewa> data_Sewas, Data_Riwayat data_Riwayat){
        String docPath;

        docPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        fileName = docPath + "\\" + data_User.getNama() + "_NOTA.txt";

        file = new File(fileName);
        try {
            if(file.createNewFile()){
                System.out.println("File Created");
            }
            else{
                System.out.println("File Already Exist");
            }
            writeFile(data_User, data_Sewas, file, data_Riwayat);
        } catch (IOException e) {
            System.out.println("Gagal");
            e.printStackTrace();
        }
    }

    public static void writeFile(Data_User data_User, List<Data_Sewa> data_Sewas, File file, Data_Riwayat data_Riwayat){
        PrintStream writer = null;

        try {
            writer = new PrintStream(file);
            writer.println(String.format("%112s", "=").replace(" ", "="));
            writer.println("||" + String.format("%59s%51s" , "NOTA SEWA", "||"));
            writer.println(String.format("%112s", "=").replace(" ", "="));
            writer.println("|| " + textLeft("Data Penyewa: ", 107) + "||");
            writer.println("|| Nama" + textRight(": ", 11) + textLeft(data_User.getNama(), 92) + "||");
            writer.println("|| Alamat" + textRight(": ", 9) + textLeft(data_User.getAlamat(), 92) + "||");
            writer.println("|| Telepon" + textRight(": ", 8) + textLeft(data_User.getTelepon(), 92) + "||");
            writer.println("||" + textRight("||", 110));
            writer.println("|| Data Kamera:" + textRight("||", 97));
            writer.println("|| -" + String.format("%105s", "-").replace(" ", "-") + " ||");
            writer.println("|| | NO |             MODEL             |        MERK        |     PRICE     | JUMLAH |        TOTAL        | ||");
            for(int i = 0; i < data_Sewas.size(); i++){
                writer.println("|| |" + textRight(String.valueOf(i + 1), 3) + " | " + textLeft(data_Sewas.get(i).getModelKamera(), 30) + "| " + textLeft(data_Sewas.get(i).getMerkKamera(), 19) + "| Rp" + textLeft(String.valueOf(data_Sewas.get(i).getPrice()), 12) + "| " + textLeft(String.valueOf(data_Sewas.get(i).getJumlah()), 7) + "| " + textLeft("Rp" + String.valueOf(data_Sewas.get(i).getPrice()*data_Sewas.get(i).getJumlah()*data_Riwayat.getHari()), 20) + "| ||");
            }
            writer.println("|| -" + String.format("%105s", "-").replace(" ", "-") + " ||");
            writer.println("|| |" + textRight(" ", 41) + textLeft("Total", 41) + "| " + textRight("Rp" + data_Riwayat.getTotal(), 20) + "| ||");
            writer.println("|| -" + String.format("%105s", "-").replace(" ", "-") + " ||");
            writer.println("||" + textRight("||", 110));
            writer.println("|| Lama Sewa       : " + textLeft(String.valueOf(data_Riwayat.getHari() + " Hari"), 89) + "||");
            writer.println("|| Tanggal Sewa    : " + textLeft(formatDate(data_Riwayat.getT_pinjam()), 89) + "||");
            writer.println("|| Tanggal Kembali : " + textLeft(formatDate(data_Riwayat.getT_tenggat()), 89) + "||");
            writer.println("||" + textRight("||", 110));
            writer.println("|| Status: " + textLeft(data_Riwayat.getStatus(), 99) + "||");
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

    public static String formatDate(String input){
        String sDate = "";
        System.out.println(input);
    try {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter timeFormatnota = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(input, timeFormat);
        sDate = timeFormatnota.format(time);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return sDate;
    }

    public static String textLeft(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String textRight(String s, int n) {
        return String.format("%" + n + "s", s);
    }
}
