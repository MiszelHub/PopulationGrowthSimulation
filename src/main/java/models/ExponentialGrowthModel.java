package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class ExponentialGrowthModel extends BasePopulationModel {
    protected double birthRate;
    protected double deathRate;

    public double getGrowthRate(){
        return birthRate - deathRate;
    }
}
