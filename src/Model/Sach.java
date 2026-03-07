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
public class Sach {
    public int maSach;
    public String tenSach;
    public double giaBan;
    public String moTa;
    public  String AnhBia;
    public  int SoLuong;
    public Date NgayCapNhat;
    public boolean Moi;
    public int maTG;
    public String Tentg;
    public int manxb;
    public int macd;

    public Sach(int maSach, String tenSach, double giaBan, String moTa, String AnhBia, int SoLuong, Date NgayCapNhat, boolean Moi, int maTG, String Tentg, int manxb, int macd) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.AnhBia = AnhBia;
        this.SoLuong = SoLuong;
        this.NgayCapNhat = NgayCapNhat;
        this.Moi = Moi;
        this.maTG = maTG;
        this.Tentg = Tentg;
        this.manxb = manxb;
        this.macd = macd;
    }
    
    public Sach(int maSach, String tenSach, double giaBan, String moTa, String AnhBia, int SoLuong, Date NgayCapNhat, boolean Moi) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.AnhBia = AnhBia;
        this.SoLuong = SoLuong;
        this.NgayCapNhat = NgayCapNhat;
        this.Moi = Moi;
    }
    
    public Sach(int maSach, String tenSach, double giaBan, String moTa,String AnhBia,int SoLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.AnhBia=AnhBia;
        this.SoLuong=SoLuong;
    }
    

    public Sach() {
    }
}

