package models;

public abstract class BasePopulationModel {
    /**
     * 0 < N < 100000 [ people ]
     */
    protected int basePopulationCount;
    /**
     * 0 < N < 100000 [ people ]
     */
    protected int populationCountAfterTime;

    public BasePopulationModel(int basePopulationCount, int populationCountAfterTime) {
        this.basePopulationCount = basePopulationCount;
        this.populationCountAfterTime = populationCountAfterTime;
    }

    public BasePopulationModel() {
    }

    public abstract double calculateCoefficient();
}
