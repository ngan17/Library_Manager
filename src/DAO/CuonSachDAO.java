/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CuonSach;
import Model.PhieuPhat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nganp
 */
public class CuonSachDAO {

    public static List<CuonSach> getCuonSach() {
        List<CuonSach> l = new ArrayList<CuonSach>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from CuonSach ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                CuonSach s = new CuonSach(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }

    public static List<String> getMaCuonByMaSach(int maSach) {
        List<String> list = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT MaCuonSach FROM CuonSach WHERE MaDauSach = ? AND TinhTrang = N'Có sẵn'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maSach);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(String.valueOf(rs.getInt("MaCuonSach")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<CuonSach> getByMaSach(int ma)
    {
         List<CuonSach> l = new ArrayList<CuonSach>();
        ResultSet rs=Connect.executeQuery("Select * from CuonSach Where MaDauSach=?", ma);
        
        try {
            while (rs.next()) {
                CuonSach s = new CuonSach(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                );

                l.add(s);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CuonSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public static int autoTra(String TT,int SL)
    {
        if (TT.equals("Tốt"))
        {
            TT="Có sẵn";
        }
        System.out.println("Ma sach: " +SL);
        return Connect.executeUpdate("update CuonSach set TinhTrang=? where MaCuonSach=?", TT,SL);
    }

}
