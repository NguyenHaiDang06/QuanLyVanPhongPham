/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon {

    private SanPham sanPham;
    private int soLuong;
    private double donGia;

    public ChiTietHoaDon(SanPham sanPham, int soLuong, double donGia) {

        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;

    }

    public double tinhTien(){

        return soLuong * donGia;

    }

}
