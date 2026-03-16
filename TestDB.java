/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM SanPham";

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Danh sách sản phẩm:");
            System.out.println("-----------------------------");

            while (rs.next()) {

                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuongTon");
                double gia = rs.getDouble("DonGia");

                System.out.println(maSP + " | " + tenSP + " | " + soLuong + " | " + gia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}