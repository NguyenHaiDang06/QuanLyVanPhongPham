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
import java.awt.*;

public class MenuForm extends JFrame {

    public MenuForm(){

        setTitle("Hệ thống quản lý văn phòng phẩm");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // sát bên trái

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2,1,5,5)); // mỗi nút 1 dòng

        JButton btnKho = new JButton("Kho hàng");
        JButton btnKhachHang = new JButton("Khách hàng");

        btnKho.addActionListener(e -> {
            new KhoHangForm().setVisible(true);
        });

        btnKhachHang.addActionListener(e -> {
            new KhachHangForm().setVisible(true);
        });

        menuPanel.add(btnKho);
        menuPanel.add(btnKhachHang);

        panel.add(menuPanel);

        add(panel, BorderLayout.NORTH); // đưa lên phía trên
    }
}
