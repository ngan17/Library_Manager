package UI;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.awt.*;

public class BieuDoDGChart {

   public static void hienThiTrongPanel(JPanel panelBieuDo, XYDataset dataset) {
    JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "📊 Biểu đồ mượn/trả theo ngày",
            "Ngày",
            "Số lượt",
            dataset,
            true,
            true,
            false
    );

    XYPlot plot = chart.getXYPlot();
    plot.setBackgroundPaint(Color.WHITE);
    plot.setRangeGridlinePaint(Color.GRAY);
    plot.setDomainGridlinePaint(Color.LIGHT_GRAY);

    // Bạn có thể giữ nguyên renderer cũ hoặc bỏ spline
    plot.setRenderer(new XYSplineRenderer());

    // Font mượt
    Font font = new Font("Tahoma", Font.PLAIN, 13);
    plot.getDomainAxis().setLabelFont(font);
    plot.getDomainAxis().setTickLabelFont(font);
    plot.getRangeAxis().setLabelFont(font);
    plot.getRangeAxis().setTickLabelFont(font);

    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(panelBieuDo.getSize());
    chartPanel.setMouseWheelEnabled(true);

    panelBieuDo.removeAll();
    panelBieuDo.setLayout(new BorderLayout());
    panelBieuDo.add(chartPanel, BorderLayout.CENTER);
    panelBieuDo.revalidate();
    panelBieuDo.repaint();
}

    // Dữ liệu test (x là thứ tự ngày, y là số lượt)
    public static XYDataset taoDuLieuDemo() {
        XYSeries muon = new XYSeries("Mượn sách");
        muon.add(1, 3);
        muon.add(2, 5);
        muon.add(3, 2);
        muon.add(4, 6);

        XYSeries tra = new XYSeries("Trả sách");
        tra.add(1, 2);
        tra.add(2, 4);
        tra.add(3, 3);
        tra.add(4, 5);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(muon);
        dataset.addSeries(tra);
        return dataset;
    }
}
