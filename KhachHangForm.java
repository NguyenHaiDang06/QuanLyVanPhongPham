package QuanLyVanPhongPham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        loadKhachHang();

        // ================= THÊM KHÁCH HÀNG =================
        btnThem.addActionListener(e -> {

            try{

                Connection conn = DBConnection.getConnection();

                String sql = "INSERT INTO KhachHang VALUES (?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, txtMa.getText());
                ps.setString(2, txtTen.getText());
                ps.setString(3, txtSDT.getText());
                ps.setString(4, txtDiaChi.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Thêm khách hàng thành công");

                model.setRowCount(0);
                loadKhachHang();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Lỗi: "+ex.getMessage());
            }

        });

        // ================= CLICK TABLE =================
        table.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){

                int row = table.getSelectedRow();

                txtMa.setText(model.getValueAt(row,0).toString());
                txtTen.setText(model.getValueAt(row,1).toString());
                txtSDT.setText(model.getValueAt(row,2).toString());
                txtDiaChi.setText(model.getValueAt(row,3).toString());

            }
        });

        // ================= SỬA KHÁCH HÀNG =================
        btnSua.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(null,"Chọn khách hàng cần sửa");
                return;
            }

            try{

                Connection conn = DBConnection.getConnection();

                String sql = "UPDATE KhachHang SET HoTen=?, SDT=?, DiaChi=? WHERE MaKH=?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, txtTen.getText());
                ps.setString(2, txtSDT.getText());
                ps.setString(3, txtDiaChi.getText());
                ps.setString(4, txtMa.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Sửa thành công");

                model.setRowCount(0);
                loadKhachHang();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Lỗi: "+ex.getMessage());
            }

        });

        
        btnXoa.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(null,"Chọn khách hàng cần xóa");
                return;
            }

            try{

                Connection conn = DBConnection.getConnection();

                String sql = "DELETE FROM KhachHang WHERE MaKH=?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, txtMa.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Xóa thành công");

                model.setRowCount(0);
                loadKhachHang();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Lỗi: "+ex.getMessage());
            }

        });

        JPanel bottom = new JPanel();
        bottom.add(btnThem);
        bottom.add(btnSua);
        bottom.add(btnXoa);

        add(panelNhap, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    // ================= LOAD DATA =================
    void loadKhachHang(){

        try{

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM KhachHang";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                model.addRow(new Object[]{
                        rs.getString("MaKH"),
                        rs.getString("HoTen"),
                        rs.getString("SDT"),
                        rs.getString("DiaChi")
                });

            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi load dữ liệu");
        }
    }
}
