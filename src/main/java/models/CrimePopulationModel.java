package models;


/**
 * Created by Marcinn on 2017-10-15.
 */
public class CrimePopulationModel extends BasePopulationModel {
    /**
     * 0 < C < 1000
     */
    private int numberOfReportedCrimes;
    private int numberOfTestedGroups;

    public CrimePopulationModel(int basePopulationCount, int populationCountAfterTime, int numberOfReportedCrimes, int numberOfTestedGroups) {
        super(basePopulationCount, populationCountAfterTime);
        this.numberOfReportedCrimes = numberOfReportedCrimes;
        this.numberOfTestedGroups = numberOfTestedGroups;
    }


    @Override
    public double calculateCoefficient() {

        double modifier = 0;
        for (int i = 0; i < this.numberOfTestedGroups; i++) {
            modifier += Math.abs( this.getCrimeRateAfterTimePopulation() - this.getCrimeRateBasePopulation() );
        }
        return modifier;
    }

    private double getCrimeRateBasePopulation() {
        return (double) numberOfReportedCrimes / this.basePopulationCount;
    }


    private double getCrimeRateAfterTimePopulation() {
        return (double) numberOfReportedCrimes / this.populationCountAfterTime;
    }
}
