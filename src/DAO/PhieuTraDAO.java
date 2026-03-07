/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhieuMuon;
import Model.PhieuPhat;
import Model.PhieuTra;
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
public class PhieuTraDAO {
     public static List<PhieuTra> getPhieuTra() {
        List<PhieuTra> l = new ArrayList<PhieuTra>();

        try {
            Connection con = Connect.getConnection();
            String sql = "select * from PhieuTra ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                PhieuTra s = new PhieuTra(
                        rs.getInt(1),
                        rs.getInt(2),
                       
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5)
                        
                );

                l.add(s);
                
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuTra.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }
     
     
     public static int insertPT(PhieuTra p)
     {
         System.out.println(p.MaPM+" "+p.GhiChu+" "+p.MaDocGia);
         return Connect.executeUpdate("Insert PhieuTra(MaPhieuMuon,NgayTra,GhiChu,MaDocGia) values(?,?,?,?)", p.MaPM,p.NgayTra,p.GhiChu,p.MaDocGia);
     }
}
