package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class LogisticGrowthModel extends ExponentialGrowthModel {
    /**
     * 0 < P < 100000
     */
    protected double enviromentCapacity;

    @Override
    public double calculateCoefficient() {
        return this.getGrowthRate();
    }
}
