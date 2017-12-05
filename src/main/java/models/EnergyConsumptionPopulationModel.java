package models;

/**
 * Created by Marcinn on 2017-10-16.
 */
public class EnergyConsumptionPopulationModel extends PopulationModelDecorator {
    /**
     * 0 < Ee < 3
     */
    private double energyEfficiency;
    /**
     * 2 < Ec < 4
     */
    private double energyPerCapita;

    public EnergyConsumptionPopulationModel(BasePopulationModel model, double energyEfficiency, double energyPerCapita) {
        super(model);
        this.energyEfficiency = energyEfficiency;
        this.energyPerCapita = energyPerCapita;
    }

    @Override
    public double calculateCoefficient() {
        final double weight = 0.01;
        return this.model.calculateCoefficient() + Math.exp(( energyPerCapita - energyEfficiency ) / 160 * Math.pow(energyEfficiency, 0.38)) * weight;
    }
}
