/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class PhieuPhatDAO {
    public static List<PhieuPhat> getPhieuPhat() {
        List<PhieuPhat> l = new ArrayList<PhieuPhat>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from PhieuPhat ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                PhieuPhat s = new PhieuPhat(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
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
    
        public static int insertPP(PhieuPhat pp) {
        return Connect.executeUpdate("insert PhieuPhat(MaPhieuMuon,NgayLap) values(?,?)", pp.MaPhieuMuon,pp.NgayLap);
    }

}
