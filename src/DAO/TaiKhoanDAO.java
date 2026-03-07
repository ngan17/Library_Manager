/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhieuPhat;
import Model.TaiKhoan;
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
public class TaiKhoanDAO {
     public static List<TaiKhoan> getTaiKhoan() {
        List<TaiKhoan> l = new ArrayList<TaiKhoan>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from TaiKhoan ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                TaiKhoan s = new TaiKhoan(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
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
