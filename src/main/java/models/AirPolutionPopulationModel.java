package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class AirPolutionPopulationModel extends BasePopulationModel {

    /**
     * 0 < E < 1
     */
    private double co2Emmision;

    /**
     * 0 < I < 10000
     */
    private double incomePerCapita;

    /**
     * 0 < R < 10
     */
    private double regulatoryEffort;

    @Override
    public double calculateCoefficient() {
        return 0;
    }
}
