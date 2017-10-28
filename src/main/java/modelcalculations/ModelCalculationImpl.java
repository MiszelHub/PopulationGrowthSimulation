package modelcalculations;

import models.BasePopulationModel;
import models.CrimePopulationModel;

import javax.xml.bind.TypeConstraintException;
import java.util.List;

public class ModelCalculationImpl implements ModelCalculation {

    public double calculateModifierValue(List<BasePopulationModel> model) {

        double coefficient = model.
                stream()
                .mapToDouble(BasePopulationModel::calculateCoefficient)
                .sum();

        return 0;
    }
}
