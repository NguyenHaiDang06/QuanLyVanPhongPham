/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NhanVien {

    String maNV;
    String matKhau;

    public NhanVien(String maNV, String matKhau) {
        this.maNV = maNV;
        this.matKhau = matKhau;
    }

    // Hàm đăng nhập
    public static boolean dangNhap(String maNV, String pass) {

        boolean ketQua = false;

        try {

            Connection conn = DBConnection.getConnection();

            if (conn == null) {
                System.out.println("Không kết nối được database");
                return false;
            }

            String sql = "SELECT * FROM NhanVien WHERE LTRIM(RTRIM(MaNV))=? AND LTRIM(RTRIM(MatKhau))=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, maNV.trim());
            ps.setString(2, pass.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ketQua = true;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    // Kiểm tra nhân viên tồn tại chưa
    public static boolean tonTai(String maNV) {

        boolean tonTai = false;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM NhanVien WHERE LTRIM(RTRIM(MaNV))=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, maNV.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tonTai = true;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tonTai;
    }
}