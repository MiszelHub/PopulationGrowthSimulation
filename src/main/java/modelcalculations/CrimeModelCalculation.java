package modelcalculations;

import models.BasePopulationModel;
import models.CrimePopulationModel;

import javax.xml.bind.TypeConstraintException;

public class CrimeModelCalculation implements ModelCalculation {

    public double calculateModifierValue(BasePopulationModel model) {

        if (model instanceof CrimePopulationModel) {
            CrimePopulationModel crimeModel = (CrimePopulationModel) model;
            double modifier = 0;
            for (int i = 0; i < crimeModel.getNumberOfTestedGroups(); i++) {
                modifier += Math.abs( crimeModel.getCrimeRateAfterTimePopulation() - crimeModel.getCrimeRateBasePopulation() );
            }
            return modifier;
        } else {
            throw new ClassCastException("Use.Crime.Model");
        }
    }
}
