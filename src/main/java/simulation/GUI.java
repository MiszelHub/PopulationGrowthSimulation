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
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class GUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSlider birthRateSlider;
    private JSlider environmentCapacitySlider;
    private JSlider basePopulationSlider;
    private JSlider deathRateSlider;
    private JSlider co2EmissionSlider;
    private JLabel basePopulationLabel;
    private JLabel environmentCapacityLablel;
    private JLabel birthrateLabel;
    private JLabel deathRateLabel;
    private JLabel CO2EmissionLabel;
    private JLabel incomePerCapitaLabel;
    private JLabel regulatoryEffortLabel;
    private JLabel numberofReportedCrimesLabel;
    private JLabel numberOfTestedGroupsLabel;
    private JLabel energyEfficiencyLabel;
    private JLabel energyPerCapitaLabel;
    private JLabel numberOfPeopleMigratingInLabel;
    private JLabel numberOfPeopleMigratingOut;
    private JSlider incomePerCapitaSlider;
    private JSlider regulatoryEffortSlider;
    private JSlider numberOfReportedCrimesSlider;
    private JSlider numberOfTestedGroupsSlider;
    private JSlider energyEfficiencySlider;
    private JSlider energyPerCapitaSlider;
    private JSlider numberOfPeopleMigratinInSlider;
    private JSlider numberOfPeopleMigratingOutSlider;
    private JLabel basePopulationValue;
    private JLabel environmentCapacityValue;
    private JLabel birthRateValue;
    private JLabel deathRateValue;
    private JLabel co2EmissionValue;
    private JLabel incomePerCapitaValue;
    private JLabel regulatoryEffortValue;
    private JLabel numberOfReportedCrimesValue;
    private JLabel numberOfTestedGroupsValue;
    private JLabel energyEfficiencyValue;
    private JLabel energyPerCapitaValue;
    private JLabel numberOfPeopleMigratingInValue;
    private JLabel numberOfPeopleMigratingOutValue;
    private JFrame chartFrame = null;

    public GUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        basePopulationSlider.addChangeListener(e -> {
            basePopulationValue.setText(String.valueOf(basePopulationSlider.getValue()));
            numberOfTestedGroupsValue.setText(String.valueOf(basePopulationSlider.getValue()/100));
        });
        environmentCapacitySlider.addChangeListener(e -> {
            environmentCapacityValue.setText(String.valueOf(environmentCapacitySlider.getValue()));
        });
        birthRateSlider.addChangeListener(e -> {
            birthRateValue.setText(String.valueOf(birthRateSlider.getValue() / 100.0));
        });
        deathRateSlider.addChangeListener(e -> {
            deathRateValue.setText(String.valueOf(deathRateSlider.getValue() / 100.0));
        });
        co2EmissionSlider.addChangeListener(e -> {
            co2EmissionValue.setText(String.valueOf(co2EmissionSlider.getValue()));
        });
        incomePerCapitaSlider.addChangeListener(e -> {
            incomePerCapitaValue.setText(String.valueOf(incomePerCapitaSlider.getValue()));
        });
        regulatoryEffortSlider.addChangeListener(e -> {
            regulatoryEffortValue.setText(String.valueOf(regulatoryEffortSlider.getValue()));
        });
        numberOfReportedCrimesSlider.addChangeListener(e -> {
            numberOfReportedCrimesValue.setText(String.valueOf(numberOfReportedCrimesSlider.getValue()));
        });
        numberOfTestedGroupsSlider.addChangeListener(e -> {
            numberOfTestedGroupsValue.setText(String.valueOf(numberOfTestedGroupsSlider.getValue()));
        });
        energyEfficiencySlider.addChangeListener(e -> {
            energyEfficiencyValue.setText(String.valueOf(energyEfficiencySlider.getValue() / 100.0));
        });
        energyPerCapitaSlider.addChangeListener(e -> {
            energyPerCapitaValue.setText(String.valueOf(energyPerCapitaSlider.getValue()));
        });
        numberOfPeopleMigratinInSlider.addChangeListener(e -> {
            numberOfPeopleMigratingInValue.setText(String.valueOf(numberOfPeopleMigratinInSlider.getValue()));
        });
        numberOfPeopleMigratingOutSlider.addChangeListener(e -> {
            numberOfPeopleMigratingOutValue.setText(String.valueOf(numberOfPeopleMigratingOutSlider.getValue()));
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        calculateModels();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void calculateModels() {


        final Logger logger = Logger.getLogger(App.class);
        final int YEAR_COUNT = 20;

        if(chartFrame != null)
            chartFrame.dispose();

        BasePopulationModel model = new BasePopulationModel();
        BasePopulationModel energyModel = new EnergyConsumptionPopulationModel(new BasePopulationModel(), Double.parseDouble(energyEfficiencyValue.getText()), Integer.parseInt(energyPerCapitaValue.getText()));
        BasePopulationModel migrationModel = new PopulationMigrationModel(new BasePopulationModel(), Integer.parseInt(numberOfPeopleMigratingInValue.getText()), Integer.parseInt(numberOfPeopleMigratingOutValue.getText()), Integer.parseInt(basePopulationValue.getText()));
        BasePopulationModel airPolutionModel = new AirPolutionPopulationModel(new BasePopulationModel(), Integer.parseInt(co2EmissionValue.getText()), Integer.parseInt(incomePerCapitaValue.getText()), Integer.parseInt(regulatoryEffortValue.getText()));
        BasePopulationModel crimeModel = new CrimePopulationModel(new BasePopulationModel(), Integer.parseInt(numberOfReportedCrimesValue.getText()), Integer.parseInt(numberOfTestedGroupsValue.getText()), Integer.parseInt(basePopulationValue.getText()));


        PopulationCalculator populationCalculator = new PopulationCalculator(new ModelCalculationImpl(), Double.parseDouble(birthRateValue.getText()), Double.parseDouble(deathRateValue.getText()), Integer.parseInt(environmentCapacityValue.getText()), Integer.parseInt(basePopulationValue.getText()));

        IDataSetBuilder<Integer, Integer> dataSetBuilder = new DataSetBuilder<>();
        ChartFactory<JFrame> chartFactory = new LineChartFactory();

        try

        {
            Dataset dataset = dataSetBuilder
                    .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, model), YEAR_COUNT, "Base Model")
                    .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, energyModel), YEAR_COUNT, "Energy Model")
                    .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, migrationModel), YEAR_COUNT, "Migration Model")
                    .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, airPolutionModel), YEAR_COUNT, "Air Pollution Model")
                    .AddDataSeries(populationCalculator.calculatePopulationValuesForGivenYearRange(YEAR_COUNT, crimeModel), YEAR_COUNT, "Crime Model")
                    .build();

            chartFrame = chartFactory.CreateChart(dataset, "Population Growth", "Time [years]", "population");
        } catch (
                ToManyArgumentsException e)

        {
            e.printStackTrace();
        }


        JFrame finalChartFrame = chartFrame;

        if (finalChartFrame != null) {
            //finalChartFrame.setAlwaysOnTop(true);
            finalChartFrame.pack();
            finalChartFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            finalChartFrame.setBounds(500, 0, 800, 600);
            finalChartFrame.setVisible(true);
        } else {
            System.err.println("SOMETHING WENT WRONG");
        }


    }
}

