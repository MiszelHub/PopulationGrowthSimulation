package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class AirPolutionPopulationModel extends BasePopulationModel {

    /**
     * 0 < E < 1
     */
    private double co2Emission;

    /**
     * 0 < I < 10000
     */
    private double incomePerCapita;

    /**
     * 0 < R < 10
     */
    private double regulatoryEffort;

    public AirPolutionPopulationModel(int basePopulationCount, int populationCountAfterTime, double co2Emission, double incomePerCapita, double regulatoryEffort) {
        super(basePopulationCount, populationCountAfterTime);
        this.co2Emission = co2Emission;
        this.incomePerCapita = incomePerCapita;
        this.regulatoryEffort = regulatoryEffort;
    }

    @Override
    public double calculateCoefficient() {
        return Math.exp(-Math.log(incomePerCapita) + Math.log(regulatoryEffort) - Math.log(co2Emission));
    }
}
