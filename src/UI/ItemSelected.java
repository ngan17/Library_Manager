package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemSelected extends JPanel {

    public int MaSach;
    public int MaCuonSach;
    public String TenSach;
//    public int SoLuongSelect;

    private JLabel lblImage, lblName, lblPrice, lblQuantity, lblMaCuon;
    private JButton btnClose;

    public ItemSelected(int maSach, int maCuonSach, String name, String imagePath, double giaBan) {
        this.MaSach = maSach;
        this.MaCuonSach = maCuonSach;
        this.TenSach=name;
//        this.SoLuongSelect = quantity;

        setPreferredSize(new Dimension(210, 100));
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Ảnh sách
        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setVerticalAlignment(SwingConstants.CENTER);
        lblImage.setPreferredSize(new Dimension(60, 80));
        setImage(imagePath);

        // Thông tin sách
        lblName = new JLabel(name);
        lblName.setFont(new Font("Arial", Font.BOLD, 12));

        lblPrice = new JLabel("Giá: " + giaBan + " đ");
        lblPrice.setFont(new Font("Arial", Font.PLAIN, 12));

//        lblQuantity = new JLabel("SL: " + quantity);
//        lblQuantity.setFont(new Font("Arial", Font.PLAIN, 12));

        lblMaCuon = new JLabel("Mã cuốn: " + maCuonSach);
        lblMaCuon.setFont(new Font("Arial", Font.ITALIC, 11));
        lblMaCuon.setForeground(Color.GRAY);

        // Panel chứa thông tin
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.add(lblName);
        infoPanel.add(lblPrice);
//        infoPanel.add(lblQuantity);
        infoPanel.add(lblMaCuon);

        // Nút X
        btnClose = new JButton("X");
        btnClose.setMargin(new Insets(0, 5, 0, 5));
        btnClose.setFont(new Font("Arial", Font.BOLD, 12));
        btnClose.setToolTipText("Xóa khỏi danh sách mượn");
        btnClose.setFocusPainted(false);
        btnClose.setBackground(Color.RED);
        btnClose.setForeground(Color.WHITE);
        btnClose.setBorder(BorderFactory.createEmptyBorder());

        btnClose.addActionListener(e -> {
            Container parent = getParent();
            if (parent != null) {
                parent.remove(ItemSelected.this);
                parent.revalidate();
                parent.repaint();
            }
        });

        // Panel top-right chứa nút X
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(btnClose, BorderLayout.EAST);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(infoPanel, BorderLayout.CENTER);

        add(lblImage, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void setImage(String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imagePath));
            Image img = icon.getImage().getScaledInstance(60, 80, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImage.setText("Không có ảnh");
            lblImage.setHorizontalAlignment(SwingConstants.CENTER);
            lblImage.setForeground(Color.GRAY);
            e.printStackTrace();
        }
    }
    
  
}
