/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

/**
 *
 * @author Admin
 */
public class NhaCungCap {

    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String sdt;

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String hienThi(){
        return maNCC + " | " + tenNCC + " | " + diaChi + " | " + sdt;
    }

}
