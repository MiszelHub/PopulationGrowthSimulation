package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class ExponentialGrowthModel extends BasePopulationModel {
    /**
     *  0 < b < 1
     */
    protected double birthRate;
    /**
     *  0 < d < 1
     */
    protected double deathRate;

    public ExponentialGrowthModel(int basePopulationCount, int populationCountAfterTime, double birthRate, double deathRate) {
        super(basePopulationCount, populationCountAfterTime);
        this.birthRate = birthRate;
        this.deathRate = deathRate;
    }

    double getGrowthRate(){
        return birthRate - deathRate;
    }

    @Override
    public double calculateCoefficient() {
        return getGrowthRate();
    }
}
