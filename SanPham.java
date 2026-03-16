/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

/**
 *
 * @author Admin
 */
public class SanPham {

    private String maSP;
    private String tenSP;
    private String donViTinh;
    private double donGia;
    private int soLuongTon;

    private LoaiSanPham loai;
    private NhaCungCap nhaCungCap;

    public SanPham(String maSP, String tenSP, String donViTinh,
                   double donGia, int soLuongTon,
                   LoaiSanPham loai, NhaCungCap nhaCungCap) {

        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.loai = loai;
        this.nhaCungCap = nhaCungCap;
    }

    public String hienThi(){

        return maSP + " | " + tenSP + " | " + donGia + " | " + soLuongTon;

    }

}