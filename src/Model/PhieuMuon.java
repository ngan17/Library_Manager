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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nganp
 */
public class PhieuMuon {
    public int MaPhieuMuon;
    public int MaDocGia;

    
    public Date NgayMuon;
    public Date NgayTra;
    
    public PhieuMuon() {
    }

    public PhieuMuon(int MaPhieuMuon, int MaDocGia, Date NgayMuon, Date NgayTra) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaDocGia = MaDocGia;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
    }
    
    
}
