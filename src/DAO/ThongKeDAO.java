/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ThongKe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Admin
 */


public class ThongKeDAO {
    public static List<ThongKe> getThongKeTheoNgay() {
        List<ThongKe> list = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            CallableStatement cs = con.prepareCall("{call sp_ThongKeMuonTraTheoNgay}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                list.add(new ThongKe(rs.getDate("Ngay"), rs.getInt("SoLuongMuon"), rs.getInt("SoLuongTra")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
public static XYDataset taoDuLieuThucTe() {
    TimeSeries muon = new TimeSeries("Mượn sách");
    TimeSeries tra = new TimeSeries("Trả sách");

    List<ThongKe> list = ThongKeDAO.getThongKeTheoNgay();

    for (ThongKe t : list) {
        Day ngay = new Day(t.Ngay);  // Ngày từ DB
        muon.addOrUpdate(ngay, t.SoLuongMuon);
        tra.addOrUpdate(ngay, t.SoLuongTra);
    }

    TimeSeriesCollection dataset = new TimeSeriesCollection();
    dataset.addSeries(muon);
    dataset.addSeries(tra);

    return dataset;
}

}

