package models;

public abstract class PopulationModelDecorator extends BasePopulationModel {

    protected BasePopulationModel model;


    public PopulationModelDecorator(BasePopulationModel model) {
        this.model = model;
    }

    public PopulationModelDecorator(int basePopulationCount, double amountOfYears, BasePopulationModel model) {
        super(basePopulationCount, amountOfYears);
        this.model = model;
    }

    public PopulationModelDecorator(int basePopulationCount, BasePopulationModel model) {

        this.basePopulationCount = basePopulationCount;
        this.model = model;
    }

    @Override
    public double calculateCoefficient() {
        return this.model.calculateCoefficient();
    }
}
