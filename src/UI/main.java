/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Model.TaiKhoan;
import Model.NhanVien;
import Model.TheThuVien;
import Model.DonHang;
import Model.DocGia;
import Model.NhaXuatBan;
import Model.ChiTietDonHang;
import Model.Sach;
import Model.PhieuMuon;
import Model.TacGia;
import Model.PhieuPhat;
import Model.ChuDe;
import Model.ChiTietPhieuMuon;
import Model.ChiTietPhieuPhat;
import DAO.ChiTietDonHangDAO;
import DAO.ChiTietPhieuMuonDAO;
import DAO.ChiTietPhieuNhapDAO;
import DAO.ChiTietPhieuPhatDAO;
import DAO.ChiTietPhieuTraDAO;
import DAO.ChuDeDAO;
import DAO.TheThuVienDAO;
import DAO.TaiKhoanDAO;
import DAO.CuonSachDAO;
import DAO.DocGiaDAO;
import DAO.NhaXuatBanDAO;
import DAO.NhanVienDAO;
import DAO.PhieuMuonDAO;
import DAO.PhieuNhapDAO;
import DAO.PhieuPhatDAO;
import DAO.PhieuTraDAO;
import DAO.SachDAO;
import DAO.SachDGDMDAO;
import DAO.TacGiaDAO;
import DAO.ThongKeDAO;
import Model.ChiTietPhieuNhap;
import Model.ChiTietPhieuTra;
import Model.CuonSach;
import Model.PhieuNhap;
import Model.PhieuTra;
import Model.SachChon;
import Model.SachDGDM;
import Model.SachDMTT;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nganp
 */
public class main extends javax.swing.JFrame {

    DocGia xSelected = new DocGia();
    String pathEdit;
    String pathEdit2;
    int mouseX, mouseY;
    List<Sach> listSach = new ArrayList<Sach>();
    List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
    List<DocGia> listDocGia = new ArrayList<DocGia>();
    List<TacGia> listTacGia = new ArrayList<TacGia>();
    List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
    List<NhaXuatBan> listNXB = new ArrayList<NhaXuatBan>();
    List<TheThuVien> listTTV = new ArrayList<TheThuVien>();
    List<ChuDe> listChuDe = new ArrayList<ChuDe>();
    List<DonHang> listDonHang = new ArrayList<DonHang>();
    List<ChiTietDonHang> listChiTietDonHang = new ArrayList<ChiTietDonHang>();
    List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
    List<ChiTietPhieuMuon> listChiTietPhieuMuon = new ArrayList<ChiTietPhieuMuon>();
    List<PhieuPhat> listPhieuPhat = new ArrayList<PhieuPhat>();
    List<ChiTietPhieuPhat> listChiTietPhieuPhat = new ArrayList<ChiTietPhieuPhat>();
    List<SachChon> listSachDCM = new ArrayList<SachChon>();
    List<SachDGDM> listSachDGDM = new ArrayList<SachDGDM>();
    List<Integer> listMaTG = new ArrayList<Integer>();
    List<Integer> listMaNXB = new ArrayList<Integer>();
    List<Integer> listMaCD = new ArrayList<Integer>();
    List<Sach> listSachNhap = new ArrayList<Sach>();
    List<PhieuNhap> listPhieuNhap = new ArrayList<PhieuNhap>();
    List<ChiTietPhieuNhap> listCTPN = new ArrayList<ChiTietPhieuNhap>();
    TaiKhoan tk = new TaiKhoan();
    List<SachDMTT> listTra = new ArrayList<SachDMTT>();
    List<PhieuTra> listPT = new ArrayList<PhieuTra>();
    List<Sach> listDST = new ArrayList<Sach>();
    List<SachDGDM> listSachTre = new ArrayList<SachDGDM>();
    String tenNV;

    /**
     * Creates new form main
     */
    public main() {
        setUndecorated(true);

        initComponents();

        loadDataBase();

        load_BD();
        ((GradientPanel) MenuPN).setGradient(Color.decode("#1cb5e0"), Color.decode("#000046"));
        jPanel7.setOpaque(false);
        jPanel6.setOpaque(false);

        LoginDialog d = new LoginDialog(this);
        d.l = listTaiKhoan;

        d.show();
        tk = d.x;
        for (NhanVien n : listNhanVien) {
            if (n.MaNV == tk.MaNV) {
                tenNV = n.TenNhanVien;
            }
        }

        Home.setOpaque(false);
        Muon.setOpaque(false);
        Tra.setOpaque(false);
        Sach.setOpaque(false);

        DSPhat.setOpaque(false);
        ;
        DocGia.setOpaque(false);
        PhieuMuon.setOpaque(false);
        NhanVien.setOpaque(false);

        Home.setBackground(Color.WHITE);;
        Muon.setBackground(Color.WHITE);
        Tra.setBackground(Color.WHITE);
        Sach.setBackground(Color.WHITE);

        DSPhat.setBackground(Color.WHITE);
        PhieuTra.setBackground(Color.WHITE);
        DocGia.setBackground(Color.WHITE);
        PhieuMuon.setBackground(Color.WHITE);
        NhanVien.setBackground(Color.WHITE);

        //--------------------------------------------------
        CHonDGPanel.setName("CHỌN DG");
        Home.setName("HOME");
        Muon.setName("MƯỢN SÁCH");
        Tra.setName("TRẢ SÁCH");
        Sach.setName("SÁCH");
        PhieuTra.setName("PHIẾU TRẢ");
        DSPhat.setName("DS PHẠT");
        ChiTietPhieuMuon.setName("Chi tiết phiếu mượn");
        DocGia.setName("ĐỘC GIẢ");
        PhieuMuon.setName("PHIẾU MƯỢN");
        Sach1.setName("Nhập sách");
        NhanVien.setName("NHÂN VIÊN");
        ChiTietPT.setName("Chi tiết PT");
        CHonDGPanel1.setName("CHỌN DG1");

    }

    void SetShowPage(String Name) {

        List<JPanel> listPN = new ArrayList<JPanel>();
        listPN.add(Home);
        listPN.add(Muon);
        listPN.add(Tra);
        listPN.add(Sach);
        listPN.add(ChiTietPhieuMuon);
        listPN.add(DSPhat);
        listPN.add(ChiTietPT);
        listPN.add(DocGia);
        listPN.add(PhieuMuon);
        listPN.add(CHonDGPanel);
        listPN.add(NhanVien);
        listPN.add(PhieuTra);
        listPN.add(CHonDGPanel1);
        listPN.add(Sach1);
        for (JPanel pn : listPN) {

            if (pn.getName().equals(Name)) {
                pn.setVisible(true);
            } else {
                pn.setVisible(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel91 = new javax.swing.JLabel();
        txtTenTG = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        btnThemTG = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        txtDiaChiTG = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        txtDienThoaitg = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTieuSu = new javax.swing.JTextArea();
        jDialog2 = new javax.swing.JDialog();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        txtTenTL = new javax.swing.JTextField();
        btnThemTL = new javax.swing.JButton();
        TimDocGia = new javax.swing.JDialog();
        jButton6 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        txtSearchSach = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblSachChuaTra = new javax.swing.JTable();
        jLabel114 = new javax.swing.JLabel();
        btnChonSachTra = new javax.swing.JButton();
        ThemDauSach = new javax.swing.JDialog();
        jLabel116 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        Anh2 = new javax.swing.JLabel();
        btnChonAnh2 = new javax.swing.JButton();
        txtTenSach2 = new javax.swing.JTextField();
        txtGiaBan2 = new javax.swing.JTextField();
        jScrollPane22 = new javax.swing.JScrollPane();
        txtMoTa2 = new javax.swing.JTextArea();
        jLabel126 = new javax.swing.JLabel();
        cboTheLoai4 = new javax.swing.JComboBox<>();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        cboNXB3 = new javax.swing.JComboBox<>();
        cboTG3 = new javax.swing.JComboBox<>();
        txtNgayCapNhat2 = new com.toedter.calendar.JDateChooser();
        jScrollPane23 = new javax.swing.JScrollPane();
        tblSach3 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        SachDM = new javax.swing.JDialog();
        jPanel56 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tblSachTre = new javax.swing.JTable();
        jPanel63 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        MainPN = new javax.swing.JPanel();
        HeaderPN = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CenterPN = new javax.swing.JPanel();
        MenuPN = new UI.GradientPanel();
        jPanel7 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        btnMuonSach = new javax.swing.JLabel();
        btnTra = new javax.swing.JLabel();
        btnSach = new javax.swing.JLabel();
        btnPhieuMuon = new javax.swing.JLabel();
        btnDSPhat = new javax.swing.JLabel();
        btnPhieuTra = new javax.swing.JLabel();
        btnDocGia = new javax.swing.JLabel();
        btnNhanVien = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        PagePN = new UI.GradientPanel();
        Home = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        LbSLDG = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        lbSlSach = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        LBSachDM = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        LBTien = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        LBTre = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbSachTre = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        BieuDoDGC = new javax.swing.JPanel();
        Muon = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenDocGiaMS = new javax.swing.JTextField();
        txtDiaChiMS = new javax.swing.JTextField();
        txtSDTMS = new javax.swing.JTextField();
        txtMaDocGiaMS = new javax.swing.JTextField();
        txtEmailMS = new javax.swing.JTextField();
        txtGioiTinhMS = new javax.swing.JComboBox<>();
        btnThemMS = new javax.swing.JButton();
        btnLoadDGMS = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        txtNgayTraDGMS = new com.toedter.calendar.JDateChooser();
        txtNgayMuonDGMS = new com.toedter.calendar.JDateChooser();
        txtNgaySinhDGMS = new com.toedter.calendar.JDateChooser();
        ItemSelectedPN = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        ItemSelect = new javax.swing.JPanel();
        BtnPanel = new javax.swing.JPanel();
        btnSuccess = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemPNMuon = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        Tra = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtTenDocGiaTS = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cboTinhTrang = new javax.swing.JComboBox<>();
        jLabel110 = new javax.swing.JLabel();
        txtNgayMuonTS = new com.toedter.calendar.JDateChooser();
        txtNgayTraTS = new com.toedter.calendar.JDateChooser();
        jLabel111 = new javax.swing.JLabel();
        cboMaDG = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtMaPMTS = new javax.swing.JTextField();
        sadđ = new javax.swing.JLabel();
        txtTenSachTS = new javax.swing.JTextField();
        cboMaCS = new javax.swing.JComboBox<>();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblDocGiaChon2 = new javax.swing.JTable();
        Sach = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btnChuDe = new javax.swing.JButton();
        btnTacGia = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        rdoNew = new javax.swing.JRadioButton();
        Anh = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel88 = new javax.swing.JLabel();
        cboTheLoai2 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        cboNXB = new javax.swing.JComboBox<>();
        cboTG1 = new javax.swing.JComboBox<>();
        txtNgayCapNhat = new com.toedter.calendar.JDateChooser();
        jPanel14 = new javax.swing.JPanel();
        btnThemSach = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        btnSuaSach = new javax.swing.JButton();
        btnXemChiTietSach = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cboTheLoai = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        cboTG = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        LBtable = new javax.swing.JLabel();
        cboNXB1 = new javax.swing.JComboBox<>();
        ItemPNMuon1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCS = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblSach1 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        PhieuMuon = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtMaDocGia = new javax.swing.JTextField();
        txtMaPhieu = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtNgayMuonPM = new com.toedter.calendar.JDateChooser();
        txtNgayTraDukien = new com.toedter.calendar.JDateChooser();
        jPanel23 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPhieuMuon = new javax.swing.JTable();
        DSPhat = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txtMaPhieuPhat = new javax.swing.JTextField();
        txtMaDocGiaPM = new javax.swing.JTextField();
        txtTongTienPM = new javax.swing.JTextField();
        txtNgayLapPM = new javax.swing.JFormattedTextField();
        jPanel29 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblPhieuPhat = new javax.swing.JTable();
        DocGia = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTenDocGiaDG = new javax.swing.JTextField();
        txtDiaChiDG = new javax.swing.JTextField();
        txtSDTDG = new javax.swing.JTextField();
        txtMaDocGiaDG = new javax.swing.JTextField();
        txtEmailDG = new javax.swing.JTextField();
        cboGTDG = new javax.swing.JComboBox<>();
        txtNgaySinhDG = new com.toedter.calendar.JDateChooser();
        jPanel32 = new javax.swing.JPanel();
        btnSuaDG = new javax.swing.JButton();
        btnThemDG = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDocGia = new javax.swing.JTable();
        NhanVien = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtDiaChiNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtMaNhanVienNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        txtGTNV = new javax.swing.JComboBox<>();
        txtNgaysinhNV = new javax.swing.JFormattedTextField();
        jLabel81 = new javax.swing.JLabel();
        txtLuongNV = new javax.swing.JTextField();
        txtNVL = new javax.swing.JFormattedTextField();
        jLabel82 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        btnThemNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnSuaNV = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        CHonDGPanel = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        btnChonDG = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        ItemPNBan1 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblDocGiaChon = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        CHonDGPanel1 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        btnChonDG1 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ItemPNBan2 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblDocGiaChon1 = new javax.swing.JTable();
        jPanel52 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        Sach1 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        btnChuDe1 = new javax.swing.JButton();
        btnTacGia1 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        rdoNew1 = new javax.swing.JRadioButton();
        Anh1 = new javax.swing.JLabel();
        btnChonAnh1 = new javax.swing.JButton();
        txtTenSach1 = new javax.swing.JTextField();
        txtGiaBan1 = new javax.swing.JTextField();
        txtSoLuong1 = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        txtMoTa1 = new javax.swing.JTextArea();
        jLabel107 = new javax.swing.JLabel();
        cboTheLoai3 = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        cboNXB2 = new javax.swing.JComboBox<>();
        cboTG2 = new javax.swing.JComboBox<>();
        cboMas = new javax.swing.JComboBox<>();
        txtNgayCapNhat1 = new com.toedter.calendar.JDateChooser();
        jPanel26 = new javax.swing.JPanel();
        btnThemSach1 = new javax.swing.JButton();
        btnXoaSach1 = new javax.swing.JButton();
        btnHoanTat = new javax.swing.JButton();
        btnHoanTat1 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        LBtable1 = new javax.swing.JLabel();
        ItemPNMuon2 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblSach2 = new javax.swing.JTable();
        PhieuTra = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtMaDocGia1 = new javax.swing.JTextField();
        txtMaPMPT = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtNgayTraPT = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        txtMaPTPT = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPhieuTra = new javax.swing.JTable();
        ChiTietPT = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtMaDocGia2 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txtMaPTPT1 = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblCTPT = new javax.swing.JTable();
        ChiTietPhieuMuon = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtMaDocGia3 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        txtMaPTPT2 = new javax.swing.JTextField();
        txtGhiChu1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jPanel67 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tblCTPT1 = new javax.swing.JTable();
        TaiKhoan = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtMaDocGia4 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        txtMaPTPT3 = new javax.swing.JTextField();
        txtGhiChu2 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jPanel70 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        tblCTPT2 = new javax.swing.JTable();

        jDialog1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog1MouseClicked(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel91.setText("Tên tác giả:");

        jLabel92.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel92.setText("THÊM TÁC GIẢ");

        btnThemTG.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemTG.setText("THÊM");
        btnThemTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTGActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel93.setText("Địa chỉ:");

        jLabel94.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel94.setText("Điện thoại");

        jLabel95.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel95.setText("Tiểu sử:");

        txtTieuSu.setColumns(20);
        txtTieuSu.setLineWrap(true);
        txtTieuSu.setRows(5);
        txtTieuSu.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txtTieuSu);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel95))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jDialog1Layout.createSequentialGroup()
                                        .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel94)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDienThoaitg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDialog1Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(btnThemTG))
                                    .addComponent(jScrollPane6)
                                    .addComponent(txtDiaChiTG))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91)
                    .addComponent(txtDienThoaitg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(txtDiaChiTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnThemTG)
                .addContainerGap())
        );

        jLabel96.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel96.setText("THÊM THỂ LOẠI");

        jLabel97.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel97.setText("Tên thể loại:");

        btnThemTL.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemTL.setText("Thêm");
        btnThemTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel96))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel97)
                        .addGap(32, 32, 32)
                        .addComponent(txtTenTL, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnThemTL)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel96)
                .addGap(18, 18, 18)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(txtTenTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemTL))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel112.setText("Từ khóa");

        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jLabel113.setText("Ngày mượn");

        tblSachChuaTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Mã cuốn sách", "Tên sách", "Mã độc giả", "Tên độc giả", "Ngày mượn"
            }
        ));
        jScrollPane21.setViewportView(tblSachChuaTra);

        jLabel114.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel114.setText("SÁCH CHƯA TRẢ");

        btnChonSachTra.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnChonSachTra.setText("CHỌN");
        btnChonSachTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSachTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TimDocGiaLayout = new javax.swing.GroupLayout(TimDocGia.getContentPane());
        TimDocGia.getContentPane().setLayout(TimDocGiaLayout);
        TimDocGiaLayout.setHorizontalGroup(
            TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimDocGiaLayout.createSequentialGroup()
                .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TimDocGiaLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btnChonSachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TimDocGiaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TimDocGiaLayout.createSequentialGroup()
                                .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel113)
                                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TimDocGiaLayout.createSequentialGroup()
                                        .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSearchSach, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addComponent(jButton6)))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        TimDocGiaLayout.setVerticalGroup(
            TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimDocGiaLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel114)
                .addGap(18, 18, 18)
                .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(txtSearchSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TimDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonSachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel116.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel116.setText("THÊM ĐẦU SÁCH");

        jLabel119.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel119.setText("Tên sách");

        jLabel120.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel120.setText("Giá:");

        jLabel121.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel121.setText("Mô tả");

        jLabel122.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel122.setText("Ngày cập nhật:");

        jLabel123.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel123.setText("Ảnh bìa:");

        btnChonAnh2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnChonAnh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gallery.png"))); // NOI18N
        btnChonAnh2.setText("Chọn ảnh");
        btnChonAnh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnh2ActionPerformed(evt);
            }
        });

        txtGiaBan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBan2ActionPerformed(evt);
            }
        });

        txtMoTa2.setColumns(20);
        txtMoTa2.setRows(5);
        jScrollPane22.setViewportView(txtMoTa2);

        jLabel126.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel126.setText("Thể loại");

        jLabel127.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel127.setText("Tác giả");

        jLabel128.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel128.setText("NXB");

        txtNgayCapNhat2.setDateFormatString("dd/MM/yyyy");
        txtNgayCapNhat2.setEnabled(false);

        tblSach3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên sách", "Giá bán", "Mô tả", "Ngày cập nhật", "Ảnh bìa", "Mới", "Mã tác giả", "Mã NXB", "Mã chủ đè"
            }
        ));
        tblSach3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSach3MouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tblSach3);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton12.setText("Thêm");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton13.setText("Xóa");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton14.setText("Sửa");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked.png"))); // NOI18N
        jButton15.setText("Hoàn tất");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ThemDauSachLayout = new javax.swing.GroupLayout(ThemDauSach.getContentPane());
        ThemDauSach.getContentPane().setLayout(ThemDauSachLayout);
        ThemDauSachLayout.setHorizontalGroup(
            ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThemDauSachLayout.createSequentialGroup()
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSach2)
                    .addComponent(txtGiaBan2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel128)
                    .addComponent(jLabel126)
                    .addComponent(jLabel127)
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboNXB3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayCapNhat2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTheLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel123, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ThemDauSachLayout.createSequentialGroup()
                                .addComponent(btnChonAnh2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addComponent(cboTG3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Anh2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ThemDauSachLayout.createSequentialGroup()
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(ThemDauSachLayout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ThemDauSachLayout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGap(365, 365, 365)))
        );
        ThemDauSachLayout.setVerticalGroup(
            ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThemDauSachLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel116)
                .addGap(18, 18, 18)
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel121)
                                .addComponent(jLabel122)
                                .addComponent(jLabel123)
                                .addComponent(jLabel119)
                                .addComponent(txtTenSach2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNgayCapNhat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ThemDauSachLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGiaBan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel120)))
                            .addGroup(ThemDauSachLayout.createSequentialGroup()
                                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnChonAnh2)
                                    .addComponent(cboNXB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel128))
                                .addGap(8, 8, 8)
                                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel126)
                                    .addComponent(cboTheLoai4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel127)
                                    .addComponent(cboTG3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(Anh2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ThemDauSachLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(ThemDauSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ThemDauSachLayout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(jLabel125)
                    .addGap(0, 307, Short.MAX_VALUE)))
        );

        jPanel56.setLayout(new java.awt.BorderLayout());

        jPanel62.setLayout(new java.awt.BorderLayout());

        tblSachTre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Mã phiếu mượn", "Ngày mượn", "Mã cuốn sách", "Tên sách", "Số ngày mượn"
            }
        ));
        tblSachTre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachTreMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tblSachTre);

        jPanel62.add(jScrollPane26, java.awt.BorderLayout.CENTER);

        jPanel56.add(jPanel62, java.awt.BorderLayout.CENTER);

        jLabel118.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel118.setText("SÁCH ĐANG TRỄ");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel118)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel56.add(jPanel63, java.awt.BorderLayout.NORTH);

        SachDM.getContentPane().add(jPanel56, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPN.setLayout(new java.awt.BorderLayout());

        HeaderPN.setBackground(new java.awt.Color(0, 102, 153));
        HeaderPN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderPNMouseDragged(evt);
            }
        });
        HeaderPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderPNMousePressed(evt);
            }
        });
        HeaderPN.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ THƯ VIỆN");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 19));
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        HeaderPN.add(jLabel2, java.awt.BorderLayout.CENTER);

        MainPN.add(HeaderPN, java.awt.BorderLayout.NORTH);

        CenterPN.setLayout(new java.awt.BorderLayout());

        MenuPN.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridLayout(0, 1, 2, 0));

        btnHome.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-page.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.setToolTipText("");
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });
        jPanel7.add(btnHome);
        btnHome.getAccessibleContext().setAccessibleName("");

        btnMuonSach.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnMuonSach.setForeground(new java.awt.Color(255, 255, 255));
        btnMuonSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrow.png"))); // NOI18N
        btnMuonSach.setText("MƯỢN SÁCH");
        btnMuonSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMuonSach.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMuonSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMuonSachMouseClicked(evt);
            }
        });
        jPanel7.add(btnMuonSach);
        btnMuonSach.getAccessibleContext().setAccessibleName("");

        btnTra.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnTra.setForeground(new java.awt.Color(255, 255, 255));
        btnTra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return1.png"))); // NOI18N
        btnTra.setText("TRẢ SÁCH");
        btnTra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTraMouseClicked(evt);
            }
        });
        jPanel7.add(btnTra);
        btnTra.getAccessibleContext().setAccessibleName("");

        btnSach.setBackground(new java.awt.Color(255, 0, 51));
        btnSach.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnSach.setForeground(new java.awt.Color(255, 255, 255));
        btnSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books.png"))); // NOI18N
        btnSach.setText("SÁCH");
        btnSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSach.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSachMouseClicked(evt);
            }
        });
        jPanel7.add(btnSach);
        btnSach.getAccessibleContext().setAccessibleName("");

        btnPhieuMuon.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnPhieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuMuon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/essay.png"))); // NOI18N
        btnPhieuMuon.setText("PHIẾU MƯỢN");
        btnPhieuMuon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPhieuMuon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPhieuMuonMouseClicked(evt);
            }
        });
        jPanel7.add(btnPhieuMuon);
        btnPhieuMuon.getAccessibleContext().setAccessibleName("");

        btnDSPhat.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDSPhat.setForeground(new java.awt.Color(255, 255, 255));
        btnDSPhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDSPhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/form.png"))); // NOI18N
        btnDSPhat.setText("DS PHẠT");
        btnDSPhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDSPhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDSPhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSPhatMouseClicked(evt);
            }
        });
        jPanel7.add(btnDSPhat);
        btnDSPhat.getAccessibleContext().setAccessibleName("");

        btnPhieuTra.setBackground(new java.awt.Color(255, 0, 51));
        btnPhieuTra.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnPhieuTra.setForeground(new java.awt.Color(255, 255, 255));
        btnPhieuTra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPhieuTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return_b.png"))); // NOI18N
        btnPhieuTra.setText("PHIẾU TRẢ");
        btnPhieuTra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPhieuTra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPhieuTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPhieuTraMouseClicked(evt);
            }
        });
        jPanel7.add(btnPhieuTra);

        btnDocGia.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDocGia.setForeground(new java.awt.Color(255, 255, 255));
        btnDocGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reading1.png"))); // NOI18N
        btnDocGia.setText("ĐỘC GIẢ");
        btnDocGia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDocGia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDocGiaMouseClicked(evt);
            }
        });
        jPanel7.add(btnDocGia);
        btnDocGia.getAccessibleContext().setAccessibleName("");

        btnNhanVien.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team.png"))); // NOI18N
        btnNhanVien.setText("NHÂN VIÊN");
        btnNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhanVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseClicked(evt);
            }
        });
        jPanel7.add(btnNhanVien);
        btnNhanVien.getAccessibleContext().setAccessibleName("");

        jPanel6.setOpaque(false);

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 33, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel7.add(jPanel6);

        MenuPN.add(jPanel7, java.awt.BorderLayout.CENTER);

        CenterPN.add(MenuPN, java.awt.BorderLayout.WEST);

        PagePN.setLayout(new java.awt.CardLayout());

        Home.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel55.setBackground(new java.awt.Color(153, 204, 255));
        jPanel55.setForeground(new java.awt.Color(255, 255, 255));
        jPanel55.setPreferredSize(new java.awt.Dimension(1368, 40));

        jLabel115.setBackground(new java.awt.Color(255, 255, 255));
        jLabel115.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/digital-library.png"))); // NOI18N
        jLabel115.setText("THƯ VIỆN NNLH");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1379, Short.MAX_VALUE)
            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                    .addContainerGap(556, Short.MAX_VALUE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(625, Short.MAX_VALUE)))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel115)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel55, java.awt.BorderLayout.NORTH);

        jPanel57.setLayout(new java.awt.GridLayout(1, 0));

        jPanel58.setBackground(new java.awt.Color(102, 153, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel117.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reading1.png"))); // NOI18N
        jLabel117.setText("Số lượng đôc giả");

        LbSLDG.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        LbSLDG.setForeground(new java.awt.Color(255, 255, 255));
        LbSLDG.setText("3");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel117))
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(LbSLDG, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LbSLDG, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel57.add(jPanel58);

        jPanel59.setBackground(new java.awt.Color(102, 153, 255));
        jPanel59.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel124.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books.png"))); // NOI18N
        jLabel124.setText("Số lượng đầu sách");

        lbSlSach.setBackground(new java.awt.Color(102, 204, 255));
        lbSlSach.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        lbSlSach.setForeground(new java.awt.Color(255, 255, 255));
        lbSlSach.setText("73");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel124)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbSlSach, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel124)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSlSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jPanel57.add(jPanel59);

        jPanel60.setBackground(new java.awt.Color(102, 153, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel60MouseClicked(evt);
            }
        });

        jLabel130.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrow.png"))); // NOI18N
        jLabel130.setText("Số lượng sách mượn");

        LBSachDM.setBackground(new java.awt.Color(102, 153, 255));
        LBSachDM.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        LBSachDM.setForeground(new java.awt.Color(255, 255, 255));
        LBSachDM.setText("13");

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBSachDM, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel130)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBSachDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jPanel57.add(jPanel60);

        jPanel61.setBackground(new java.awt.Color(102, 153, 255));
        jPanel61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel132.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/web.png"))); // NOI18N
        jLabel132.setText("Tổng tiền phạt");

        LBTien.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        LBTien.setForeground(new java.awt.Color(255, 255, 255));
        LBTien.setText("100,000Đ");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel132)
                    .addComponent(LBTien, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel132)
                .addGap(17, 17, 17)
                .addComponent(LBTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel57.add(jPanel61);

        jPanel64.setBackground(new java.awt.Color(102, 153, 255));
        jPanel64.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel64MouseClicked(evt);
            }
        });

        jLabel133.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/web.png"))); // NOI18N
        jLabel133.setText("Sách trễ hạn");

        LBTre.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        LBTre.setForeground(new java.awt.Color(255, 255, 255));
        LBTre.setText("100,000Đ");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel133)
                    .addComponent(LBTre, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel133)
                .addGap(17, 17, 17)
                .addComponent(LBTre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel57.add(jPanel64);

        jPanel4.add(jPanel57, java.awt.BorderLayout.CENTER);

        Home.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout lbSachTreLayout = new javax.swing.GroupLayout(lbSachTre);
        lbSachTre.setLayout(lbSachTreLayout);
        lbSachTreLayout.setHorizontalGroup(
            lbSachTreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        lbSachTreLayout.setVerticalGroup(
            lbSachTreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );

        jPanel5.add(lbSachTre, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel54.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout BieuDoDGCLayout = new javax.swing.GroupLayout(BieuDoDGC);
        BieuDoDGC.setLayout(BieuDoDGCLayout);
        BieuDoDGCLayout.setHorizontalGroup(
            BieuDoDGCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        BieuDoDGCLayout.setVerticalGroup(
            BieuDoDGCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );

        jPanel54.add(BieuDoDGC, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel54, java.awt.BorderLayout.WEST);

        Home.add(jPanel9, java.awt.BorderLayout.CENTER);

        PagePN.add(Home, "card2");

        Muon.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã độc giả");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên độc giả");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày sinh");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SDT:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Giới tính:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ngày trả dự kiến:");

        txtTenDocGiaMS.setEnabled(false);

        txtMaDocGiaMS.setEditable(false);
        txtMaDocGiaMS.setEnabled(false);

        txtEmailMS.setEnabled(false);

        txtGioiTinhMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        txtGioiTinhMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioiTinhMSActionPerformed(evt);
            }
        });

        btnThemMS.setBackground(new java.awt.Color(51, 153, 255));
        btnThemMS.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemMS.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemMS.setText("Thêm mới");
        btnThemMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMSActionPerformed(evt);
            }
        });

        btnLoadDGMS.setBackground(new java.awt.Color(102, 153, 255));
        btnLoadDGMS.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnLoadDGMS.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadDGMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tap.png"))); // NOI18N
        btnLoadDGMS.setText("Chọn độc giả cũ");
        btnLoadDGMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDGMSActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Ngày mượn:");

        txtNgayTraDGMS.setDateFormatString("dd/MM/yyyy");
        txtNgayTraDGMS.setEnabled(false);

        txtNgayMuonDGMS.setDateFormatString("dd/MM/yyyy");
        txtNgayMuonDGMS.setEnabled(false);

        txtNgaySinhDGMS.setDateFormatString("dd/MM/yyyy");
        txtNgaySinhDGMS.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaDocGiaMS, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDocGiaMS, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGioiTinhMS, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailMS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNgaySinhDGMS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayMuonDGMS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChiMS, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTraDGMS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTMS, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemMS, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadDGMS))
                .addGap(138, 138, 138))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaDocGiaMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDTMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmailMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnLoadDGMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtGioiTinhMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayMuonDGMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDocGiaMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinhDGMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDiaChiMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgayTraDGMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        Muon.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        ItemSelectedPN.setLayout(new java.awt.BorderLayout());

        jLabel25.setBackground(new java.awt.Color(51, 204, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("DANH SÁCH SÁCH MƯỢN");
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel25.setOpaque(true);
        ItemSelectedPN.add(jLabel25, java.awt.BorderLayout.NORTH);

        ItemSelect.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout ItemSelectLayout = new javax.swing.GroupLayout(ItemSelect);
        ItemSelect.setLayout(ItemSelectLayout);
        ItemSelectLayout.setHorizontalGroup(
            ItemSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        ItemSelectLayout.setVerticalGroup(
            ItemSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        ItemSelectedPN.add(ItemSelect, java.awt.BorderLayout.CENTER);

        BtnPanel.setBackground(new java.awt.Color(51, 204, 255));

        btnSuccess.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnSuccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked.png"))); // NOI18N
        btnSuccess.setText("Hoàn tất");
        btnSuccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BtnPanelLayout = new javax.swing.GroupLayout(BtnPanel);
        BtnPanel.setLayout(BtnPanelLayout);
        BtnPanelLayout.setHorizontalGroup(
            BtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        BtnPanelLayout.setVerticalGroup(
            BtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ItemSelectedPN.add(BtnPanel, java.awt.BorderLayout.PAGE_END);

        Muon.add(ItemSelectedPN, java.awt.BorderLayout.LINE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        ItemPNMuon.setMaximumSize(new java.awt.Dimension(841, 493));

        javax.swing.GroupLayout ItemPNMuonLayout = new javax.swing.GroupLayout(ItemPNMuon);
        ItemPNMuon.setLayout(ItemPNMuonLayout);
        ItemPNMuonLayout.setHorizontalGroup(
            ItemPNMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1204, Short.MAX_VALUE)
        );
        ItemPNMuonLayout.setVerticalGroup(
            ItemPNMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(ItemPNMuon);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel37.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1206, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel37, java.awt.BorderLayout.NORTH);

        Muon.add(jPanel3, java.awt.BorderLayout.CENTER);

        PagePN.add(Muon, "card3");

        Tra.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(102, 204, 255));
        jPanel11.setForeground(new java.awt.Color(153, 204, 255));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked.png"))); // NOI18N
        jButton7.setText("Hoàn tất");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton10.setText("Sửa");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
        );

        Tra.add(jPanel11, java.awt.BorderLayout.LINE_END);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(102, 204, 255));

        txtTenDocGiaTS.setEditable(false);
        txtTenDocGiaTS.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mã Cuốn sách");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tên độc giả");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ngày trả");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Ngày mượn");

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tốt", "Mất sách", "Hư hỏng" }));

        jLabel110.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setText("Tình trạng");

        txtNgayMuonTS.setDateFormatString("dd/MM/yyyy");
        txtNgayMuonTS.setEnabled(false);

        txtNgayTraTS.setDateFormatString("dd/MM/yyyy");
        txtNgayTraTS.setEnabled(false);

        jLabel111.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("Mã độc giả");

        cboMaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaDGActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mã phiếu mượn");

        txtMaPMTS.setEditable(false);
        txtMaPMTS.setEnabled(false);

        sadđ.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        sadđ.setForeground(new java.awt.Color(255, 255, 255));
        sadđ.setText("Tên sách");

        txtTenSachTS.setEditable(false);
        txtTenSachTS.setEnabled(false);

        cboMaCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaCSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14))
                    .addComponent(jLabel13))
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenDocGiaTS, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaCS, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaPMTS, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtNgayMuonTS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtNgayTraTS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(sadđ, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSachTS, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTraTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel111)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sadđ)
                                .addComponent(txtTenSachTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayMuonTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cboMaCS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel110)
                                .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDocGiaTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(txtMaPMTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel12.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        tblDocGiaChon2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Mã phiếu mượn", "Ngày mượn", "Mã cuốn sách", "Tên sách", "Tình trạng"
            }
        ));
        tblDocGiaChon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocGiaChon2MouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tblDocGiaChon2);

        jPanel12.add(jScrollPane17, java.awt.BorderLayout.CENTER);

        Tra.add(jPanel12, java.awt.BorderLayout.CENTER);

        PagePN.add(Tra, "card4");

        Sach.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(51, 204, 255));

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("QUẢN LÝ SÁCH");

        btnChuDe.setBackground(new java.awt.Color(102, 153, 255));
        btnChuDe.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnChuDe.setForeground(new java.awt.Color(255, 255, 255));
        btnChuDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnChuDe.setText("Thêm Thể loại");
        btnChuDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuDeActionPerformed(evt);
            }
        });

        btnTacGia.setBackground(new java.awt.Color(102, 153, 255));
        btnTacGia.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnTacGia.setForeground(new java.awt.Color(255, 255, 255));
        btnTacGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnTacGia.setText("Thêm tác giả");
        btnTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacGiaActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Mã sách:");

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Tên sách");

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Giá bán:");

        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Mô tả");

        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Ngày cập nhật:");

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Ảnh bìa:");

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Số lượng");

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));

        rdoNew.setForeground(new java.awt.Color(255, 255, 255));
        rdoNew.setText("Mới");

        btnChonAnh.setBackground(new java.awt.Color(102, 153, 255));
        btnChonAnh.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnChonAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gallery.png"))); // NOI18N
        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel88.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Thể loại");

        jLabel89.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Tác giả");

        jLabel90.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("NXB");

        txtNgayCapNhat.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addGap(439, 439, 439))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel90))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(txtTenSach)
                            .addComponent(txtGiaBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(cboNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel88)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel89)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addGap(136, 136, 136))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(cboTG1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboTheLoai2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgayCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoNew, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnChuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 325, Short.MAX_VALUE)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnChonAnh)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel45)
                                .addComponent(jLabel49)
                                .addComponent(jLabel50)
                                .addComponent(jLabel51)
                                .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoNew))
                            .addComponent(txtNgayCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel52)
                                    .addComponent(btnChonAnh)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel53)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel88)
                                    .addComponent(cboTheLoai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChuDe))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel90)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTacGia)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel89)
                                            .addComponent(cboTG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Anh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        Sach.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel14.setBackground(new java.awt.Color(51, 204, 255));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));

        btnThemSach.setBackground(new java.awt.Color(102, 153, 255));
        btnThemSach.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemSach.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box.png"))); // NOI18N
        btnThemSach.setText("Nhập sách");
        btnThemSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnXoaSach.setBackground(new java.awt.Color(102, 153, 255));
        btnXoaSach.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXoaSach.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnXoaSach.setText("Thêm DS mới");
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });

        btnSuaSach.setBackground(new java.awt.Color(102, 153, 255));
        btnSuaSach.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnSuaSach.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnSuaSach.setText("Sửa");
        btnSuaSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSachActionPerformed(evt);
            }
        });

        btnXemChiTietSach.setBackground(new java.awt.Color(102, 153, 255));
        btnXemChiTietSach.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXemChiTietSach.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTietSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewde.png"))); // NOI18N
        btnXemChiTietSach.setText("Xem chi tiết");
        btnXemChiTietSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXemChiTietSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnXemChiTietSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXemChiTietSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
        );

        Sach.add(jPanel14, java.awt.BorderLayout.LINE_END);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel38.setBackground(new java.awt.Color(51, 204, 255));
        jPanel38.setPreferredSize(new java.awt.Dimension(1252, 70));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tìm kiếm:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cboTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTheLoaiActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Thể loại");

        jLabel86.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("NXB:");

        cboTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTGActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Tác giả");

        LBtable.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        LBtable.setForeground(new java.awt.Color(255, 255, 255));
        LBtable.setText("BẢNG ĐẦU SÁCH");

        cboNXB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNXB1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNXB1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel87)
                .addGap(18, 18, 18)
                .addComponent(cboTG, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(28, 28, 28)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(16, 16, 16))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(LBtable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LBtable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel85)
                    .addComponent(cboTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel15)
                    .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNXB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel38, java.awt.BorderLayout.NORTH);

        ItemPNMuon1.setMaximumSize(new java.awt.Dimension(841, 493));
        ItemPNMuon1.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel19.setLayout(new java.awt.CardLayout());

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Giá bán", "Mô tả", "Ngày cập nhật", "Ảnh bìa", "Số lượng", "Mới", "Mã tác giả", "Mã NXB", "Mã chủ đè"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSach);

        jPanel19.add(jScrollPane7, "card2");

        tblCS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã cuốn sách", "Mã đầu sách", "Trạng thái", "Vị trí"
            }
        ));
        jScrollPane3.setViewportView(tblCS);

        jPanel19.add(jScrollPane3, "card3");

        jPanel20.setLayout(new java.awt.BorderLayout());

        tblSach1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Giá bán", "Mô tả", "Ngày cập nhật", "Ảnh bìa", "Số lượng", "Mới"
            }
        ));
        tblSach1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSach1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSach1MouseEntered(evt);
            }
        });
        jScrollPane18.setViewportView(tblSach1);

        jPanel20.add(jScrollPane18, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1206, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel21, java.awt.BorderLayout.PAGE_START);

        jPanel19.add(jPanel20, "card5");

        jPanel8.add(jPanel19, java.awt.BorderLayout.CENTER);

        ItemPNMuon1.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel15.add(ItemPNMuon1, java.awt.BorderLayout.CENTER);

        Sach.add(jPanel15, java.awt.BorderLayout.CENTER);

        PagePN.add(Sach, "card5");

        PhieuMuon.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(51, 204, 255));

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("PHIẾU MƯỢN");

        jLabel55.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Mã độc giả");

        jLabel56.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Mã phiếu mượn:");

        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Ngày mượn:");

        jLabel58.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Ngày trả:");

        txtNgayMuonPM.setDateFormatString("dd/MM/yyyy");
        txtNgayMuonPM.setEnabled(false);

        txtNgayTraDukien.setDateFormatString("dd/MM/yyyy");
        txtNgayTraDukien.setEnabled(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(txtMaDocGia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(txtNgayMuonPM, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 364, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayTraDukien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel56)
                    .addContainerGap(1239, Short.MAX_VALUE)))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel54)
                .addGap(19, 19, 19)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(txtMaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNgayTraDukien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(txtNgayMuonPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jLabel56)
                    .addContainerGap(134, Short.MAX_VALUE)))
        );

        PhieuMuon.add(jPanel22, java.awt.BorderLayout.PAGE_START);

        jPanel23.setBackground(new java.awt.Color(51, 204, 255));

        jButton26.setBackground(new java.awt.Color(102, 153, 255));
        jButton26.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton26.setText("Xem chi tiết");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton26)
                .addContainerGap(546, Short.MAX_VALUE))
        );

        PhieuMuon.add(jPanel23, java.awt.BorderLayout.LINE_END);

        jPanel24.setLayout(new java.awt.BorderLayout());

        tblPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã phiếu mượn", "Mã độc giả", "Ngày mượn", "Ngày trả"
            }
        ));
        tblPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblPhieuMuon);

        jPanel24.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        PhieuMuon.add(jPanel24, java.awt.BorderLayout.CENTER);

        PagePN.add(PhieuMuon, "card6");

        DSPhat.setLayout(new java.awt.BorderLayout());

        jPanel28.setBackground(new java.awt.Color(51, 204, 255));

        jLabel59.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("DANH SÁCH PHẠT");

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Mã phiếu phạt:");

        jLabel61.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Mã phiếu mượn");

        jLabel62.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Ngày lập");

        jLabel63.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Tổng tiền");

        txtTongTienPM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTongTienPMFocusLost(evt);
            }
        });
        txtTongTienPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienPMActionPerformed(evt);
            }
        });

        try {
            txtNgayLapPM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPhieuPhat, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txtMaDocGiaPM))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayLapPM, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTongTienPM, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(808, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel59)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel62)
                    .addComponent(txtMaPhieuPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayLapPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel63)
                    .addComponent(txtMaDocGiaPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        DSPhat.add(jPanel28, java.awt.BorderLayout.PAGE_START);

        jPanel29.setBackground(new java.awt.Color(51, 204, 255));

        jButton21.setBackground(new java.awt.Color(102, 153, 255));
        jButton21.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton21.setText("Xem chi tiết");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton21)
                .addContainerGap(565, Short.MAX_VALUE))
        );

        DSPhat.add(jPanel29, java.awt.BorderLayout.LINE_END);

        jPanel30.setLayout(new java.awt.BorderLayout());

        tblPhieuPhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã phiếu phạt", "Mã phiếu mượn", "Ngày lập", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuPhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuPhatMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblPhieuPhat);

        jPanel30.add(jScrollPane10, java.awt.BorderLayout.CENTER);

        DSPhat.add(jPanel30, java.awt.BorderLayout.CENTER);

        PagePN.add(DSPhat, "card6");

        DocGia.setLayout(new java.awt.BorderLayout());

        jPanel31.setBackground(new java.awt.Color(51, 204, 255));
        jPanel31.setForeground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Mã độc giả");

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Tên độc giả");

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Ngày sinh");

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Địa chỉ");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("SDT:");

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Giới tính:");

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Email:");

        txtMaDocGiaDG.setEditable(false);

        cboGTDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtNgaySinhDG.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaDocGiaDG, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txtTenDocGiaDG))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailDG, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 174, Short.MAX_VALUE)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaChiDG, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(340, 340, 340))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(txtNgaySinhDG, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel33)
                    .addComponent(txtMaDocGiaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDocGiaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel32)
                    .addComponent(cboGTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtDiaChiDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgaySinhDG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        DocGia.add(jPanel31, java.awt.BorderLayout.PAGE_START);

        jPanel32.setBackground(new java.awt.Color(51, 204, 255));

        btnSuaDG.setBackground(new java.awt.Color(102, 153, 255));
        btnSuaDG.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnSuaDG.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnSuaDG.setText("Sửa");
        btnSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDGActionPerformed(evt);
            }
        });

        btnThemDG.setBackground(new java.awt.Color(102, 153, 255));
        btnThemDG.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemDG.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemDG.setText("Thêm");
        btnThemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(629, Short.MAX_VALUE))
        );

        DocGia.add(jPanel32, java.awt.BorderLayout.LINE_END);

        jPanel33.setLayout(new java.awt.BorderLayout());

        tblDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "SDT"
            }
        ));
        tblDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblDocGiaMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblDocGia);

        jPanel33.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        DocGia.add(jPanel33, java.awt.BorderLayout.CENTER);

        PagePN.add(DocGia, "card6");

        NhanVien.setLayout(new java.awt.BorderLayout());

        jPanel34.setBackground(new java.awt.Color(51, 204, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Mã nhân viên");

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Tên nhân viên");

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Ngày sinh");

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Địa chỉ");

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("SDT:");

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Giới tính:");

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Email:");

        txtGTNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        txtGTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGTNVActionPerformed(evt);
            }
        });

        try {
            txtNgaysinhNV.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNgaysinhNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaysinhNVActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Lương");

        try {
            txtNVL.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNVLActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Ngày vào làm");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNhanVienNV, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(txtTenNV)
                    .addComponent(txtNgaysinhNV))
                .addGap(42, 42, 42)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 251, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNVL, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(246, 346, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel42)
                    .addComponent(txtMaNhanVienNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel41)
                    .addComponent(txtGTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgaysinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel81)
                        .addComponent(txtNVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel82)
                        .addComponent(txtLuongNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        NhanVien.add(jPanel34, java.awt.BorderLayout.PAGE_START);

        jPanel35.setBackground(new java.awt.Color(51, 204, 255));

        btnThemNV.setBackground(new java.awt.Color(102, 153, 255));
        btnThemNV.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemNV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnXoaNV.setBackground(new java.awt.Color(102, 153, 255));
        btnXoaNV.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXoaNV.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnXoaNV.setText("Xóa");
        btnXoaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        btnSuaNV.setBackground(new java.awt.Color(102, 153, 255));
        btnSuaNV.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnSuaNV.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(607, Short.MAX_VALUE))
        );

        NhanVien.add(jPanel35, java.awt.BorderLayout.LINE_END);

        jPanel36.setLayout(new java.awt.BorderLayout());

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "Lương", "Ngày vào làm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tblNhanVien);

        jPanel36.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        NhanVien.add(jPanel36, java.awt.BorderLayout.CENTER);

        PagePN.add(NhanVien, "card6");

        CHonDGPanel.setLayout(new java.awt.BorderLayout());

        btnChonDG.setText("Chọn");
        btnChonDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnChonDG)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnChonDG)
                .addContainerGap(750, Short.MAX_VALUE))
        );

        CHonDGPanel.add(jPanel47, java.awt.BorderLayout.LINE_END);

        jPanel48.setLayout(new java.awt.BorderLayout());

        ItemPNBan1.setMaximumSize(new java.awt.Dimension(841, 493));
        ItemPNBan1.setLayout(new java.awt.BorderLayout());

        tblDocGiaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Ngày sinh", "Giới tính", "Địa chỉ", "Email", "SDT"
            }
        ));
        jScrollPane14.setViewportView(tblDocGiaChon);

        ItemPNBan1.add(jScrollPane14, java.awt.BorderLayout.CENTER);

        jScrollPane13.setViewportView(ItemPNBan1);

        jPanel48.add(jScrollPane13, java.awt.BorderLayout.CENTER);

        jLabel71.setText("Tìm kiếm:");

        jButton20.setText("Search");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel48.add(jPanel49, java.awt.BorderLayout.NORTH);

        CHonDGPanel.add(jPanel48, java.awt.BorderLayout.CENTER);

        PagePN.add(CHonDGPanel, "card14");

        CHonDGPanel1.setLayout(new java.awt.BorderLayout());

        btnChonDG1.setText("Chọn");
        btnChonDG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonDG1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnChonDG1)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnChonDG1)
                .addContainerGap(750, Short.MAX_VALUE))
        );

        CHonDGPanel1.add(jPanel50, java.awt.BorderLayout.LINE_END);

        jPanel51.setLayout(new java.awt.BorderLayout());

        ItemPNBan2.setMaximumSize(new java.awt.Dimension(841, 493));
        ItemPNBan2.setLayout(new java.awt.BorderLayout());

        tblDocGiaChon1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Mã phiếu mượn", "Ngày mượn", "Mã cuốn sách", "Tên sách"
            }
        ));
        jScrollPane16.setViewportView(tblDocGiaChon1);

        ItemPNBan2.add(jScrollPane16, java.awt.BorderLayout.CENTER);

        jScrollPane15.setViewportView(ItemPNBan2);

        jPanel51.add(jScrollPane15, java.awt.BorderLayout.CENTER);

        jLabel84.setText("Tìm kiếm:");

        jButton23.setText("Search");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton23)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel51.add(jPanel52, java.awt.BorderLayout.NORTH);

        CHonDGPanel1.add(jPanel51, java.awt.BorderLayout.CENTER);

        PagePN.add(CHonDGPanel1, "card14");

        Sach1.setLayout(new java.awt.BorderLayout());

        jPanel25.setBackground(new java.awt.Color(51, 204, 255));

        jLabel98.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("QUẢN LÝ SÁCH");

        btnChuDe1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnChuDe1.setText("Thêm Thể loại");
        btnChuDe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuDe1ActionPerformed(evt);
            }
        });

        btnTacGia1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnTacGia1.setText("Thêm tác giả");
        btnTacGia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacGia1ActionPerformed(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("Mã sách:");

        jLabel100.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("Tên sách");

        jLabel101.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("Giá bán:");

        jLabel102.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Mô tả");

        jLabel103.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Ngày cập nhật:");

        jLabel104.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("Ảnh bìa:");

        jLabel105.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Số lượng");

        jLabel106.setForeground(new java.awt.Color(255, 255, 255));

        rdoNew1.setText("Mới");

        btnChonAnh1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnChonAnh1.setText("Chọn ảnh");
        btnChonAnh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnh1ActionPerformed(evt);
            }
        });

        txtTenSach1.setEditable(false);

        txtGiaBan1.setEditable(false);
        txtGiaBan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBan1ActionPerformed(evt);
            }
        });

        txtMoTa1.setColumns(20);
        txtMoTa1.setRows(5);
        jScrollPane19.setViewportView(txtMoTa1);

        jLabel107.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setText("Thể loại");

        jLabel108.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("Tác giả");

        jLabel109.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("NXB");

        cboMas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMasItemStateChanged(evt);
            }
        });
        cboMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMasActionPerformed(evt);
            }
        });

        txtNgayCapNhat1.setDateFormatString("dd/MM/yyyy");
        txtNgayCapNhat1.setEnabled(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel98)
                .addGap(439, 439, 439))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel109))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenSach1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(txtGiaBan1))
                            .addComponent(cboMas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(cboNXB2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel107)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel108)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayCapNhat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(rdoNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(cboTG2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTacGia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(cboTheLoai3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(136, 136, 136)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChonAnh1))
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addComponent(Anh1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel98)
                .addGap(17, 17, 17)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel99)
                        .addComponent(jLabel102)
                        .addComponent(jLabel103)
                        .addComponent(jLabel104)
                        .addComponent(rdoNew1)
                        .addComponent(cboMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayCapNhat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChonAnh1)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel100)
                                .addComponent(jLabel105)
                                .addComponent(txtTenSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel101)
                            .addComponent(jLabel106)
                            .addComponent(txtGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel107)
                            .addComponent(cboTheLoai3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChuDe1))
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboNXB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel109)))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel108)
                                    .addComponent(cboTG2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTacGia1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Anh1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        Sach1.add(jPanel25, java.awt.BorderLayout.PAGE_START);

        jPanel26.setBackground(new java.awt.Color(51, 204, 255));

        btnThemSach1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemSach1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSach1.setText("Thêm ");
        btnThemSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSach1ActionPerformed(evt);
            }
        });

        btnXoaSach1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXoaSach1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnXoaSach1.setText("Xóa");
        btnXoaSach1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoaSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSach1ActionPerformed(evt);
            }
        });

        btnHoanTat.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnHoanTat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked.png"))); // NOI18N
        btnHoanTat.setText("Hoàn tất");
        btnHoanTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTatActionPerformed(evt);
            }
        });

        btnHoanTat1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnHoanTat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back2 (1).png"))); // NOI18N
        btnHoanTat1.setText("Quay lại");
        btnHoanTat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTat1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHoanTat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHoanTat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnXoaSach1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSach1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnThemSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnHoanTat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoanTat1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        Sach1.add(jPanel26, java.awt.BorderLayout.LINE_END);

        jPanel27.setLayout(new java.awt.BorderLayout());

        jPanel43.setBackground(new java.awt.Color(51, 204, 255));
        jPanel43.setPreferredSize(new java.awt.Dimension(1252, 70));

        LBtable1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        LBtable1.setForeground(new java.awt.Color(255, 255, 255));
        LBtable1.setText("BẢNG NHẬP SÁCH");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(LBtable1)
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LBtable1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel27.add(jPanel43, java.awt.BorderLayout.NORTH);

        ItemPNMuon2.setMaximumSize(new java.awt.Dimension(841, 493));
        ItemPNMuon2.setLayout(new java.awt.BorderLayout());

        jPanel46.setLayout(new java.awt.BorderLayout());

        jPanel53.setLayout(new java.awt.CardLayout());

        tblSach2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Giá bán", "Mô tả", "Ngày cập nhật", "Ảnh bìa", "Số lượng", "Mới", "Mã tác giả", "Mã NXB", "Mã chủ đè"
            }
        ));
        tblSach2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSach2MouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tblSach2);

        jPanel53.add(jScrollPane20, "card2");

        jPanel46.add(jPanel53, java.awt.BorderLayout.CENTER);

        ItemPNMuon2.add(jPanel46, java.awt.BorderLayout.CENTER);

        jPanel27.add(ItemPNMuon2, java.awt.BorderLayout.CENTER);

        Sach1.add(jPanel27, java.awt.BorderLayout.CENTER);

        PagePN.add(Sach1, "card5");

        PhieuTra.setLayout(new java.awt.BorderLayout());

        jPanel39.setBackground(new java.awt.Color(51, 204, 255));

        jLabel64.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("PHIẾU TRẢ");

        jLabel65.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Mã độc giả");

        jLabel66.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Mã phiếu mượn:");

        jLabel68.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Ngày trả:");

        txtNgayTraPT.setDateFormatString("dd/MM/yyyy");
        txtNgayTraPT.setEnabled(false);

        jLabel69.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Mã phiếu trả");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPTPT, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtMaDocGia1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTraPT, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPMPT, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(604, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel64)
                .addGap(19, 19, 19)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(txtMaPTPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)))
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaDocGia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel66)
                                .addComponent(txtMaPMPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtNgayTraPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        PhieuTra.add(jPanel39, java.awt.BorderLayout.PAGE_START);

        jPanel40.setBackground(new java.awt.Color(51, 204, 255));

        jButton22.setBackground(new java.awt.Color(102, 153, 255));
        jButton22.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton22.setText("Xem chi tiết");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton22)
                .addContainerGap(546, Short.MAX_VALUE))
        );

        PhieuTra.add(jPanel40, java.awt.BorderLayout.LINE_END);

        jPanel41.setLayout(new java.awt.BorderLayout());

        tblPhieuTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã phiếu trả", "Mã phiếu mượn", "Mã độc giả", "Ngày trả"
            }
        ));
        tblPhieuTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuTraMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblPhieuTra);

        jPanel41.add(jScrollPane11, java.awt.BorderLayout.CENTER);

        PhieuTra.add(jPanel41, java.awt.BorderLayout.CENTER);

        PagePN.add(PhieuTra, "card6");

        ChiTietPT.setLayout(new java.awt.BorderLayout());

        jPanel42.setBackground(new java.awt.Color(51, 204, 255));

        jLabel67.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("PHIẾU TRẢ");

        jLabel70.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Mã cuốn sách");

        jLabel74.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Mã phiếu mượn");

        jLabel75.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Số lượng");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPTPT1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtMaDocGia2))
                        .addGap(108, 108, 108)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGhiChu))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(676, 676, 676))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel67)
                .addGap(21, 21, 21)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel74)
                        .addComponent(txtMaPTPT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel75)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(txtMaDocGia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        ChiTietPT.add(jPanel42, java.awt.BorderLayout.PAGE_START);

        jPanel44.setBackground(new java.awt.Color(51, 204, 255));

        jButton24.setBackground(new java.awt.Color(102, 153, 255));
        jButton24.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back2 (1).png"))); // NOI18N
        jButton24.setText("Quay lại");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton24)
                .addContainerGap(546, Short.MAX_VALUE))
        );

        ChiTietPT.add(jPanel44, java.awt.BorderLayout.LINE_END);

        jPanel45.setLayout(new java.awt.BorderLayout());

        tblCTPT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phiếu mượn", "Mã cuốn sách", "Số lượng"
            }
        ));
        tblCTPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPTMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblCTPT);

        jPanel45.add(jScrollPane12, java.awt.BorderLayout.CENTER);

        ChiTietPT.add(jPanel45, java.awt.BorderLayout.CENTER);

        PagePN.add(ChiTietPT, "card6");

        ChiTietPhieuMuon.setLayout(new java.awt.BorderLayout());

        jPanel65.setBackground(new java.awt.Color(51, 204, 255));

        jLabel72.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("PHIẾU TRẢ");

        jLabel73.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Mã cuốn sách");

        jLabel76.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Mã phiếu trả");

        jLabel77.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Ghi chú");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPTPT2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtMaDocGia3))
                        .addGap(108, 108, 108)
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGhiChu1))
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(676, 676, 676))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel72)
                .addGap(21, 21, 21)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel76)
                        .addComponent(txtMaPTPT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel77)
                    .addComponent(txtGhiChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(txtMaDocGia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        ChiTietPhieuMuon.add(jPanel65, java.awt.BorderLayout.PAGE_START);

        jPanel66.setBackground(new java.awt.Color(51, 204, 255));

        jButton25.setBackground(new java.awt.Color(102, 153, 255));
        jButton25.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back2 (1).png"))); // NOI18N
        jButton25.setText("Quay lại");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton25)
                .addContainerGap(546, Short.MAX_VALUE))
        );

        ChiTietPhieuMuon.add(jPanel66, java.awt.BorderLayout.LINE_END);

        jPanel67.setLayout(new java.awt.BorderLayout());

        tblCTPT1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phiếu trả", "Mã cuốn sách", "Ghi chú"
            }
        ));
        tblCTPT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPT1MouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tblCTPT1);

        jPanel67.add(jScrollPane25, java.awt.BorderLayout.CENTER);

        ChiTietPhieuMuon.add(jPanel67, java.awt.BorderLayout.CENTER);

        PagePN.add(ChiTietPhieuMuon, "card6");

        TaiKhoan.setLayout(new java.awt.BorderLayout());

        jPanel68.setBackground(new java.awt.Color(51, 204, 255));

        jLabel78.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("TÀI KHOẢN");

        jLabel79.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Mã cuốn sách");

        jLabel80.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Mã phiếu trả");

        jLabel129.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setText("Ghi chú");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel68Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPTPT3, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtMaDocGia4))
                        .addGap(108, 108, 108)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGhiChu2))
                    .addGroup(jPanel68Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(676, 676, 676))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel78)
                .addGap(21, 21, 21)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel80)
                        .addComponent(txtMaPTPT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel129)
                    .addComponent(txtGhiChu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel79)
                    .addComponent(txtMaDocGia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        TaiKhoan.add(jPanel68, java.awt.BorderLayout.PAGE_START);

        jPanel69.setBackground(new java.awt.Color(51, 204, 255));

        jButton27.setBackground(new java.awt.Color(102, 153, 255));
        jButton27.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back2 (1).png"))); // NOI18N
        jButton27.setText("Quay lại");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton27)
                .addContainerGap(481, Short.MAX_VALUE))
        );

        TaiKhoan.add(jPanel69, java.awt.BorderLayout.LINE_END);

        jPanel70.setLayout(new java.awt.BorderLayout());

        tblCTPT2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phiếu trả", "Mã cuốn sách", "Ghi chú"
            }
        ));
        tblCTPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPT2MouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(tblCTPT2);

        jPanel70.add(jScrollPane27, java.awt.BorderLayout.CENTER);

        TaiKhoan.add(jPanel70, java.awt.BorderLayout.CENTER);

        PagePN.add(TaiKhoan, "card16");

        CenterPN.add(PagePN, java.awt.BorderLayout.CENTER);

        MainPN.add(CenterPN, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainPN, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
        System.out.println(mouseX + " " + mouseY);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MousePressed

    private void HeaderPNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderPNMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
        System.out.println(mouseX + " " + mouseY);// TODO add your handling code here:
    }//GEN-LAST:event_HeaderPNMousePressed

    private void HeaderPNMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderPNMouseDragged
        int x = this.getLocation().x + evt.getX() - mouseX;
        int y = this.getLocation().y + evt.getY() - mouseY;
        this.setLocation(x, y);
        // TODO add your handling code here:
    }//GEN-LAST:event_HeaderPNMouseDragged

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        int x = this.getLocation().x + evt.getX() - mouseX;
        int y = this.getLocation().y + evt.getY() - mouseY;
        this.setLocation(x, y);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseDragged

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());// TODO add your handling code here:
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnMuonSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMuonSachMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());

        // TODO add your handling code here:
    }//GEN-LAST:event_btnMuonSachMouseClicked

    public void loadComboTacGia(JComboBox<TacGia> cbo) {
        DefaultComboBoxModel<TacGia> model = new DefaultComboBoxModel<>();

        model.addElement(new TacGia(-1, "Mặc định", "", "", ""));

        List<TacGia> list = TacGiaDAO.getTacGia();  // ví dụ gọi DAO

        for (TacGia tg : listTacGia) {
            model.addElement(tg);
        }

        cboTG.setModel((ComboBoxModel) model);
    }

    double load_ttPhat() {
        double s = 0;
        for (PhieuPhat p : listPhieuPhat) {
            s += p.TongTien;
        }
        return s;
    }

    void loadDataBase() {

        listSach = SachDAO.getSachfull();
        rsSach();
        loadMSNhap();
        listSachDGDM = SachDGDMDAO.getSach();
        loadMPTS();

        listPT = PhieuTraDAO.getPhieuTra();
        listChiTietDonHang = ChiTietDonHangDAO.getChiTietDonHang();
        listChiTietPhieuMuon = ChiTietPhieuMuonDAO.getChiTietPhieuMuon();
        listSachDGDM = SachDGDMDAO.getSach();
        listChiTietPhieuPhat = ChiTietPhieuPhatDAO.getChiTietPhieuPhat();
        listChuDe = ChuDeDAO.getChuDe();
        listDocGia = DocGiaDAO.getDocGia();
        rsDocGia();

        listNXB = NhaXuatBanDAO.getNXB();
        listNhanVien = NhanVienDAO.getNhanVien();
        rsNhanVien();
        listPhieuMuon = PhieuMuonDAO.getPhieuMuon();
        rsPhieuMuon();
        listPhieuPhat = PhieuPhatDAO.getPhieuPhat();
        rsPhieuPhat();
        listPT = PhieuTraDAO.getPhieuTra();
        rsPhieuTra();
        listTTV = TheThuVienDAO.getTTV();
        listTacGia = TacGiaDAO.getTacGia();
        listTaiKhoan = TaiKhoanDAO.getTaiKhoan();
        cboNXB.removeAll();
        cboNXB1.removeAll();
        cboTG3.removeAll();
        cboNXB3.removeAll();
        cboTheLoai4.removeAll();
        cboTheLoai.addItem("Mặc định");
        cboNXB1.addItem("Mặc định");
        cboTG.addItem("Mặc định");
        for (TacGia i : listTacGia) {
            cboTG.addItem(i.TenTacGia);
            cboTG1.addItem(i.TenTacGia);

            cboTG2.addItem(i.TenTacGia);
            cboTG3.addItem(i.TenTacGia);

        }

        for (NhaXuatBan i : listNXB) {
            cboNXB.addItem(i.TenNXB);
            cboNXB1.addItem(i.TenNXB);
            cboNXB2.addItem(i.TenNXB);
            cboNXB3.addItem(i.TenNXB);
        }

        for (ChuDe i : listChuDe) {
            cboTheLoai.addItem(i.TenChuDe);
            cboTheLoai2.addItem(i.TenChuDe);
            cboTheLoai3.addItem(i.TenChuDe);
            cboTheLoai4.addItem(i.TenChuDe);
        }
        LbSLDG.setText(String.valueOf(listDocGia.size()));
        lbSlSach.setText(String.valueOf(listSach.size()));
        LBSachDM.setText(String.valueOf(listSachDGDM.size()));
        loadMPTS();
        LBTien.setText(String.valueOf(load_ttPhat()) + "VND");
        SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println(fo.parse(fo.format(java.sql.Date.valueOf(LocalDate.now()))));
            txtNgayMuonDGMS.setDate(fo.parse(fo.format(java.sql.Date.valueOf(LocalDate.now()))));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println(fo.parse(fo.format(java.sql.Date.valueOf(LocalDate.now()))));
            Calendar cal = Calendar.getInstance();       // Lấy ngày hiện tại
            cal.add(Calendar.DAY_OF_MONTH, 7);
            txtNgayTraDGMS.setDate(cal.getTime());

        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        listSachTre = SachDGDMDAO.QuaHan();
        LBTre.setText(String.valueOf(listSachTre.size()));
        load_sachtre();
    }

    void rsSach() {

        ItemSelect.setLayout(new WrapLayout(FlowLayout.LEFT));

        ItemPNMuon.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
        ItemPNMuon.removeAll();
        for (Sach s : listSach) {
            List<String> danhSachMaCuon = CuonSachDAO.getMaCuonByMaSach(s.maSach);

            ItemPanel it = new ItemPanel(s.maSach, s.tenSach, s.AnhBia, s.giaBan, s.SoLuong, s.moTa, 1, danhSachMaCuon, this::onSelected);

            ItemPNMuon.add(it);
        }

        ((DefaultTableModel) tblSach.getModel()).setRowCount(0);
        for (Sach s : listSach) {
            Object[] obj = new Object[]{
                s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia, s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
            };
            ((DefaultTableModel) tblSach.getModel()).addRow(obj);
        }
    }

    void rsPhieuMuon() {

        ((DefaultTableModel) tblPhieuMuon.getModel()).setRowCount(0);
        for (PhieuMuon s : listPhieuMuon) {
            Object[] obj = new Object[]{s.MaPhieuMuon, s.MaDocGia, s.NgayMuon, s.NgayTra};

            ((DefaultTableModel) tblPhieuMuon.getModel()).addRow(obj);
        }
        loadDGMuon();
    }

    void rsPhieuPhat() {
        ((DefaultTableModel) tblPhieuPhat.getModel()).setRowCount(0);
        for (PhieuPhat s : listPhieuPhat) {

            Object[] obj = new Object[]{s.MaPhieuPhat, s.MaPhieuPhat, s.NgayLap, s.TongTien};

            ((DefaultTableModel) tblPhieuPhat.getModel()).addRow(obj);
        }
    }

    void rsDocGia() {
        ((DefaultTableModel) tblDocGia.getModel()).setRowCount(0);

        ((DefaultTableModel) tblDocGiaChon.getModel()).setRowCount(0);
        for (DocGia s : listDocGia) {
            {
                Object[] obj = new Object[]{s.MaDocGia, s.TenDocGia, s.NgaySinh, s.GioiTinh, s.DiaChi, s.Email, s.SDT};

                ((DefaultTableModel) tblDocGia.getModel()).addRow(obj);
                ((DefaultTableModel) tblDocGiaChon.getModel()).addRow(obj);

            }

        }
    }


    private void btnTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraMouseClicked

    private void btnSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSachMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnSachMouseClicked

    void onSelected(ItemPanel item) {

        SachChon sc = new SachChon(item.MaSach, item.getMaCuonDuocChon(), item.name);
        if (AutoCapNhatCS(item.getMaCuonDuocChon())) {
            return;
        };
        listSachDCM.add(sc);

        ItemSelect.add(new ItemSelected(item.MaSach, item.getMaCuonDuocChon(), item.name, item.imagePath, item.giaBan));
        ItemSelect.revalidate();
        ItemSelect.repaint();

    }
    private void btnPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhieuMuonMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnPhieuMuonMouseClicked

    private void btnDSPhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSPhatMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnDSPhatMouseClicked

    private void btnDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDocGiaMouseClicked

        SetShowPage(((JLabel) evt.getSource()).getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnDocGiaMouseClicked

    private void btnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMouseClicked

        System.out.println(tk.Role);
        if (tk.Role.equals("1") == false) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập nội dung này");
            return;
        }
        SetShowPage(((JLabel) evt.getSource()).getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhanVienMouseClicked

    private void txtGTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGTNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGTNVActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void txtTongTienPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienPMActionPerformed

    private void tblPhieuPhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuPhatMouseClicked
        int index = tblPhieuPhat.getSelectedRow();
        if (index < 0) {
            return;

        }

        txtMaPhieuPhat.setText(tblPhieuPhat.getValueAt(index, 0).toString());
        txtMaDocGiaPM.setText(tblPhieuPhat.getValueAt(index, 1).toString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        try {
            d = format.parse(tblPhieuPhat.getValueAt(index, 2).toString());
            txtNgayLapPM.setText(format2.format(d));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);

        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        txtTongTienPM.setText(decimalFormat.format((long) Double.parseDouble(tblPhieuPhat.getValueAt(index, 3).toString())));

// TODO add your handling code here:
    }//GEN-LAST:event_tblPhieuPhatMouseClicked

    void rsNhanVien() {

        ((DefaultTableModel) tblNhanVien.getModel()).setRowCount(0);
        for (NhanVien s : listNhanVien) {

            Object[] obj = new Object[]{s.MaNV, s.TenNhanVien, s.NgaySinh, s.GioiTinh, s.DiaChi, s.Email, s.Luong, s.NgayVaoLam};

            ((DefaultTableModel) tblNhanVien.getModel()).addRow(obj);
        }
    }
    private void txtTongTienPMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTongTienPMFocusLost

        try {
            // Xóa hết ký tự không phải số
            String input = txtTongTienPM.getText().replaceAll("[^\\d]", "");
            if (!input.isEmpty()) {
                long amount = Long.parseLong(input);
                NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
                txtTongTienPM.setText(vnFormat.format(amount) + " ₫");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienPMFocusLost

    private void txtNgaysinhNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaysinhNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaysinhNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        NhanVien x = new NhanVien();
        x.TenNhanVien = txtTenNV.getText();
        x.DiaChi = txtDiaChiNV.getText();
        x.Email = txtEmailNV.getText();
        NumberFormat fo = NumberFormat.getInstance(new Locale("vi"));

        try {
            x.Luong = fo.parse(txtLuongNV.getText()).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        x.GioiTinh = cboGTDG.getSelectedItem().toString();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        try {
            x.NgayVaoLam = f.parse(txtNVL.getText());

            // TODO add your handling code here:
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            x.NgaySinh = f.parse(txtNgaysinhNV.getText());
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (NhanVienDAO.insertNV(x) == 1) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataBase();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        SetShowPage("Nhập sách");        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void txtGioiTinhMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioiTinhMSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioiTinhMSActionPerformed

    private void btnLoadDGMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDGMSActionPerformed
        SetShowPage("CHỌN DG");          // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadDGMSActionPerformed

    private int KiemTra(int ma) {
        int d = 0;
        for (int i = 0; i < listSachDGDM.size(); i++) {
            if (listSachDGDM.get(i).MaDG == ma) {
                d++;
            }
        }
        return d;
    }
    private void btnSuccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuccessActionPerformed

        if (txtMaDocGiaMS.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn độc giả !");
            return;
        }
        int kt = (KiemTra(Integer.parseInt(txtMaDocGiaMS.getText())));
        if (txtNgayTraDGMS.getDate().before(txtNgayMuonDGMS.getDate()) || txtNgayTraDGMS.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày trả dự kiến sau ngày mượn!");
            return;
        }

        getSelect();
        if ((listSachDCM.size() + kt) > 3) {
            JOptionPane.showMessageDialog(this, "Độc giả " + txtTenDocGiaMS.getText() + " chỉ được mượn tối đa 3 cuốn sách!!");
            loadDataBase();
            return;
        }
        if (listSachDCM.size() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách độc giả cần mượn!");
        }
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat fo2 = new SimpleDateFormat("dd/MM/yyyy");

        PhieuMuonDAO.insertPhieuMuon(txtMaDocGiaMS.getText(), fo.format(txtNgayMuonDGMS.getDate()), fo.format(txtNgayTraDGMS.getDate()));
        listPhieuMuon = PhieuMuonDAO.getPhieuMuon();
        List<SachDGDM> list = new ArrayList<SachDGDM>();
        PhieuMuon x = listPhieuMuon.get(listPhieuMuon.size() - 1);

        for (SachChon i : listSachDCM) {
            try {
                list.add(new SachDGDM(Integer.parseInt(txtMaDocGiaMS.getText()), txtTenDocGiaMS.getText(), x.MaPhieuMuon, fo2.parse(fo2.format(txtNgayMuonDGMS.getDate())), i.MaCuonSach, i.Ten));
                ChiTietPhieuMuonDAO.insertCTPM((x.MaPhieuMuon), i.MaCuonSach, 1);// TODO add your handling code here:
            } catch (ParseException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        JOptionPane.showMessageDialog(this, "Thêm phiếu mượn thành công");
        InPM.xuatPhieuMuon(txtTenDocGiaMS.getText(), txtMaDocGiaMS.getText(), String.valueOf(x.MaPhieuMuon), fo.format(txtNgayMuonDGMS.getDate()), list);
        ItemSelect.removeAll();
        txtMaDocGiaMS.setText("");
        txtDiaChiMS.setText("");
        txtGioiTinhMS.setSelectedItem("");
        txtSDTMS.setText("");
        txtTenDocGiaMS.setText("");

        txtEmailMS.setText("");
        loadDataBase();
    }//GEN-LAST:event_btnSuccessActionPerformed

    private boolean AutoCapNhatCS(int ma) {

        for (Component c : ItemSelect.getComponents()) {
            if (c instanceof ItemSelected) {
                ItemSelected x = (ItemSelected) c;
                if (x.MaCuonSach == ma) {
                    return true;

                }

            }
        }
        return false;
    }

    private void getSelect() {
        listSachDCM = new ArrayList<SachChon>();
        for (Component c : ItemSelect.getComponents()) {
            if (c instanceof ItemSelected) {
                ItemSelected x = (ItemSelected) c;
                listSachDCM.add(new SachChon(x.MaSach, x.MaCuonSach, x.TenSach));

            }
        }

    }
    private void btnChonDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonDGActionPerformed
        int index = tblDocGiaChon.getSelectedRow();

        DocGia x = new DocGia();

        x.MaDocGia = Integer.parseInt(tblDocGiaChon.getValueAt(index, 0).toString());

        x.TenDocGia = tblDocGiaChon.getValueAt(index, 1).toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date v = format.parse(tblDocGiaChon.getValueAt(index, 2).toString());
            x.NgaySinh = format.parse(tblDocGiaChon.getValueAt(index, 2).toString());

            txtNgaySinhDGMS.setDate((v));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        x.GioiTinh = tblDocGiaChon.getValueAt(index, 3).toString();
        x.DiaChi = tblDocGiaChon.getValueAt(index, 4).toString();
        x.Email = tblDocGiaChon.getValueAt(index, 5).toString();
        x.SDT = tblDocGiaChon.getValueAt(index, 6).toString();
        xSelected = x;
        SetShowPage("MƯỢN SÁCH");
        // TODO add your handling code here:

        txtMaDocGiaMS.setText(String.valueOf(xSelected.MaDocGia));
        txtDiaChiMS.setText(xSelected.DiaChi);
        txtGioiTinhMS.setSelectedItem(xSelected.GioiTinh);
        txtSDTMS.setText(x.SDT);
        txtTenDocGiaMS.setText(x.TenDocGia);

        txtEmailMS.setText(x.Email);
    }//GEN-LAST:event_btnChonDGActionPerformed

    private void btnThemMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMSActionPerformed
        SetShowPage("ĐỘC GIẢ");        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMSActionPerformed
    boolean kt_DocGia() {
        return !(txtTenDocGiaDG.getText().isEmpty() || txtEmailDG.getText().isEmpty() || txtDiaChiDG.getText().isEmpty() || txtSDTDG.getText().isEmpty());
    }
    private void btnThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDGActionPerformed
        DocGia x = new DocGia();
        if (!kt_DocGia()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin đọc giả!");
            return;
        }
        // TODO add your handling code here:
        x.TenDocGia = txtTenDocGiaDG.getText();
        x.GioiTinh = cboGTDG.getSelectedItem().toString();
        x.Email = txtEmailDG.getText();
        x.SDT = txtSDTDG.getText();
        x.DiaChi = txtDiaChiDG.getText();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            x.NgaySinh = format2.parse(format2.format(txtNgaySinhDG.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
        if (DocGiaDAO.insertDG(x) == 1) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            loadDataBase();
            SetShowPage("ĐỘC GIẢ");
        } else {
            JOptionPane.showMessageDialog(DocGia, "Thêm  không thành công");
        }
    }//GEN-LAST:event_btnThemDGActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        if (tblNhanVien.getSelectedRow() < 0) {
            return;
        }

        int row = tblNhanVien.getSelectedRow();

        txtMaNhanVienNV.setText(tblNhanVien.getValueAt(row, 0).toString());
        txtTenNV.setText(tblNhanVien.getValueAt(row, 1).toString());
        txtGTNV.setSelectedItem(tblNhanVien.getValueAt(row, 3).toString());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = format.parse(tblNhanVien.getValueAt(row, 2).toString()); // Đã sửa ở đây
            txtNgaysinhNV.setText(format2.format(d));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtDiaChiNV.setText(tblNhanVien.getValueAt(row, 4).toString());
        txtEmailNV.setText(tblNhanVien.getValueAt(row, 5).toString());
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        double x1;

        txtLuongNV.setText(decimalFormat.format((long) Double.parseDouble(tblNhanVien.getValueAt(row, 6).toString())));
        try {
            Date d = format.parse(tblNhanVien.getValueAt(row, 7).toString()); // Đã sửa ở đây
            txtNVL.setText(format2.format(d));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtNVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNVLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNVLActionPerformed

    private void tblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanVienMouseEntered

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        if (tblNhanVien.getSelectedRow() < 0) {
            return;
        }
        if (NhanVienDAO.deleteNV(Integer.parseInt(tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 0).toString())) == 1) {
            loadDataBase();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        if (tblNhanVien.getSelectedRow() < 0) {
            return;

        }

        NhanVien x = new NhanVien();
        x.MaNV = Integer.parseInt(tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 0).toString());
        x.TenNhanVien = txtTenNV.getText();
        x.DiaChi = txtDiaChiNV.getText();
        x.Email = txtEmailNV.getText();
        NumberFormat fo = NumberFormat.getInstance(new Locale("vi"));

        try {
            x.Luong = fo.parse(txtLuongNV.getText()).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        x.GioiTinh = cboGTDG.getSelectedItem().toString();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        try {
            x.NgayVaoLam = f.parse(txtNVL.getText());

            // TODO add your handling code here:
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            x.NgaySinh = f.parse(txtNgaysinhNV.getText());
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (NhanVienDAO.updateNV(x) == 1) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataBase();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void loadDGMuon() {
        listSachDGDM = SachDGDMDAO.getSach();
        ((DefaultTableModel) tblDocGiaChon1.getModel()).setRowCount(0);
        ((DefaultTableModel) tblDocGiaChon2.getModel()).setRowCount(0);
        ((DefaultTableModel) tblSachChuaTra.getModel()).setRowCount(0);
        for (SachDGDM i : listSachDGDM) {
            Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, i.NgayMuon, i.MaCS, i.TenSach};
            Object[] obj2 = new Object[]{i.MaMS, i.MaCS, i.TenSach, i.MaDG, i.Ten, i.NgayMuon};
            ((DefaultTableModel) tblSachChuaTra.getModel()).addRow(obj2);
            ((DefaultTableModel) tblDocGiaChon1.getModel()).addRow(obj);

        }

    }
    private void btnChonDG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonDG1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonDG1ActionPerformed

    private void loadCuonSach(int ma) {
        List<CuonSach> l = new ArrayList<CuonSach>();

        l = CuonSachDAO.getByMaSach(ma);
        ((DefaultTableModel) tblCS.getModel()).setRowCount(0);

        for (CuonSach i : l) {
            Object[] obj = new Object[]{i.MaCS, i.MaDauSach, i.TinhTrang, i.ViTri};
            ((DefaultTableModel) tblCS.getModel()).addRow(obj);
        }
    }
    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        if (tblSach.getSelectedRow() < 0) {
            return;
        }
        txtMaSach.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 0).toString());
        loadCuonSach(Integer.parseInt(tblSach.getValueAt(tblSach.getSelectedRow(), 0).toString()));
        txtTenSach.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString());
        txtGiaBan.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 2).toString());
        txtMoTa.setLineWrap(true);
        txtMoTa.setWrapStyleWord(true);
        txtMoTa.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 3).toString());
        try {
            SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = tblSach.getValueAt(tblSach.getSelectedRow(), 4).toString();
            Date v = fo.parse(dateStr); // parse thay vì format
            txtNgayCapNhat.setDate(v);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        String path = tblSach.getValueAt(tblSach.getSelectedRow(), 5).toString();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + path));
        Image img = icon.getImage().getScaledInstance(140, 150, Image.SCALE_SMOOTH);
        Anh.setIcon(new ImageIcon(img));

        txtSoLuong.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 6).toString());
        rdoNew.setSelected(Boolean.parseBoolean(tblSach.getValueAt(tblSach.getSelectedRow(), 7).toString()));
        for (int i = 0; i < listTacGia.size(); i++) {
            if (Integer.parseInt(tblSach.getValueAt(tblSach.getSelectedRow(), 8).toString()) == listTacGia.get(i).MaTacgia) {
                cboTG1.setSelectedItem(listTacGia.get(i).TenTacGia);
            }
        }
        for (int i = 0; i < listNXB.size(); i++) {
            if (Integer.parseInt(tblSach.getValueAt(tblSach.getSelectedRow(), 9).toString()) == listNXB.get(i).MaNXB) {
                cboNXB.setSelectedItem(listNXB.get(i).TenNXB);
            }
        }
        for (int i = 0; i < listChuDe.size(); i++) {
            if (Integer.parseInt(tblSach.getValueAt(tblSach.getSelectedRow(), 10).toString()) == listChuDe.get(i).MaChuDe) {
                cboTheLoai2.setSelectedItem(listChuDe.get(i).TenChuDe);
            }
        }
    }//GEN-LAST:event_tblSachMouseClicked

    private void btnXemChiTietSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietSachActionPerformed
        if (tblSach.getSelectedRow() < 0) {
            return;
        }
        txtMaSach.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 0).toString());
        loadCuonSach(Integer.parseInt(tblSach.getValueAt(tblSach.getSelectedRow(), 0).toString()));
        if (btnXemChiTietSach.getText().equals("Xem chi tiết")) {
            jScrollPane3.setVisible(true);
            jScrollPane7.setVisible(false);
            btnXemChiTietSach.setText("Quay lại");
            LBtable.setText("BẢNG CUỐN SÁCH THUỘC " + tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString());
        } else {
            jScrollPane3.setVisible(false);
            jScrollPane7.setVisible(true);
            btnXemChiTietSach.setText("Xem chi tiết");
            LBtable.setText("BẢNG ĐẦU SÁCH");
        }

    }//GEN-LAST:event_btnXemChiTietSachActionPerformed

    private void setCbotg(int ma) {

    }
    private void tblSach1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSach1MouseClicked

    }//GEN-LAST:event_tblSach1MouseClicked

    private void tblSach1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSach1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSach1MouseEntered

    private void btnTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacGiaActionPerformed
        jDialog1.pack();
        jDialog1.show();// TODO add your handling code here:
    }//GEN-LAST:event_btnTacGiaActionPerformed

    private void jDialog1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1MouseClicked

    private void btnThemTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTGActionPerformed
        TacGia t = new TacGia();
        t.TenTacGia = txtTenTG.getText();
        t.DiaChi = txtDiaChiTG.getText();
        t.DienThoai = txtDienThoaitg.getText();
        t.TieuSu = txtTieuSu.getText();
        if (TacGiaDAO.InsertTG(t) == 1) {
            JOptionPane.showMessageDialog(this, "Thêm tác giả thành công");
            loadDataBase();
        } // TODO add your handling code here:
        else {
            JOptionPane.showMessageDialog(this, "Thêm tác giả thất bại");
        }
    }//GEN-LAST:event_btnThemTGActionPerformed

    private void btnThemTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTLActionPerformed
        if (ChuDeDAO.insertTL(txtTenTL.getText()) == 1) {
            JOptionPane.showMessageDialog(this, "Thêm thể loại thành công");
            loadDataBase();
        }// TODO add your handling code here:
        else {
            JOptionPane.showMessageDialog(this, "Thêm thể loại thất bại");
        }
    }//GEN-LAST:event_btnThemTLActionPerformed

    private void btnChuDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuDeActionPerformed
        jDialog2.pack();
        jDialog2.show();// TODO add your handling code here:
    }//GEN-LAST:event_btnChuDeActionPerformed

    private void btnChuDe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuDe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuDe1ActionPerformed

    private void btnTacGia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacGia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTacGia1ActionPerformed

    private void txtGiaBan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBan1ActionPerformed

   private void btnThemSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSach1ActionPerformed
       if (txtSoLuong1.getText() == "" || !txtSoLuong1.getText().matches("\\d+")) {

           JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là số");
           return;
       }
       int x1 = Integer.parseInt(txtSoLuong1.getText());
       if (x1 == 0) {
           JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là số");
           return;
       }

       int x = Integer.parseInt(cboMas.getSelectedItem().toString());
       for (int i = 0; i < listSach.size(); i++) {
           if (listSach.get(i).maSach == x) {
               Sach sachChon = listSach.get(i);

               // Kiểm tra nếu sách đã có trong listSachNhap
               boolean tonTai = false;
               for (Sach s : listSachNhap) {
                   if (s.maSach == sachChon.maSach) {
                       // Nếu đã tồn tại, cập nhật số lượng
                       s.SoLuong = Integer.parseInt(txtSoLuong1.getText());
                       tonTai = true;
                       break;
                   }
               }

               if (!tonTai) {
                   sachChon.SoLuong = Integer.parseInt(txtSoLuong1.getText());
                   listSachNhap.add(sachChon);
               }

               break; // Dừng vòng lặp vì đã tìm thấy sách
           }
       }

       DefaultTableModel model = (DefaultTableModel) tblSach2.getModel();
       model.setRowCount(0);
       for (Sach s : listSachNhap) {
           Object[] obj = new Object[]{
               s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia,
               s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
           };
           model.addRow(obj);
       }

}//GEN-LAST:event_btnThemSach1ActionPerformed


    private void tblSach2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSach2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSach2MouseClicked

    private void cboMasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMasItemStateChanged

    }//GEN-LAST:event_cboMasItemStateChanged

    private void cboMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMasActionPerformed
        int x = Integer.parseInt(cboMas.getSelectedItem().toString());
        for (int i = 0; i < listSach.size(); i++) {
            if (listSach.get(i).maSach == x) {
                Sach v = listSach.get(i);
                txtTenSach1.setText(v.tenSach);
                txtGiaBan1.setText(String.valueOf(v.giaBan));
                SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    txtNgayCapNhat1.setDate(fo.parse(v.NgayCapNhat.toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                txtMoTa1.setLineWrap(true);
                txtMoTa1.setWrapStyleWord(true);
                txtMoTa1.setText(v.moTa);
                String path = v.AnhBia;
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + path));
                Image img = icon.getImage().getScaledInstance(140, 150, Image.SCALE_SMOOTH);
                Anh1.setIcon(new ImageIcon(img));
                txtSoLuong1.setText("0");
                rdoNew1.setSelected(v.Moi);
                for (int j = 0; j < listTacGia.size(); j++) {
                    if (v.maTG == listTacGia.get(j).MaTacgia) {
                        cboTG2.setSelectedItem(listTacGia.get(j).TenTacGia);
                    }
                }
                for (int j = 0; j < listNXB.size(); j++) {
                    if (v.manxb == listNXB.get(j).MaNXB) {
                        cboNXB2.setSelectedItem(listNXB.get(j).TenNXB);
                    }
                }
                for (int j = 0; j < listChuDe.size(); j++) {
                    if (v.macd == listChuDe.get(j).MaChuDe) {
                        cboTheLoai3.setSelectedItem(listChuDe.get(j).TenChuDe);
                    }
                }
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_cboMasActionPerformed

    private void load_BD() {
        BieuDoDGChart.hienThiTrongPanel(BieuDoDGC, ThongKeDAO.taoDuLieuThucTe());
        BieuDoTron.hienThiBieuDo(lbSachTre);
    }
    private void btnXoaSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSach1ActionPerformed
        if (tblSach2.getSelectedRow() < 0) {
            return;
        }
        listSachNhap.remove(tblSach2.getSelectedRow());
        DefaultTableModel model = (DefaultTableModel) tblSach2.getModel();
        model.setRowCount(0);
        for (Sach s : listSachNhap) {
            Object[] obj = new Object[]{
                s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia,
                s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
            };
            model.addRow(obj);
        }
    }//GEN-LAST:event_btnXoaSach1ActionPerformed

    private void btnHoanTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTatActionPerformed
        PhieuNhap pn = new PhieuNhap();
        pn.maNhanVien = tk.MaNV;

        pn.ngayNhap = java.sql.Date.valueOf(LocalDate.now());
        pn.ghiChu = "Tốt";
        PhieuNhapDAO.insertPN(pn);
        listPhieuNhap = PhieuNhapDAO.getPhieuNhap();
        PhieuNhap xy = listPhieuNhap.get(listPhieuNhap.size() - 1);
        for (Sach i : listSachNhap) {
            ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
            ct.maPhieuNhap = xy.maPhieuNhap;
            ct.maSach = i.maSach;
            ct.donGia = i.giaBan;
            ct.soLuong = i.SoLuong;
            ChiTietPhieuNhapDAO.insertCTPN(ct);
            System.out.println(i.SoLuong + " " + i.maSach);
//            SachDAO.capnhatSL(i.SoLuong, i.maSach);
        }
        JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thành công");
        InPhieuNhap.xuatPhieuNhap(tenNV, String.valueOf(tk.MaNV), String.valueOf(xy.maPhieuNhap), xy.ngayNhap.toString(), listSachNhap);
        listSachNhap = new ArrayList<Sach>();
        DefaultTableModel model = (DefaultTableModel) tblSach2.getModel();
        model.setRowCount(0);

// TODO add your handling code here:
    }//GEN-LAST:event_btnHoanTatActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TimDocGia.pack();
        TimDocGia.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void loadMPTS() {
        Set<String> l = new LinkedHashSet<String>();
        for (SachDGDM tg : listSachDGDM) {

            l.add(String.valueOf(tg.MaDG));
        }

        cboMaDG.removeAllItems();
        for (String tg : l) {

            cboMaDG.addItem(tg);
        }
    }
    private void btnChonSachTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSachTraActionPerformed
        if (tblSachChuaTra.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần trả!");
            return;
        }

        cboMaDG.setSelectedItem(tblSachChuaTra.getValueAt(tblSachChuaTra.getSelectedRow(), 0).toString());
        TimDocGia.show(false);// TODO add your handling code here:

    }//GEN-LAST:event_btnChonSachTraActionPerformed

    private void LoadcboMaPM(int ma) {
        cboMaCS.removeAllItems();

        for (int i = 0; i < listSachDGDM.size(); i++) {
            if (listSachDGDM.get(i).MaDG == ma) {
                cboMaCS.addItem(String.valueOf(listSachDGDM.get(i).MaCS));
            }
        }
    }
    private void cboMaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaDGActionPerformed
        listSachDGDM = SachDGDMDAO.getSach();
        if (cboMaDG.getSelectedItem() == null) {
            return;
        }

        int x = Integer.parseInt(cboMaDG.getSelectedItem().toString());

        for (int i = 0; i < listSachDGDM.size(); i++) {
            if (listSachDGDM.get(i).MaDG == x) {
                SachDGDM v = listSachDGDM.get(i);
                txtTenDocGiaTS.setText(v.Ten);
                LoadcboMaPM(v.MaDG);
                txtTenSachTS.setText(String.valueOf(v.TenSach));
                txtMaPMTS.setText(String.valueOf(v.MaMS));
                SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    txtNgayMuonTS.setDate(fo.parse(v.NgayMuon.toString()));
                    txtNgayTraTS.setDate(new Date());
                } catch (ParseException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_cboMaDGActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        List<SachDGDM> l = SachDGDMDAO.Seachs(txtSearchSach.getText());
        ((DefaultTableModel) tblSachChuaTra.getModel()).setRowCount(0);
        for (SachDGDM i : l) {

            Object[] obj2 = new Object[]{i.MaMS, i.MaCS, i.TenSach, i.MaDG, i.Ten, i.NgayMuon};
            ((DefaultTableModel) tblSachChuaTra.getModel()).addRow(obj2);

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ((DefaultTableModel) tblDocGiaChon2.getModel()).setRowCount(0);
        SachDMTT x = new SachDMTT();
        x.MaDG = Integer.parseInt(cboMaDG.getSelectedItem().toString());
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        try {
            x.NgayMuon = fo.parse(fo.format(txtNgayMuonTS.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        x.Ten = txtTenDocGiaTS.getText();
        x.TenSach = txtTenSachTS.getText();

        x.MaCS = Integer.parseInt(cboMaCS.getSelectedItem().toString());
        x.MaMS = Integer.parseInt(txtMaPMTS.getText());
        x.TinhTrang = cboTinhTrang.getSelectedItem().toString();
        if (Kt_tra(x.MaDG, x.MaCS)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ chọn 1 độc giả duy nhất và không trùng mã cuốn sách!");
            for (SachDMTT i : listTra) {
                Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, fo.format(i.NgayMuon), i.MaCS, i.TenSach, i.TinhTrang};

                ((DefaultTableModel) tblDocGiaChon2.getModel()).addRow(obj);
            }
            return;
        }
        listTra.add(x);
        for (SachDMTT i : listTra) {
            Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, fo.format(i.NgayMuon), i.MaCS, i.TenSach, i.TinhTrang};

            ((DefaultTableModel) tblDocGiaChon2.getModel()).addRow(obj);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    private void cboMaCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaCSActionPerformed
        Object selected = cboMaCS.getSelectedItem();
        if (selected == null) {
            return;
        }
        for (SachDGDM s : listSachDGDM) {
            if (s.MaCS == Integer.parseInt(cboMaCS.getSelectedItem().toString())) {
                txtTenDocGiaTS.setText(s.Ten);

                txtTenSachTS.setText(s.TenSach);
                txtMaPMTS.setText(String.valueOf(s.MaMS));
                SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    txtNgayMuonTS.setDate(fo.parse(fo.format(s.NgayMuon)));
                } catch (ParseException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_cboMaCSActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        PhieuTra pt = new PhieuTra();
        int sont=0;
        pt.MaDocGia = Integer.parseInt(tblDocGiaChon2.getValueAt(0, 0).toString());
        pt.NgayTra = java.sql.Date.valueOf(LocalDate.now());
        pt.MaPM = Integer.parseInt(tblDocGiaChon2.getValueAt(0, 2).toString());
        pt.GhiChu = "...";

        if (PhieuTraDAO.insertPT(pt) != 0) {
            JOptionPane.showMessageDialog(this, "Thêm phiếu trả thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm phiếu trả thất bại");
        }

        listPT = PhieuTraDAO.getPhieuTra();
        PhieuTra x = listPT.getLast();
        for (int i = 0; i < ((DefaultTableModel) tblDocGiaChon2.getModel()).getRowCount(); i++) {
            int sl = ((DefaultTableModel) tblDocGiaChon2.getModel()).getRowCount();
            ChiTietPhieuTra ct = new ChiTietPhieuTra();
            ct.MaPhieuTra = x.MaPhieuTra;

            ct.MaCuonSach = Integer.parseInt(tblDocGiaChon2.getValueAt(i, 4).toString());

            ct.GhiChu = "...";
            String tt = tblDocGiaChon2.getValueAt(i, 6).toString();
            if (tt.equals("Mất sách")) {
                PhieuPhat pp = new PhieuPhat();
                pp.MaPhieuMuon = pt.MaPM;
                pp.NgayLap = pt.NgayTra;
                PhieuPhatDAO.insertPP(pp);
                listPhieuPhat = PhieuPhatDAO.getPhieuPhat();

                ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
                PhieuPhat n = listPhieuPhat.getLast();
                ctpp.MaPhieuPhat = n.MaPhieuPhat;
                ctpp.MaSach = ct.MaCuonSach;
                ctpp.SoNgayTre = 0;
                ctpp.TienPhat = 50000;
                ChiTietPhieuPhatDAO.insertCTPP(ctpp);
                ct.GhiChu = "50000 VND";

            } else if (tt.equals("Hư hỏng")) {
                PhieuPhat pp = new PhieuPhat();
                pp.MaPhieuMuon = pt.MaPM;
                pp.NgayLap = pt.NgayTra;
                PhieuPhatDAO.insertPP(pp);
                listPhieuPhat = PhieuPhatDAO.getPhieuPhat();

                ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
                PhieuPhat n = listPhieuPhat.getLast();
                ctpp.MaPhieuPhat = n.MaPhieuPhat;
                ctpp.MaSach = ct.MaCuonSach;
                ctpp.SoNgayTre = 0;
                ctpp.TienPhat = 50000;
                ChiTietPhieuPhatDAO.insertCTPP(ctpp);
                ct.GhiChu = "50000 VND";

            } else {
                for (SachDGDM s : listSachTre) {
                    
                    if (s.MaCS==ct.MaCuonSach)
                    {
                         PhieuPhat pp = new PhieuPhat();
                    pp.MaPhieuMuon = pt.MaPM;
                    pp.NgayLap = pt.NgayTra;
                    PhieuPhatDAO.insertPP(pp);
                    listPhieuPhat = PhieuPhatDAO.getPhieuPhat();

                    ChiTietPhieuPhat ctpp = new ChiTietPhieuPhat();
                    PhieuPhat n = listPhieuPhat.getLast();
                    ctpp.MaPhieuPhat = n.MaPhieuPhat;
                    ctpp.MaSach = ct.MaCuonSach;
                    ctpp.SoNgayTre = Integer.parseInt(s.SoNgayMuon);
                    ctpp.TienPhat = 5000;
                    sont=ctpp.SoNgayTre;
                    ChiTietPhieuPhatDAO.insertCTPP(ctpp);
                    ct.GhiChu = String.valueOf(ctpp.TienPhat*ctpp.SoNgayTre);
                    }
                           
                }

            }
            CuonSachDAO.autoTra(tt, ct.MaCuonSach);

            ChiTietPhieuTraDAO.inssertctpt(ct);
        }
        InPhieuTra.xuatPhieuTra(tblDocGiaChon2.getValueAt(0, 1).toString(), String.valueOf(pt.MaDocGia), String.valueOf(x.MaPhieuTra), x.NgayTra.toString(), listTra,sont);
        listTra = new ArrayList<SachDMTT>();
        loadDataBase();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private boolean Kt_tra(int madg, int macs) {
        for (SachDMTT x : listTra) {
            if (x.MaDG != madg) {
                return true;
            }
            if (x.MaDG == madg && x.MaCS == macs) {
                return true;
            }
        }

        return false;
    }
    private void tblDocGiaChon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocGiaChon2MouseClicked
        int i = tblDocGiaChon2.getSelectedRow();
        if (i < 0) {
            return;
        }
        cboMaDG.setSelectedItem(tblDocGiaChon2.getValueAt(i, 0).toString());
        cboMaCS.setSelectedItem(tblDocGiaChon2.getValueAt(i, 4).toString());

        txtTenDocGiaTS.setText(tblDocGiaChon2.getValueAt(i, 1).toString());

        txtTenSachTS.setText((tblDocGiaChon2.getValueAt(i, 5).toString()));
        txtMaPMTS.setText(tblDocGiaChon2.getValueAt(i, 2).toString());
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");

        try {
            txtNgayMuonTS.setDate(fo.parse(tblDocGiaChon2.getValueAt(i, 3).toString()));
            txtNgayTraTS.setDate(new Date());
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
// TODO add your handling code here:
    }//GEN-LAST:event_tblDocGiaChon2MouseClicked

    private void btnChonAnh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnh1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn ảnh bìa cuốn sách");

// Chỉ cho chọn file ảnh
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Hình ảnh", "jpg", "png", "jpeg", "gif"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            // Hiển thị vào JLabel (ảnh bìa)
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH); // resize nếu muốn
            Anh1.setIcon(new ImageIcon(img));

            // Lưu path vào biến hoặc textbox để sau này lưu DB
            // ví dụ
        }
    }//GEN-LAST:event_btnChonAnh1ActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn ảnh bìa cuốn sách");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Hình ảnh", "jpg", "png", "jpeg", "gif"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            // Hiển thị ảnh
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            Anh.setIcon(new ImageIcon(img));

            try {
                //  Khai báo đúng biến Path
                Path source = Paths.get(path);
                Path target = Paths.get("src/images/" + source.getFileName());

                //  Lưu tên ảnh
                pathEdit = source.getFileName().toString();

                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Không thể sao chép ảnh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        ThemDauSach.pack();
        ThemDauSach.show();        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnSuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSachActionPerformed
        int in = tblSach.getSelectedRow();
        if (in < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần sửa!");
            return;
        }// TODO add your handling code here:
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        Sach s = new Sach();
        s.maSach = Integer.parseInt(txtMaSach.getText());
        if (pathEdit == null) {
            s.AnhBia = tblSach.getValueAt(in, 5).toString();
        } else {
            s.AnhBia = pathEdit;
        }
        s.tenSach = txtTenSach.getText();
        s.moTa = txtMoTa.getText();
        try {
            s.NgayCapNhat = fo.parse(fo.format(txtNgayCapNhat.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listNXB.size(); i++) {
            if (cboNXB.getSelectedItem().toString().equals(listNXB.get(i).TenNXB)) {

                s.manxb = listNXB.get(i).MaNXB;
            }
        }
        for (int i = 0; i < listChuDe.size(); i++) {
            if (cboTheLoai2.getSelectedItem().toString().equals(listChuDe.get(i).TenChuDe)) {

                s.macd = listChuDe.get(i).MaChuDe;
            }
        }
        s.giaBan = Double.parseDouble(txtGiaBan.getText());
        SachDAO.capnhatSachNhap(s);
        loadDataBase();
    }//GEN-LAST:event_btnSuaSachActionPerformed

    private void btnChonAnh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnh2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn ảnh bìa cuốn sách");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Hình ảnh", "jpg", "png", "jpeg", "gif"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            // Hiển thị ảnh
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            Anh2.setIcon(new ImageIcon(img));

            try {
                //  Khai báo đúng biến Path
                Path source = Paths.get(path);
                Path target = Paths.get("src/images/" + source.getFileName());

                //  Lưu tên ảnh
                pathEdit2 = source.getFileName().toString();

                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Không thể sao chép ảnh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnChonAnh2ActionPerformed

    private void txtGiaBan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBan2ActionPerformed

    private void tblSach3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSach3MouseClicked
        if (tblSach3.getSelectedRow() < 0) {
            return;
        }

        txtTenSach2.setText(tblSach3.getValueAt(tblSach3.getSelectedRow(), 0).toString());
        txtGiaBan2.setText(tblSach3.getValueAt(tblSach3.getSelectedRow(), 1).toString());
        txtMoTa2.setLineWrap(true);
        txtMoTa2.setWrapStyleWord(true);
        txtMoTa2.setText(tblSach3.getValueAt(tblSach3.getSelectedRow(), 2).toString());
        try {
            SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = tblSach3.getValueAt(tblSach3.getSelectedRow(), 3).toString();
            Date v = fo.parse(dateStr); // parse thay vì format
            txtNgayCapNhat2.setDate(v);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        String path = tblSach3.getValueAt(tblSach3.getSelectedRow(), 4).toString();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + path));
        Image img = icon.getImage().getScaledInstance(140, 150, Image.SCALE_SMOOTH);
        Anh2.setIcon(new ImageIcon(img));

        rdoNew.setSelected(Boolean.parseBoolean(tblSach3.getValueAt(tblSach3.getSelectedRow(), 5).toString()));
        for (int i = 0; i < listTacGia.size(); i++) {
            if (Integer.parseInt(tblSach3.getValueAt(tblSach3.getSelectedRow(), 6).toString()) == listTacGia.get(i).MaTacgia) {
                cboTG1.setSelectedItem(listTacGia.get(i).TenTacGia);
            }
        }
        for (int i = 0; i < listNXB.size(); i++) {
            if (Integer.parseInt(tblSach3.getValueAt(tblSach3.getSelectedRow(), 7).toString()) == listNXB.get(i).MaNXB) {
                cboNXB.setSelectedItem(listNXB.get(i).TenNXB);
            }
        }
        for (int i = 0; i < listChuDe.size(); i++) {
            if (Integer.parseInt(tblSach3.getValueAt(tblSach3.getSelectedRow(), 8).toString()) == listChuDe.get(i).MaChuDe) {
                cboTheLoai2.setSelectedItem(listChuDe.get(i).TenChuDe);
            }
        }
    }//GEN-LAST:event_tblSach3MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Sach s = new Sach();
        if (!KT_ThemDauSach()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu đàu sách!");
            return;
        }
        s.AnhBia = pathEdit2;
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        s.tenSach = txtTenSach2.getText();
        s.moTa = txtMoTa2.getText();
        try {
            s.NgayCapNhat = fo.parse(fo.format(txtNgayCapNhat2.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listNXB.size(); i++) {
            if (cboNXB2.getSelectedItem().toString().equals(listNXB.get(i).TenNXB)) {

                s.manxb = listNXB.get(i).MaNXB;
            }
        }
        for (int i = 0; i < listChuDe.size(); i++) {
            if (cboTheLoai4.getSelectedItem().toString().equals(listChuDe.get(i).TenChuDe)) {

                s.macd = listChuDe.get(i).MaChuDe;
            }
        }

        for (int i = 0; i < listTacGia.size(); i++) {
            if (cboTG3.getSelectedItem().toString().equals(listTacGia.get(i).TenTacGia)) {

                s.maTG = listTacGia.get(i).MaTacgia;
            }
        }
        s.giaBan = Double.parseDouble(txtGiaBan2.getText());
        listDST.add(s);
        ((DefaultTableModel) tblSach3.getModel()).setRowCount(0);
        for (Sach sa : listDST) {

            Object[] obj = new Object[]{
                sa.tenSach, sa.giaBan, sa.moTa, fo.format(sa.NgayCapNhat), sa.AnhBia, sa.Moi, sa.maTG, sa.manxb, sa.macd
            };
            ((DefaultTableModel) tblSach3.getModel()).addRow(obj);

            // TODO add your handling code here:
        }
        listSachNhap.add(s);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int in = tblSach3.getSelectedRow();
        if (in < 0) {
            JOptionPane.showMessageDialog(this, "Vui long chọn sách cần xóa");
            return;
        }
        System.out.println(in);
        listDST.remove(in);
        ((DefaultTableModel) tblSach3.getModel()).removeRow(in);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int in = tblSach3.getSelectedRow();
        if (in < 0) {
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn đầu sách cần sửa!");
            return;
        }
        Sach s = listDST.get(in);

        s.AnhBia = pathEdit2;
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        s.tenSach = txtTenSach2.getText();
        s.moTa = txtMoTa2.getText();
        try {
            s.NgayCapNhat = fo.parse(fo.format(txtNgayCapNhat2.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listNXB.size(); i++) {
            if (cboNXB2.getSelectedItem().toString().equals(listNXB.get(i).TenNXB)) {

                s.manxb = listNXB.get(i).MaNXB;
            }
        }
        for (int i = 0; i < listChuDe.size(); i++) {
            if (cboTheLoai4.getSelectedItem().toString().equals(listChuDe.get(i).TenChuDe)) {

                s.macd = listChuDe.get(i).MaChuDe;
            }
        }

        for (int i = 0; i < listTacGia.size(); i++) {
            if (cboTG3.getSelectedItem().toString().equals(listTacGia.get(i).TenTacGia)) {

                s.maTG = listTacGia.get(i).MaTacgia;
            }
        }
        s.giaBan = Double.parseDouble(txtGiaBan2.getText());

        ((DefaultTableModel) tblSach3.getModel()).setRowCount(0);
        for (Sach sa : listDST) {

            Object[] obj = new Object[]{
                sa.tenSach, sa.giaBan, sa.moTa, fo.format(sa.NgayCapNhat), sa.AnhBia, sa.maTG, sa.manxb, sa.macd
            };
            ((DefaultTableModel) tblSach3.getModel()).addRow(obj);

            // TODO add your handling code here:
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private boolean KT_ThemDauSach() {
        return !(txtGiaBan2.getText().isEmpty() || txtTenSach2.getText().isEmpty() || txtMoTa2.getText().isEmpty() || pathEdit2 == null);
    }
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        for (Sach sa : listDST) {
            SachDAO.ThemSachNhap(sa);
        }
        JOptionPane.showMessageDialog(this, "Thêm đầu sách mới thành công!");
        loadDataBase();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void rsPhieuTra() {
        ((DefaultTableModel) tblPhieuTra.getModel()).setRowCount(0);
        for (PhieuTra s : listPT) {
            Object[] obj = new Object[]{s.MaPhieuTra, s.MaPM, s.MaDocGia, s.NgayTra};

            ((DefaultTableModel) tblPhieuTra.getModel()).addRow(obj);
        }
        loadDGMuon();
    }
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        int in = tblDocGiaChon2.getSelectedRow();
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");

        if (in < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần sửa!");
            return;
        }
        SachDMTT x = listTra.get(tblDocGiaChon2.getSelectedRow());
        int mdg = Integer.parseInt(cboMaDG.getSelectedItem().toString());
        int mms = Integer.parseInt(cboMaCS.getSelectedItem().toString());
//        if (Kt_tra(mdg, mms)) {
//            ((DefaultTableModel) tblDocGiaChon2.getModel()).setRowCount(0);
//            JOptionPane.showMessageDialog(this, "Vui lòng chỉ chọn 1 độc giả duy nhất và không trùng mã cuốn sách!");
//            for (SachDMTT i : listTra) {
//                Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, fo.format(i.NgayMuon), i.MaCS, i.TenSach, i.TinhTrang};
//
//                ((DefaultTableModel) tblDocGiaChon2.getModel()).addRow(obj);
//            }
//            return;
//        }
        x.MaDG = mdg;
        x.MaMS = mms;
        x.TinhTrang = cboTinhTrang.getSelectedItem().toString();
        ((DefaultTableModel) tblDocGiaChon2.getModel()).setRowCount(0);
        for (SachDMTT i : listTra) {
            Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, fo.format(i.NgayMuon), i.MaCS, i.TenSach, i.TinhTrang};

            ((DefaultTableModel) tblDocGiaChon2.getModel()).addRow(obj);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int in = tblDocGiaChon2.getSelectedRow();
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");

        if (in < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        ((DefaultTableModel) tblDocGiaChon2.getModel()).removeRow(in);
        listTra.remove(in);
        ((DefaultTableModel) tblDocGiaChon2.getModel()).setRowCount(0);
        for (SachDMTT i : listTra) {
            Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, fo.format(i.NgayMuon), i.MaCS, i.TenSach, i.TinhTrang};

            ((DefaultTableModel) tblDocGiaChon2.getModel()).addRow(obj);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void load_sachtre() {
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        ((DefaultTableModel) tblSachTre.getModel()).setRowCount(0);
        for (SachDGDM i : listSachTre) {
            Object[] obj = new Object[]{i.MaDG, i.Ten, i.MaMS, fo.format(i.NgayMuon), i.MaCS, i.TenSach, i.SoNgayMuon};

            ((DefaultTableModel) tblSachTre.getModel()).addRow(obj);
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel60MouseClicked
        jDialog2.pack();
        jDialog2.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel60MouseClicked

    private void btnPhieuTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhieuTraMouseClicked
        SetShowPage(((JLabel) evt.getSource()).getText());
    }//GEN-LAST:event_btnPhieuTraMouseClicked

    private void btnSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDGActionPerformed
        int in = tblDocGia.getSelectedRow();
        if (in < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn độc giả để sửa!");
            return;
        }
        DocGia x = listDocGia.get(in);

        // TODO add your handling code here:
        x.TenDocGia = txtTenDocGiaDG.getText();
        x.GioiTinh = cboGTDG.getSelectedItem().toString();
        x.Email = txtEmailDG.getText();
        x.SDT = txtSDTDG.getText();
        x.DiaChi = txtDiaChiDG.getText();
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            x.NgaySinh = format2.parse(format2.format((txtNgaySinhDG.getDate())));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
        if (DocGiaDAO.updateDG(x) == 1) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            loadDataBase();
            SetShowPage("ĐỘC GIẢ");
        } else {
            JOptionPane.showMessageDialog(DocGia, "Thêm  không thành công");
        }
    }//GEN-LAST:event_btnSuaDGActionPerformed

    private void cboTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTheLoaiActionPerformed
        if (cboTheLoai.getSelectedItem().toString().equals("Mặc định")) {
            rsSach();
            return;
        }
        int ma = -1;
        for (ChuDe cd : listChuDe) {
            if (cd.TenChuDe.equals(cboTheLoai.getSelectedItem().toString())) {
                ma = cd.MaChuDe;
            }
        }
        ((DefaultTableModel) tblSach.getModel()).setRowCount(0);

        for (Sach s : listSach) {
            if (s.macd == ma) {
                Object[] obj = new Object[]{
                    s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia, s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
                };
                ((DefaultTableModel) tblSach.getModel()).addRow(obj);
            }

        }     // TODO add your handling code here:
    }//GEN-LAST:event_cboTheLoaiActionPerformed

    private void cboNXB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNXB1ActionPerformed
        if (cboNXB1.getSelectedItem().toString().equals("Mặc định")) {
            rsSach();
            return;
        }
        int ma = -1;
        for (NhaXuatBan cd : listNXB) {
            if (cd.TenNXB.equals(cboNXB1.getSelectedItem().toString())) {
                ma = cd.MaNXB;
            }
        }
        ((DefaultTableModel) tblSach.getModel()).setRowCount(0);

        for (Sach s : listSach) {
            if (s.manxb == ma) {
                Object[] obj = new Object[]{
                    s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia, s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
                };
                ((DefaultTableModel) tblSach.getModel()).addRow(obj);
            }

        }         // TODO add your handling code here:
    }//GEN-LAST:event_cboNXB1ActionPerformed

    private void cboTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTGActionPerformed
        if (cboTG.getSelectedItem().toString().equals("Mặc định")) {
            rsSach();
            return;
        }
        int ma = -1;
        for (TacGia cd : listTacGia) {
            if (cd.TenTacGia.equals(cboTG.getSelectedItem().toString())) {
                ma = cd.MaTacgia;
            }
        }
        ((DefaultTableModel) tblSach.getModel()).setRowCount(0);

        for (Sach s : listSach) {
            if (s.maTG == ma) {
                Object[] obj = new Object[]{
                    s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia, s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
                };
                ((DefaultTableModel) tblSach.getModel()).addRow(obj);
            }

        }      // TODO add your handling code here:
    }//GEN-LAST:event_cboTGActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        ((DefaultTableModel) tblSach.getModel()).setRowCount(0);
        for (Sach s : listSach) {
            if (s.tenSach.contains(txtSearch.getText())) {
                Object[] obj = new Object[]{
                    s.maSach, s.tenSach, s.giaBan, s.moTa, s.NgayCapNhat, s.AnhBia, s.SoLuong, s.Moi, s.maTG, s.manxb, s.macd
                };
                ((DefaultTableModel) tblSach.getModel()).addRow(obj);
            }

        }         // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblDocGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocGiaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDocGiaMouseEntered

    private void btnHoanTat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTat1ActionPerformed
        SetShowPage("SÁCH");        // TODO add your handling code here:
    }//GEN-LAST:event_btnHoanTat1ActionPerformed

    private void tblPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuonMouseClicked

        int in = tblPhieuMuon.getSelectedRow();
        if (in < 0) {
            return;
        }
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        txtMaPhieu.setText(tblPhieuMuon.getValueAt(in, 0).toString());
        txtMaDocGia.setText((tblPhieuMuon.getValueAt(in, 1).toString()));
        try {

            String dateStr = tblPhieuMuon.getValueAt(tblPhieuMuon.getSelectedRow(), 2).toString();
            Date v = fo.parse(dateStr); // parse thay vì format

            txtNgayMuonPM.setDate(v);

            dateStr = tblPhieuMuon.getValueAt(tblPhieuMuon.getSelectedRow(), 3).toString();
            v = fo.parse(dateStr);
            txtNgayTraDukien.setDate(v);
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblPhieuMuonMouseClicked

    private void tblPhieuTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuTraMouseClicked
        int in = tblPhieuTra.getSelectedRow();
        if (in < 0) {
            return;
        }
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
        txtMaPTPT.setText(tblPhieuTra.getValueAt(in, 0).toString());
        txtMaDocGia1.setText((tblPhieuTra.getValueAt(in, 2).toString()));
        txtMaPMPT.setText(tblPhieuTra.getValueAt(in, 1).toString());
        try {

            String dateStr = tblPhieuTra.getValueAt(tblPhieuTra.getSelectedRow(), 3).toString();
            Date v = fo.parse(dateStr); // parse thay vì format

            txtNgayTraPT.setDate(v);

        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblPhieuTraMouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        SetShowPage("Chi tiết PT");
        List<ChiTietPhieuTra> l = ChiTietPhieuTraDAO.getChiTietPhieuMuon();
        ((DefaultTableModel) tblCTPT.getModel()).setRowCount(0);
        for (ChiTietPhieuTra ct : l) {
            if (ct.MaPhieuTra == Integer.parseInt(txtMaPTPT.getText())) {
                Object[] obj = new Object[]{ct.MaPhieuTra, ct.MaCuonSach, ct.GhiChu};

                ((DefaultTableModel) tblCTPT.getModel()).addRow(obj);
            }
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        SetShowPage("PHIẾU TRẢ");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void tblCTPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCTPTMouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        SetShowPage("PHIẾU MƯỢN");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void tblCTPT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPT1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCTPT1MouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        SetShowPage("Chi tiết phiếu mượn");
        List<ChiTietPhieuMuon> l = ChiTietPhieuMuonDAO.getChiTietPhieuMuon();
        ((DefaultTableModel) tblCTPT1.getModel()).setRowCount(0);
        for (ChiTietPhieuMuon ct : l) {
            if (ct.MaPhieuMuon == Integer.parseInt(txtMaPhieu.getText())) {
                Object[] obj = new Object[]{ct.MaPhieuMuon, ct.MaSach, ct.SoLuong};

                ((DefaultTableModel) tblCTPT1.getModel()).addRow(obj);
            }
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void tblSachTreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachTreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSachTreMouseClicked

    private void jPanel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel64MouseClicked
        SachDM.pack();
        SachDM.show();
    }//GEN-LAST:event_jPanel64MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void tblCTPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPT2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCTPT2MouseClicked

    private void loadMSNhap() {
        for (Sach i : listSach) {
            int x = i.maSach;
            cboMas.addItem(String.valueOf(x));
        }

    }

    private void tblDocGiaMouseClicked(java.awt.event.MouseEvent evt) {
        if (tblDocGia.getSelectedRow() < 0) {
            return;
        }

        int row = tblDocGia.getSelectedRow();

        txtMaDocGiaDG.setText(tblDocGia.getValueAt(row, 0).toString());
        txtTenDocGiaDG.setText(tblDocGia.getValueAt(row, 1).toString());
        cboGTDG.setSelectedItem(tblDocGia.getValueAt(row, 3).toString());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = format.parse(tblDocGia.getValueAt(row, 2).toString()); // Đã sửa ở đây
            txtNgaySinhDG.setDate(format2.parse(format2.format(d)));
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtDiaChiDG.setText(tblDocGia.getValueAt(row, 4).toString());
        txtEmailDG.setText(tblDocGia.getValueAt(row, 5).toString());
        txtSDTDG.setText(tblDocGia.getValueAt(row, 6).toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Đặt giao diện Nimbus nếu có

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Tạo và hiển thị form bo góc
        java.awt.EventQueue.invokeLater(() -> {
            main frame = new main();                  // Tạo JFrame
            // Xoá viền mặc định
            frame.setSize(1500, 700);                  // Đặt kích thước nếu chưa có
            frame.setLocationRelativeTo(null);        // Căn giữa màn hình

            // Bo góc cửa sổ
            frame.setShape(new java.awt.geom.RoundRectangle2D.Double(
                    0, 0, frame.getWidth(), frame.getHeight(), 40, 40
            ));

            frame.setVisible(true);                   // Hiển thị form
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Anh;
    private javax.swing.JLabel Anh1;
    private javax.swing.JLabel Anh2;
    private javax.swing.JPanel BieuDoDGC;
    private javax.swing.JPanel BtnPanel;
    private javax.swing.JPanel CHonDGPanel;
    private javax.swing.JPanel CHonDGPanel1;
    private javax.swing.JPanel CenterPN;
    private javax.swing.JPanel ChiTietPT;
    private javax.swing.JPanel ChiTietPhieuMuon;
    private javax.swing.JPanel DSPhat;
    private javax.swing.JPanel DocGia;
    private javax.swing.JPanel HeaderPN;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel ItemPNBan1;
    private javax.swing.JPanel ItemPNBan2;
    private javax.swing.JPanel ItemPNMuon;
    private javax.swing.JPanel ItemPNMuon1;
    private javax.swing.JPanel ItemPNMuon2;
    private javax.swing.JPanel ItemSelect;
    private javax.swing.JPanel ItemSelectedPN;
    private javax.swing.JLabel LBSachDM;
    private javax.swing.JLabel LBTien;
    private javax.swing.JLabel LBTre;
    private javax.swing.JLabel LBtable;
    private javax.swing.JLabel LBtable1;
    private javax.swing.JLabel LbSLDG;
    private javax.swing.JPanel MainPN;
    private javax.swing.JPanel MenuPN;
    private javax.swing.JPanel Muon;
    private javax.swing.JPanel NhanVien;
    private javax.swing.JPanel PagePN;
    private javax.swing.JPanel PhieuMuon;
    private javax.swing.JPanel PhieuTra;
    private javax.swing.JPanel Sach;
    private javax.swing.JPanel Sach1;
    private javax.swing.JDialog SachDM;
    private javax.swing.JPanel TaiKhoan;
    private javax.swing.JDialog ThemDauSach;
    private javax.swing.JDialog TimDocGia;
    private javax.swing.JPanel Tra;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnChonAnh1;
    private javax.swing.JButton btnChonAnh2;
    private javax.swing.JButton btnChonDG;
    private javax.swing.JButton btnChonDG1;
    private javax.swing.JButton btnChonSachTra;
    private javax.swing.JButton btnChuDe;
    private javax.swing.JButton btnChuDe1;
    private javax.swing.JLabel btnDSPhat;
    private javax.swing.JLabel btnDocGia;
    private javax.swing.JButton btnHoanTat;
    private javax.swing.JButton btnHoanTat1;
    private javax.swing.JLabel btnHome;
    private javax.swing.JButton btnLoadDGMS;
    private javax.swing.JLabel btnMuonSach;
    private javax.swing.JLabel btnNhanVien;
    private javax.swing.JLabel btnPhieuMuon;
    private javax.swing.JLabel btnPhieuTra;
    private javax.swing.JLabel btnSach;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSuaDG;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnSuaSach;
    private javax.swing.JButton btnSuccess;
    private javax.swing.JButton btnTacGia;
    private javax.swing.JButton btnTacGia1;
    private javax.swing.JButton btnThemDG;
    private javax.swing.JButton btnThemMS;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnThemSach1;
    private javax.swing.JButton btnThemTG;
    private javax.swing.JButton btnThemTL;
    private javax.swing.JLabel btnTra;
    private javax.swing.JButton btnXemChiTietSach;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.JButton btnXoaSach1;
    private javax.swing.JComboBox<String> cboGTDG;
    private javax.swing.JComboBox<String> cboMaCS;
    private javax.swing.JComboBox<String> cboMaDG;
    private javax.swing.JComboBox<String> cboMas;
    private javax.swing.JComboBox<String> cboNXB;
    private javax.swing.JComboBox<String> cboNXB1;
    private javax.swing.JComboBox<String> cboNXB2;
    private javax.swing.JComboBox<String> cboNXB3;
    private javax.swing.JComboBox<String> cboTG;
    private javax.swing.JComboBox<String> cboTG1;
    private javax.swing.JComboBox<String> cboTG2;
    private javax.swing.JComboBox<String> cboTG3;
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JComboBox<String> cboTheLoai2;
    private javax.swing.JComboBox<String> cboTheLoai3;
    private javax.swing.JComboBox<String> cboTheLoai4;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JPanel lbSachTre;
    private javax.swing.JLabel lbSlSach;
    private javax.swing.JRadioButton rdoNew;
    private javax.swing.JRadioButton rdoNew1;
    private javax.swing.JLabel sadđ;
    private javax.swing.JTable tblCS;
    private javax.swing.JTable tblCTPT;
    private javax.swing.JTable tblCTPT1;
    private javax.swing.JTable tblCTPT2;
    private javax.swing.JTable tblDocGia;
    private javax.swing.JTable tblDocGiaChon;
    private javax.swing.JTable tblDocGiaChon1;
    private javax.swing.JTable tblDocGiaChon2;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblPhieuMuon;
    private javax.swing.JTable tblPhieuPhat;
    private javax.swing.JTable tblPhieuTra;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblSach1;
    private javax.swing.JTable tblSach2;
    private javax.swing.JTable tblSach3;
    private javax.swing.JTable tblSachChuaTra;
    private javax.swing.JTable tblSachTre;
    private javax.swing.JTextField txtDiaChiDG;
    private javax.swing.JTextField txtDiaChiMS;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtDiaChiTG;
    private javax.swing.JTextField txtDienThoaitg;
    private javax.swing.JTextField txtEmailDG;
    private javax.swing.JTextField txtEmailMS;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JComboBox<String> txtGTNV;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGhiChu1;
    private javax.swing.JTextField txtGhiChu2;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaBan1;
    private javax.swing.JTextField txtGiaBan2;
    private javax.swing.JComboBox<String> txtGioiTinhMS;
    private javax.swing.JTextField txtLuongNV;
    private javax.swing.JTextField txtMaDocGia;
    private javax.swing.JTextField txtMaDocGia1;
    private javax.swing.JTextField txtMaDocGia2;
    private javax.swing.JTextField txtMaDocGia3;
    private javax.swing.JTextField txtMaDocGia4;
    private javax.swing.JTextField txtMaDocGiaDG;
    private javax.swing.JTextField txtMaDocGiaMS;
    private javax.swing.JTextField txtMaDocGiaPM;
    private javax.swing.JTextField txtMaNhanVienNV;
    private javax.swing.JTextField txtMaPMPT;
    private javax.swing.JTextField txtMaPMTS;
    private javax.swing.JTextField txtMaPTPT;
    private javax.swing.JTextField txtMaPTPT1;
    private javax.swing.JTextField txtMaPTPT2;
    private javax.swing.JTextField txtMaPTPT3;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtMaPhieuPhat;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextArea txtMoTa1;
    private javax.swing.JTextArea txtMoTa2;
    private javax.swing.JFormattedTextField txtNVL;
    private com.toedter.calendar.JDateChooser txtNgayCapNhat;
    private com.toedter.calendar.JDateChooser txtNgayCapNhat1;
    private com.toedter.calendar.JDateChooser txtNgayCapNhat2;
    private javax.swing.JFormattedTextField txtNgayLapPM;
    private com.toedter.calendar.JDateChooser txtNgayMuonDGMS;
    private com.toedter.calendar.JDateChooser txtNgayMuonPM;
    private com.toedter.calendar.JDateChooser txtNgayMuonTS;
    private com.toedter.calendar.JDateChooser txtNgaySinhDG;
    private com.toedter.calendar.JDateChooser txtNgaySinhDGMS;
    private com.toedter.calendar.JDateChooser txtNgayTraDGMS;
    private com.toedter.calendar.JDateChooser txtNgayTraDukien;
    private com.toedter.calendar.JDateChooser txtNgayTraPT;
    private com.toedter.calendar.JDateChooser txtNgayTraTS;
    private javax.swing.JFormattedTextField txtNgaysinhNV;
    private javax.swing.JTextField txtSDTDG;
    private javax.swing.JTextField txtSDTMS;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchSach;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtTenDocGiaDG;
    private javax.swing.JTextField txtTenDocGiaMS;
    private javax.swing.JTextField txtTenDocGiaTS;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenSach1;
    private javax.swing.JTextField txtTenSach2;
    private javax.swing.JTextField txtTenSachTS;
    private javax.swing.JTextField txtTenTG;
    private javax.swing.JTextField txtTenTL;
    private javax.swing.JTextArea txtTieuSu;
    private javax.swing.JTextField txtTongTienPM;
    // End of variables declaration//GEN-END:variables
}
