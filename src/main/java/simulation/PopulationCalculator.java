package simulation;

import modelcalculations.ModelCalculation;
import models.BasePopulationModel;
import models.LogisticGrowthModel;

import java.util.ArrayList;
import java.util.List;

public class PopulationCalculator {

    private BasePopulationModel model;
    private ModelCalculation modelCalculation;
    private double birthrate;
    private double deathRate;
    private int environmentCapacity;
    private int basePopulationCount;


    public PopulationCalculator(ModelCalculation modelCalculation, double birthrate, double deathRate, int environmentCapacity, int basePopulationCount) {
        this.birthrate = birthrate;
        this.deathRate = deathRate;
        this.environmentCapacity = environmentCapacity;
        this.basePopulationCount = basePopulationCount;
        this.model = createModel(new BasePopulationModel());
        this.modelCalculation = modelCalculation;
    }

    private LogisticGrowthModel createModel(BasePopulationModel compoundModel) {
        return new LogisticGrowthModel(compoundModel, birthrate, deathRate, environmentCapacity, basePopulationCount, 0);
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
