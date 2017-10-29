package modelcalculations;

import models.BasePopulationModel;

public class ModelCalculationImpl implements ModelCalculation {

    public int calculateNextPopulationCount(BasePopulationModel model) {

        double coefficient = model.calculateCoefficient();

        return 0;
    }
}
