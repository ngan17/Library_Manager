/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NhanVien;
import Model.PhieuPhat;
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
public class NhanVienDAO {

    public static List<NhanVien> getNhanVien() {
        List<NhanVien> l = new ArrayList<NhanVien>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from NhanVien ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                NhanVien s = new NhanVien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getDate(8)
                );
       
                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }

    public static int insertNV(NhanVien v) {
        return Connect.executeUpdate("insert NhanVien(TenNV,GioiTinh,DiaChi,NgaySinh,NgayVaoLam,Email,Luong) values(?,?,?,?,?,?,?)",v.TenNhanVien,v.GioiTinh,v.DiaChi,v.NgaySinh,v.NgayVaoLam,v.Email,v.Luong );
    }
    public static int deleteNV(int ma)
    {
        return Connect.executeUpdate("delete NhanVien where MaNV=?", ma);
    }
    
    public static int updateNV(NhanVien v)
    {
        return Connect.executeUpdate("update NhanVien set TenNV=?,GioiTinh=?,DiaChi=?,NgayVaoLam=?,Email=?,Luong=? where MaNV=?", v.TenNhanVien,v.GioiTinh,v.DiaChi,v.NgayVaoLam,v.Email,v.Luong,v.MaNV);
    }
    
    
}
