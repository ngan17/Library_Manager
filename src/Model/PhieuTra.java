package Model;

import java.util.Date;

public class PhieuTra {
    public int MaPhieuTra;
    public int MaDocGia;
    public Date NgayTra;
    public int MaPM;

   public String GhiChu;

    public PhieuTra(int MaPhieuTra, int MaPM,  Date NgayTra, String GhiChu, int MaDocGia) {
        this.MaPhieuTra = MaPhieuTra;
        this.MaDocGia = MaDocGia;
        this.NgayTra = NgayTra;
        this.MaPM = MaPM;
   
        this.GhiChu = GhiChu;
    }

 

    public PhieuTra() {
    }

    public PhieuTra(int maPhieuTra, int maDocGia, Date ngayTra) {
        this.MaPhieuTra = maPhieuTra;
        this.MaDocGia = maDocGia;
        this.NgayTra = ngayTra;
    }

  
}
