package models;

/**
 * Created by Marcinn on 2017-10-16.
 */
public class EnergyConsumptionPopulationModel extends BasePopulationModel {
    /**
     * 0 < Ee < 3
     */
    private double energyEfficiency;
    /**
     * 2 < Ec < 4
     */
    private double energyPerCapita;

    @Override
    public double calculateCoefficient() {
        return Math.exp(( energyPerCapita - energyEfficiency ) / 160 * Math.pow(energyEfficiency, 0.38));
    }
}
