package UI;

import Model.SachDGDM;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class InPM {
    public static void xuatPhieuMuon(String tenDocGia, String maDocGia, String maPM, String ngayMuon, List<SachDGDM> danhSach) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("phieu_muon_" + maPM + ".pdf"));
            doc.open();

        
            BaseFont bf = BaseFont.createFont("src/doanquanlythuvien/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(bf, 16, Font.BOLD);
            Font normalFont = new Font(bf, 12);

            Paragraph title = new Paragraph("PHIẾU MƯỢN THƯ VIỆN", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph(" "));

            doc.add(new Paragraph("Độc giả: " + tenDocGia, normalFont));
            doc.add(new Paragraph("Mã độc giả: " + maDocGia, normalFont));
            doc.add(new Paragraph("Mã phiếu mượn: " + maPM, normalFont));
            doc.add(new Paragraph("Ngày mượn: " + ngayMuon, normalFont));
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 5, 3});

            // Header table
            table.addCell(new PdfPCell(new Phrase("STT", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Mã cuốn", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Tên sách", normalFont)));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", normalFont)));

            int stt = 1;
            for (SachDGDM item : danhSach) {
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stt++), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(item.MaCS), normalFont)));
                table.addCell(new PdfPCell(new Phrase(item.TenSach, normalFont)));
                table.addCell(new PdfPCell(new Phrase("", normalFont)));
            }

            doc.add(table);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Người mượn ký tên: ____________________", normalFont));

            doc.close();
            JOptionPane.showMessageDialog(null, "Đã xuất phiếu mượn thành PDF!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

// Mở file PDF sau khi xuất
File file = new File("phieu_muon_" + maPM + ".pdf");
if (file.exists()) {
    if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().open(file);
    } else {
        JOptionPane.showMessageDialog(null, "Không hỗ trợ mở file trên hệ thống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

            JOptionPane.showMessageDialog(null, "Đã xuất phiếu mượn thành PDF!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất phiếu mượn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
