package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class CrimePopulationModel extends BasePopulationModel {

    private int numberOfReportedCrimes;

    public double getCrimeRate(){
        return this.basePopulationCount / numberOfReportedCrimes;
    }
}
