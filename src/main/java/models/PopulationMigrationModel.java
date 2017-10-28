package models;

/**
 * Created by Marcinn on 2017-10-15.
 */
public class PopulationMigrationModel extends ExponentialGrowthModel {

    /**
     * 0 < M1 < 40000 [ people ]
     */
    private int numberOfPeopleMigratingIn;
    /**
     * 0 < M2 < 40000 [ people ]
     */
    private int numberOfPeopleMigratingOut;

    public PopulationMigrationModel(int basePopulationCount, int populationCountAfterTime, double birthRate, double deathRate, int numberOfPeopleMigratingIn, int numberOfPeopleMigratingOut) {
        super(basePopulationCount, populationCountAfterTime, birthRate, deathRate);
        this.numberOfPeopleMigratingIn = numberOfPeopleMigratingIn;
        this.numberOfPeopleMigratingOut = numberOfPeopleMigratingOut;
    }

    @Override
    public double calculateCoefficient() {
        return numberOfPeopleMigratingIn - numberOfPeopleMigratingOut;
    }
}
