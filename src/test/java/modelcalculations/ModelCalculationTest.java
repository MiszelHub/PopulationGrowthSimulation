package modelcalculations;

import models.BasePopulationModel;
import models.CrimePopulationModel;
import org.junit.Before;
import org.junit.Test;

public class ModelCalculationTest {

    private ModelCalculation modelCalculation;

    @Before
    public void setUp() throws Exception {
        modelCalculation = new CrimeModelCalculation();

    }

    @Test
    public void calculateModifierValue() {

//        double v = modelCalculation.calculateModifierValue(new CrimePopulationModel(10000, 200000, 1000, 10));
        double v = modelCalculation.calculateModifierValue(new BasePopulationModel(10000, 200000));

        System.out.println(v);

    }

}