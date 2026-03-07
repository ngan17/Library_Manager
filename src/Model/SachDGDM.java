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
public class SachDGDM {
    public int MaMS;
    public int MaDG;
    public String Ten;
    public Date NgayMuon;
    public int MaCS;
    public String TenSach;
    public String SoNgayMuon;

    public SachDGDM() {
    }

    public SachDGDM(int MaDG,String Ten  ,int MaMS, Date NgayMuon, int MaCS, String TenSach) {
        this.MaMS = MaMS;
        this.MaDG = MaDG;
        this.Ten = Ten;
        this.NgayMuon = NgayMuon;
        this.MaCS = MaCS;
        this.TenSach = TenSach;
    }
    
    
    
}
