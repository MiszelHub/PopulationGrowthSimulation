package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class CrimePopulationModel extends BasePopulationModel {
    /**
     *  0 < C < 1000
     */
    private int numberOfReportedCrimes;

    public double getCrimeRate(){
        return numberOfReportedCrimes / this.basePopulationCount;
    }
}
