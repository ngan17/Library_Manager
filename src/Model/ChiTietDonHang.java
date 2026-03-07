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
public class ChiTietDonHang {
    public int MaDonHang;
    public int MaSach;
    public int SoLuong;
    public int DonGia;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(int MaDonHang, int MaSach, int SoLuong, int DonGia) {
        this.MaDonHang = MaDonHang;
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }
   
}
