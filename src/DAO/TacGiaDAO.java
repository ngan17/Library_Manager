/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhieuPhat;
import Model.TacGia;
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
public class TacGiaDAO {
    public static List<TacGia> getTacGia() {
        List<TacGia> l = new ArrayList<TacGia>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from TacGia ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                TacGia s = new TacGia(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }
    
    public static int InsertTG(TacGia t)
    {
        return Connect.executeUpdate("Insert TacGia(TenTacGia,DiaChi,TieuSu,DienThoai) values(?,?,?,?)", t.TenTacGia,t.DiaChi,t.TieuSu,t.DienThoai);
    }
    
    public static  int DeleteTG(int Ma)
    {
        return Connect.executeUpdate("delete TacGia where MaTacGia=?", Ma);
    }
    
    
}
