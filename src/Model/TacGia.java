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
public class TacGia {
    public int MaTacgia;
    public String TenTacGia;
    public String DiaChi;
    public String TieuSu;
    public String DienThoai;

    public TacGia() {
    }

    public TacGia(int MaTacgia, String TenTacGia, String DiaChi, String TieuSu, String DienThoai) {
        this.MaTacgia = MaTacgia;
        this.TenTacGia = TenTacGia;
        this.DiaChi = DiaChi;
        this.TieuSu = TieuSu;
        this.DienThoai = DienThoai;
    }

    @Override
    public String toString() {
        return  TenTacGia ;
    }
    
   
}
