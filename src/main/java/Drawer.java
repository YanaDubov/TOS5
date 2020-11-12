
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Drawer extends JFrame {

    public Drawer() {
    }

    public Drawer(String title, Map<String, double[]> funcs) {

        initUI(title, funcs);
    }

    private void initUI(String title, Map<String, double[]> funcs) {

        XYSeriesCollection data = new XYSeriesCollection();
        funcs.forEach((title1, val) -> data.addSeries(createDataset(title1, val)));
        graphics(title, data);
    }

    private void graphics(String title, XYSeriesCollection data) {
        JFreeChart chart = createChart(data);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle(title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYSeries createDataset(String title, double[] values) {

        XYSeries series = new XYSeries(title);

        for (int a = 0; a <= values.length-1; a++) {
            series.add(a , values[a]);
        }
        return series;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                " ",
                "n",
                "x(n)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesShapesVisible(3, false);
        renderer.setSeriesShapesVisible(4, false);

        return chart;
    }
}
