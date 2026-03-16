/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterForm extends JFrame {

    JTextField txtUser;
    JPasswordField txtPass;

    public RegisterForm() {

        setTitle("Đăng ký nhân viên");
        setSize(300,200);
        setLocationRelativeTo(null);

        JLabel lbUser = new JLabel("Mã nhân viên");
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

            if (NhanVien.tonTai(user)) {

                JOptionPane.showMessageDialog(null,"Mã nhân viên đã tồn tại");

            } else {

                try {

                    Connection conn = DBConnection.getConnection();

                    String sql = "INSERT INTO NhanVien(MaNV,HoTen,NgaySinh,MatKhau,ChucVu,SDT) VALUES(?,?,?,?,?,?)";

                    PreparedStatement ps = conn.prepareStatement(sql);

                    ps.setString(1, user);
                    ps.setString(2, "Nhân viên mới");
                    ps.setDate(3, java.sql.Date.valueOf("2000-01-01"));
                    ps.setString(4, pass);
                    ps.setString(5, "Nhân viên");
                    ps.setString(6, "0000000000");

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Đăng ký thành công");

                    dispose();

                } catch(Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Lỗi đăng ký");
                }

            }

        });

        setVisible(true);
    }
}