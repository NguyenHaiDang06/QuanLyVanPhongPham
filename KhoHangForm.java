package QuanLyVanPhongPham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KhoHangForm extends JFrame {

    JTable table;
    DefaultTableModel model;
    JTextField txtMa, txtTen, txtGia, txtSL, txtLoai, txtNCC;

    public KhoHangForm(){

        setTitle("Kho hàng");
        setSize(700,400);
        setLocationRelativeTo(null);

        String[] column = {"Mã SP","Tên SP","Đơn giá","Số lượng","Loại","Nhà cung cấp"};

        model = new DefaultTableModel(column,0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        JPanel panelNhap = new JPanel(new GridLayout(2,6,5,5));

        txtMa = new JTextField();
        txtTen = new JTextField();
        txtGia = new JTextField();
        txtSL = new JTextField();
        txtLoai = new JTextField();
        txtNCC = new JTextField();

        panelNhap.add(new JLabel("Mã SP"));
        panelNhap.add(new JLabel("Tên SP"));
        panelNhap.add(new JLabel("Đơn giá"));
        panelNhap.add(new JLabel("Số lượng"));
        panelNhap.add(new JLabel("Loại"));
        panelNhap.add(new JLabel("Nhà cung cấp"));

        panelNhap.add(txtMa);
        panelNhap.add(txtTen);
        panelNhap.add(txtGia);
        panelNhap.add(txtSL);
        panelNhap.add(txtLoai);
        panelNhap.add(txtNCC);

        JButton btnNhap = new JButton("Nhập hàng");
        JButton btnSua = new JButton("Sửa");
        JButton btnXoa = new JButton("Xóa");

        loadSanPham();

        // Nhập hàng
        btnNhap.addActionListener(e -> {

            if(txtMa.getText().isEmpty() || txtTen.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Nhập đầy đủ thông tin!");
                return;
            }

            try{

                Connection conn = DBConnection.getConnection();

                String sql = "INSERT INTO SanPham (MaSP,TenSP,DonGia,SoLuongTon,MaLoai,MaNCC) VALUES (?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, txtMa.getText());
                ps.setString(2, txtTen.getText());
                ps.setDouble(3, Double.parseDouble(txtGia.getText()));
                ps.setInt(4, Integer.parseInt(txtSL.getText()));
                ps.setString(5, txtLoai.getText());
                ps.setString(6, txtNCC.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Nhập hàng thành công");

                model.setRowCount(0);
                loadSanPham();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        // Click bảng
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){

                int row = table.getSelectedRow();

                txtMa.setText(model.getValueAt(row,0).toString());
                txtTen.setText(model.getValueAt(row,1).toString());
                txtGia.setText(model.getValueAt(row,2).toString());
                txtSL.setText(model.getValueAt(row,3).toString());
                txtLoai.setText(model.getValueAt(row,4).toString());
                txtNCC.setText(model.getValueAt(row,5).toString());
            }
        });

        // Sửa
        btnSua.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(null,"Chọn sản phẩm cần sửa");
                return;
            }

            try{

                Connection conn = DBConnection.getConnection();

                String sql = "UPDATE SanPham SET TenSP=?, DonGia=?, SoLuongTon=?, MaLoai=?, MaNCC=? WHERE MaSP=?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, txtTen.getText());
                ps.setDouble(2, Double.parseDouble(txtGia.getText()));
                ps.setInt(3, Integer.parseInt(txtSL.getText()));
                ps.setString(4, txtLoai.getText());
                ps.setString(5, txtNCC.getText());
                ps.setString(6, txtMa.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Sửa thành công");

                model.setRowCount(0);
                loadSanPham();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        // Xóa
        btnXoa.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(null,"Chọn sản phẩm cần xóa");
                return;
            }

            try{

                Connection conn = DBConnection.getConnection();

                String sql = "DELETE FROM SanPham WHERE MaSP=?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, txtMa.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Xóa thành công");

                model.setRowCount(0);
                loadSanPham();

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        JPanel bottom = new JPanel();
        bottom.add(btnNhap);
        bottom.add(btnSua);
        bottom.add(btnXoa);

        add(panelNhap, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    // load dữ liệu
    void loadSanPham(){

        try{

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM SanPham";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                model.addRow(new Object[]{
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getDouble("DonGia"),
                        rs.getInt("SoLuongTon"),
                        rs.getString("MaLoai"),
                        rs.getString("MaNCC")
                });

            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}