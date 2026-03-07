/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.SachDGDM;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nganp
 */
public class SachDGDMDAO {

    public static List<SachDGDM> getSach() {

        List<SachDGDM> l = new ArrayList<SachDGDM>();
        try {
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            CallableStatement cs = conn.prepareCall("{call sp_DocGiaDangMuon_ChiTietDayDu}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                SachDGDM s = new SachDGDM(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6)
                );

                l.add(s);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }

    public static List<SachDGDM> Seachs(String x) {

        List<SachDGDM> l = new ArrayList<SachDGDM>();
        try {
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            CallableStatement cstmt = conn.prepareCall("{call sp_TimKiemDocGiaDangMuon_1TextBox(?)}");
            cstmt.setString(1, x.trim());
            ResultSet rs = cstmt.executeQuery();
// Load rs vào bảng

            while (rs.next()) {
                SachDGDM s = new SachDGDM(
                        rs.getInt("MaDocGia"),
                        rs.getString("TenDocGia"),
                        rs.getInt("MaPhieuMuon"),
                        rs.getDate("NgayMuon"),
                        rs.getInt("MaCuonSach"),
                        rs.getString("TenSach")
                );

                l.add(s);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }
    
    
    public static List<SachDGDM> QuaHan( ) {

        List<SachDGDM> l = new ArrayList<SachDGDM>();
        try {
            Connection conn = Connect.getConnection();
            Statement st = conn.createStatement();
            CallableStatement cstmt = conn.prepareCall("{call sp_SachMuonQuaHan7Ngay}");
           
            ResultSet rs = cstmt.executeQuery();
// Load rs vào bảng

            while (rs.next()) {
                SachDGDM s = new SachDGDM(
                        rs.getInt("MaDocGia"),
                        rs.getString("TenDocGia"),
                        rs.getInt("MaPhieuMuon"),
                        rs.getDate("NgayMuon"),
                        rs.getInt("MaCuonSach"),
                        rs.getString("TenSach")
                        
                );
                s.SoNgayMuon=rs.getString ("SoNgayDaMuon");
                l.add(s);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }
// Load rs vào bảng

}
