package UI;

import java.awt.*;
import javax.swing.*;

import java.awt.*;
import javax.swing.*;

public class GradientPanel extends JPanel {
    private Color colorStart = Color.decode("#C9FFBF");
    private Color colorEnd = Color.decode("#FFAFBD");

    public GradientPanel() {
        setOpaque(true); 
    }

    public GradientPanel(Color start, Color end) {
        this.colorStart = start;
        this.colorEnd = end;
        setOpaque(true);
    }

    public void setGradient(Color start, Color end) {
        this.colorStart = start;
        this.colorEnd = end;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Gọi trước để panel hoạt động đúng
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, colorStart, 0, h, colorEnd);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        g2d.dispose();
    }
}
