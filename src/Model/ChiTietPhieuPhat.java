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
public class ChiTietPhieuPhat {
    public int MaPhieuPhat;
    public int MaSach;
    public int SoNgayTre;
    public double TienPhat;

    public ChiTietPhieuPhat() {
    }

    public ChiTietPhieuPhat(int MaPhieuPhat, int MaSach, int SoNgayTre, double TienPhat) {
        this.MaPhieuPhat = MaPhieuPhat;
        this.MaSach = MaSach;
        this.SoNgayTre = SoNgayTre;
        this.TienPhat = TienPhat;
    }
    
    
}
