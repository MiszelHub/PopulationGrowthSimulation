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

    double getGrowthRate(){
        return birthRate - deathRate;
    }

    @Override
    public double calculateCoefficient() {
        return getGrowthRate();
    }
}
