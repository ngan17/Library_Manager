/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nganp
 */
public class PhieuPhat {
    public int MaPhieuPhat;
    public int MaPhieuMuon;
    public Date NgayLap;
    public double TongTien;
     

    public PhieuPhat() {
    }

    public PhieuPhat(int MaPhieuPhat, int MaPhieuMuon, Date NgayLap, double TongTien) {
        this.MaPhieuPhat = MaPhieuPhat;
        this.MaPhieuMuon = MaPhieuMuon;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }
    
    
}
