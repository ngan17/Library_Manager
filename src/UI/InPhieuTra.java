/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Model.SachDGDM;
import Model.SachDMTT;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class InPhieuTra {

    public static void xuatPhieuTra(String tenDocGia, String maDocGia, String maPhieuTra,String ngaytra, List<SachDMTT> danhSach,int songaytre) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("PT" + maPhieuTra + ".pdf"));
            doc.open();

            BaseFont bf = BaseFont.createFont("src/doanquanlythuvien/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(bf, 16, Font.BOLD);
            Font normalFont = new Font(bf, 12);

            Paragraph title = new Paragraph("PHIẾU TRẢ THƯ VIỆN", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Độc giả: " + tenDocGia, normalFont));
            doc.add(new Paragraph("Mã độc giả: " + maDocGia, normalFont));
            doc.add(new Paragraph("Mã phiếu mượn: " + maPhieuTra, normalFont));
          
            doc.add(new Paragraph("Ngày trả: " + ngaytra, normalFont));
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 5, 5,2});

            // Header table
            table.addCell(new PdfPCell(new Phrase("STT", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Mã cuốn", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Tên sách", normalFont)));
             table.addCell(new PdfPCell(new Phrase("Số ngày trễ", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", normalFont)));

            int stt = 1;
            for (SachDMTT item : danhSach) {
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stt++), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(item.MaCS), normalFont)));
                table.addCell(new PdfPCell(new Phrase(item.TenSach, normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(songaytre))));
                if (item.TinhTrang.equals("Mất sách")){
                    table.addCell(new PdfPCell(new Phrase("50000 VND(Mất)", normalFont)));
                }
                else
                   if (item.TinhTrang.equals("Hư hỏng")){
                    table.addCell(new PdfPCell(new Phrase("30000 VND(Hư)", normalFont)));
                }
                else
                       if (songaytre>0)
                   {
                         table.addCell(new PdfPCell(new Phrase(String.valueOf(songaytre*5000), normalFont)));
                   }
                else
                       {
                         table.addCell(new PdfPCell(new Phrase("", normalFont)));
                   }     
              
            }

            doc.add(table);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Người trả ký tên: ____________________", normalFont));

            doc.close();
            JOptionPane.showMessageDialog(null, "Đã xuất phiếu trả thành PDF!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

// Mở file PDF sau khi xuất
            File file = new File("PT" + maPhieuTra + ".pdf");
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(null, "Không hỗ trợ mở file trên hệ thống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }

            JOptionPane.showMessageDialog(null, "Đã xuất phiếu trả thành PDF!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất phiếu trả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
