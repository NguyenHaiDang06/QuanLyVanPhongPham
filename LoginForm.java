/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame{

    JTextField txtUser;
    JPasswordField txtPass;

    public LoginForm(){

        setTitle("Đăng nhập nhân viên");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lbUser = new JLabel("Tài khoản");
        JLabel lbPass = new JLabel("Mật khẩu");

        txtUser = new JTextField(15);
        txtPass = new JPasswordField(15);

        JButton btnLogin = new JButton("Đăng nhập");
        JButton btnRegister = new JButton("Đăng ký");

        JPanel p = new JPanel();

        p.add(lbUser);
        p.add(txtUser);

        p.add(lbPass);
        p.add(txtPass);

        p.add(btnLogin);
        p.add(btnRegister);

        add(p);

        btnLogin.addActionListener((ActionEvent e) -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());
            
            if(NhanVien.dangNhap(user,pass)){
                JOptionPane.showMessageDialog(null,"Đăng nhập thành công");
            }else{
                JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu");
            }
        });

        btnRegister.addActionListener((ActionEvent e) -> {
            new RegisterForm().setVisible(true);
        });

    }

}
