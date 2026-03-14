/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

/**
 *
 * @author Admin
 */

import java.util.ArrayList;

public class HoaDon {

    private String maHD;
    private String ngayLap;

    private NhanVien nhanVien;
    private KhachHang khachHang;

    private ArrayList<ChiTietHoaDon> ds = new ArrayList<>();

    public HoaDon(String maHD, String ngayLap,
                  NhanVien nhanVien, KhachHang khachHang) {

        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;

    }

}
