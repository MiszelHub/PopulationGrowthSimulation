package modelcalculations;

import models.BasePopulationModel;

import java.util.List;

public interface ModelCalculation {
    int calculateNextPopulationCount(BasePopulationModel model);
}
