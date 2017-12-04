package simulation;

import charts.ChartFactory;
import charts.LineChartFactory;
import charts.builders.DataSetBuilder;
import charts.builders.IDataSetBuilder;
import charts.builders.exceptions.ToManyArgumentsException;
import modelcalculations.ModelCalculationImpl;
import models.*;
import org.apache.log4j.Logger;
import org.jfree.data.general.Dataset;

import javax.swing.*;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class);
    private static final int YEAR_COUNT = 20;

    public static void main(String[] args) {
//        BasePopulationModel model = new BasePopulationModel();
//        BasePopulationModel energyModel = new EnergyConsumptionPopulationModel(new BasePopulationModel(), 0.4, 3);
//        BasePopulationModel migrationModel = new PopulationMigrationModel(new BasePopulationModel(), 40000, 20000, 5000);
//        BasePopulationModel airPolutionModel = new AirPolutionPopulationModel(new BasePopulationModel(), 18, 340, 3.5);
//        BasePopulationModel crimeModel = new CrimePopulationModel(new BasePopulationModel(), 70, 10, 5000);
//
//        PopulationCalculator populationCalculator = new PopulationCalculator(new ModelCalculationImpl());
//
//        IDataSetBuilder<Integer,Integer> dataSetBuilder = new DataSetBuilder<>();
//        ChartFactory<JFrame> chartFactory = new LineChartFactory();
//        JFrame chartFrame = null;
//        try {
//            Dataset dataset = dataSetBuilder
//                .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, model), YEAR_COUNT, "Base Model")
//                .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, energyModel), YEAR_COUNT, "Energy Model")
//                .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, migrationModel), YEAR_COUNT, "Migration Model")
//                .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, airPolutionModel), YEAR_COUNT, "Air Pollution Model")
//                .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, crimeModel), YEAR_COUNT, "Crime Model")
//                .build();
//
//            chartFrame = chartFactory.CreateChart(dataset, "Population Growth", "Time [years]", "population");
//        } catch (ToManyArgumentsException e) {
//            e.printStackTrace();
//        }
//
//
//        JFrame finalChartFrame = chartFrame;
//        SwingUtilities.invokeLater(() -> {
//            if (finalChartFrame != null) {
//                finalChartFrame.setAlwaysOnTop(true);
//                finalChartFrame.pack();
//                finalChartFrame.setSize(600, 400);
//                finalChartFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                finalChartFrame.setVisible(true);
//            }else{
//                System.err.println("SOMETHING WENT WRONG");
//            }
//
//        });



        GUI dialog = new GUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
