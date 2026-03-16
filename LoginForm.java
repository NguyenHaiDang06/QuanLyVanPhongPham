/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {

    JTextField txtUser;
    JPasswordField txtPass;

    public LoginForm() {

        setTitle("Đăng nhập nhân viên");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lbUser = new JLabel("Mã nhân viên");
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

        // Sự kiện đăng nhập
        btnLogin.addActionListener((ActionEvent e) -> {

            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword()).trim();

            if(user.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // DEBUG xem dữ liệu nhập
            System.out.println("Login: " + user + " - " + pass);

            boolean check = NhanVien.dangNhap(user, pass);

            if (check) {

                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");

                new MenuForm().setVisible(true);
                dispose();

            } else {

                JOptionPane.showMessageDialog(null, "Sai mã nhân viên hoặc mật khẩu");

            }

        });

        // Mở form đăng ký
        btnRegister.addActionListener((ActionEvent e) -> {
            new RegisterForm().setVisible(true);
        });

        setVisible(true);
    }
}