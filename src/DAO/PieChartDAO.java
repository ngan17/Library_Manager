/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class PieChartDAO {
    
public static DefaultPieDataset taoDatasetTinhTrangSach() {
    DefaultPieDataset dataset = new DefaultPieDataset();

    try {
        ResultSet rs = Connect.executeQuery("SELECT TinhTrang, COUNT(*) AS SoLuong FROM CuonSach GROUP BY TinhTrang");
        while (rs.next()) {
            String tinhTrang = rs.getString("TinhTrang");
            int soLuong = rs.getInt("SoLuong");
            dataset.setValue(tinhTrang, soLuong);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return dataset;
}

}
