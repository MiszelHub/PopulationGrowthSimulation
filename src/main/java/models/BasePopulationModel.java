package models;

public class BasePopulationModel {
    /**
     * 0 < N < 100000 [ people ]
     */
    protected int basePopulationCount;
    /**
     * 0 < N < 100000 [ people ]
     */
    protected int populationCountAfterTime;

    protected double amountOfYears;


    public BasePopulationModel(int basePopulationCount, double amountOfYears) {
        this.basePopulationCount = basePopulationCount;
        this.amountOfYears = amountOfYears;
    }

    public BasePopulationModel() {

    }

    public double calculateCoefficient() {
        return 0;
    }

    public int getBasePopulationCount() {
        return basePopulationCount;
    }

    public int getPopulationCountAfterTime() {
        return populationCountAfterTime;
    }

    public double getAmountOfYears() {
        return amountOfYears;
    }

    public void setBasePopulationCount(int basePopulationCount) {
        this.basePopulationCount = basePopulationCount;
    }
}
