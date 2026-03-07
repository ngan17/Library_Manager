/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhieuMuon;
import Model.PhieuPhat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
    import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Nganp
 */
public class PhieuMuonDAO {
     public static List<PhieuMuon> getPhieuMuon() {
        List<PhieuMuon> l = new ArrayList<PhieuMuon>();

        try {
            Connection con = Connect.getConnection();
            String sql = "select * from PhieuMuon ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                PhieuMuon s = new PhieuMuon(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDate(4)
                );

                l.add(s);
                
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }
     
     
     public static int insertPhieuMuon(String MaDG,String NgayMuon, String NgayTra)
     {
         Connect con=new Connect();
         return con.executeUpdate("insert PhieuMuon(MaDocGia,NgayMuon,NgayTra) values (?,?,?)", Integer.parseInt(MaDG) , NgayMuon,  NgayTra );
     
     
     }





    public static XYSeriesCollection getDocGiaMuonTraTheoNgaySpline() {
        XYSeries muonSeries = new XYSeries("Mượn sách");
        XYSeries traSeries = new XYSeries("Trả sách");

        Map<String, Integer> ngayToIndex = new TreeMap<>();
        int index = 1;

        try {
            Connection conn = Connect.getConnection();

            // Mượn sách
            String sqlMuon = "SELECT CONVERT(date, NgayMuon) AS Ngay, COUNT(DISTINCT MaDocGia) AS SoLuong " +
                    "FROM PhieuMuon GROUP BY CONVERT(date, NgayMuon) ORDER BY Ngay";
            PreparedStatement pstMuon = conn.prepareStatement(sqlMuon);
            ResultSet rsMuon = pstMuon.executeQuery();

            while (rsMuon.next()) {
                String ngay = rsMuon.getString("Ngay");
                int sl = rsMuon.getInt("SoLuong");

                // ánh xạ ngày -> index
                if (!ngayToIndex.containsKey(ngay)) {
                    ngayToIndex.put(ngay, index++);
                }
                muonSeries.add((double)ngayToIndex.get(ngay), sl);
            }

            // Trả sách
            String sqlTra = "SELECT CONVERT(date, NgayTra) AS Ngay, COUNT(DISTINCT MaPhieuMuon) AS SoLuong " +
                    "FROM PhieuTra GROUP BY CONVERT(date, NgayTra) ORDER BY Ngay";
            PreparedStatement pstTra = conn.prepareStatement(sqlTra);
            ResultSet rsTra = pstTra.executeQuery();

            while (rsTra.next()) {
                String ngay = rsTra.getString("Ngay");
                int sl = rsTra.getInt("SoLuong");

                if (!ngayToIndex.containsKey(ngay)) {
                    ngayToIndex.put(ngay, index++);
                }
                traSeries.add((double)ngayToIndex.get(ngay), sl);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(muonSeries);
        dataset.addSeries(traSeries);
        return dataset;
    }
}

    

