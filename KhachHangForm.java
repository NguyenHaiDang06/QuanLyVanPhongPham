/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class KhachHangForm extends JFrame {

    JTable table;
    DefaultTableModel model;

    JTextField txtMa, txtTen, txtSDT, txtDiaChi;

    public KhachHangForm(){

        setTitle("Quản lý khách hàng");
        setSize(650,400);
        setLocationRelativeTo(null);

        String[] column = {"Mã KH","Tên KH","Số điện thoại","Địa chỉ"};

        model = new DefaultTableModel(column,0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        JPanel panelNhap = new JPanel(new GridLayout(2,4,5,5));

        txtMa = new JTextField();
        txtTen = new JTextField();
        txtSDT = new JTextField();
        txtDiaChi = new JTextField();

        panelNhap.add(new JLabel("Mã KH"));
        panelNhap.add(new JLabel("Tên KH"));
        panelNhap.add(new JLabel("SĐT"));
        panelNhap.add(new JLabel("Địa chỉ"));

        panelNhap.add(txtMa);
        panelNhap.add(txtTen);
        panelNhap.add(txtSDT);
        panelNhap.add(txtDiaChi);

        JButton btnThem = new JButton("Thêm");
        JButton btnSua = new JButton("Sửa");
        JButton btnXoa = new JButton("Xóa");

        // thêm khách hàng
        btnThem.addActionListener(e -> {

            model.addRow(new Object[]{
                txtMa.getText(),
                txtTen.getText(),
                txtSDT.getText(),
                txtDiaChi.getText()
            });

            JOptionPane.showMessageDialog(null,"Thêm khách hàng thành công");

            txtMa.setText("");
            txtTen.setText("");
            txtSDT.setText("");
            txtDiaChi.setText("");
        });

        // click bảng hiện dữ liệu
        table.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){

                int row = table.getSelectedRow();

                txtMa.setText(model.getValueAt(row,0).toString());
                txtTen.setText(model.getValueAt(row,1).toString());
                txtSDT.setText(model.getValueAt(row,2).toString());
                txtDiaChi.setText(model.getValueAt(row,3).toString());

            }
        });

        // sửa khách hàng
        btnSua.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(null,"Chọn khách hàng cần sửa");
                return;
            }

            model.setValueAt(txtMa.getText(),row,0);
            model.setValueAt(txtTen.getText(),row,1);
            model.setValueAt(txtSDT.getText(),row,2);
            model.setValueAt(txtDiaChi.getText(),row,3);

            JOptionPane.showMessageDialog(null,"Sửa thành công");
        });

        // xóa khách hàng
        btnXoa.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(null,"Chọn khách hàng cần xóa");
                return;
            }

            txtMa.setText("");
            txtTen.setText("");
            txtSDT.setText("");
            txtDiaChi.setText("");
        });

        JPanel bottom = new JPanel();
        bottom.add(btnThem);
        bottom.add(btnSua);
        bottom.add(btnXoa);

        add(panelNhap, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}
