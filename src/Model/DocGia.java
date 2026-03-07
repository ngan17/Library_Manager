/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import DAO.DonHangDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nganp
 */
public class DocGia {
    public int MaDocGia;
    public String TenDocGia;
    public Date NgaySinh;
    public String GioiTinh ;
    public String DiaChi;
    public String Email;
    public int Loai;
    public String SDT;
    

    public DocGia() {
    }

    public DocGia(int MaDocGia, String TenDocGia, Date NgaySinh, String GioiTinh, String DiaChi, String Email, String SDT, int loai) {
        this.MaDocGia = MaDocGia;
        this.TenDocGia = TenDocGia;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Loai = loai;
        this.SDT = SDT;
    }

    public DocGia(int MaDocGia, String TenDocGia, Date NgaySinh, String GioiTinh, String DiaChi, String Email, String SDT) {
        this.MaDocGia = MaDocGia;
        this.TenDocGia = TenDocGia;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SDT = SDT;
    }

   
    public double getTongTien(int Ma)
    {
        double st=0;
        List<DonHang> l=DonHangDAO.getDonHang();
        for(DonHang s:l)
        {
            
            if(s.MaDocGia==Ma)
            {
                st+=s.TongTien;
            }
        }
        return st;
    }
    
    
}
