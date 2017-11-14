package simulation;

import modelcalculations.ModelCalculation;
import models.BasePopulationModel;
import models.LogisticGrowthModel;

import java.util.ArrayList;
import java.util.List;

public class PopulationCalculator {

    private BasePopulationModel model;
    private ModelCalculation modelCalculation;


    public PopulationCalculator(ModelCalculation modelCalculation) {
        this.model = createModel(new BasePopulationModel());
        this.modelCalculation = modelCalculation;
    }

    private LogisticGrowthModel createModel(BasePopulationModel compoundModel) {
        return new LogisticGrowthModel(compoundModel, 0.9, 0.5, 60000, 5000, 0);
    }

    List<Integer> calculatePopulationValuesForGivenYearRange(int yearAmount, BasePopulationModel compoundModel){

        this.model = createModel(compoundModel);

        List<Integer> populationValues = new ArrayList<>();

        for (int i=0 ;i < yearAmount ;i++){
            int nextPopulation = (modelCalculation.calculateNextPopulationCount(model,i));
            populationValues.add(nextPopulation);
            model.setBasePopulationCount(nextPopulation);
        }

        return populationValues;
    }
}
