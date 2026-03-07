/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nganp
 */
public class TaiKhoan {
    public String TenDangNhap;
    public String MauKhau;
    public int MaNV;
    public String Role;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenDangNhap, String MauKhau, int MaNV, String Role) {
        this.TenDangNhap = TenDangNhap;
        this.MauKhau = MauKhau;
        this.MaNV = MaNV;
        this.Role = Role;
    }
    
    
   
}
