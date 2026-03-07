/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiTietPhieuMuon;
import Model.ChiTietPhieuTra;
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
public class ChiTietPhieuTraDAO {
        public static List<ChiTietPhieuTra> getChiTietPhieuMuon() {
        List<ChiTietPhieuTra> l = new ArrayList<ChiTietPhieuTra>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from ChiTietPhieuTra ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ChiTietPhieuTra s = new ChiTietPhieuTra(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3)
                     
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }
        
        public static int inssertctpt(ChiTietPhieuTra ct)
        {
            return Connect.executeUpdate("Insert ChiTietPhieuTra(MaPhieuTra,MaCuonSach,GhiChu) values(?,?,?)", ct.MaPhieuTra,ct.MaCuonSach,ct.GhiChu);
        }
}
