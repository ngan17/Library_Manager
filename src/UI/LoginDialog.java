package UI;

import Model.TaiKhoan;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

public class LoginDialog extends JDialog {

    private JTextField txtuser;
    private JPasswordField txtPass;
    private JButton btnLogin;
    public boolean isLoggedIn = false;
    public List<TaiKhoan> l = new ArrayList<TaiKhoan>();

    public TaiKhoan x = new TaiKhoan();

    public LoginDialog(Frame parent) {
        super(parent, "Đăng nhập", true);
        initComponents();
    }

    private void initComponents() {
        // Gradient nền bo góc
        RoundedPanel gradientPanel = new RoundedPanel(30);
        gradientPanel.setLayout(new BoxLayout(gradientPanel, BoxLayout.Y_AXIS));
        gradientPanel.setBackground(new Color(255, 255, 255, 10));
        gradientPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        Font fontTitle = new Font("Segoe UI", Font.BOLD, 26);
        Font fontSub = new Font("Segoe UI", Font.ITALIC, 16);
        Font fontLabel = new Font("Segoe UI", Font.PLAIN, 14);

               ImageIcon logo = new ImageIcon(getClass().getResource("/images/digital-library.png"));
        Image scaledLogo = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(scaledLogo));
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        gradientPanel.add(lblLogo); 
        
        JLabel lblTitle = new JLabel("THƯ VIỆN NNLH", SwingConstants.CENTER);
        lblTitle.setFont(fontTitle);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
 

        JLabel lblSub = new JLabel("LOGIN", SwingConstants.CENTER);
        lblSub.setFont(fontSub);
        lblSub.setForeground(Color.WHITE);
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblUser = new JLabel("Tên đăng nhập");
        lblUser.setFont(fontLabel);
        lblUser.setForeground(Color.WHITE);
        lblUser.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        txtuser = new RoundedTextField(25);
        txtuser.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtuser.setFont(fontLabel);
        txtuser.setBackground(new Color(255, 255, 255, 230));
        txtuser.setForeground(Color.BLACK);
        txtuser.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblPass = new JLabel("Mật khẩu");
        lblPass.setFont(fontLabel);
        lblPass.setForeground(Color.WHITE);

        txtPass = new RoundedPasswordField(25);
        txtPass.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtPass.setFont(fontLabel);
        txtPass.setBackground(new Color(255, 255, 255, 230));
        txtPass.setForeground(Color.BLACK);
        txtPass.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        btnLogin = new RoundedButton("ĐĂNG NHẬP");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setBackground(new Color(0, 153, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 120, 215));
            }

            public void mouseExited(MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 153, 255));
            }
        });

        btnLogin.addActionListener(e -> dangNhap());

        gradientPanel.add(lblTitle);
        gradientPanel.add(Box.createVerticalStrut(8));
        gradientPanel.add(lblSub);
        gradientPanel.add(Box.createVerticalStrut(25));
        gradientPanel.add(lblUser);
        gradientPanel.add(txtuser);
        gradientPanel.add(Box.createVerticalStrut(18));
        gradientPanel.add(lblPass);
        gradientPanel.add(txtPass);
        gradientPanel.add(Box.createVerticalStrut(25));
        gradientPanel.add(btnLogin);

        JPanel wrapper = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 200, 255), 0, getHeight(), new Color(0, 0, 100));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            }
        };
        wrapper.setLayout(new BorderLayout());
        wrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        wrapper.setBackground(new Color(0, 0, 0, 0));
        wrapper.add(gradientPanel, BorderLayout.CENTER);

        setUndecorated(true);
        setSize(450, 440);
        setLocationRelativeTo(null);
        setContentPane(wrapper);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
    }

    private void dangNhap() {
        String user = txtuser.getText().trim();
        String pass = new String(txtPass.getPassword()).trim();
        for (TaiKhoan i : l) {
            if (user.equals(i.TenDangNhap) && pass.equals(i.MauKhau)) {
                x = i;
                isLoggedIn = true;
                dispose();
                return;
            }
            
            
        }
        JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginDialog login = new LoginDialog(null);
            main x = new main();
            x.show(true);
        });
    }
}

class RoundedPanel extends JPanel {

    private final int radius;

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
    }
}

class RoundedTextField extends JTextField {

    private int radius;

    public RoundedTextField(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }
}

class RoundedPasswordField extends JPasswordField {

    private int radius;

    public RoundedPasswordField(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }
}

class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        super.paintComponent(g);
        g2.dispose();
    }
}