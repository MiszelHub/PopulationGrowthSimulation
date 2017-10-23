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

    public BasePopulationModel(int basePopulationCount, int populationCountAfterTime) {
        this.basePopulationCount = basePopulationCount;
        this.populationCountAfterTime = populationCountAfterTime;
    }

    public BasePopulationModel() {
    }

    public int getBasePopulationCount() {
        return basePopulationCount;
    }

    public int getPopulationCountAfterTime() {
        return populationCountAfterTime;
    }


}
