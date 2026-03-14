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

public class RegisterForm extends JFrame{

    JTextField txtUser;
    JPasswordField txtPass;

    public RegisterForm(){

        setTitle("Đăng ký nhân viên");
        setSize(300,200);
        setLocationRelativeTo(null);

        JLabel lbUser = new JLabel("Tài khoản");
        JLabel lbPass = new JLabel("Mật khẩu");

        txtUser = new JTextField(15);
        txtPass = new JPasswordField(15);

        JButton btnSave = new JButton("Đăng ký");

        JPanel p = new JPanel();

        p.add(lbUser);
        p.add(txtUser);

        p.add(lbPass);
        p.add(txtPass);

        p.add(btnSave);

        add(p);

        btnSave.addActionListener((ActionEvent e) -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());
            
            if(NhanVien.tonTai(user)){
                JOptionPane.showMessageDialog(null,"Tài khoản đã tồn tại");
            }else{
                
                NhanVien.ds.add(new NhanVien(user,pass));
                
                JOptionPane.showMessageDialog(null,"Đăng ký thành công");
                
                dispose();
            }
        });

    }

}
