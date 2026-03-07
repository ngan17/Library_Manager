/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiTietPhieuPhat;
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
public class ChiTietPhieuPhatDAO {

    public static List<ChiTietPhieuPhat> getChiTietPhieuPhat() {
        List<ChiTietPhieuPhat> l = new ArrayList<ChiTietPhieuPhat>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from ChiTietPhieuPhat ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ChiTietPhieuPhat s = new ChiTietPhieuPhat(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4)
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }

    public static int insertCTPP(ChiTietPhieuPhat ct)
    {
        return Connect.executeUpdate("insert ChiTietPhieuPhat values(?,?,?,?)", ct.MaPhieuPhat,ct.MaSach,ct.SoNgayTre,ct.TienPhat);
    }
}
