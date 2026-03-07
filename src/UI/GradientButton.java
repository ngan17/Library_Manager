/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

/**
 *
 * @author Nganp
 */
public class GradientButton extends JButton {



    private Color colorStart = Color.decode("#C9FFBF");
    private Color colorEnd = Color.decode("#FFAFBD");
    public GradientButton() {
         setOpaque(true);
    }
    

    public GradientButton(String text, Color start, Color end) {
        super(text);
        this.colorStart = start;
        this.colorEnd = end;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE); // Text color
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setOpaque(true);
    }
    
    public void SetGradientButon(Color start, Color end)
    {
        this.colorStart=start;
        this.colorEnd=end;
          
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, colorStart, w, h, colorEnd);
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, w, h, 20, 20); // bo góc 20px
        g2.dispose();

        super.paintComponent(g);
    }
}
