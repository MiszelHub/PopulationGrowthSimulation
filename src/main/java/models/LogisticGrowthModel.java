package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class LogisticGrowthModel extends PopulationModelDecorator {
    /**
     * 0 < P < 100000
     */
    protected double environmentCapacity;
    /**
     * 0 < b < 1
     */
    protected double birthRate;
    /**
     * 0 < d < 1
     */
    protected double deathRate;


    public LogisticGrowthModel(BasePopulationModel model, double birthRate, double deathRate, double environmentCapacity, int basePopulationCount, double numberOfYears) {
        super(basePopulationCount, numberOfYears,model);
        this.environmentCapacity = environmentCapacity;
        this.birthRate = birthRate;
        this.deathRate = deathRate;
        this.basePopulationCount = basePopulationCount;
    }


    @Override
    public double calculateCoefficient() {
        return this.model.calculateCoefficient() + this.getGrowthRate();
    }

    private double getGrowthRate() {
        return birthRate - deathRate;
    }

    public double getEnvironmentCapacity() {
        return environmentCapacity;
    }
}
