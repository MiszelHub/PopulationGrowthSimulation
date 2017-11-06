package charts;

import modelcalculations.ModelCalculation;
import models.LogisticGrowthModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

/**
 * Created by Marcinn on 2017-11-06.
 */
public class LineChart extends JFrame {

    private static final long serialVersionUID = 1L;
    private final LogisticGrowthModel model;
    private ModelCalculation modelCalculation;
    public LineChart(String title, LogisticGrowthModel model, ModelCalculation modelCalculation) {
        super(title);
        this.model = model;
        this.modelCalculation = modelCalculation;
        // Create dataset
        CategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart("Population Diagram",
                "time [years]",
                "population count",
                dataset, PlotOrientation.VERTICAL,true,true,false);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {

        String series1 = "Population growth";
        //String series2 = "Unique Visitor";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(model.getBasePopulationCount(),series1,String.valueOf(0));
        for (int i=1;i <=20;i++){
            int nextPopulation = (modelCalculation.calculateNextPopulationCount(model,i));
            dataset.addValue(nextPopulation,series1,String.valueOf(i));
            model.setBasePopulationCount(nextPopulation);
        }

//        dataset.addValue(200, series1, "2016-12-19");
//        dataset.addValue(150, series1, "2016-12-20");
//        dataset.addValue(100, series1, "2016-12-21");
//        dataset.addValue(210, series1, "2016-12-22");
//        dataset.addValue(240, series1, "2016-12-23");
//        dataset.addValue(195, series1, "2016-12-24");
//        dataset.addValue(245, series1, "2016-12-25");

//        dataset.addValue(150, series2, "2016-12-19");
//        dataset.addValue(130, series2, "2016-12-20");
//        dataset.addValue(95, series2, "2016-12-21");
//        dataset.addValue(195, series2, "2016-12-22");
//        dataset.addValue(200, series2, "2016-12-23");
//        dataset.addValue(180, series2, "2016-12-24");
//        dataset.addValue(230, series2, "2016-12-25");

        return dataset;
    }
}
