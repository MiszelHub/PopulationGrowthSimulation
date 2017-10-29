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
                        new BasePopulationModel(basePopulationCount), numberOfPeopleMigratingIn, numberOfPeopleMigratingOut), birthRate, deathRate, environmentCapacity);

        double v = model.calculateCoefficient();
        modelCalculation.calculateNextPopulationCount(model);
        System.out.println(v);
    }

}