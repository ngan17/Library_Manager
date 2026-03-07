/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Sach;
import Model.SachDGDM;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nganp
 */
public class SachDAO {
     public static List<Sach> getSach() {
       

        List<Sach> l = new ArrayList<Sach>();
        try {
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM DauSach";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Sach s = new Sach(
                        rs.getInt("MaSach"),
                        rs.getString("TenSach"),
                        rs.getInt("GiaBan"),
                        rs.getString("MoTa"),
                        rs.getString("AnhBia"),
                        rs.getInt("SoLuongTon"),
                        rs.getDate("NgayCapNhat"),
                        rs.getBoolean("Moi")
                );
              

                                l.add(s);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }
     
     public static List<Sach> getSachfull() {
       

        List<Sach> l = new ArrayList<Sach>();
        try {
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            CallableStatement cs = conn.prepareCall("{call sp_LayDanhSachSach_KeCaTacGia}");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Sach s = new Sach(
                       rs.getInt("MaSach"),
                        rs.getString("TenSach"),
                        rs.getInt("GiaBan"),
                        rs.getString("MoTa"),
                        rs.getString("AnhBia"),
                        rs.getInt("SoLuongCon"),
                        rs.getDate("NgayCapNhat"),
                        rs.getBoolean("Moi"),
                        rs.getInt("MaTacGia"),
                        rs.getString("TenTacGia"),
                        rs.getInt("MaNXB"),
                        rs.getInt("MaChuDe")
                  
                );
              

                                l.add(s);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }
     
    
     
     public static int capnhatSachNhap(Sach s)
     {
       return Connect.executeUpdate("update DauSach set TenSach=?,GiaBan=?,MoTa=?,NgayCapNhat=?,AnhBia=?,MaChuDe=?,MaNXB=? where MaSach=?",s.tenSach,s.giaBan,s.moTa,s.NgayCapNhat,s.AnhBia,s.macd,s.manxb,s.maSach );
     }
     public static int ThemSachNhap(Sach s)
     {
       return Connect.executeUpdate("Insert  DauSach(TenSach,GiaBan,MoTa,NgayCapNhat,AnhBia,MaChuDe,Moi,MaNXB) values(?,?,?,?,?,?,?,?)",s.tenSach,s.giaBan,s.moTa,s.NgayCapNhat,s.AnhBia,s.macd,1,s.manxb );
     }
     
     public static int capnhatSL(int sl,int ma)
     {
         return Connect.executeUpdate("update DauSach set SoLuongTon+=? where MaSach=?", sl,ma);
     }
     
     
}
