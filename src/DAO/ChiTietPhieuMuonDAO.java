/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiTietPhieuMuon;
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
public class ChiTietPhieuMuonDAO {
    
    public static List<ChiTietPhieuMuon> getChiTietPhieuMuon() {
        List<ChiTietPhieuMuon> l = new ArrayList<ChiTietPhieuMuon>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from ChiTietPhieuMuon ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ChiTietPhieuMuon s = new ChiTietPhieuMuon(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)
                     
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }
    public static  int insertCTPM(int MaPM,int MaSach,int SL)
    {
        return Connect.executeUpdate("insert ChiTietPhieuMuon(MaPhieuMuon,MaCuonSach,SoLuong) values (?,?,?)",MaPM, MaSach, SL );
    }


}
    