/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nganp
 */
package DAO;

import Model.TaiKhoan;
import Model.NhanVien;
import Model.TheThuVien;
import Model.DocGia;
import Model.DonHang;
import Model.NhaXuatBan;
import Model.ChiTietDonHang;
import Model.Sach;
import Model.PhieuMuon;
import Model.TacGia;
import Model.ChuDe;
import Model.PhieuPhat;
import Model.ChiTietPhieuMuon;
import Model.ChiTietPhieuPhat;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class Connect {

    private static final String URL = "jdbc:sqlserver://ADMIN-PC\\SQLEXPRESS02:1433;databaseName=QuanLyBanSach;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy JDBC Driver", e);
        }
    }
// Execute SELECT với tham số

    public static ResultSet executeQuery(String sql, Object... params) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            setParameters(pstmt, params);
            return pstmt.executeQuery(); // Không đóng conn/pstmt ở đây
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

// Execute INSERT/UPDATE/DELETE với tham số
    public static int executeUpdate(String sql, Object... params) {
        int result = 0;
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setParameters(pstmt, params);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

// Hàm set tham số cho PreparedStatement
    private static void setParameters(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }

}
