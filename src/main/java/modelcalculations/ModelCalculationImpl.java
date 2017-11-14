package modelcalculations;

import models.BasePopulationModel;
import models.LogisticGrowthModel;

import java.math.BigDecimal;

public class ModelCalculationImpl implements ModelCalculation {

    public int calculateNextPopulationCount(BasePopulationModel model, double time) {

        LogisticGrowthModel logisticGrowthModel = (LogisticGrowthModel) model;

        double coefficient = model.calculateCoefficient();

//        System.out.println("licznik "+logisticGrowthModel.getEnvironmentCapacity()
//                * model.getBasePopulationCount()
//                * Math.exp(coefficient * Math.abs(time - (time - 1))))

        double result = (logisticGrowthModel.getEnvironmentCapacity()
                * model.getBasePopulationCount()
                * Math.exp(coefficient * Math.abs(time - (time - 1))))
                / (logisticGrowthModel.getEnvironmentCapacity()
                + model.getBasePopulationCount()
                * (Math.exp((coefficient * Math.abs(time - (time - 1)))) - 1));


        return (int) result;
    }
}
