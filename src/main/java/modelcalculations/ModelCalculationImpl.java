package modelcalculations;

import models.BasePopulationModel;
import models.LogisticGrowthModel;

public class ModelCalculationImpl implements ModelCalculation {

    public int calculateNextPopulationCount(BasePopulationModel model, double time) {

        LogisticGrowthModel logisticGrowthModel = (LogisticGrowthModel) model;

        double coefficient = model.calculateCoefficient();

        double result = (logisticGrowthModel.getEnvironmentCapacity()
                * model.getBasePopulationCount()
                * Math.exp(coefficient * (time - model.getAmountOfYears())))
                / (logisticGrowthModel.getEnvironmentCapacity()
                + model.getBasePopulationCount()
                * (Math.exp(coefficient * (time - model.getAmountOfYears())) - 1));


        return (int) result;
    }
}
