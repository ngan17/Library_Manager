/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Model.Sach;
import Model.SachDMTT;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class InPhieuNhap {

    public static void xuatPhieuNhap(String tenNhanVien, String maNhanVien, String maPhieuNhap, String ngayNhap, List<Sach> danhSach) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("PN" + maPhieuNhap + ".pdf"));
            doc.open();

            BaseFont bf = BaseFont.createFont("src/doanquanlythuvien/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(bf, 16, Font.BOLD);
            Font normalFont = new Font(bf, 12);

            Paragraph title = new Paragraph("PHIẾU NHẬP THƯ VIỆN", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Nhân viên: " + tenNhanVien, normalFont));
            doc.add(new Paragraph("Mã nhân viên: " + maNhanVien, normalFont));
            doc.add(new Paragraph("Mã phiếu nhập: " + maPhieuNhap, normalFont));

            doc.add(new Paragraph("Ngày Nhập: " + ngayNhap, normalFont));
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 5, 3,4});

            // Header table
            table.addCell(new PdfPCell(new Phrase("STT", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Mã cuốn", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Tên sách", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", normalFont)));

            int stt = 1;
            for (Sach item : danhSach) {
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stt++), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(item.maSach), normalFont)));
                table.addCell(new PdfPCell(new Phrase(item.tenSach, normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(item.SoLuong), normalFont)));
                table.addCell(new PdfPCell(new Phrase("Tốt", normalFont)));
            }

            doc.add(table);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Người mượn ký tên: ____________________", normalFont));

            doc.close();
            JOptionPane.showMessageDialog(null, "Đã xuất phiếu nhập thành PDF!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

// Mở file PDF sau khi xuất
            File file = new File("PN" + maPhieuNhap + ".pdf");
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(null, "Không hỗ trợ mở file trên hệ thống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }

            JOptionPane.showMessageDialog(null, "Đã xuất phiếu nhập thành PDF!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất phiếu nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
