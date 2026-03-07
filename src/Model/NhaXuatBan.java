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
public class NhaXuatBan {
    public int MaNXB;
    public String TenNXB;
    public String DiaChi;
    public String SDT;

    public NhaXuatBan() {
    }

    public NhaXuatBan(int MaNXB, String TenNXB, String DiaChi, String SDT) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return  TenNXB ;
    }
    
   
}
