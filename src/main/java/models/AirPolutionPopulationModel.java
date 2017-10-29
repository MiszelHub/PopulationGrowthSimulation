package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class AirPolutionPopulationModel extends PopulationModelDecorator {

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


    public AirPolutionPopulationModel(BasePopulationModel model, double co2Emission, double incomePerCapita, double regulatoryEffort) {
        super(model);
        this.co2Emission = co2Emission;
        this.incomePerCapita = incomePerCapita;
        this.regulatoryEffort = regulatoryEffort;
    }

    @Override
    public double calculateCoefficient() {
        double weight = 0.8;
        return Math.exp(-Math.log(incomePerCapita) + Math.log(regulatoryEffort) - Math.log(co2Emission)) * weight;
    }
}
