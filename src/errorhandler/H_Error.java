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
}
