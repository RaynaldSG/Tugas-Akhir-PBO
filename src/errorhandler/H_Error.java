package errorhandler;

import javax.swing.JOptionPane;

public class H_Error {
    public static void failure_login(){
        JOptionPane.showMessageDialog(null, "Login Gagal, Username Atau Password Salah!", "Login Failure", JOptionPane.WARNING_MESSAGE);
    }
}
