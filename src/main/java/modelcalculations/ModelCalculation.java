package modelcalculations;

import models.BasePopulationModel;

import java.util.List;

public interface ModelCalculation {
    double calculateModifierValue(List<BasePopulationModel> model);
}
