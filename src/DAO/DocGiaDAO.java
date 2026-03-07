/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.DocGia;
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
public class DocGiaDAO {

    public static List<DocGia> getDocGia() {
        List<DocGia> l = new ArrayList<DocGia>();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from DocGia ";
            Statement st = (Statement) con.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                DocGia s = new DocGia(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                );

                l.add(s);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        };
        return l;
    }

    public static int insertDG(DocGia t) {
        return Connect.executeUpdate("insert DocGia(TenDocGia,Email,DiaChi,GioiTinh,NgaySinh,SDT,LoaiKhach)  values(?,?,?,?,?,?,1)", t.TenDocGia, t.Email, t.DiaChi, t.GioiTinh, t.NgaySinh, t.SDT);
    }

    public static int deleteDG(int ma) {

        return Connect.executeUpdate("delete DocGia where MaDocGIa=?", ma);

    }
    
    public static  int updateDG(DocGia t)
    {
        return Connect.executeUpdate("update DocGia set TenDocGia= ?,Email=?,SDT=?,DiaChi=?,GioiTinh=?,NgaySinh=? where MaDocGia=?", t.TenDocGia, t.Email, t.SDT, t.DiaChi, t.GioiTinh, t.NgaySinh, t.MaDocGia);
    }
    
    
}
