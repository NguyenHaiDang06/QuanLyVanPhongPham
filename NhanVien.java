/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;

public class NhanVien {

    public static ArrayList<NhanVien> ds = new ArrayList<>();

    String username;
    String password;

    public NhanVien(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public static boolean dangNhap(String user, String pass){

        for(NhanVien nv : ds){

            if(nv.username.equals(user) && nv.password.equals(pass)){
                return true;
            }

        }

        return false;

    }

    public static boolean tonTai(String user){

        for(NhanVien nv : ds){

            if(nv.username.equals(user)){
                return true;
            }

        }

        return false;

    }

}
