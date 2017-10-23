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

    public double getCrimeRateBasePopulation() {
        return (double) numberOfReportedCrimes / this.basePopulationCount;
    }


    public double getCrimeRateAfterTimePopulation() {
        return (double) numberOfReportedCrimes / this.populationCountAfterTime;
    }

    public int getNumberOfReportedCrimes() {
        return numberOfReportedCrimes;
    }

    public int getNumberOfTestedGroups() {
        return numberOfTestedGroups;
    }
}
