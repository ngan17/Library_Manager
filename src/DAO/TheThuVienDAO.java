/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhieuPhat;
import Model.TheThuVien;
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
public class TheThuVienDAO {
    public static List<TheThuVien> getTTV() {
        List<TheThuVien> l = new ArrayList<TheThuVien>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from TheThuVien ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                TheThuVien s = new TheThuVien(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3)
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }

}
