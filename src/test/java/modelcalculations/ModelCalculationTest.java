package modelcalculations;

import models.*;

import org.junit.Before;
import org.junit.Test;
import sun.rmi.runtime.Log;

import static org.junit.Assert.assertEquals;

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
                        new BasePopulationModel(basePopulationCount,1), numberOfPeopleMigratingIn, numberOfPeopleMigratingOut,500), birthRate, deathRate, environmentCapacity, 500,1);

        double v = model.calculateCoefficient();
        modelCalculation.calculateNextPopulationCount(model, 1);
        System.out.println(v);
    }

    @Test
    public void CalculateNextPopulationValue() throws Exception {
        BasePopulationModel model =
                arrangeModel(0,500, LogisticGrowthModel.class);

        int result = modelCalculation.calculateNextPopulationCount(model, 1.0);

        System.out.println(result);

        assertEquals(622,result);
    }



    @Test
    public void modelDecorator_assign_Correct_values() throws Exception {
        BasePopulationModel model =
                arrangeModel(1,500, LogisticGrowthModel.class);

        assertEquals(500,model.getBasePopulationCount());
        assertEquals(1.0,model.getAmountOfYears(),1);
    }

    private static <T extends BasePopulationModel>BasePopulationModel arrangeModel(int numberOfYears,int basePopulationCount ,Class<T> model) {

        if(model.equals(LogisticGrowthModel.class)){
            return new LogisticGrowthModel(new BasePopulationModel(basePopulationCount, numberOfYears), 0.6, 0.1, 1000, basePopulationCount, numberOfYears);
        }
        else if(model.equals(PopulationMigrationModel.class)){
            return new PopulationMigrationModel(new BasePopulationModel(basePopulationCount, numberOfYears), 800, 1000, 500);
        }
        else if(model.equals(EnergyConsumptionPopulationModel.class)){
            return new EnergyConsumptionPopulationModel(new BasePopulationModel(basePopulationCount, numberOfYears), 1, 10);
        }
        else if(model.equals(AirPolutionPopulationModel.class)){
            return new AirPolutionPopulationModel(new BasePopulationModel(basePopulationCount, numberOfYears), 50, 1000, 10);
        }
        else if(model.equals(CrimePopulationModel.class)){
            return new CrimePopulationModel(new BasePopulationModel(basePopulationCount, numberOfYears), 100, 1,500);
        }

        return null;

    }

    @Test
    public void migrationModelCoefficient() throws Exception {
        BasePopulationModel  model = arrangeModel(1,500,PopulationMigrationModel.class);

        double coefficient = model.calculateCoefficient();

        System.out.println(coefficient);
    }

    @Test
    public void EnergyConsumptionModelCoefficient() throws Exception {
        BasePopulationModel  model = arrangeModel(1,500,EnergyConsumptionPopulationModel.class);

        double coefficient = model.calculateCoefficient();

        System.out.println(coefficient);
    }

    @Test
    public void AirPollutionModelCoefficient() throws Exception {
        BasePopulationModel  model = arrangeModel(1,500,AirPolutionPopulationModel.class);

        double coefficient = model.calculateCoefficient();

        System.out.println(coefficient);
    }

    @Test
    public void CrimePopulationModelCoefficient() throws Exception {
        BasePopulationModel  model = arrangeModel(1,500,CrimePopulationModel.class);

        double coefficient = model.calculateCoefficient();

        System.out.println(coefficient);
    }
}