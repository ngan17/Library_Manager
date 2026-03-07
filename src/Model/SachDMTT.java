/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class SachDMTT {
      public int MaMS;
    public int MaDG;
    public String Ten;
    public Date NgayMuon;
    public int MaCS;
    public String TenSach;
    public String TinhTrang;

    public SachDMTT() {
    }

    public SachDMTT(int MaMS, int MaDG, String Ten, Date NgayMuon, int MaCS, String TenSach, String TinhTrang) {
        this.MaMS = MaMS;
        this.MaDG = MaDG;
        this.Ten = Ten;
        this.NgayMuon = NgayMuon;
        this.MaCS = MaCS;
        this.TenSach = TenSach;
        this.TinhTrang = TinhTrang;
    }
    
    
}
