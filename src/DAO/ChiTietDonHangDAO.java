/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiTietDonHang;
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
public class ChiTietDonHangDAO {
       public static List<ChiTietDonHang> getChiTietDonHang() {
        List<ChiTietDonHang> l = new ArrayList<ChiTietDonHang>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from ChiTietDonHang ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ChiTietDonHang s = new ChiTietDonHang(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDonHang.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }
}

