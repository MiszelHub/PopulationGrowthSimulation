package modelcalculations;

import models.*;
import org.junit.Before;
import org.junit.Test;

public class ModelCalculationTest {

    private ModelCalculation modelCalculation;


    @Before
    public void setUp() throws Exception {
        modelCalculation = new ModelCalculationImpl();

    }

    @Test
    public void calculateModifierValue() {


       final int basePopulationCount = 40_000;
       final int numberOfPeopleMigratingIn = 0;
       final int numberOfPeopleMigratingOut = 4_000;
       final double birthRate = 0.5;
       final double deathRate = 0.2;
       final double environmentCapacity = 50_000;

        LogisticGrowthModel model = new LogisticGrowthModel(
                new PopulationMigrationModel(
                        new BasePopulationModel(basePopulationCount,1), numberOfPeopleMigratingIn, numberOfPeopleMigratingOut), birthRate, deathRate, environmentCapacity, 500);

        double v = model.calculateCoefficient();
        modelCalculation.calculateNextPopulationCount(model, 1);
        System.out.println(v);
    }

    @Test
    public void CalculateNextPopulationValue() throws Exception {
        LogisticGrowthModel model =
                new LogisticGrowthModel(new BasePopulationModel(500,0.0),0.6,0.1,1000, 500);

        int result = modelCalculation.calculateNextPopulationCount(model, 1.0);

        System.out.println(result);
    }
}