/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Nganp
 */
public class PhieuNhap {
     public int maPhieuNhap;
    public int maNhanVien;
    public Date ngayNhap;
    public String ghiChu;
    public double TongTien;

    public PhieuNhap() {}

    public PhieuNhap(int maPhieuNhap, int maNhanVien, Date ngayNhap, String ghiChu,double TongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
        this.TongTien=TongTien;
    }
}
