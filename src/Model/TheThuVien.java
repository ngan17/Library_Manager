/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nganp
 */
public class TheThuVien {

    public int MaDocGia;
    public Date NgayCap;
    public Date NgayHetHan;

    public TheThuVien( int MaDocGia, Date NgayCap, Date NgayHetHan) {

        this.MaDocGia = MaDocGia;
        this.NgayCap = NgayCap;
        this.NgayHetHan = NgayHetHan;
    }

    public TheThuVien() {
    }
    
    
}
