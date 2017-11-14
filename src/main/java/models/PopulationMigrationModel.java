package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class PopulationMigrationModel extends PopulationModelDecorator {

    /**
     * 0 < M1 < 40000 [ people ]
     */
    private int numberOfPeopleMigratingIn;
    /**
     * 0 < M2 < 40000 [ people ]
     */
    private int numberOfPeopleMigratingOut;




    public PopulationMigrationModel(BasePopulationModel model, int numberOfPeopleMigratingIn, int numberOfPeopleMigratingOut,int basePopulationCount) {
        super(basePopulationCount,model);
        this.numberOfPeopleMigratingIn = numberOfPeopleMigratingIn;
        this.numberOfPeopleMigratingOut = numberOfPeopleMigratingOut;
    }

    @Override
    public double calculateCoefficient() {
        double migrationDifference = (numberOfPeopleMigratingIn - numberOfPeopleMigratingOut)/1000000.0;

        return this.model.calculateCoefficient() + Math.abs(migrationDifference);
    }
}
