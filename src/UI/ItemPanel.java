package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Consumer;

public class ItemPanel extends JPanel {

    private JLabel lblImage, lblName, lblPrice, lblQuantity;
    private JButton btnChon;
    private JComboBox<String> cboMaCuonSach;

    private int cornerRadius = 20; // Bo góc

    public int MaSach;
    public String name;
    public String imagePath;
    public double giaBan;
    public int quantity;
    public int BM;
    public int slchon;

    public ItemPanel(int masach, String name, String imagePath, double giaBan, int quantity, String mota, int bm, List<String> danhSachMaCuon, Consumer<ItemPanel> onButtonClick) {
        setPreferredSize(new Dimension(220, 330));
        setLayout(new BorderLayout(5, 5));
        setOpaque(false);
        setBackground(Color.WHITE);

        this.name = name;
        this.imagePath = imagePath;
        this.giaBan = giaBan;
        this.quantity = quantity;
        this.MaSach = masach;
        this.BM = bm;

        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setVerticalAlignment(SwingConstants.CENTER);
        lblImage.setPreferredSize(new Dimension(140, 150));
        setImage(imagePath);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        
        

        lblName = new JLabel(name.length() > 20 ? name.substring(0, 20) + "." : name);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblName.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblPrice = new JLabel("Giá: " + new DecimalFormat("#,###").format(giaBan) + " đ");
        lblPrice.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblPrice.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblQuantity = new JLabel("Kho: " + quantity);
        lblQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblQuantity.setAlignmentX(Component.LEFT_ALIGNMENT);

        infoPanel.add(lblName);
        infoPanel.add(Box.createVerticalStrut(4));
        infoPanel.add(lblPrice);
        infoPanel.add(Box.createVerticalStrut(4));
        infoPanel.add(lblQuantity);
        infoPanel.add(Box.createVerticalStrut(8));

        // ComboBox Mã cuốn sách
        infoPanel.add(new JLabel("Mã cuốn:"));
        infoPanel.add(Box.createVerticalStrut(4));

        cboMaCuonSach = new JComboBox<>();
        for (String maCuon : danhSachMaCuon) {
            cboMaCuonSach.addItem(maCuon);
        }
        cboMaCuonSach.setMaximumSize(new Dimension(80, 25));
        cboMaCuonSach.setPreferredSize(new Dimension(80, 25));
        cboMaCuonSach.setAlignmentX(Component.LEFT_ALIGNMENT);

        infoPanel.add(cboMaCuonSach);
        infoPanel.add(Box.createVerticalStrut(8));

        // Nút Chọn
        btnChon = new JButton("Chọn");
        btnChon.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnChon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnChon.addActionListener(e -> {
            if (onButtonClick != null) {
                onButtonClick.accept(this);
            }
        });
        infoPanel.add(btnChon);

        add(lblImage, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
        setToolTipText(mota);

        // Hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(230, 240, 255));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.WHITE);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.setColor(Color.LIGHT_GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose();
        super.paintComponent(g);
    }

    private void setImage(String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imagePath));
            Image img = icon.getImage().getScaledInstance(140, 150, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImage.setText("Không có ảnh");
            lblImage.setHorizontalAlignment(SwingConstants.CENTER);
            lblImage.setForeground(Color.GRAY);
            e.printStackTrace();
        }
    }

    public int getMaCuonDuocChon() {
        return Integer.parseInt(cboMaCuonSach.getSelectedItem().toString());
    }
}
