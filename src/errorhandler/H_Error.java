package errorhandler;

import javax.swing.JOptionPane;

public class H_Error {
    public static void failure_login(){
        JOptionPane.showMessageDialog(null, "Login Gagal, Username Atau Password Salah!", "Login Failure", JOptionPane.WARNING_MESSAGE);
    }

    public static void empty_username(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Username", "Input Failure", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void empty_password(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Password", "Input Failure", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void empty_nama(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Nama", "Input Failure", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void empty_alamat(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Alamat", "Input Failure", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void empty_telepon(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Telepon", "Input Failure", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void wrong_telepon(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Field Telepon Dengan Angka", "Input Failure", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void failure_registration(){
        JOptionPane.showMessageDialog(null, "Registrasi Gagal", "Registration Failure", JOptionPane.WARNING_MESSAGE);
    }
    public static void empty_data_keranjang(){
        JOptionPane.showMessageDialog(null, "Tolong Pilih Barang yang ingin ditambahkan", "Empty Data", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void minus_hari(){
        JOptionPane.showMessageDialog(null, "Minimal Waktu Sewa Adalah 1 hari", "Wrong Input", JOptionPane.WARNING_MESSAGE);
    }
    public static void empty_hari(){
        JOptionPane.showMessageDialog(null, "Masukkan Jumlah Hari", "Empty Input", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void empty_keranjang(){
        JOptionPane.showMessageDialog(null, "Keranjang Anda Kosong", "Empty Cart", JOptionPane.WARNING_MESSAGE);
    }
    public static void wrong_format(){
        JOptionPane.showMessageDialog(null, "Masukkan Angka", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void empty_field(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Input", "Empty Field", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void minus_field(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Angka Lebih Dari 0", "Zero Field", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void data_notfound(){
        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan", "Data", JOptionPane.WARNING_MESSAGE);
    }
    public static void sama_uname(){
        JOptionPane.showMessageDialog(null, "Username telah terpakai", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void data_exist(){
        JOptionPane.showMessageDialog(null, "Data sudah ada!!", "Data Already Exist", JOptionPane.INFORMATION_MESSAGE);
    }
}
