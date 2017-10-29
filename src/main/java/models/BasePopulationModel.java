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


    public BasePopulationModel(int basePopulationCount) {
        this.basePopulationCount = basePopulationCount;
    }

    public BasePopulationModel() {

    }

    public double calculateCoefficient() {
        return 0;
    }
}
