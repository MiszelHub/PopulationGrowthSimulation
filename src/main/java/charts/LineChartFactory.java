package charts;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;

import javax.swing.*;

public class LineChartFactory implements ChartFactory<JFrame> {

    @Override
    public JFrame CreateChart(final Dataset dataset, final String title, final String xAxisLabel, final String yAxisLabel) {

        JFreeChart chart = org.jfree.chart.ChartFactory.createLineChart(title,
            xAxisLabel,
            yAxisLabel,
            (CategoryDataset) dataset, PlotOrientation.VERTICAL, true, true, false);


        JFrame frame = new JFrame(title);
        ChartPanel panel = new ChartPanel(chart);
        frame.setContentPane(panel);

        return frame;
    }
}
