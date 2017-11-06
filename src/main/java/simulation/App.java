package simulation;

import charts.LineChart;
import modelcalculations.ModelCalculationImpl;
import models.*;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        BasePopulationModel model = new BasePopulationModel();
        BasePopulationModel energyModel = new EnergyConsumptionPopulationModel(new BasePopulationModel(), 0.4, 3);
        BasePopulationModel migrationModel = new PopulationMigrationModel(new BasePopulationModel(), 15000, 2000, 5000);
        BasePopulationModel airPolutionModel = new AirPolutionPopulationModel(new BasePopulationModel(), 18, 340, 3.5);
        BasePopulationModel crimeModel = new CrimePopulationModel(new BasePopulationModel(), 70, 10, 5000);

        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Population Growth Model", new LogisticGrowthModel(model, 0.9, 0.5, 60000, 5000, 0), new ModelCalculationImpl());

            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
