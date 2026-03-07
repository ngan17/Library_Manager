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
public class DonHang {
    public int MaDonHang;
    public int MaDocGia;
    public Date NgayDat;
    public Date NgayGiao;
    public String DaThanhToan;
    public int TinhTrang;
    public double TongTien;

    public DonHang() {
    }

    public DonHang(int MaDonHang, Date NgayDat, Date NgayGiao, String DaThanhToan, int TinhTrang,int MaDocGia) {
        this.MaDonHang = MaDonHang;
        
        this.NgayDat = NgayDat;
        this.NgayGiao = NgayGiao;
        this.DaThanhToan = DaThanhToan;
        this.TinhTrang = TinhTrang;
        this.MaDocGia = MaDocGia;
    }

    public DonHang(int MaDonHang, Date NgayDat, Date NgayGiao, String DaThanhToan, int TinhTrang,int MaDocGia,  double TongTien) {
        this.MaDonHang = MaDonHang;
        this.MaDocGia = MaDocGia;
        this.NgayDat = NgayDat;
        this.NgayGiao = NgayGiao;
        this.DaThanhToan = DaThanhToan;
        this.TinhTrang = TinhTrang;
        this.TongTien = TongTien;
    }
    
   
}
