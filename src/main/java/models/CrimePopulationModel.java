package models;


/**
 * Created by Marcinn on 2017-10-15.
 */
public class CrimePopulationModel extends PopulationModelDecorator {
    /**
     * 0 < C < 1000
     */
    private int numberOfReportedCrimes;
    private int numberOfTestedGroups;


    public CrimePopulationModel(BasePopulationModel model, int numberOfReportedCrimes, int numberOfTestedGroups,int basePopulationcount) {
        super(basePopulationcount,model);
        this.numberOfReportedCrimes = numberOfReportedCrimes;
        this.numberOfTestedGroups = numberOfTestedGroups;
    }

    @Override
    public double calculateCoefficient() {

        double modifier = 0;
        double weight = 0.01;

        for (int i = 0; i < this.numberOfTestedGroups; i++) {
            modifier += (this.getCrimeRateBasePopulation());
        }
        return this.model.calculateCoefficient() + modifier * weight;
    }

    private double getCrimeRateBasePopulation() {
        return (double) numberOfReportedCrimes / this.basePopulationCount;
    }


    private double getCrimeRateAfterTimePopulation() {
        return (double) numberOfReportedCrimes / this.populationCountAfterTime;
    }
}
