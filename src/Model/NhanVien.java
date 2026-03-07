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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nganp
 */
public class NhanVien {
    public int MaNV;
    public String TenNhanVien;
    public Date NgaySinh;
    public String DiaChi;
    public String Email;
    public String GioiTinh;
    public Date NgayVaoLam;
    public double Luong;
    public String Username;
    public String pass;

    public NhanVien(int MaNV, String TenNhanVien, Date NgaySinh, String DiaChi, String Email, String GioiTinh, Date NgayVaoLam, double Luong, String Username, String pass) {
        this.MaNV = MaNV;
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.NgayVaoLam = NgayVaoLam;
        this.Luong = Luong;
        this.Username = Username;
        this.pass = pass;
    }

    public NhanVien(int MaNV, String TenNhanVien,Date NgaySinh, String GT, String DiaChi, String Email, double Luong,Date NgayVaoLam) {
        this.MaNV = MaNV;
        this.TenNhanVien = TenNhanVien;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.GioiTinh = GT;
        this.NgayVaoLam = NgayVaoLam;
        this.Luong = Luong;
    }

   
    public NhanVien() {
    }
    
   
}
