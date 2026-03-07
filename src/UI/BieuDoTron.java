/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;
import static DAO.PieChartDAO.taoDatasetTinhTrangSach;
    import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Admin
 */
public class BieuDoTron {



    public static void hienThiBieuDo(JPanel panel) {
        DefaultPieDataset dataset = taoDatasetTinhTrangSach();

        JFreeChart chart = ChartFactory.createPieChart(
                "📘 Tỉ lệ tình trạng sách hiện tại",
                dataset,
                true, true, false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setLabelFont(new Font("Tahoma", Font.PLAIN, 12));
        plot.setCircular(true);
        plot.setLabelGap(0.02);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(panel.getSize());

        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();
    }
}


